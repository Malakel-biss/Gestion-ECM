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
    window.location.href ='/dashboardprof/homeprof'; // Replace '/your-other-page' with the actual path you want to navigate to
  };

export function Competence() {
  const [type, setType] = useState('card');
  
  const [competence, setEtudiant] = useState({});
  const navigate = useNavigate();


const handleButtonClicker = () => {
    const req = async () => {
      console.log("competence",competence)
      const result = await axios.post(
        "http://localhost:8080/api/prof/competences",
        
        competence,
    
        {
          headers: {
            "Content-Type": "application/json",
            
          },
          withCredentials: true,
        }
      );
      console.log("ajout etu xxxxxxxxxx: " , result);
      navigate('/dashboardprof/homeprof');
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
        Competence
      </Typography>
    </CardHeader>
    <CardBody>
      <Tabs value={type} className="overflow-visible">
        <TabsHeader className="relative z-0 ">
          <Tab value="card" onClick={() => setType('card')}>
            Ajouter compétence
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
            <div className="my-3">
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Code Competence
                </Typography>
                <Input
                onChange= {(e) => setEtudiant({...competence, codeCompetence: e.target.value})}
                  type="nom"
                  placeholder="Code Competence"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />

         
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium "
                >
                 libelle
                </Typography>

                <Input
                onChange= {(e) => setEtudiant({...competence, libelle: e.target.value})}
                 
                  placeholder="Entrez libelle de competence"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  
                />
             <div>
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Description
                </Typography>
                <Input
                onChange= {(e) => setEtudiant({...competence, description: e.target.value})}
                  placeholder="description"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
         

       
         
             
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Niveau Exigé
                </Typography>
                <Input
                  placeholder="Niveau Exigé"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium"
                >
                  Type Stage
                </Typography>
                <Input
                  placeholder="Type Stage"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  labelProps={{
                    className: 'before:content-none after:content-none',
                  }}
                />
    </div>
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

export default Competence;