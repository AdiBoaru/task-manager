import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { TTeamPick } from "../../interfaces/TCreateProjectData";
import { TCreateTeamData } from "../../interfaces/TCreateTeamData";

export const apiTeamSlice = createApi({
  reducerPath: "teamApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/" }),
  tagTypes: ["Team"],
  endpoints: (builder) => ({
    getTeams: builder.query<TTeamPick[], void>({
      query: () => `team`,
      providesTags: ["Team"],
    }),
    getTeamById: builder.query<TCreateTeamData, number | string>({
      query: (id: any) => `team/${id}`,
      providesTags: (result, error, id) => [{ type: "Team", id }],
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
      query: ({ id, ...body }) => ({
        url: `team/${id}`,
        method: "PUT",
        body: body,
      }),
      invalidatesTags: ["Team"],
    }),
  }),
});

export const {
  useGetTeamsQuery,
  useGetTeamByIdQuery,
  useCreateTeamMutation,
  useDeleteTeamMutation,
  useUpdateTeamMutation,
} = apiTeamSlice;
