<template>
  <v-app>
    <v-navigation-drawer app clipped v-model="drawer">
      Navigation Lists
    </v-navigation-drawer>
    <v-app-bar dark color="indigo" app clipped-left>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>CoC Util</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-menu offset-y>
          <template v-slot:activator="{ on }">
            <v-btn v-on="on" text>Support</v-btn>
          </template>
          <v-list>
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title>Consulting and support</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            <v-list-item>
              <v-list-item-content @click="hoge">
                <v-list-item-title>Discord community</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-menu>
        <v-btn text>Support</v-btn>
      </v-toolbar-items>
    </v-app-bar>
    <v-footer dark color="indigo" app>
      Copyright © 2020 GoA. All Rights Reserved.
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: "App",
  components: {},
  data: () => ({
    drawer: false
  }),
  methods: {
    hoge: function() {
      console.log("test");
    }
  }
};
</script>
