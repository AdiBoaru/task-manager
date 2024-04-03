import { configureStore } from "@reduxjs/toolkit";
import { setupListeners } from "@reduxjs/toolkit/query";
import { apiProjectSlice } from "../services/ProjectsApi/api";
import { apiTeamSlice } from "../services/TeamsApi/api";
import { apiTaskSlice } from "../services/TasksApi/api";
import { apiEmployeeSlice } from "../services/EmployeesApi/api";
import { tableContextSlice } from "./slices/tableContextSlice";
import { modalSlice } from "./slices/modalSlice";

export const store = configureStore({
  reducer: {
    [apiProjectSlice.reducerPath]: apiProjectSlice.reducer,
    [apiTeamSlice.reducerPath]: apiTeamSlice.reducer,
    [apiTaskSlice.reducerPath]: apiTaskSlice.reducer,
    [apiEmployeeSlice.reducerPath]: apiEmployeeSlice.reducer,
    [tableContextSlice.reducerPath]: tableContextSlice.reducer,
    [modalSlice.reducerPath]: modalSlice.reducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(
      apiProjectSlice.middleware,
      apiTeamSlice.middleware,
      apiTaskSlice.middleware,
      apiEmployeeSlice.middleware
    ),
});

setupListeners(store.dispatch);
export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
