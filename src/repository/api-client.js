import Axios from 'axios';

export const myApiClient = Axios.create({
  baseURL: 'http://localhost:8080/',
  method: 'GET',
  headers: {
    'Content-Type': 'application/json; charset=utf-8',
  },
  timeout: 60000,
});
