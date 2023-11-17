import { Navigate } from "react-router-dom";
import {
  DEFAULT,
  HOME,
  LANDING_PAGE,
  LOGIN,
  PROJECTS,
  REGISTER,
  TEAMS,
} from "./routePaths";
import LandingPage from "../pages/LandingPage/LandingPage";
import RegisterPage from "../pages/RegisterPage/RegisterPage";
import LoginPage from "../pages/LoginPage/LoginPage";
import ProjectsPage from "../pages/ProjectsPage/ProjectsPage";
import HomePage from "../pages/HomePage/HomePage";
import TeamsPage from "../pages/TeamsPage/TeamsPage";

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
  {
    path: LOGIN,
    auth: false,
    roles: [],
    element: <LoginPage />,
  },
  {
    path: PROJECTS,
    auth: true,
    roles: [],
    element: <ProjectsPage />,
  },
  {
    path: HOME,
    auth: true,
    roles: [],
    element: <HomePage />,
  },
  {
    path: TEAMS,
    auth: true,
    roles: [],
    element: <TeamsPage />,
  },
];
