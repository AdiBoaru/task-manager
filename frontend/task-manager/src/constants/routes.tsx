import { Navigate } from "react-router-dom";
import { LANDING_PAGE, REGISTER } from "./routePaths";
import LandingPage from "../pages/LandingPage/LandingPage";
import RegisterPage from "../pages/RegisterPage/RegisterPage";

export const ROUTES = [
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
