import { RiArrowUpSFill, RiArrowDownSFill } from "react-icons/ri";
import { ASC, DESC } from "../../../constants/sort-constants";

type TArrowsFilter = {
  filterOption: string;
  onClick: () => void;
};

const ArrowsFilter = ({ filterOption, onClick }: TArrowsFilter) => {
  return (
    <div className="" onKeyDown={undefined} onClick={onClick}>
      <RiArrowUpSFill
        className={`${filterOption === ASC && "bg-secondaryColor"}`}
      />
      <RiArrowDownSFill
        className={`${filterOption === DESC && "bg-secondaryColor"}`}
      />
    </div>
  );
};

export default ArrowsFilter;
