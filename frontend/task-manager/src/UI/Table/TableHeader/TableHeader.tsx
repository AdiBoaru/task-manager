import { headerData } from "../../../constants/tableResource";
import useTable from "../../../hooks/useTable";
import ArrowsFilter from "../TableArrowsFilter/ArrowsFilter";

const TableHeader = () => {
  const { handleSortClick, sort } = useTable();

  return (
    <thead className="sticky top-0 bg-secondaryColor">
      <tr>
        {headerData.map(({ id, header }) => (
          <ArrowsFilter
            colTitle={header}
            sortTable={handleSortClick}
            sort={sort}
            key={id}
          />
        ))}
      </tr>
    </thead>
  );
};

export default TableHeader;
