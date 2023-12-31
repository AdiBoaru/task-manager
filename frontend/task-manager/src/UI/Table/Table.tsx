import { useEffect, useState } from "react";
import { headerData } from "../../constants/tableResource";
import useTasks from "../../hooks/useTasks";
import TableBody from "./TableBody/TableBody";
import TableHeader from "./TableHeader/TableHeader";

const Table = ({ data }: { data: any[] }) => {
  const [dataInfo, setDataInfo] = useState([]);

  const url = "http://localhost:8080/project";
  useEffect(() => {
    fetch(url)
      .then((res) => res.json())
      .then((res) => setDataInfo(res));
  }, []);

  console.log(dataInfo);
  return (
    <div className="flex flex-col items-start ">
      <div className="overflow-y-scroll scrollbar h-[70vh] rounded-t-[20px]">
        {data.length ? (
          <table className="h-[100vh] w-[70vw]">
            <TableHeader />
            <TableBody entries={data} columns={headerData} />
          </table>
        ) : (
          <p>No data</p>
        )}
      </div>
      <p className="text-white">Projects: {data.length}</p>
    </div>
  );
};

export default Table;
