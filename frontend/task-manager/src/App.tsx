import { ToastContainer } from "react-toastify";
import { Provider } from "react-redux";
import { store } from "./store";
import SwitchRoutes from "./components/SwitchRoutes";

import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <Provider store={store}>
      <SwitchRoutes />
      <ToastContainer />
    </Provider>
  );
}

export default App;
