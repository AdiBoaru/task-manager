import { Navigate } from "react-router-dom";
import { LANDING_PAGE } from "./routePaths";
import LandingPage from "../components/LandingPage/LandingPage";

export const ROUTES = [
  {
    path: LANDING_PAGE,
    auth: false,
    roles: [],
    element: <LandingPage />,
  },
];
