import Axios from 'axios';

export const myApiClient = Axios.create({
  baseURL: 'https://api.clashofclans.com/v1/',
  method: 'GET',
  headers: {
    'Content-Type': 'application/json; charset=utf-8',
  },
  timeout: 60000,
});
