import { useEffect, useState } from "react";
import Table from "../../UI/Table/Table";

const ProjectsPage = () => {
  const [projects, setProjects] = useState([]);
  const URL = "http://localhost:8080/project";
  useEffect(() => {
    fetch(URL)
      .then((res) => res.json())
      .then((projects) => setProjects(projects));
  }, []);

  console.log(projects);

  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      <Table />
    </div>
  );
};

export default ProjectsPage;
