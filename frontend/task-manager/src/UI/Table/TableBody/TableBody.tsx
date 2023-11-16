const TableBody = ({ entries, columns }: any) => {
  console.log(columns);

  return (
    <tbody className="bg-gray-50 h-[200px]">
      {entries.map((entry: any) => (
        <tr key={entry.id}>
          {columns.map(({ key }: any) => (
            <td className="p-5 border-b-2" key={key}>
              {entry[key]}
            </td>
          ))}
        </tr>
      ))}
    </tbody>
  );
};

export default TableBody;
