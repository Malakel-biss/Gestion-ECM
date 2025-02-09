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
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
const handleButtonClicker = () => {
    // Navigate to another page when the button is clicked
    window.location.href ='/dashboard/tablesstages'; // Replace '/your-other-page' with the actual path you want to navigate to
  };

export function Typestage() {
  const [type, setType] = useState('card');
  
  const [typeStage, setEtudiant] = useState({});
  const [date, setDate] = useState({});
const navigate = useNavigate();

const handleButtonClicker = () => {
    const req = async () => {
      const result = await axios.post(
        "http://localhost:8080/api/admin/typesStage",
  
        
        typeStage,

        
        {
          headers: {
            "Content-Type": "application/json",
            
          },
          withCredentials: true,
        }
      );
 
      console.log("ajout etu xxxxxxxxxx: " , result);
      navigate('/dashboard/tablesstages');
    };
    req();
    const req2 = async () => {
      const result2 = await axios.post(
  
        "http://localhost:8080/api/admin/dates",
        

        date,
        
        {
          headers: {
            "Content-Type": "application/json",
            
          },
          withCredentials: true,
        }
      );
 
      console.log("ajout etu xxxxxxxxxx: " , result2);
      navigate('/dashboard/tablesstages');
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
      <Typography variant="h5" color="white">
        Type de stage
      </Typography>
    </CardHeader>
    <CardBody>
      <Tabs value={type} className="overflow-visible">
        <TabsHeader className="relative z-0 ">
          <Tab value="card" onClick={() => setType('card')}>
            Insérer un type de stage 
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
                  Code de Stage 
                </Typography>
                <Input
                onChange= {(e) => setEtudiant({...typeStage, codeStage: e.target.value})}
                  type="nom"
              
                  placeholder="Code de Stage"
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
                 Date début
                </Typography>

                <Input
                 type="date"
                 onChange= {(e) => setDate({...date, dateDebut: e.target.value})}
                  placeholder="Entrez le nombre de semaine de ce type de stage"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  
                />
              </div>
              <div className="my-3">
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium "
                >
                 Date fin
                </Typography>

                <Input
                 type="date"
                 onChange= {(e) => setDate({...date, dateFin: e.target.value})}
                  placeholder="Entrez le nombre de semaine de ce type de stage"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  
                />
              </div>
              <div className="my-3">
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="mb-2 font-medium "
                >
                 Nombre de semaine
                </Typography>

                <Input
                 onChange= {(e) => setEtudiant({...typeStage, nbSemaine: e.target.value})}
                  placeholder="Entrez le nombre de semaine de ce type de stage"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  
                />
              </div>
              <Button size="lg" onClick={handleButtonClicker}>Enregistrer</Button>
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

export default Typestage;

