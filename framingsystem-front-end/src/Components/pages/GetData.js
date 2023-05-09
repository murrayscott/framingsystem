import React, { useState, useEffect } from 'react';

function GetData() {

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/orders')
      .then(response => response.json())
      .then(data => setOrders(data));
  }, []);

  return (
    <div>
        <p> Order Number Customer Name Date Ordered Date Required Telephone</p>
        {orders.map(order => (
        <div key={order.id}>
          <p>{order.id} {order.customer.name} {order.date} {order.requiredDate} {order.customer.telephone}</p>
          <p>Products: {order.product}</p>
          <p>DeliveryType: {order.deliveryType}</p>
          <p>Deleted: {order.deleted}</p>
          <p>Review: {order.rewiew}</p>
          <p>GDPR: {order.gdpr}</p>
        </div>

      ))}
    </div>
  );
}

export default GetData;