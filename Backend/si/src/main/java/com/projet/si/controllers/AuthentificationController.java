package com.projet.si.controllers;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.projet.si.exception.TokenRefreshException;
import com.projet.si.message.ResponseMessage;
import com.projet.si.model.*;
import com.projet.si.payload.request.LoginRequest;
import com.projet.si.payload.request.SignupRequest;
import com.projet.si.payload.request.TokenRefreshRequest;
import com.projet.si.payload.response.JwtResponse;
import com.projet.si.payload.response.MessageResponse;
import com.projet.si.payload.response.TokenRefreshResponse;
import com.projet.si.repository.*;
import com.projet.si.security.jwt.JwtUtils;
import com.projet.si.security.services.RefreshTokenService;
import com.projet.si.security.services.UserDetailsImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;

//for Angular Client (withCredentials)
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ProfesseursansAuthRepository professeursauthRepository;
    @Autowired
    EtudiantsansAuthRepository etudiantsansAuthRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CandidatRepository candidatRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createOrUpdateRefreshToken(userDetails.getId());

        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
                userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/refreshment")
    public ResponseEntity<?> refreshment(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        try {
            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
            }
            // Create a new user's account
            User user = new User(signUpRequest.getEmail(),
                    signUpRequest.getNom(),
                    signUpRequest.getPrenom(),
                    signUpRequest.getEmail(),
                    encoder.encode(signUpRequest.getPassword()));

            ERole role = signUpRequest.getRole();
            user.setRole(role);

            // Save the user to the users table
            userRepository.save(user);

            // Depending on the user's role, add additional data to the corresponding table
            switch (role) {
                case ETUDIANT -> {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setUser(user);
                    etudiant.setNometudiant(signUpRequest.getNom());
                    etudiant.setPrenometudiant(signUpRequest.getPrenom());
                    etudiant.setAdresseetudiant(signUpRequest.getAdresse());
                    etudiant.setCodePostaletudiant(signUpRequest.getCodePostal());
                    etudiant.setVilleetudiant(signUpRequest.getVille());
                    etudiant.setSexetudiant(signUpRequest.getSex());
                    etudiant.setDateNaissanceetudiant(signUpRequest.getDateNaissance());
                    etudiant.setEmailetudiant(signUpRequest.getEmail());
                    etudiant.setTelephoneetudiant(signUpRequest.getTelephone());
                    etudiant.setEqualite(signUpRequest.getQualite());
                    etudiant.setEsuite(signUpRequest.getSuite());
                    etudiant.setMention(signUpRequest.getE_Mention());
                    etudiant.setAnnee_promo(signUpRequest.getAnneepromo());
                    etudiantRepository.save(etudiant);
                    Etudiantsauth etudiantsauth = new Etudiantsauth();
                    etudiantsauth.setNometudiant(signUpRequest.getNom());
                    etudiantsauth.setPrenometudiant(signUpRequest.getPrenom());
                    etudiantsauth.setAdresseetudiant(signUpRequest.getAdresse());
                    etudiantsauth.setCodePostaletudiant(signUpRequest.getCodePostal());
                    etudiantsauth.setVilleetudiant(signUpRequest.getVille());
                    etudiantsauth.setSexetudiant(signUpRequest.getSex());
                    etudiantsauth.setDateNaissanceetudiant(signUpRequest.getDateNaissance());
                    etudiantsauth.setEmailetudiant(signUpRequest.getEmail());
                    etudiantsauth.setTelephoneetudiant(signUpRequest.getTelephone());
                    etudiantsauth.setEqualite(signUpRequest.getQualite());
                    etudiantsauth.setEsuite(signUpRequest.getSuite());
                    etudiantsauth.setMention(signUpRequest.getE_Mention());
                    etudiantsauth.setAnnee_promo(signUpRequest.getAnneepromo());
                    //etudiantsansAuthRepository.save(etudiantsauth);
                }

                case CANDIDAT -> {
                    Candidat candidat = new Candidat();
                  // // Set the User object (if you have a relationship defined in Candidat entity)
                    candidat.setNom(signUpRequest.getNom());
                    candidat.setPrenom(signUpRequest.getPrenom());
                    candidat.setAdresse(signUpRequest.getAdresse());
                    candidat.setCodePostal(signUpRequest.getCodePostal());
                    candidat.setVille(signUpRequest.getVille());
                    candidat.setSex(signUpRequest.getSex());
                    candidat.setDateNaissance(signUpRequest.getDateNaissance());
                    candidat.setEmail(signUpRequest.getEmail());
                    candidat.setTelephone(signUpRequest.getTelephone());
                    candidatRepository.save(candidat);
                }
                case PROFESSEUR -> {
                    Professeur professeur = new Professeur();
                    professeur.setUser(user);
                    professeur.setPnom(signUpRequest.getNom());
                    professeur.setPprenom(signUpRequest.getPrenom());
                    professeur.setPadresse(signUpRequest.getAdresse());
                    professeur.setPcodePostal(signUpRequest.getCodePostal());
                    professeur.setPville(signUpRequest.getVille());
                    professeur.setPsuite(signUpRequest.getSuite());
                    professeur.setPqualite(signUpRequest.getQualite());
                    professeur.setPdatenaissance(signUpRequest.getDateNaissance());
                    professeur.setDateembauche(signUpRequest.getDateembauche());
                    professeur.setDatedepart(signUpRequest.getDatedepart());
                    professeur.setPtelephonedomicile(signUpRequest.getTelephone());
                    professeur.setPtelephoneecole(signUpRequest.getTelephoneecole());
                    professeurRepository.save(professeur);
                    Professeursauth professeursauth= new Professeursauth();
                    professeursauth.setPnom(signUpRequest.getNom());
                    professeursauth.setPprenom(signUpRequest.getPrenom());
                    professeursauth.setPadresse(signUpRequest.getAdresse());
                    professeursauth.setPcodePostal(signUpRequest.getCodePostal());
                    professeursauth.setPville(signUpRequest.getVille());
                    professeursauth.setPsuite(signUpRequest.getSuite());
                    professeursauth.setPqualite(signUpRequest.getQualite());
                    professeursauth.setPdatenaissance(signUpRequest.getDateNaissance());
                    professeursauth.setDateembauche(signUpRequest.getDateembauche());
                    professeursauth.setDatedepart(signUpRequest.getDatedepart());
                    professeursauth.setPtelephonedomicile(signUpRequest.getTelephone());
                    professeursauth.setPtelephoneecole(signUpRequest.getTelephoneecole());
                    professeursauthRepository.save(professeursauth);


                }

                case ADMIN -> {
                    Admin admin = new Admin();
                    admin.setUser(user);
                    admin.setNom(signUpRequest.getNom());
                    admin.setPrenom(signUpRequest.getPrenom());
                    admin.setEmail(signUpRequest.getEmail());
                    adminRepository.save(admin);
                }
                default -> {
                    // Handle other roles or provide a default behavior
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("no role specified error."));
                }
            }
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("An error occurred during registration."));
        }
    }
    @PostMapping("/sign-out")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}