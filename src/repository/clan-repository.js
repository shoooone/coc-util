import { myApiClient } from './api-client';

export const searchClans = async name => {
  const res = await myApiClient('clans', {
    params: {
      name: name.length < 3 ? `${name} ` : name,
    },
  });
  return res.data;
};
