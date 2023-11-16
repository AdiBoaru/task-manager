import { headerData } from "../../constants/tableResource";
import useTasks from "../../hooks/useTasks";
import TableBody from "./TableBody/TableBody";
import TableHeader from "./TableHeader/TableHeader";

const Table = (data: any) => {
  const { tasks } = useTasks();

  return (
    <div className="flex flex-col items-start">
      <div className="overflow-auto no-scrollbar h-[70vh] rounded-t-[20px]">
        {tasks.length ? (
          <table className="relative h-[100vh] w-[70vw]">
            <TableHeader />
            <TableBody entries={tasks} columns={headerData} />
          </table>
        ) : (
          <p>No data</p>
        )}
      </div>
      <p className="text-white">Projects: {tasks.length}</p>
    </div>
  );
};

export default Table;
