import { Route, Routes } from "react-router-dom";
import { ROUTES } from "../constants/routes";
import { Fragment } from "react";

const SwitchRoutes = () => {
  return (
    <Routes data-testid="switch-routes">
      {ROUTES.map(({ path, element }, index) => (
        <Fragment key={index}>
          <Route path={path} element={element} />
        </Fragment>
      ))}
    </Routes>
  );
};

export default SwitchRoutes;
