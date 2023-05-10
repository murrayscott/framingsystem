import React, { useState, useEffect } from 'react';

function GetProductData() {

  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/products')
      .then(response => response.json())
      .then(data => setProducts(data));
  }, []);

  return (
    <>
    <h3>Products:</h3>
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
                <th>Qty</th>
                <th>Progress</th>
                <th>Action</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            {products.map(product => (
            <tr key={product.id}>
                <td>{product.id}</td>
                <td>{product.description}</td>
                <td>{product.width>0 ? product.width + " mm":"-"}</td>
                <td>{product.height>0 ? product.height + " mm":"-"}</td>
                <td>{product.top>0 ? product.top + " mm":"-"}</td>
                <td>{product.bottom>0 ? product.bottom + " mm":"-"}</td>
                <td>{product.left>0 ? product.left + " mm":"-"}</td>
                <td>{product.right>0 ? product.right + " mm":"-"}</td>
                <td>{product.qty}</td>
                <td>0</td>
                <td><button>Edit</button></td>
                <td><button>Remove</button></td>
                {/* <td><button onClick={() => handleEdit(rowData)}>Edit</button></td> */}
            </tr>))}
        </tbody>
    </table>
    <td><button>Add Product To Order</button></td>
    </>
  );
}

export default GetProductData;