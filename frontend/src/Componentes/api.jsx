import React, { useEffect, useState } from 'react';
import axios from 'axios';

const MyComponent = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Faça uma chamada GET para o endpoint do backend
    axios.get('http://localhost:8080/products')
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error('Erro ao obter dados do backend:', error);
      });
  }, []);

  return (
    <div>
      <h1>Dados do Backend:</h1>
      <ul>
        {data.map((item) => (
          <li key={item.idProduct}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default MyComponent;
