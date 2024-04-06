import { PayloadAction, createSlice } from "@reduxjs/toolkit";

export const tableContextSlice = createSlice({
  name: "tableContext",
  initialState: "projects",
  reducers: {
    setTableContext(_, action: PayloadAction<string>) {
      return action.payload;
    },
  },
});

export const { setTableContext } = tableContextSlice.actions;
