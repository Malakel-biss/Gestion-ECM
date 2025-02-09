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


export function AjouterEtudiant() {
  const [type, setType] = useState('card');
  
  const [etudiant, setEtudiant] = useState({});
  const navigate = useNavigate();


const handleButtonClicker = () => {
    const req = async () => {
      console.log("etudiant",etudiant)
      const result = await axios.post(
        "http://localhost:8080/api/admin/etudiants",
        
          etudiant,
    
        {
          headers: {
            "Content-Type": "application/json",
            
          },
          withCredentials: true,
        }
      );
      console.log("ajout etu xxxxxxxxxx: " , result);
      navigate('/dashboard/tables');
    };
    req();
    

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
        Formulaire d'ajout
      </Typography>
    </CardHeader>
    <CardBody>
      <Tabs value={type} className="overflow-visible">
        <TabsHeader className="relative z-0 ">
          <Tab value="card" onClick={() => setType('card')}>
            Insérer Etudiant
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
                  nom 
                </Typography>
                <Input
                
                  onChange= {(e) => setEtudiant({...etudiant, nometudiant: e.target.value})}
                  type="nom"
                  value={etudiant.nom_etudiant}
                  placeholder="Nom Complet"
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
                  prenom 
                </Typography>
                <Input
                
                  onChange= {(e) => setEtudiant({...etudiant, prenometudiant: e.target.value})}
                  type="nom"
                  value={etudiant.prenom_etudiant}
                  placeholder="Nom Complet"
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
                value={etudiant.adresseetudiant}
                 onChange= {(e) => setEtudiant({...etudiant, adresseetudiant: e.target.value})}
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
                      Promo
                    </Typography>
                    <Input
                    value={etudiant.annee_promo}
                     onChange= {(e) => setEtudiant({...etudiant, annee_promo: e.target.value})}
                     type="name" id="promo" class="border p-2" 
                     placeholder='YYYY/YYYY'
                    />
                  </div>
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                     Code Postal                    </Typography>
                    <Input
                     onChange= {(e) => setEtudiant({...etudiant, codePostaletudiant: e.target.value})}
                      maxLength={4}
                      value={etudiant.codePostaletudiant}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="Code postal"
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
                     Sexe
                    </Typography>
                    <Input
                    value={etudiant.sexetudiant}
                     onChange= {(e) => setEtudiant({...etudiant, sexetudiant: e.target.value})}
                      maxLength={5}
                    //   value={formatExpires(cardExpires)}
                    //   onChange={(event) => setCardExpires(event.target.value)}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="F/M"
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
                     Ville                  </Typography>
                    <Input
                     onChange= {(e) => setEtudiant({...etudiant, villeetudiant: e.target.value})}
                      maxLength={4}
                      value={etudiant.villeetudiant}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="Entrez la ville"
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
                      Mention
                    </Typography>
                    <Input
                     onChange= {(e) => setEtudiant({...etudiant, mention: e.target.value})}
                      maxLength={5}
                      value={etudiant.mention}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="Très Bien/ Bien/ Assez Bien/ Passable/ Ajourné"
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
                     Date de naissance                   </Typography>
                    <Input
                    value={etudiant.dateNaissanceetudiant}
                     onChange= {(e) => setEtudiant({...etudiant, dateNaissanceetudiant: e.target.value})}
                    type="date" id="dateInput" class="border p-2"
                     
                    />
                  </div>
                </div>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Email Institutionnel
                </Typography>
                <Input
                value={etudiant.emailetudiant}
                 onChange= {(e) => setEtudiant({...etudiant, emailetudiant: e.target.value})}
                  placeholder="name@mail.com"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
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

export default AjouterEtudiant;

