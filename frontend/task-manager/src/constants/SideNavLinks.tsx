import { TLinks } from "../interfaces/TLinks";
import ROUTEPATHS from "./routePaths";
import { RiHome2Line, RiTeamLine } from "react-icons/ri";
import { AiOutlineFundProjectionScreen } from "react-icons/ai";
import { BsListTask } from "react-icons/bs";
import { CgProfile } from "react-icons/cg";
import { LuSettings } from "react-icons/lu";
import { RxExit } from "react-icons/rx";

export const SIDE_LINKS: TLinks[] = [
  { title: "Home", href: ROUTEPATHS.HOME, role: [], icon: <RiHome2Line /> },
  {
    title: "Projects",
    href: ROUTEPATHS.PROJECTS,
    role: [],
    icon: <AiOutlineFundProjectionScreen />,
  },
  { title: "Tasks", href: ROUTEPATHS.TASKS, role: [], icon: <BsListTask /> },
  { title: "Profile", href: ROUTEPATHS.PROFILE, role: [], icon: <CgProfile /> },
  { title: "Teams", href: ROUTEPATHS.TEAMS, role: [], icon: <RiTeamLine /> },
  {
    title: "Settings",
    href: ROUTEPATHS.SETTINGS,
    role: [],
    icon: <LuSettings />,
  },
  { title: "Logout", href: ROUTEPATHS.LOGIN, role: [], icon: <RxExit /> },
];
