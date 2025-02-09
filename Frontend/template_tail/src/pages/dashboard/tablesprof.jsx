import {
  Card,
  CardHeader,
  CardBody,
  Typography,
  Avatar,
  Chip,
  Tooltip,
  Button,
  Progress,
} from "@material-tailwind/react";
import { Link } from "react-router-dom";
import { EllipsisVerticalIcon } from "@heroicons/react/24/outline";
import { authorsTableData, prof } from "@/data";
import { HiPencilAlt, HiTrash } from 'react-icons/hi';
import axios from "axios";
import { useState, useEffect } from "react";
 const handleButtonClicker = () => {
    // Navigate to another page when the button is clicked
    window.location.href ='/dashboard/Ajouterprof'; // Replace '/your-other-page' with the actual path you want to navigate to
  };
export function Tablesprof() {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios.get(
        "http://localhost:8080/api/admin/professor"
      );
      setData(result.data);
      console.log(result.data);
    };
    fetchData();
  }, []
  );
  console.log(data);


 useEffect(() => {}, []);
  return (
    <div className="mt-12 mb-8 flex flex-col gap-12">
      <Card>
        <CardHeader variant="gradient" color="gray" className="mb-8 p-6">
          <Typography variant="h6" color="white">
            Liste des professeurs
           
          </Typography>
          
        </CardHeader>
        {/* <Link to="/dashboard/AjouterEtudiant"> */}
        <Button variant="outlined" size="sm" color="black" className="w-24 ml-auto" onClick={handleButtonClicker}>
  Ajouter Professeur
</Button>

        <CardBody className="overflow-x-scroll px-0 pt-0 pb-2">
          <table className="w-full min-w-[640px] table-auto">
            <thead>
              <tr>
                {["Nom complet", "Adresse", "Telephone", "Date Embauche","Date Départ","Action"].map((el) => (
                  <th
                    key={el}
                    className="border-b border-blue-gray-50 py-3 px-5 text-left"
                  >
                    <Typography
                      variant="small"
                      className="text-[11px] font-bold uppercase text-blue-gray-400"
                    >
                      {el}
                    </Typography>
                  </th>
                ))}
              </tr>
            </thead>
            <tbody>
            {data && data.length > 0 && data.map(
                ({ pnom, pprenom, padresse, ptelephonedomicile, dateembauche,datedepart }, key) => {
                  const className = `py-3 px-5 ${
                    key === authorsTableData.length - 1
                      ? ""
                      : "border-b border-blue-gray-50"
                  }`;

                  return (
                    <tr key={pnom}>
                      <td className={className}>
                        <div className="flex items-center gap-4">
                          <div>
                            <Typography
                              variant="small"
                              color="blue-gray"
                              className="font-semibold"
                            >
                             {pnom + " " + pprenom}
                            </Typography>
                          </div>
                        </div>
                      </td>
                      <td className={className}>
                      <Typography className="text-xs font-semibold text-blue-gray-600">
                          {padresse}
                        </Typography>
                      </td>
                      {/* <td className={className}>
                        <Chip
                          variant="gradient"
                          color={online ? "green" : "blue-gray"}
                          value={online ? "online" : "offline"}
                          className="py-0.5 px-2 text-[11px] font-medium w-fit"
                        />
                      </td> */}
                      <td className={className}>
                        <Typography className="text-xs font-semibold text-blue-gray-600">
                          {ptelephonedomicile}
                        </Typography>
                      </td>
                      <td className={className}>
                        <Typography className="text-xs font-semibold text-blue-gray-600">
                          {dateembauche}
                        </Typography>
                      </td>
                      <td className={className}>
                        <Typography className="text-xs font-semibold text-blue-gray-600">
                          {datedepart}
                        </Typography>
                      </td>
                      <td className={className}>
                      <Typography as="div" className="flex items-center">
                        <Link to="/dashboard/Modifyprof">
    <button  className="mr-2" title="Edit" >
      <HiPencilAlt className="text-blue-gray-600" />
    </button>
    </Link>
    <button title="Delete">
      <HiTrash className="text-red-500" />
    </button>
  </Typography>
                      </td>
                    </tr>
                  );
                }
              )}
            </tbody>
          </table>
        </CardBody>
      </Card>

    </div>
  );
}

export default Tablesprof;
