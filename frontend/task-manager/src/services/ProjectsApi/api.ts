import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { TProjectsData } from "../../interfaces/TProjectsData";

export const apiProjectSlice = createApi({
  reducerPath: "projectsApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/" }),
  tagTypes: ["Project"],
  endpoints: (builder) => ({
    getProjects: builder.query<TProjectsData, void>({
      query: () => "project",
      providesTags: ["Project"],
    }),
    createProject: builder.mutation({
      query: (resource) => ({
        url: "/project",
        method: "POST",
        body: resource,
      }),
      invalidatesTags: ["Project"],
    }),
    deleteProject: builder.mutation({
      query: (id) => ({
        url: `project/${id}`,
        method: "DELETE",
      }),
      invalidatesTags: ["Project"],
    }),
    editProject: builder.mutation({
      query: ({ id, ...patch }) => ({
        url: `project/${id}`,
        method: "PATCH",
        body: { patch },
      }),
      invalidatesTags: (result, error) => (!error ? ["Project"] : []),
    }),
  }),
});

export const {
  useGetProjectsQuery,
  useCreateProjectMutation,
  useDeleteProjectMutation,
  useEditProjectMutation,
} = apiProjectSlice;
