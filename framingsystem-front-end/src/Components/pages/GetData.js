import React, { useState, useEffect } from 'react';

function GetData() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/customers')
      .then(response => response.json())
      .then(data => setCustomers(data));
  }, []);

  return (
    <div>
      {customers.map(customer => (
        <div key={customer.name}>
          <h2>{customer.name}</h2>
          <p>Company: {customer.company}</p>
          <p>Address: {customer.address1} {customer.address2} {customer.address3} {customer.address4}</p>
          <p>Postcode: {customer.postcode}</p>
          <p>Telephone: {customer.telephone}</p>
          <p>Email: {customer.email}</p>
        </div>
      ))}
    </div>
  );
}

export default GetData;