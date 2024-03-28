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

import { newProjectSchema } from "../../constants/formValidations";
import {
  TCreateProjectData,
  TTeamPick,
} from "../../interfaces/TCreateProjectData";
import Button from "../../UI/Button/Button";
import FormInput from "../../UI/FormInput/FormInput";
import {
  useCreateProjectMutation,
  useGetTeamsQuery,
} from "../../services/api/api";
import { useNavigate } from "react-router-dom";
import ROUTESPATHS from "../../constants/routePaths";
import { useState } from "react";
import useToastify from "../../hooks/useToastify";

type TNewProjectFormProps = {
  btnStyle: string;
  handleClose: () => void;
};

const NewProjectForm = ({ btnStyle, handleClose }: TNewProjectFormProps) => {
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
      .then((response) => console.log(response))
      .catch(({ data }) => console.log(data));
    navigate(ROUTESPATHS.PROJECTS);
    notification("Project created successfully", "success");
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
      zIndex: 9999,
    }),
  };

  return (
    <FormProvider {...methods}>
      <form
        data-testid="create-project-form"
        className="absolute flex flex-col bg-primaryColor items-center gap-3 z-10 py-10 rounded-[20px] border border-secondaryColor h-auto w-[40%] laptop:pt-0 laptop:h-[70%]"
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
                  menuPosition="fixed"
                  menuPortalTarget={document.body}
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
        </div>

        <Button
          testId="create-button"
          type="submit"
          style={`${btnStyle} text-secondaryColor text-xl border border-secondaryColor rounded-[10px] py-3 hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor `}
        >
          Create
        </Button>
        <Button
          testId="cancel-button"
          type="button"
          style={`text-gray-500 text-xl border border-gray-500 rounded-[10px] py-3 w-[25rem] hover:font-semibold hover:text-white hover:bg-gray-500`}
          onClick={handleClose}
        >
          Cancel
        </Button>
      </form>
    </FormProvider>
  );
};

export default NewProjectForm;
