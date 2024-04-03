import Table from "../../UI/Table/Table";
import { useGetTasksQuery } from "../../services/api/api";

const TasksPage = () => {
  const { data, isLoading } = useGetTasksQuery();

  if (isLoading) {
    return <div>Loading....</div>;
  }

  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      <Table data={data} />
    </div>
  );
};

export default TasksPage;
