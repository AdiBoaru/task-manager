import { Route, Routes, useLocation } from "react-router-dom";
import { Fragment } from "react";

import { ROUTES } from "../constants/routes";
import ROUTEPATHS from "../constants/routePaths";
import Layout from "./Layout/Layout";

const SwitchRoutes = () => {
  const { pathname } = useLocation();

  return (
    <Routes data-testid="switch-routes">
      <Route
        path={ROUTEPATHS.DEFAULT}
        element={
          pathname !== "/landing-page" &&
          pathname !== "/login" &&
          pathname !== "/register" && <Layout />
        }
      >
        {ROUTES.map(({ path, element }, index) => (
          <Fragment key={index}>
            <Route path={path} element={element} />
          </Fragment>
        ))}
      </Route>
    </Routes>
  );
};

export default SwitchRoutes;
