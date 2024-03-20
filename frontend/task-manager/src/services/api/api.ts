import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'
import { TProjectsData } from '../../interfaces/TProjectsData';
import { TTeamsData } from '../../interfaces/TTeamsData';

export const apiSlice = createApi({
  reducerPath: 'api',
  baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/' }),
  endpoints: (builder) => 
  ({
    getProjects: builder.query<TProjectsData, void>({
      query: () => 'project',
    }),
    getTasks: builder.query({
      query: () => `task`,
    }),
    getTeams: builder.query<TTeamsData, void>({
      query: () => `team`,
    }),
    createProject: builder.mutation({
        query: (resource) => ({
          url: '/project/create',
          method: 'POST',
          body: resource,
        }),
    }),
    createTeam: builder.mutation({
      query: (resource) => ({
        url: '/team/create',
        method: 'POST',
        body: resource,
      }),
    }),
  }),
})

export const { useGetProjectsQuery, useGetTasksQuery, useGetTeamsQuery, useCreateProjectMutation, useCreateTeamMutation } = apiSlice;