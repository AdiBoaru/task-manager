import { Outlet } from "react-router-dom";

import SideNavigation from "../Navigation/SideNavigation/SideNavigation";
import TopNavigation from "../Navigation/TopNavigation/TopNavigation";

const Layout = () => {
  return (
    <div className="w-screen h-[calc(100%-200px)] overflow-x-hidden">
      <TopNavigation />
      <SideNavigation />
      <div className="fixed right-0 w-[calc(100%-325px)] mt-[200px]">
        <Outlet />
      </div>
    </div>
  );
};

export default Layout;
