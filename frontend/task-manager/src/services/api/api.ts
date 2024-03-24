import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'
import { TProjectsData } from '../../interfaces/TProjectsData';
import { TTeamsData } from '../../interfaces/TTeamsData';

export const apiSlice = createApi({
  reducerPath: 'api',
  baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/' }),
  tagTypes: ['Team'],
  endpoints: (builder) => 
  ({
    getProjects: builder.query<TProjectsData, void>({
      query: () => 'project',
    }),
    getTasks: builder.query<any, void>({
      query: () => `task`,
    }),
    getTeams: builder.query<TTeamsData, void>({
      query: () => `team`,
      providesTags: ['Team']
    }),
    getEmployees: builder.query<any, void>({
      query: () => `employee`,
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
        url: '/team',
        method: 'POST',
        body: resource,
      }),
      invalidatesTags: ['Team']
    }),
  }),
})

export const { useGetProjectsQuery, useGetEmployeesQuery, useGetTasksQuery, useGetTeamsQuery, useCreateProjectMutation, useCreateTeamMutation } = apiSlice;