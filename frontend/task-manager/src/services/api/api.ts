import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'
import { TProjectsData } from '../../interfaces/TProjectsData';
import { TEmployeesPick } from '../../interfaces/TCreateTeamData';
import { TTeamPick } from '../../interfaces/TCreateProjectData';

export const apiSlice = createApi({
  reducerPath: 'api',
  baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/' }),
  tagTypes: ['Team', 'Project', 'Profile'],
  endpoints: (builder) => 
  ({
    getProjects: builder.query<TProjectsData, void>({
      query: () => 'project',
      providesTags: ['Project']
    }),
    getTasks: builder.query<any, void>({
      query: () => `task`,
    }),
    getTeams: builder.query<TTeamPick[], void>({
      query: () => `team`,
      providesTags: ['Team']
    }),
    getEmployees: builder.query<TEmployeesPick[], void>({
      query: () => `employee`,
    }),
    createProject: builder.mutation({
      query: (resource) => ({
        url: '/project',
        method: 'POST',
        body: resource,
      }),
      invalidatesTags: ['Project']
    }),
    createTeam: builder.mutation({
      query: (resource) => ({
        url: '/team',
        method: 'POST',
        body: resource,
      }),
      invalidatesTags: ['Team']
    }),

    editProfile: builder.mutation({
      query: (id) => ({
        url: '/account/${id}',
        method: 'PUT',
      }),
      invalidatesTags: ['Profile']
    }),

    getProfile: builder.query({
      query: (id) => ({
        url: `/account/${id}`,
        method: 'GET',
      }),
     // invalidatesTags: ['Team']
    }),
  }),
})

export const { useGetProjectsQuery, useGetEmployeesQuery, useGetTasksQuery, useGetTeamsQuery, useCreateProjectMutation, useCreateTeamMutation, useEditProfileMutation } = apiSlice;