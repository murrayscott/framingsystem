import React, { useState, useEffect } from 'react';

function GetPartData() {

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/parts')
      .then(response => response.json())
      .then(data => setOrders(data));
  }, []);



  return (
    <>
    <h3>Parts</h3>
    <table>
        <thead>
            <tr>
                <th>Part Number</th>
                <th>Description</th>
                <th>Width</th>
                <th>Height</th>
                <th>Length</th>
                <th>Type</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            {orders.map(part => (
            <tr key={part.id}>
                <td>{part.id}</td>
                <td>{part.description}</td>
                <td>{part.width} mm</td>
                <td>{part.height} mm</td>
                <td>{part.length} mm</td>
                <td>{part.type}</td>
                <td><button>Edit</button></td>
                {/* <td><button onClick={() => handleEdit(rowData)}>Edit</button></td> */}
            </tr>))}
        </tbody>
    </table>
    </>
  );
}

export default GetPartData;