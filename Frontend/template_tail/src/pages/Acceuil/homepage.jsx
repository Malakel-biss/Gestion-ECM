import React from "react";
import {
  Card,
  CardBody,
  CardHeader,
  Typography,
  Button,
  IconButton,
  Input,
  Textarea,
  Checkbox,
} from "@material-tailwind/react";
import { FingerPrintIcon, UsersIcon } from "@heroicons/react/24/solid";
import { PageTitle, Footer } from "@/widgets/layout";
import { FeatureCard, TeamCard } from "@/widgets/cards";
import { featuresData, teamData, contactData } from "@/data";
  
  export function Homepage() {
    return (

  <>
 
      <div className="relative flex h-screen content-center items-center justify-center pt-16 pb-32">
        <div className="absolute top-0 h-full w-full bg-[url('/img/background-3.png')] bg-cover bg-center" />
        <div className="absolute top-0 h-full w-full bg-black/60 bg-cover bg-center" />
        <div className="max-w-8xl container relative mx-auto">
          <div className="flex flex-wrap items-center">
            <div className="ml-auto mr-auto w-full px-4 text-center lg:w-8/12">
              <Typography
                variant="h1"
                color="white"
                className="mb-6 font-black"
              >
                Bienvenue à l'espace ECM.
              </Typography>
              <Typography variant="lead" color="white" className="opacity-80">
              Notre université se distingue par une approche éducative novatrice, mettant en avant la
               gestion efficace des candidatures, des professeurs et des stages des étudiants. Simplifiant 
               le processus d'admission, nous offrons un enseignement de qualité dispensé par des professeurs émérites,
                tout en favorisant des opportunités de stage enrichissantes. Rejoignez-nous pour une expérience éducative qui 
                va au-delà des normes conventionnelles, axée sur une gestion proactive pour 
              vous offrir une formation complète et pertinente.
              </Typography>
            </div>
          </div>
        </div>
      </div>
      <section className="-mt-32 bg-white px-4 pb-20 pt-4">
        <div className="container mx-auto">
          <div className="grid grid-cols-1 gap-6 md:grid-cols-2 lg:grid-cols-3">
            {featuresData.map(({ color, title, icon, description }) => (
              <FeatureCard
                key={title}
                color={color}
                title={title}
                icon={React.createElement(icon, {
                  className: "w-5 h-5 text-white",
                })}
                description={description}
              />
            ))}
          </div>
          <div className="mt-32 flex flex-wrap items-center">
            <div className="mx-auto -mt-8 w-full px-4 md:w-5/12">
              <div className="mb-6 inline-flex h-16 w-16 items-center justify-center rounded-full bg-blue-gray-900 p-2 text-center shadow-lg">
                <FingerPrintIcon className="h-8 w-8 text-white " />
              </div>
              <Typography
                variant="h3"
                className="mb-3 font-bold"
                color="blue-gray"
              >
                Rejoignez-nous pour transformer vos aspirations en réalité. 
              </Typography>
              <Typography className="mb-8 font-normal text-blue-gray-500">
              Bienvenue à notre université, 
              un lieu d'apprentissage exceptionnel
               où l'excellence académique et l'innovation se rencontrent. En choisissant de rejoindre notre institution,
                vous optez pour une expérience éducative immersive et stimulante, propice au développement personnel et professionnel. Nos programmes de pointe, dispensés par des professeurs renommés, offrent une formation de qualité, tandis que nos installations modernes et nos ressources technologiques vous préparent à exceller dans un monde en constante évolution. En tant qu'étudiant ici, vous bénéficierez d'un environnement inclusif, favorisant le réseautage, la collaboration et l'épanouissement personnel. Rejoignez-nous pour façonner votre avenir avec des compétences solides, une vision globale et une communauté universitaire engagée
              </Typography>
              <Button variant="filled">read more</Button>
            </div>
            <div className="mx-auto mt-24 flex w-full justify-center px-4 md:w-4/12 lg:mt-0">
              <Card className="shadow-lg border shadow-gray-500/10 rounded-lg">
                <CardHeader floated={false} className="relative h-56">
                  <img
                    alt="Card Image"
                    src="/public/img/teamwork.png"
                    className="h-full w-full"
                  />
                </CardHeader>
                <CardBody>
                  <Typography variant="small" color="blue-gray" className="font-normal">Enterprise</Typography>
                  <Typography
                    variant="h5"
                    color="blue-gray"
                    className="mb-3 mt-2 font-bold"
                  >
                   Communauté inclusive
                  </Typography>
                  <Typography className="font-normal text-blue-gray-500">
                  Un environnement accueillant, encourageant le partage d'idées et la collaboration.
                  </Typography>
                </CardBody>
              </Card>
            </div>
          </div>
        </div>
      </section>
      <section className="px-4 pt-20 pb-48">
        <div className="container mx-auto">
          <PageTitle section="Corps Administratif" heading="Présentation de notre équipe">
          Ces professionnels, spécialisés dans divers domaines tels que la gestion des ressources humaines, la comptabilité, les affaires juridiques et les technologies de l'information, jouent un rôle central dans le maintien de l'ordre organisationnel. En assurant une gestion efficace des opérations logistiques et bureaucratiques, le corps administratif garantit la conformité aux réglementations, la transparence des processus et la réalisation des objectifs fixés. 
          </PageTitle>
          <div className="mt-24 grid grid-cols-1 gap-12 gap-x-24 md:grid-cols-2 xl:grid-cols-4">
            {teamData.map(({ img, name, position, socials }) => (
              <TeamCard
                key={name}
                img={img}
                name={name}
                position={position}
                socials={
                  <div className="flex items-center gap-2">
                    {socials.map(({ color, name }) => (
                      <IconButton key={name} color={color} variant="text">
                        <i className={`fa-brands text-xl fa-${name}`} />
                      </IconButton>
                    ))}
                  </div>
                }
              />
            ))}
          </div>
        </div>
      </section>
     
  
    </>
    );
  }
  
  export default Homepage;
  