import { useLocation, useNavigate } from "react-router-dom";
import { renderTableDataContent } from "../../../utils/tableDataContent";
import { BsTrash } from "react-icons/bs";
import { TbEdit } from "react-icons/tb";
import { useSelector } from "react-redux";
import useDelete from "../../../hooks/useDelete";

const TableBody = ({ entries }: any) => {
  const pageContext = useSelector((state: any) => state.tableContext);
  const navigate = useNavigate();
  const { pathname } = useLocation();
  const deleteHandler = useDelete(pageContext);
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
                {renderTableDataContent(item, entry.id, deleteHandler)}
              </td>
            ))}
          </tr>
        );
      })}
    </tbody>
  );
};

export default TableBody;
