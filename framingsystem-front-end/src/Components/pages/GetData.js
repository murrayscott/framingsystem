import React, { useState, useEffect } from 'react';

function GetData() {

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/orders')
      .then(response => response.json())
      .then(data => setOrders(data));
  }, []);



  return (
    <>
    <h3>Orders:</h3>
    <button>All</button>
    <button>Active</button>
    <button>Priority</button>
    <button>Deleted</button>
    <table>
        <thead>
            <tr>
                <th>Number</th>
                <th>Customer Name</th>
                <th>Date Ordered</th>
                <th>Date Required</th>
                <th>Telephone</th>
                <th>Products</th>
                <th>Progress</th>
                <th>Cost</th>
                <th>Method</th>
                <th>Action</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            {orders.map(order => (
            <tr key={order.id}>
                <td>{order.id}</td>
                <td>{order.customer.name}</td>
                <td>{order.date}</td>
                <td>{order.requiredDate}</td>
                <td>{order.customer.telephone}</td>
                <td><button>1</button></td>
                <td>0%</td>
                <td>£0.00</td>
                <td>{order.deliveryType}</td>
                <td><button>Edit</button></td>
                <td><button>{order.deleted ? "Restore" : "Remove"}</button></td>
                {/* <td><button onClick={() => handleEdit(rowData)}>Edit</button></td> */}
            </tr>))}
        </tbody>
    </table>
    <button>Add New Order</button>
    </>
  );
}

export default GetData;