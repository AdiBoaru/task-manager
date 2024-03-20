import Table from "../../UI/Table/Table";

import { useGetProjectsQuery } from "../../services/api/api";

const ProjectsPage = () => {
  const { data } = useGetProjectsQuery();
 
  if (!data) return null;

  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      <Table data={data} />
    </div>
  );
};

export default ProjectsPage;
