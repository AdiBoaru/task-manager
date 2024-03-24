import TableBody from "./TableBody/TableBody";
import TableHeader from "./TableHeader/TableHeader";

const Table = ({ data }: any) => {
  const headerData =
    data &&
    Object.keys(data[0]).map(
      (header) => header.charAt(0).toUpperCase() + header.slice(1)
    );

  return (
    <div className="flex flex-col items-start ">
      <div className="overflow-y-scroll scrollbar h-[70vh] rounded-t-[20px]">
        {data?.length ? (
          <table className="h-[100vh] w-[70vw]">
            <TableHeader headerData={headerData} />
            <TableBody entries={data} />
          </table>
        ) : (
          <div className="text-white text-center w-[100px]">No data</div>
        )}
      </div>
      <p className="text-white">{data && `Projects: ${data?.length}`}</p>
    </div>
  );
};

export default Table;
