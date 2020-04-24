<template>
  <v-container>
    <v-row>
      <v-col>
        <v-text-field
          prepend-icon="mdi-shield-search"
          label="Search By Clan Name"
          autofocus
          clearable
          v-model="inputName"
          @keydown.enter="search"
        ></v-text-field>
      </v-col>
    </v-row>
    <template v-if="showClans">
      <v-row v-for="clan in clans" :key="clan.tag">
        <v-col>
          <v-card>
            <v-list-item>
              <v-list-item-avatar>
                <img :src="clan.badgeUrls.small" alt="John" />
              </v-list-item-avatar>
              <v-list-item-content>
                <v-list-item-title class="headline">
                  {{ clan.name }}
                </v-list-item-title>
                <v-list-item-subtitle>{{ clan.tag }}</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-card>
        </v-col>
      </v-row>
      <v-row v-if="nextPageKey">
        <v-progress-circular></v-progress-circular>
      </v-row>
    </template>
    <template v-else>
      <v-row>
        <v-col>Please input valid clan name.</v-col>
      </v-row>
    </template>
  </v-container>
</template>
<script>
import { searchClans } from '../repository/clan-repository';

export default {
  name: 'Clans',
  data: () => ({
    inputName: 'はろ',
    clans: [],
    nextPageKey: '',
  }),
  computed: {
    showClans: function() {
      return this.clans && Array.isArray(this.clans) && this.clans.length > 0;
    },
  },
  methods: {
    search: async function() {
      const clans = await searchClans(this.inputName);
      this.clans = clans.items;
      this.nextPageKey =
        clans.paging && clans.paging.cursors ? clans.paging.cursors.after : '';
    },
  },
};
</script>
