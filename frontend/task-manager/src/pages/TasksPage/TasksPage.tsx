import Table from "../../UI/Table/Table";
import { useGetTasksQuery } from "../../services/api/api";

const TasksPage = () => {
  const { data, error, isLoading, isFetching } = useGetTasksQuery("task");
  console.log(data);

  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      <Table
        data={data}
        error={error}
        isLoading={isLoading}
        isFetching={isFetching}
        tableHeader={TASKS_PAGE_HEADER}
      />
    </div>
  );
};

export default TasksPage;
