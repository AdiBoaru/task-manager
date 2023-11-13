import TableHeader from "./TableHeader/TableHeader";

const Table = () => {
  const data = ["test"];
  return (
    <>
      {data.length ? (
        <table>
          <TableHeader />
        </table>
      ) : (
        <p>No data</p>
      )}
    </>
  );
};

export default Table;
