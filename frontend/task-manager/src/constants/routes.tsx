import { Navigate } from "react-router-dom";
import { DEFAULT, LANDING_PAGE, REGISTER } from "./routePaths";
import LandingPage from "../pages/LandingPage/LandingPage";
import RegisterPage from "../pages/RegisterPage/RegisterPage";

export const ROUTES = [
  {
    path: DEFAULT,
    auth: false,
    roles: [],
    element: <Navigate to={LANDING_PAGE} />,
  },
  {
    path: LANDING_PAGE,
    auth: false,
    roles: [],
    element: <LandingPage />,
  },
  {
    path: REGISTER,
    auth: false,
    roles: [],
    element: <RegisterPage />,
  },
];
