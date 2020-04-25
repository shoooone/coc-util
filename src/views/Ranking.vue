<template>
  <v-container>
    <v-row>
      <v-col>
        <v-select :items="locationNames" :label="'Select Area or Country'">
        </v-select>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { locations as fetchLocations } from '../repository/location-repository';
export default {
  name: 'Ranking',
  data: () => ({
    locations: [],
  }),
  computed: {
    locationNames: function() {
      return ['All', ...this.locations.map(l => l.name)];
    },
  },
  methods: {
    fetchLocations: async function() {
      const locations = await fetchLocations();
      this.locations = locations.items;
    },
  },
  async mounted() {
    await this.fetchLocations();
  },
};
</script>
