import { BsTrash } from "react-icons/bs";
import { TbEdit } from "react-icons/tb";
import { useState } from "react";

const useTasks = () => {
  const [tasks, setTasks] = useState([
    {
      id: "1",
      name: "Security project",
      description: "create interface",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "2",
      name: "ING",
      description: "create backend",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "3",
      name: "BTPAY",
      description: "debug",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "4",
      name: "CC",
      description: "fix issues",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "6",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "7",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "8",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "9",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "10",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "11",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "12",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
    {
      id: "13",
      name: "TEAM",
      description: "add auth",
      cc: "10-10-2025",
      team: ["fla,ditz,toghi"],
      edit: [{ trashIcon: <BsTrash />, editIcon: <TbEdit /> }],
    },
  ]);

  return { tasks };
};

export default useTasks;
