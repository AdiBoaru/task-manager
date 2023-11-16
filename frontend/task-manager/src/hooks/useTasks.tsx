import { BsTrash } from "react-icons/bs";
import { useState } from "react";

const useTasks = () => {
  const [tasks, setTasks] = useState([
    {
      id: "1",
      name: "Security project",
      description: "create interface",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "2",
      name: "ING",
      description: "create backend",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "3",
      name: "BTPAY",
      description: "debug",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "4",
      name: "CC",
      description: "fix issues",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
    {
      id: "5",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: <BsTrash />,
    },
  ]);

  return { tasks };
};

export default useTasks;
