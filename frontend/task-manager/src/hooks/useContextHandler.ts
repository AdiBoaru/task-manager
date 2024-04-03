import { useDispatch } from "react-redux";
import { setTableContext } from "../store/slices/tableContextSlice";
import { useLocation } from "react-router-dom";
import { useEffect } from "react";

const useContextHandler = () => {
  const dispatch = useDispatch();
  const { pathname } = useLocation();
  useEffect(() => {
    const pathContextMap = {
      "/teams": "teams",
      "/tasks": "tasks",
      "/projects": "projects",
    } as any;

    const basePath = pathname.split("/").slice(0, 2).join("/");
    const contextForPage = pathContextMap[basePath] || "defaultContext"; // Tre sa vad aici dc nu se updateaza contextu in tableDataContent in functia de delete

    dispatch(setTableContext(contextForPage));
  }, [dispatch, pathname]);
};

export default useContextHandler;
