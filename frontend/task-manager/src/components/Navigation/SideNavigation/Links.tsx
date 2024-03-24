import { NavLink } from "react-router-dom";
import { SIDE_LINKS } from "../../../constants/SideNavLinks";

const Links = () => {
  const topSection = SIDE_LINKS.slice(0, SIDE_LINKS.length - 2);
  const bottomSection = SIDE_LINKS.slice(
    SIDE_LINKS.length - 2,
    SIDE_LINKS.length
  );

  return (
    <div className="flex flex-col justify-between h-[calc(100vh-200px)]">
      <div className="border-b-[1px] h-[450px] ">
        {topSection.map(({ title, href, icon }: any) => (
          <div key={title} className=" text-white">
            <NavLink
              to={href}
              data-testid="side-nav-link"
              className={({ isActive }) =>
                `${
                  isActive &&
                  "bg-gray-100 bg-opacity-10 border-secondaryColor border-r-2"
                } relative p-5 flex items-end justify-start z-10 before:bg-gray-100 before:bg-opacity-10 before:content[''] before:absolute before:w-[100%] before:h-[100%] before:top-0 before:left-0 before:scale-x-0 before:transition-transform before:ease-in-out before:origin-left before:duration-500 hover:before:scale-x-100 hover:before:origin-left`
              }
            >
              <span className="text-3xl mr-3">{icon}</span>
              {title}
            </NavLink>
          </div>
        ))}
      </div>
      <div>
        {bottomSection.map(({ title, href, icon }) => (
          <div key={title} className="text-white">
            <NavLink
              to={href}
              data-testid="side-nav-link"
              className={({ isActive }) =>
                `${
                  isActive &&
                  "bg-gray-100 bg-opacity-10 border-secondaryColor border-r-2"
                } relative p-5 flex items-end justify-start z-10 before:bg-gray-100 before:bg-opacity-10 before:content[''] before:absolute before:w-[100%] before:h-[100%] before:top-0 before:left-0 before:scale-x-0 before:transition-transform before:ease-in-out before:origin-left before:duration-500 hover:before:scale-x-100 hover:before:origin-left`
              }
            >
              <span className="text-3xl mr-3">{icon}</span>
              {title}
            </NavLink>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Links;
