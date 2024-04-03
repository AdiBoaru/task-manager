import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { TTeamPick } from "../../interfaces/TCreateProjectData";

export const apiTaskSlice = createApi({
  reducerPath: "tasksApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/" }),
  tagTypes: ["Task"],
  endpoints: (builder) => ({
    getTasks: builder.query<TTeamPick[], void>({
      query: () => `task`,
      providesTags: ["Task"],
    }),
    createTask: builder.mutation({
      query: (resource) => ({
        url: "/task",
        method: "POST",
        body: resource,
      }),
      invalidatesTags: ["Task"],
    }),
    deleteTask: builder.mutation({
      query: (id) => ({
        url: `task/${id}`,
        method: "DELETE",
      }),
      invalidatesTags: ["Task"],
    }),
  }),
});

export const {
  useGetTasksQuery,
  useCreateTaskMutation,
  useDeleteTaskMutation,
} = apiTaskSlice;
