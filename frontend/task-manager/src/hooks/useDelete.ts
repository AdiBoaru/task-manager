import { useDeleteTeamMutation } from "../services/TeamsApi/api";
import { useDeleteTaskMutation } from "../services/TasksApi/api";
import { useDeleteProjectMutation } from "../services/ProjectsApi/api";
import useToastify from "./useToastify";

const useDelete = (pageContext: string) => {
  const [deleteTeam] = useDeleteTeamMutation();
  const [deleteTask] = useDeleteTaskMutation();
  const [deleteProject] = useDeleteProjectMutation();
  const { notification } = useToastify();

  let deleteMutation: any;

  switch (pageContext) {
    case "teams":
      deleteMutation = (id: number) => {
        deleteTeam(id)
          .then((data) => {
            notification(`Team ${id} deleted successfuly`, "success");
            console.log(data);
          })
          .catch((error) => {
            notification("Failed to delete data", "warning");
            console.log(error);
          });
      };
      break;
    case "tasks":
      deleteMutation = (id: number) => {
        deleteTask(id)
          .then(() => notification(`Task ${id} deleted successfuly`, "success"))
          .catch((error) => {
            notification("Failed to delete data", "warning");
            console.log(error);
          });
      };
      break;
    case "projects":
      deleteMutation = (id: number) => {
        deleteProject(id)
          .then(() =>
            notification(`Project ${id} deleted successfuly`, "success")
          )
          .catch((error) => {
            notification("Failed to delete data", "warning");
            console.log(error);
          });
      };
      break;
    default:
      console.log("test");
  }

  const deleteHandler = (
    event: React.MouseEvent<HTMLButtonElement, MouseEvent>,
    id: number,
    action: "edit" | "delete"
  ) => {
    event.stopPropagation();
    if (action === "delete") {
      deleteMutation(id);
    }
  };

  return deleteHandler;
};

export default useDelete;
