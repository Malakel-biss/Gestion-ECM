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
  import { authorsTableData, stageDataTable } from "@/data";
  import { HiPencilAlt, HiTrash } from 'react-icons/hi';
  import axios from "axios";
import { useState, useEffect } from "react";
    
    export function Tablesstages() {

      const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios.get(
        "http://localhost:8080/api/admin/intern",
        
      );
      setData(result.data);
      console.log(result.data);
    };
    fetchData();
  }, []
  );
  console.log(data);


 useEffect(() => {}, []);
      
      

      const handleButtonClick = () => {
        // Navigate to another page when the button is clicked
        window.location.href ='/dashboard/typestage'; // Replace '/your-other-page' with the actual path you want to navigate to
      };
      return (
        <div className="mt-12 mb-8 flex flex-col gap-12">
          <Card>
            <CardHeader variant="gradient" color="gray" className="mb-8 p-6">
              <Typography variant="h6" color="white">
                Liste des stages
               
              </Typography>
              
            </CardHeader>
            <Button variant="outlined" size="sm" color="black" className="w-24 ml-auto"onClick={handleButtonClick}>
      Gestion Type Stages 
    </Button>
            <CardBody className="overflow-x-scroll px-0 pt-0 pb-2">
              <table className="w-full min-w-[640px] table-auto">
                <thead>
                  <tr>
                    {["Nom étudiant", "Promotion", "Entreprise","Tuteur","Professeur Encadrant","Compte Rendu","action"].map((el) => (
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
                ({ nomEtudiant, anneePromo, nomEntreprise, nomTuteur,compteRendu ,nomProfesseur}, key) => {
                  const className = `py-3 px-5 ${
                    key === authorsTableData.length - 1
                      ? ""
                      : "border-b border-blue-gray-50"
                  }`;

                  return (
                    <tr key={nomEtudiant}>
                      <td className={className}>
                        <div className="flex items-center gap-4">
                          <div>
                            <Typography
                              variant="small"
                              color="blue-gray"
                              className="font-semibold"
                            >
                             {nomEtudiant }
                            </Typography>
                          </div>
                        </div>
                      </td>
                      <td className={className}>
                      <Typography className="text-xs font-semibold text-blue-gray-600">
                          {anneePromo}
                        </Typography>
                      </td>
                 
                      <td className={className}>
                        <Typography className="text-xs font-semibold text-blue-gray-600">
                          {nomEntreprise}
                        </Typography>
                      </td>
                      <td className={className}>
                        <Typography className="text-xs font-semibold text-blue-gray-600">
                          {nomTuteur}
                        </Typography>
                      </td>
                      {/* <td className={className}>
                            <Chip
                              variant="gradient"
                              color={statut ? "green" : "red"}
                              value={statut ? "valide" : "non valide"}
                              className="py-0.5 px-2 text-[11px] font-medium w-fit"
                            />
                          </td> */}
                      <td className={className}>
                        <Typography className="text-xs font-semibold text-blue-gray-600">
                          {nomProfesseur}
                        </Typography>
                      </td>
                  
                      <td className={className}>
                        <Typography className="text-xs font-semibold text-blue-gray-600">
                          {compteRendu}
                        </Typography>
                      </td>
                      <td className={className}>
                      <Typography as="div" className="flex items-center">
                        <Link to="/dashboard/ModifyStage">
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
          {/* <Card>
            <CardHeader variant="gradient" color="gray" className="mb-8 p-6">
              <Typography variant="h6" color="white">
                Projects Table
              </Typography>
            </CardHeader>
            <CardBody className="overflow-x-scroll px-0 pt-0 pb-2">
              <table className="w-full min-w-[640px] table-auto">
                <thead>
                  <tr>
                    {["companies", "members", "budget", "completion", ""].map(
                      (el) => (
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
                      )
                    )}
                  </tr>
                </thead>
                <tbody>
                  {projectsTableData.map(
                    ({ img, name, members, budget, completion }, key) => {
                      const className = `py-3 px-5 ${
                        key === projectsTableData.length - 1
                          ? ""
                          : "border-b border-blue-gray-50"
                      }`;
    
                      return (
                        <tr key={name}>
                          <td className={className}>
                            <div className="flex items-center gap-4">
                              <Avatar src={img} alt={name} size="sm" />
                              <Typography
                                variant="small"
                                color="blue-gray"
                                className="font-bold"
                              >
                                {name}
                              </Typography>
                            </div>
                          </td>
                          <td className={className}>
                            {members.map(({ img, name }, key) => (
                              <Tooltip key={name} content={name}>
                                <Avatar
                                  src={img}
                                  alt={name}
                                  size="xs"
                                  variant="circular"
                                  className={`cursor-pointer border-2 border-white ${
                                    key === 0 ? "" : "-ml-2.5"
                                  }`}
                                />
                              </Tooltip>
                            ))}
                          </td>
                          <td className={className}>
                            <Typography
                              variant="small"
                              className="text-xs font-medium text-blue-gray-600"
                            >
                              {budget}
                            </Typography>
                          </td>
                          <td className={className}>
                            <div className="w-10/12">
                              <Typography
                                variant="small"
                                className="mb-1 block text-xs font-medium text-blue-gray-600"
                              >
                                {completion}%
                              </Typography>
                              <Progress
                                value={completion}
                                variant="gradient"
                                color={completion === 100 ? "green" : "gray"}
                                className="h-1"
                              />
                            </div>
                          </td>
                          <td className={className}>
                            <Typography
                              as="a"
                              href="#"
                              className="text-xs font-semibold text-blue-gray-600"
                            >
                              <EllipsisVerticalIcon
                                strokeWidth={2}
                                className="h-5 w-5 text-inherit"
                              />
                            </Typography>
                          </td>
                        </tr>
                      );
                    }
                  )}
                </tbody>
              </table>
            </CardBody>
          </Card> */}
        </div>
      );
    }
    
    export default Tablesstages;
    