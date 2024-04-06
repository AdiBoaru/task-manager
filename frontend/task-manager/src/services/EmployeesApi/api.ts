import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { TEmployeesPick } from "../../interfaces/TCreateTeamData";

export const apiEmployeeSlice = createApi({
  reducerPath: "employeesApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/" }),
  tagTypes: ["Employee"],
  endpoints: (builder) => ({
    getEmployees: builder.query<TEmployeesPick[], void>({
      query: () => `employee`,
    }),
  }),
});

export const { useGetEmployeesQuery } = apiEmployeeSlice;
