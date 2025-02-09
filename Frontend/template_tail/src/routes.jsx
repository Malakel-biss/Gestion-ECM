import {
  HomeIcon,
  UserCircleIcon,
  TableCellsIcon,
  InformationCircleIcon,
  ServerStackIcon,
  RectangleStackIcon,
} from "@heroicons/react/24/solid";
import { Home, Profile, Tables, Promo,Tablesprof,Tablescandidat,Tablesstages,AjouterEtudiant,ModifyEtudiant,Ajouterprof,Modifyprof,Typestage,ModifyStage,Ajouterpromo} from "@/pages/dashboard";
import { SignIn, SignUp } from "@/pages/auth";
import { Homeprof,Competence,Validerstage,Profileprof,Stageprof } from "@/pages/dashboardprof";
import { Homeetudiant,Profileetudiant, Stageetu } from "@/pages/dashboardetudiant";

const icon = {
  className: "w-5 h-5 text-inherit",
};

export const routes = [
  {
    layout: "dashboard",
    pages: [
      {
        icon: <HomeIcon {...icon} />,
        name: "Tableau de bord",
        path: "/home",
        element: <Home />,
      },
      {
        icon: <UserCircleIcon {...icon} />,
        name: "profile",
        path: "/profile",
        element: <Profile />,
      },
      {
        icon: <TableCellsIcon {...icon} />,
        name: "Gestion des Etudiants",
        path: "/tables",
        element: <Tables />,
      },
      {
        icon: <TableCellsIcon {...icon} />,
        name: "Gestion des Professeurs",
        path: "/tablesprof",
        element: <Tablesprof />,
      },
      {
        icon: <TableCellsIcon {...icon} />,
        name: "Gestion des Stages",
        path: "/tablesstages",
        element: <Tablesstages/>,
      },
         {
        icon: <TableCellsIcon {...icon} />,
        name: "Gestion des Candidats",
        path: "/tablescandidat",
        element: <Tablescandidat />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "promo",
        path: "/promo",
        element: <Promo />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Ajouter etudiant",
        path: "/AjouterEtudiant",
        element: <AjouterEtudiant />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Modifier etudiant",
        path: "/ModifyEtudiant",
        element: <ModifyEtudiant />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Ajouter professeur",
        path: "/Ajouterprof",
        element: <Ajouterprof />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Modifier professeur",
        path: "/Modifyprof",
        element: <Modifyprof />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Type Stage",
        path: "/typestage",
        element: <Typestage />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Infos Stage",
        path: "/ModifyStage",
        element: <ModifyStage />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Ajouter Promotion",
        path: "/ajouterpromo",
        element: <Ajouterpromo />,
      },

    ],
  },
  {
    layout: "dashboardprof",
    pages: [
      {
        icon: <HomeIcon {...icon} />,
        name: "Tableau de bord",
        path: "/homeprof",
        element: <Homeprof />,
      },
      {
        icon: <UserCircleIcon {...icon} />,
        name: "profile",
        path: "/profileprof",
        element: <Profileprof />,
      },
      {
        icon: <TableCellsIcon {...icon} />,
        name: "Gestion des stages",
        path: "/stageprof",
        element: <Stageprof />,
      },
   
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Competences",
        path: "/compétences",
        element: <Competence />,
      },
   
      
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Valider stage",
        path: "/validerstage",
        element: <Validerstage />,
      },
       
     

    ],
  },
  {
    layout: "dashboardetudiant",
    pages: [
      {
        icon: <HomeIcon {...icon} />,
        name: "Tableau de bord",
        path: "/homeetudiant",
        element: <Homeetudiant />,
      },
      {
        icon: <HomeIcon {...icon} />,
        name: "Profile",
        path: "/profileetudiant",
        element: <Profileetudiant />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "Espace Stage",
        path: "/Stageetu",
        element: <Stageetu />,
      },
 

    ],
  },
  
  {
    // title: "auth pages",
    layout: "auth",
    pages: [
      {
        icon: <ServerStackIcon {...icon} />,
        name: "sign in",
        path: "/sign-in",
        element: <SignIn />,
      },
      {
        icon: <RectangleStackIcon {...icon} />,
        name: "sign up",
        path: "/sign-up",
        element: <SignUp />,
      },
    ],
  },
];

export default routes;
