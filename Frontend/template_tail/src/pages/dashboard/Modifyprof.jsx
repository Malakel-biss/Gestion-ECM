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
    window.location.href ='/dashboard/tablesprof'; // Replace '/your-other-page' with the actual path you want to navigate to
  };

export function Modifyprof() {
  const [type, setType] = useState('card');
  const [cardNumber, setCardNumber] = useState('');
  const [cardExpires, setCardExpires] = useState('');

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
        Formulaire de modification
      </Typography>
    </CardHeader>
    <CardBody>
      <Tabs value={type} className="overflow-visible">
        <TabsHeader className="relative z-0 ">
          <Tab value="card" onClick={() => setType('card')}>
            Modifier professeur
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
                  Nom 
                </Typography>
                <Input
                  type="nom"
                  placeholder="Nom "
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
                  Prénom
                </Typography>
                <Input
                  type="prenom"
                  placeholder="Prénom "
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
                 
                  placeholder="Entrez adresse professeur"
                  className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
                  
                />
                <div className="my-4 flex items-center gap-4">
                  
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                     Qualité                    </Typography>
                    <Input
                      maxLength={4}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="qualité "
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
                     Code Postal                    </Typography>
                    <Input
                      maxLength={4}
                      containerProps={{ className: 'min-w-[72px]' }}
                      placeholder="Code postal"
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
                    type="date" id="dateInput" class="border p-2"
                     
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
                      maxLength={4}
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
                      Promo
                    </Typography>
                    <Input
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
                     Date d'embauche                  </Typography>
                    <Input
                    type="date" id="dateInput" class="border p-2"
                     
                    />
                  </div>

                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="mb-2 font-medium"
                    >
                     Date de départ                 </Typography>
                    <Input
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

export default Modifyprof;

