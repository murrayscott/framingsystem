import React, { useState, useEffect } from 'react';

function GetProductData() {

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/products')
      .then(response => response.json())
      .then(data => setOrders(data));
  }, []);

  return (
    <>
    <h3>Products</h3>
    <table>
        <thead>
            <tr>
                <th>Number</th>
                <th>Description</th>
                <th>Width</th>
                <th>Height</th>
                <th>Top</th>
                <th>Bottom</th>
                <th>Left</th>
                <th>Right</th>
                <th>Action</th>
                <th>Qty</th>
            </tr>
        </thead>
        <tbody>
            {orders.map(part => (
            <tr key={product.id}>
                <td>{product.id}</td>
                <td>{product.description}</td>
                <td>{product.width} mm</td>
                <td>{product.height} mm</td>
                <td>{product.top} mm</td>
                <td>{product.bottom} mm</td>
                <td>{product.left}mmm</td>
                <td>{product.right}mmm</td>
                <td>{product.qty}</td>
                <td><button>Edit</button></td>
                {/* <td><button onClick={() => handleEdit(rowData)}>Edit</button></td> */}
            </tr>))}
        </tbody>
    </table>
    </>
  );
}

export default GetProductData;