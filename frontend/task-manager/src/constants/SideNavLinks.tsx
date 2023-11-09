import { TLinks } from "../interfaces/TLinks";
import {
  HOME,
  LOGIN,
  PROFILE,
  PROJECTS,
  SETTINGS,
  TASKS,
  TEAMS,
} from "./routePaths";
import { RiHome2Line, RiTeamLine } from "react-icons/ri";
import { AiOutlineFundProjectionScreen } from "react-icons/ai";
import { BsListTask } from "react-icons/bs";
import { CgProfile } from "react-icons/cg";
import { LuSettings } from "react-icons/lu";
import { RxExit } from "react-icons/rx";

export const SIDE_LINKS: TLinks[] = [
  { title: "Home", href: HOME, role: [], icon: <RiHome2Line /> },
  {
    title: "Projects",
    href: PROJECTS,
    role: [],
    icon: <AiOutlineFundProjectionScreen />,
  },
  { title: "Tasks", href: TASKS, role: [], icon: <BsListTask /> },
  { title: "Profile", href: PROFILE, role: [], icon: <CgProfile /> },
  { title: "Teams", href: TEAMS, role: [], icon: <RiTeamLine /> },
  { title: "Settings", href: SETTINGS, role: [], icon: <LuSettings /> },
  { title: "Logout", href: LOGIN, role: [], icon: <RxExit /> },
];
