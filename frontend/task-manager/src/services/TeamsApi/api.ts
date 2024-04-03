import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { TTeamPick } from "../../interfaces/TCreateProjectData";

export const apiTeamSlice = createApi({
  reducerPath: "teamApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/" }),
  tagTypes: ["Team"],
  endpoints: (builder) => ({
    getTeams: builder.query<TTeamPick[], void>({
      query: () => `team`,
      providesTags: ["Team"],
    }),
    getTeam: builder.query<TTeamPick, void>({
      query: (id) => `team/${id}`,
      transformResponse: (response: { data: TTeamPick }, meta, arg) =>
        response.data,
      providesTags: ["Team"],
    }),
    createTeam: builder.mutation({
      query: (resource) => ({
        url: "/team",
        method: "POST",
        body: resource,
      }),
      invalidatesTags: ["Team"],
    }),
    deleteTeam: builder.mutation({
      query: (id) => ({
        url: `team/${id}`,
        method: "DELETE",
      }),
      invalidatesTags: ["Team"],
    }),
    updateTeam: builder.mutation({
      query: (id) => ({
        url: `team/${id}`,
        method: "PATCH",
      }),
      invalidatesTags: ["Team"],
    }),
  }),
});

export const {
  useGetTeamsQuery,
  useGetTeamQuery,
  useCreateTeamMutation,
  useDeleteTeamMutation,
  useUpdateTeamMutation,
} = apiTeamSlice;
