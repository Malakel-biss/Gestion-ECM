import { SignIn, SignUp } from "@/pages/auth";
import { Homepage} from "@/pages/Acceuil";

export const routesnav = [
  {
    name: "homepage",
    path: "/Acceuil",
    element: <Homepage />,
  },

  {
    name: "Administrateur",
    path: "/sign-in",
    element: <SignIn />,
  },
  {
    name: "Professeur",
    path: "/sign-in",
    element: <SignIn />,
  },
  {
    name: "Etudiant",
    path: "/sign-in",
    element: <SignIn />,
  },
  {
    name: "Candidat",
    path: "/sign-up",
    element: <SignUp />,
  },
//   {
//     name: "Docs",
//     href: "https://www.material-tailwind.com/docs/react/installation",
//     target: "_blank",
//     element: "",
//   },
];

export default routesnav;
