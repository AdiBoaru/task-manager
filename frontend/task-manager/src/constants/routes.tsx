import { Navigate } from "react-router-dom";
import ROUTESPATHS from "./routePaths";
import LandingPage from "../pages/LandingPage/LandingPage";
import RegisterPage from "../pages/RegisterPage/RegisterPage";
import LoginPage from "../pages/LoginPage/LoginPage";
import ProjectsPage from "../pages/ProjectsPage/ProjectsPage";
import HomePage from "../pages/HomePage/HomePage";
import TeamsPage from "../pages/TeamsPage/TeamsPage";
import TasksPage from "../pages/TasksPage/TasksPage";
import ProfilePage from "../pages/ProfilePage/ProfilePage";

export const ROUTES = [
  {
    path: ROUTESPATHS.DEFAULT,
    auth: false,
    roles: [],
    element: <Navigate to={ROUTESPATHS.LANDING_PAGE} />,
  },
  {
    path: ROUTESPATHS.LANDING_PAGE,
    auth: false,
    roles: [],
    element: <LandingPage />,
  },
  {
    path: ROUTESPATHS.REGISTER,
    auth: false,
    roles: [],
    element: <RegisterPage />,
  },
  {
    path: ROUTESPATHS.LOGIN,
    auth: false,
    roles: [],
    element: <LoginPage />,
  },
  {
    path: ROUTESPATHS.PROJECTS,
    auth: true,
    roles: [],
    element: <ProjectsPage />,
  },
  {
    path: ROUTESPATHS.HOME,
    auth: true,
    roles: [],
    element: <HomePage />,
  },
  {
    path: ROUTESPATHS.TEAMS,
    auth: true,
    roles: [],
    element: <TeamsPage />,
  },
  {
    path: ROUTESPATHS.TASKS,
    auth: true,
    roles: [],
    element: <TasksPage />,
  },
  {
    path: ROUTESPATHS.PROFILE,
    auth: false,
    roles: [],
    element: <ProfilePage />,
  },
];
