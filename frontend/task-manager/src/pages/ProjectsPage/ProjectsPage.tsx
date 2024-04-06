import Table from "../../UI/Table/Table";

import { useGetProjectsQuery } from "../../services/ProjectsApi/api";

const ProjectsPage = () => {
  const { data: projects, isLoading } = useGetProjectsQuery();

  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      {isLoading ? (
        <div className="text-white">Loading...</div>
      ) : (
        <Table data={projects} />
      )}
    </div>
  );
};

export default ProjectsPage;
