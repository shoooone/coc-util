import { myApiClient } from './api-client';

export const searchClans = async (name, after) => {
  const res = await myApiClient('clans', {
    params: {
      name: name.length < 3 ? `${name} ` : name,
      limit: 50,
      after,
    },
  });
  return res.data;
};
