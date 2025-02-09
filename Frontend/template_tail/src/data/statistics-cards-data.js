import {
  BanknotesIcon,
  UserPlusIcon,
  UsersIcon,
  ChartBarIcon,
} from "@heroicons/react/24/solid";

export const statisticsCardsData = [
  {
    color: "gray",
    icon: BanknotesIcon,
    title: "Nombre Inscrits",
    value: "500",
    footer: {
      color: "text-green-500",
     
    },
  },
  {
    color: "gray",
    icon: UsersIcon,
    title: "Nombres reçus",
    value: "400",
    footer: {
      color: "text-green-500",
    },
  },
  {
    color: "gray",
    icon: UserPlusIcon,
    title: "Profil",
    value: "Admin",
    footer: {
      color: "text-green-500",
    },
  },
 

];

export default statisticsCardsData;
