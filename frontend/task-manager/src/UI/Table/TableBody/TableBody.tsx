const TableBody = ({ entries, columns }: any) => {
  return (
    <tbody className="bg-gray-50 h-[200px] ">
      {entries.map((entry: any) => (
        <tr key={entry.id}>
          {columns.map(({ key }: any) => (
            <td className="p-5 border-b-2" key={key}>
              {key === "edit" ? (
                <div>
                  {entry[key].map((editItem: any, index: number) => (
                    <div key={index} className="flex space-x-2">
                      {editItem.trashIcon}
                      {editItem.editIcon}
                    </div>
                  ))}
                </div>
              ) : (
                entry[key]
              )}
            </td>
          ))}
        </tr>
      ))}
    </tbody>
  );
};

export default TableBody;
