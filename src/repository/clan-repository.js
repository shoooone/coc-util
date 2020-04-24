import { myApiClient } from './api-client';

export const searchClans = async name => {
  const res = await myApiClient('clans', {
    params: {
      name: name.length < 3 ? `${name} ` : name,
      limit: 50,
    },
  });
  return res.data;
};
