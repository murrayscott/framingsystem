import React, { useState, useEffect } from 'react';

function GetPartData() {

  const [parts, setParts] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/parts')
      .then(response => response.json())
      .then(data => setParts(data));
  }, []);



  return (
    <>
    <h3>Parts:</h3>
    <button>All</button>
    <button>Deleted</button>
    <table>
        <thead>
            <tr>
                <th>Part Number</th>
                <th>Description</th>
                <th>Width</th>
                <th>Height</th>
                <th>Length</th>
                <th>Type</th>
                <th>Qty</th>
                <th>Cost</th>
                <th>Total</th>
                <th>Progress</th>
                <th>Action</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            {parts.map(part => (
            <tr key={part.id}>
                <td>{part.id}</td>
                <td>{part.description}</td>
                <td>{part.width>0 ? part.width + " mm":"-"}</td>
                <td>{part.height>0 ? part.height + " mm":"-"}</td>
                <td>{part.length>0 ? part.length + " mm":"-"}</td>
                <td>{part.type}</td>
                <td>{part.unitMultiple}</td>
                <td>£0.00</td>
                <td>£0.00</td>
                <td>{part.progress}%</td>
                <td><button>Edit</button></td>
                <td><button>{part.deleted ? "Restore" : "Remove"}</button></td>
            </tr>))}
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>Total:</td>
              <td>£0.00</td>
            </tr>
        </tbody>
    </table>
    <button>Add Preset Part</button>
    <button>Add New Part</button>
    </>
  );
}

export default GetPartData;