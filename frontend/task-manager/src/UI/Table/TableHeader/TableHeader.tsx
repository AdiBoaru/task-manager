import { headerData } from "../../../constants/tableResource";
import useTable from "../../../hooks/useTable";
import ArrowsFilter from "../TableArrowsFilter/ArrowsFilter";

const TableHeader = () => {
  const { handleSortClick, sort } = useTable();

  return (
    <thead>
      <tr>
        {headerData.map(({ id, header, hasFilter, key }) => (
          <th key={id}>
            <span>{header}</span>
            {hasFilter && (
              <ArrowsFilter
                filterOption={sort.direction}
                onClick={() => handleSortClick({ header, key })}
              />
            )}
          </th>
        ))}
      </tr>
    </thead>
  );
};

export default TableHeader;
