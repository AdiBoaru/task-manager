import TableBody from "./TableBody/TableBody";
import TableHeader from "./TableHeader/TableHeader";

const Table = ({ data, openModal, setIsConfirmationModal }: any) => {
  const headerData =
    data &&
    Object.keys(data[0])
      .map((header) => header.charAt(0).toUpperCase() + header.slice(1))
      .concat("Edit");

  return (
    <div className="flex flex-col items-start">
      <div className="overflow-y-scroll scrollbar h-[70vh] rounded-t-[20px]">
        {data?.length ? (
          <table className="max-h-full w-[70vw]">
            <TableHeader headerData={headerData} />
            <TableBody entries={data} openModal={openModal} setIsConfirmationModal={setIsConfirmationModal}/>
          </table>
        ) : (
          <div className="text-white text-center w-[100px]">No data</div>
        )}
      </div>
      <p className="text-white">{data && `${data?.length}`}</p>
    </div>
  );
};

export default Table;
