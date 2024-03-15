import { headerDataTeam } from "../../../../constants/tableTeamResource";
import useTable from "../../../../hooks/useTable";
import ArrowsFilter from "../../TableArrowsFilter/ArrowsFilter";

const TableHeader = () => {
  const { handleSortClick, sort } = useTable();

  return (
    <thead className="sticky top-0 bg-secondaryColor">
      <tr>
        {headerDataTeam.map(({ id, header }) => (
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
