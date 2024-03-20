import useTable from "../../../hooks/useTable";
import ArrowsFilter from "../TableArrowsFilter/ArrowsFilter";

const TableHeader = ({ headerData }: any) => {
  const { handleSortClick, sort } = useTable();

  return (
    <thead className="sticky top-0 bg-secondaryColor">
      <tr>
        {headerData.map((val: any) => (
          <ArrowsFilter
            colTitle={val}
            sortTable={handleSortClick}
            sort={sort}
            key={val}
          />
        ))}
      </tr>
    </thead>
  );
};

export default TableHeader;
