import Table from "../../UI/Table/Table";

import { useGetProjectsQuery } from "../../services/api/api";

const ProjectsPage = () => {
  const { data, isLoading } = useGetProjectsQuery();
  console.log(data);
  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      {isLoading ? (
        <div className="text-white">Loading...</div>
      ) : (
        <Table data={data} />
      )}
    </div>
  );
};

export default ProjectsPage;
