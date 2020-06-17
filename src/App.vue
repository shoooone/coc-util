<template>
  <v-app>
    <v-navigation-drawer app clipped v-model="drawer">
      <v-container>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="title grey--text text--darken-2">
              My Clans
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
        <v-list dense nav>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>はろ</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>はろ サブ</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="title grey--text text--darken-2">
              Menu
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
        <v-list dense nav>
          <v-list-item v-for="nav in nav_lists" :key="nav.name" :to="nav.link">
            <v-list-item-icon>
              <v-icon>{{ nav.icon }}</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>{{ nav.name }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item v-for="nav in nav_lists_ex" :key="nav.name">
            <v-list-item-icon>
              <v-icon>{{ nav.icon }}</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>{{ nav.name }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-container>
    </v-navigation-drawer>
    <v-app-bar dark color="indigo" app clipped-left>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>CoC Util</v-toolbar-title>
      <v-spacer></v-spacer>
    </v-app-bar>
    <v-content>
      <router-view></router-view>
    </v-content>
    <v-footer dark color="indigo" app>
      Copyright © 2020 GoA. All Rights Reserved.
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  components: {},
  data: () => ({
    drawer: null,
    nav_lists: [
      { name: 'Search Clans', icon: 'mdi-shield-search', link: 'clans' },
      { name: 'Ranking', icon: 'mdi-slope-downhill', link: 'ranking' },
      { name: 'Layouts', icon: 'mdi-animation-play-outline', link: 'layouts' },
      { name: 'Tactics', icon: 'mdi-chart-multiple', link: 'tactics' },
    ],
    nav_lists_ex: [
      {
        name: 'Official Page',
        icon: 'mdi-earth',
        link: 'https://supercell.com/en/games/clashofclans/',
      },
      {
        name: 'Official Twitter',
        icon: 'mdi-twitter',
        link: 'https://twitter.com/ClashofClans',
      },
    ],
  }),
  methods: {
    hoge: function() {
      console.log('test');
    },
  },
};
</script>
