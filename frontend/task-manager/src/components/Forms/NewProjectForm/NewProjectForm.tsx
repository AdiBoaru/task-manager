import { ErrorMessage } from "@hookform/error-message";
import { yupResolver } from "@hookform/resolvers/yup";

import {
  useForm,
  SubmitHandler,
  useController,
  FormProvider,
  Controller,
} from "react-hook-form";
import Select, { CSSObjectWithLabel, SingleValue } from "react-select";
import moment from "moment";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

import { newProjectSchema } from "../../../constants/formValidations";
import {
  TCreateProjectData,
  TTeamPick,
} from "../../../interfaces/TCreateProjectData";
import FormInput from "../../../UI/FormInput/FormInput";
import { useCreateProjectMutation } from "../../../services/ProjectsApi/api";
import { useGetTeamsQuery } from "../../../services/TeamsApi/api";
import { useNavigate } from "react-router-dom";
import ROUTESPATHS from "../../../constants/routePaths";
import { useState } from "react";
import useToastify from "../../../hooks/useToastify";

type TNewProjectFormProps = {
  onSuccess: () => void;
};

const NewProjectForm = ({ onSuccess }: TNewProjectFormProps) => {
  const { data: teams } = useGetTeamsQuery();
  const [createProject] = useCreateProjectMutation();
  const { notification } = useToastify();
  const [selectedDate, setSelectedDate] = useState<Date | string>(new Date());

  const navigate = useNavigate();
  const methods = useForm<TCreateProjectData>({
    mode: "onChange",
    resolver: yupResolver<TCreateProjectData>(newProjectSchema),
  });

  const {
    control,
    handleSubmit,
    formState: { errors },
  } = methods;

  const onInvalid = (errors: any) => console.error(errors);
  const onSubmit: SubmitHandler<TCreateProjectData> = (
    data: TCreateProjectData
  ) => {
    createProject(data)
      .unwrap()
      .then(() => {
        onSuccess();
        navigate(ROUTESPATHS.PROJECTS);
        notification("Project created successfully", "success");
      })
      .catch(({ data }) => console.log(data));
  };

  const { field: teamsField } = useController({
    name: "team",
    control,
  });
  const { field: dateField } = useController({
    name: "dueDate",
    control,
  });

  const handleTeamPick = (option: SingleValue<TTeamPick>) => {
    teamsField.onChange(option);
  };

  const handleDatePick = (option: SingleValue<Date>) => {
    if (option) {
      dateField.onChange(moment(option).format("YYYY-MM-DD"));
      setSelectedDate(moment(option).format("YYYY-MM-DD"));
    }
  };

  const colorStyles = {
    control: (styles: CSSObjectWithLabel) => ({
      ...styles,
      width: "25rem",
      padding: "6px",
      margin: "4px",
      borderRadius: "10px",
      zIndex: 900,
    }),
    option: (styles: CSSObjectWithLabel, { isSelected, isFocused }: any) => ({
      ...styles,
      color: "black",
      backgroundColor: isSelected ? "lightblue" : undefined,
      overflow: "hidden",
      cursor: "pointer",
      ":hover": {
        backgroundColor: isFocused ? "lightblue" : "lightgray",
      },
    }),
  };

  return (
    <FormProvider {...methods}>
      <form
        id="create-new-project-form"
        data-testid="create-project-form"
        className="flex flex-col items-center gap-3 py-10 rounded-[20px] h-auto w-[40%] laptop:pt-0 laptop:h-[70%]"
        onSubmit={handleSubmit(onSubmit, onInvalid)}
      >
        <FormInput
          testId="project-name"
          inputTestId="project-name-input"
          errorTestId="project-name-error"
          labelStyle="px-4 text-white text-lg"
          inputStyle=" mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your project name"
          type="text"
          labelText="Project name"
          inputId="projectName"
          name="name"
        />
        <FormInput
          testId="project-description"
          inputTestId="project-description-input"
          errorTestId="project-description-error"
          labelStyle="p-4 text-white text-lg"
          inputStyle=" mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter project description"
          type="text"
          labelText="Description"
          inputId="description"
          name="description"
        />
        <div>
          <label className="ml-3 text-white text-lg">
            Teams
            <Controller
              data-testid="controller"
              name="team"
              control={control}
              rules={{ required: "Choose a team" }}
              render={() => (
                <Select
                  id="teams"
                  data-testid="teams-select"
                  onChange={handleTeamPick}
                  options={teams}
                  getOptionLabel={(option: TTeamPick) => option.name}
                  getOptionValue={(option: any) => option.id}
                  placeholder="Choose your team"
                  styles={colorStyles}
                />
              )}
            />
          </label>
          <ErrorMessage
            errors={errors}
            name={"team"}
            render={({ message }) => <p className="text-red-600">{message}</p>}
          />
        </div>
        <div>
          <label className="text-white text-lg flex flex-col">
            Completion Date
            <Controller
              data-testid="controller"
              name="dueDate"
              control={control}
              rules={{ required: "Pick a date" }}
              render={() => (
                <DatePicker
                  className="mb-[10px] w-[25rem] p-3 rounded-[10px] text-black focus:border-secondaryColor focus:outline-secondaryColor"
                  onChange={handleDatePick}
                  selected={selectedDate as Date}
                  name="dueDate"
                  minDate={moment(new Date()).startOf("day").toDate()}
                />
              )}
            />
          </label>
          <ErrorMessage
            errors={errors}
            name={"dueDate"}
            render={({ message }) => <p className="text-red-600">{message}</p>}
          />
        </div>
      </form>
    </FormProvider>
  );
};

export default NewProjectForm;
