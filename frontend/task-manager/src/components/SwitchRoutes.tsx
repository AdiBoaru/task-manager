import { Route, Routes } from "react-router-dom";
import { ROUTES } from "../constants/routes";
import { Fragment } from "react";

const SwitchRoutes = () => {
  return (
    <Routes>
      {ROUTES.map(({ path, auth, element, roles }, index) => (
        <Fragment key={index}>
          <Route path={path} element={element} />
        </Fragment>
      ))}
    </Routes>
  );
};

export default SwitchRoutes;
