import Table from "../../UI/Table/Table";
import { useGetTeamsQuery } from "../../services/api/api";

const TeamsPage = () => {
  const { data: teams } = useGetTeamsQuery();

  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      <Table data={teams} />
    </div>
  );
};

export default TeamsPage;
