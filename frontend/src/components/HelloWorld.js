import React, { useEffect, useState } from 'react';
import axios from 'axios';

const HelloWorld = () => {
  const [message, setMessage] = useState('');

  useEffect(() => {
    // Replace with your Spring Boot backend URL
    axios.get('http://localhost:8080/api/hello')
      .then(response => setMessage(response.data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div>
      <h1>{message}</h1>
    </div>
  );
};

export default HelloWorld;
