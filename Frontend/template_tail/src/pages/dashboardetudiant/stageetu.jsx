import React, { useState } from 'react';
import {
  Card,
  CardHeader,
  CardBody,
  Input,
  Button,
  Typography,
  Tabs,
  TabsHeader,
  TabsBody,
  Tab,
  TabPanel,
  Select,
  Option,
} from '@material-tailwind/react';
import { CreditCardIcon, LockClosedIcon } from '@heroicons/react/24/solid';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const formatCardNumber = (cardNumber) => {
  // Implement your card number formatting logic here
  return cardNumber;
};

// Function to format card expiration as you did in your original code
const formatExpires = (cardExpires) => {
  // Implement your card expiration formatting logic here
  return cardExpires;
};

const countriesData = [
  { name: 'USA', flags: { svg: 'path-to-flag-svg' } },
  // Add more countries as needed
];
const handleButtonClicker = () => {
    // Navigate to another page when the button is clicked
    window.location.href ='/dashboardetudiant/homeetudiant'; // Replace '/your-other-page' with the actual path you want to navigate to
  };

export function Stageetu() {
  const [type, setType] = useState('card');
  const [cardNumber, setCardNumber] = useState('');
  const [cardExpires, setCardExpires] = useState('');
  const [entreprise, setEtudiant] = useState({});
  const [tuteur, setDate] = useState({});
const navigate = useNavigate();
const handleButtonClicker = () => {
    const req = async () => {
      const result = await axios.post(
        "http://localhost:8080/api/etudiant/entreprises",
  
        
        entreprise,

        
        {
          headers: {
            "Content-Type": "application/json",
            
          },
          withCredentials: true,
        }
      );
 
      console.log("ajout etu xxxxxxxxxx: " , result);
      navigate('/dashboardetudiant/homeetudiant');
    };
    req();
    const req2 = async () => {
      const result2 = await axios.post(
  
        "http://localhost:8080/api/etudiant/tuut",
        

        tuteur,
        
        {
          headers: {
            "Content-Type": "application/json",
            
          },
          withCredentials: true,
        }
      );
 
      console.log("ajout etu xxxxxxxxxx: " , result2);
      navigate('/dashboardetudiant/homeetudiant');
    };
    req2();
 
    // window.location.href ='/dashboard/tables';
  };

  return (
<Card className="w-full centered max-w-[40rem] ml-40"> {/* Increased width to 28rem */}
    <CardHeader
      color="gray"
      floated={false}
      shadow={false}
      className="m-0 grid place-items-center px-4 py-8 text-center"
    >
      {/* <div className="mb-4 h-20 p-6 text-white">
        {type === 'card' ? (
          <CreditCardIcon className="h-10 w-10 text-white" />
        ) : (
          <img
            alt="paypal "
            className="w-14 "
            src="https://docs.material-tailwind.com/icons/paypall.png"
          />
        )}
      </div> */}
      <Typography variant="h5" color="white">
        Fiche de Stage
      </Typography>
    </CardHeader>
    <CardBody>
      <Tabs value={type} className="overflow-visible">
        <TabsHeader className="relative z-0 ">
          <Tab value="card" onClick={() => setType('card')}>
            Entrez les informations de votre stage 
          </Tab>
          {/* Remove the Tab for PayPal */}
        </TabsHeader>
        <TabsBody
          className="!overflow-x-hidden !overflow-y-visible"
          animate={{
            initial: {
              x: type === 'card' ? 400 : -400,
            },
            mount: {
              x: 0,
            },
            unmount: {
              x: type === 'card' ? 400 : -400,
            },
          }}
        >
          <TabPanel value="card" className="p-0">
            <form className="mt-12 flex flex-col gap-4">
              <div>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Nom Entreprise
                </Typography>
                <Input
                onChange= {(e) => setEtudiant({...entreprise, nomEntreprise: e.target.value})}
                  type="nom"
                  placeholder=" Nom Entreprise"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
              </div>

              <div className="my-3">
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium "
                >
                 Adresse
                </Typography>

                <Input  
                 onChange= {(e) => setEtudiant({...entreprise, adresseentreprise: e.target.value})}
                  placeholder="Entrez adresse étudiant"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  
                />
                <div className="my-4 flex items-center gap-4">
                 
                 <div>
                   <Typography
                     variant="small"
                     color="blue-gray"
                     className="mb-2 font-medium"
                   >
                     Ville Entreprise
                   </Typography>
                   <Input
                   
                   
                     
                     onChange= {(e) => setEtudiant({...entreprise, villeentreprise: e.target.value})}
                   //   value={formatExpires(cardExpires)}
                   //   onChange={(event) => setCardExpires(event.target.value)}
                     containerProps={{ className: 'min-w-[72px]' }}
                     placeholder=" Ville Entreprise"
                     className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                     labelProps={{
                       className: 'before:content-none after:content-none',
                     }}
                   />
                   
                 </div>
                 <div>
                   <Typography
                     variant="small"
                     color="blue-gray"
                     className="mb-2 font-medium"
                   >
                    Code Postal Entreprise              </Typography>
                   <Input
                   
                    onChange= {(e) => setEtudiant({...entreprise, codePostalentreprise: e.target.value})}
                    
                     containerProps={{ className: 'min-w-[72px]' }}
                     placeholder="Code Postal Entreprise"
                     className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                     labelProps={{
                       className: 'before:content-none after:content-none',
                     }}
                   />
                 </div>
               </div>
                <div className="my-4 flex items-center gap-4">
                  
                  
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                      Raison Sociale
                    </Typography>
                    <Input
                      onChange= {(e) => setEtudiant({...entreprise, raisonSociale: e.target.value})}
                     
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="Raison Sociale"
                      className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                      labelProps={{
                        className: 'before:content-none after:content-none',
                      }}
                    />
                  </div>
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                     Forme Juridique                    </Typography>
                    <Input
                     onChange= {(e) => setEtudiant({...entreprise, formeJuridique: e.target.value})}
                      
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="Forme juridique"
                      className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                      labelProps={{
                        className: 'before:content-none after:content-none',
                      }}
                    />
                  </div>
                </div>
                
                <div className="my-4 flex items-center gap-4">
                 
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                       Contact Entreprise
                    </Typography>
                    <Input
                     onChange= {(e) => setEtudiant({...entreprise, contactentreprise: e.target.value})}
                    
                    //   value={formatExpires(cardExpires)}
                    //   onChange={(event) => setCardExpires(event.target.value)}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="  contact entreprise"
                      className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                      labelProps={{
                        className: 'before:content-none after:content-none',
                      }}
                    />
                  </div>
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                      Telephone Entreprise
                    </Typography>
                    <Input
                     onChange= {(e) => setEtudiant({...entreprise, telephoneentreprise: e.target.value})}
                     
                    //   value={formatExpires(cardExpires)}
                    //   onChange={(event) => setCardExpires(event.target.value)}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder=" Telephone Entreprise"
                      className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                      labelProps={{
                        className: 'before:content-none after:content-none',
                      }}
                    />
                  </div>
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                      fax Entreprise
                    </Typography>
                    <Input
                     onChange= {(e) => setEtudiant({...entreprise, fax: e.target.value})}
                     
                    //   value={formatExpires(cardExpires)}
                    //   onChange={(event) => setCardExpires(event.target.value)}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder=" Telephone Entreprise"
                      className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                      labelProps={{
                        className: 'before:content-none after:content-none',
                      }}
                    />
                  </div>
                  

                  
                </div>

              
                  <div>
                <div className="my-4 flex items-center gap-4">
                  <div>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Nom Tuteur
                </Typography>
                <Input
                 onChange= {(e) => setDate({...tuteur, nom: e.target.value})}
                  type="nom"
                  placeholder=" Nom Tuteur"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
              </div>
              <div>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Prenom Tuteur
                </Typography>
                <Input
                onChange= {(e) => setDate({...tuteur, prenom: e.target.value})}
                  type="nom"
                  placeholder=" Prenom Tuteur"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
              </div>
              </div>
              <div className="my-4 flex items-center gap-4"></div>
              <div>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Qualite
                </Typography>
                <Input
                onChange= {(e) => setDate({...tuteur, qualite: e.target.value})}
                  type="nom"
                  placeholder=" qualite"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
              </div>
              <div>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Telephone
                </Typography>
                <Input
                onChange= {(e) => setDate({...tuteur, telephone: e.target.value})}
                  type="nom"
                  placeholder=" telephone"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
              </div>
              
            

                  
                   
                    {/* <Input
                    type="date" id="dateInput" class="border p-2"
                     
                    /> */}
                  </div>

              </div>
         <div>
            <Typography
              variant="small"
              color="blue-gray"
              className="mb-2 font-medium"
            >
              Ajouter un fichier PDF
            </Typography>
            <input
              type="file"
              accept=".pdf"
              className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
            />
          </div>
              <Button size="lg"onClick={handleButtonClicker}>Enregistrer</Button>
              {/* <Typography
                variant="small"
                color="gray"
                className="mt-2 flex items-center justify-center gap-2 font-medium opacity-60"
              >
                <LockClosedIcon className="-mt-0.5 h-4 w-4" /> Payments are
                secure and encrypted
              </Typography> */}
            </form>
          </TabPanel>
        </TabsBody>
      </Tabs>
    </CardBody>
  </Card>
  
  );
}

export default Stageetu;