import { useLocation, useNavigate } from "react-router-dom";
import { BsTrash } from "react-icons/bs";
import { TbEdit } from "react-icons/tb";
import Button from "../../Button/Button";

const TableBody = ({ entries, openModal, setIsConfirmationModal }: any) => {
  const navigate = useNavigate();
  const { pathname } = useLocation();
  const handleRowClick = (entryId: string) => {
    navigate(`${pathname}/${entryId}`);
  };

  return (
    <tbody className="bg-gray-50">
      {entries.map((entry: any) => {
        const rowData = Object.values(entry);
        const updatedRowData = [
          ...rowData,
          {
            edit: {
              trashIcon: <BsTrash className="h-[20px] w-[20px] text-red-700" />,
              editIcon: <TbEdit className="h-[20px] w-[20px]" />,
            },
          },
        ];

        return (
          <tr
            key={entry.name}
            className="bg-gray-200 bg-opacity-25 max-h-[100px] cursor-pointer hover:bg-opacity-50"
            onClick={() => handleRowClick(entry.id)}
          >
            {updatedRowData.map((item: any, idx) => (
              <td key={idx} className="p-5 border-b-2 max-h-[50px]">
                {Array.isArray(item) ? (
                  <ul>
                    {item.length ? (
                      item.map((el) => <li key={el.id}>{el.fullName}</li>)
                    ) : (
                      <li>-</li>
                    )}
                  </ul>
                ) : typeof item === "object" && item !== null && item.edit ? (
                  <div className="flex items-center justify-center w-fit gap-3">
                    <Button
                      type="button"
                      testId="edit-icon-button"
                      onClick={(e) => {
                        openModal(entry.id);
                        e.stopPropagation();
                        setIsConfirmationModal(false);
                      }}
                    >
                      {item.edit.editIcon}
                    </Button>
                    <Button
                      type="button"
                      testId="trash-icon-button"
                      onClick={(e) => {
                        openModal(entry.id);
                        e.stopPropagation();
                        setIsConfirmationModal(true);
                      }}
                    >
                      {item.edit.trashIcon}
                    </Button>
                  </div>
                ) : (
                  item
                )}
              </td>
            ))}
          </tr>
        );
      })}
    </tbody>
  );
};

export default TableBody;
