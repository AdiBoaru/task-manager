import { NavLink } from "react-router-dom";

import { DEFAULT } from "../../constants/routePaths";
import classNames from "classnames";

const Logo = ({ mt }: { mt?: string }) => {
  return (
    <div
      className={classNames(
        `flex justify-between w-[20rem] items-center ${mt}`
      )}
    >
      <NavLink
        data-testid="landing-page-logo"
        to={DEFAULT}
        className="text-secondaryColor text-5xl "
      >
        TaskFlow
      </NavLink>
      <img className="h-15 w-20" src="./assets/brain-line-icon.png" />
    </div>
  );
};

export default Logo;