import { ToastContainer } from "react-toastify";
import SwitchRoutes from "./components/SwitchRoutes";
import "react-toastify/dist/ReactToastify.css";
import useContextHandler from "./hooks/useContextHandler";

function App() {
  useContextHandler();

  return (
    <>
      <SwitchRoutes />
      <ToastContainer />
    </>
  );
}

export default App;
