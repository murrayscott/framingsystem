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
    <button>All</button>
    <button>Active</button>
    <button>Priority</button>
    <button>Deleted</button>
    <table>
        <thead>
            <tr>
                <th>Number</th>
                <th>Description</th>
                <th>Width</th>
                <th>Height</th>
                <th>Overlap</th>
                <th>Top</th>
                <th>Bottom</th>
                <th>Left</th>
                <th>Right</th>
                <th>Qty</th>
                <th>Cost</th>
                <th>Total</th>
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
                <td>{product.printWidth>0 ? product.printWidth + " mm":"-"}</td>
                <td>{product.printHeight>0 ? product.printHeight + " mm":"-"}</td>
                <td>{product.mountOverlap>0 ? product.mountOverlap + " mm":"-"}</td>
                <td>{product.mountSizeTop>0 ? product.mountSizeTop + " mm":"-"}</td>
                <td>{product.mountSizeBottom>0 ? product.mountSizeBottom + " mm":"-"}</td>
                <td>{product.mountSizeLeft>0 ? product.mountSizeLeft + " mm":"-"}</td>
                <td>{product.mountSizeRight>0 ? product.mountSizeRight + " mm":"-"}</td>
                <td>{product.qty}</td>
                <td>£0.00</td>
                <td>£0.00</td>
                <td>0%</td>
                <td><button>Edit</button></td>
                <td><button>Remove</button></td>
                {/* <td><button onClick={() => handleEdit(rowData)}>Edit</button></td> */}
            </tr>))}
            <tr>
              <td></td>
              <td></td>
              <td></td>
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
    <button>Add Preset Product</button>
    <button>Add New Product</button>
    </>
  );
}

export default GetProductData;