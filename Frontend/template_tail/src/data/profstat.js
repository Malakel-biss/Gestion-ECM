import {
    BanknotesIcon,
    UserPlusIcon,
    UsersIcon,
    ChartBarIcon,
  } from "@heroicons/react/24/solid";
  
  export const profstat = [
    {
      color: "gray",
      icon: BanknotesIcon,
      title: "Promotion Associée",
      value: "2024",
      footer: {
        color: "text-green-500",
        value: "",
        label: "",
      },
    },
    // {
    //   color: "gray",
    //   icon: UsersIcon,
    // //   title: "Professeur Encadrant",
    //   value: "Etudiants",
    //   footer: {
    //     color: "text-green-500",
    //     value: "600",
    //     label: " étudiants",
    //   },
    // },
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
      title: "Profil ",
      value: "Professeur",
      footer: {
        color: "text-red-500",
        value: "",
        label: "",
      },
    },
  ];
  
  export default profstat;
  