import { RiArrowUpSFill, RiArrowDownSFill } from "react-icons/ri";
import { ASC, DESC } from "../../../constants/sort-constants";

type TArrowsFilter = {
  colTitle: string;
  sortTable: (newSorting: { colTitle: string; direction: string }) => void;
  sort?: { colTitle: string; direction: string };
};

const ArrowsFilter = ({ colTitle, sort, sortTable }: TArrowsFilter) => {
  const isAscending = sort?.colTitle === colTitle && sort.direction === ASC;
  const isDescending = sort?.colTitle === colTitle && sort.direction === DESC;
  const futureOrder = isDescending ? ASC : DESC;

  return (
    <th
      className="p-5"
      onClick={() => sortTable({ colTitle, direction: futureOrder })}
    >
      <div className="flex items-center w-full">
        {colTitle}
        {isAscending && <RiArrowUpSFill />}
        {isDescending && <RiArrowDownSFill />}
      </div>
    </th>
  );
};

export default ArrowsFilter;
