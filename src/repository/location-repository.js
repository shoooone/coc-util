import { myApiClient } from './api-client';

export const locations = async () => {
  const res = await myApiClient('locations');
  return res.data;
};

export const rankingByLocationId = async (locationId, after) => {
  const res = await myApiClient(`location/${locationId}/rankings/clans`, {
    params: {
      limit: 50,
      after,
    },
  });
  return res.data;
};
