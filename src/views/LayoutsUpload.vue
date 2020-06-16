<template>
  <v-container>
    <v-row>
      <v-col class="display-1">
        Layout Register
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-form>
          <v-row>
            <v-col cols="2">
              <v-subheader>Copy URL</v-subheader>
            </v-col>
            <v-col cols="4">
              <v-text-field :value="layout.url"></v-text-field>
            </v-col>
          </v-row>
          <v-row align="center">
            <v-col cols="2">
              <v-subheader>Type</v-subheader>
            </v-col>
            <v-col cols="10">
              <v-radio-group v-model="layout.type" row>
                <v-radio label="Farming" value="1"></v-radio>
                <v-radio label="Battle" value="2"></v-radio>
              </v-radio-group>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="2">
              <v-subheader>Image</v-subheader>
            </v-col>
            <v-col cols="4">
              <v-file-input :value="layout.file"></v-file-input>
            </v-col>
          </v-row>
        </v-form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'LayoutsUpload',
  data: () => ({
    layout: {},
  }),
};
</script>

<style scoped></style>
