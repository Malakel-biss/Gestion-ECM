import {
    BanknotesIcon,
    UserPlusIcon,
    UsersIcon,
    ChartBarIcon,
  } from "@heroicons/react/24/solid";
  
  export const etudiantstat = [
    {
      color: "gray",
      icon: BanknotesIcon,
      title: "Mention de stage",
      value: "",
      footer: {
        color: "text-green-500",
        value: "",
        label: "",
      },
    },
    {
      color: "gray",
      icon: UsersIcon,
      title: "Professeur Encadrant",
      value: "Assma El Hajjam",
      footer: {
        color: "text-green-500",
        value: "",
        label: "",
      },
    },
    // {
    //   color: "gray",
    //   icon: UserPlusIcon,
    //   title: "Statistiques Candidats",
    //   value: "200",
    //   footer: {
    //     color: "text-green-500",
    //     value: "+20%",
    //     label: "que l'année dernière",
    //   },
    // },
    {
      color: "gray",
      icon: ChartBarIcon,
      title: "Statut",
      value: "Etudiant",
      footer: {
        color: "text-red-500",
        value: "",
        label: "",
      },
    },
  ];
  
  export default etudiantstat;
  