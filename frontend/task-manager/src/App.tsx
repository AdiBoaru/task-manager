import { ToastContainer } from "react-toastify";
import SwitchRoutes from "./components/SwitchRoutes";

import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <>
      <SwitchRoutes />
      <ToastContainer />
    </>
  );
}

export default App;
