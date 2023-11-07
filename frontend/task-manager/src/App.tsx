import { ToastContainer } from "react-toastify";

import SwitchRoutes from "./components/SwitchRoutes";

import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <div>
      <ToastContainer />
      <SwitchRoutes />
    </div>
  );
}

export default App;
