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
          <v-row align="center">
            <v-col cols="2">
              <v-subheader>TH or BH</v-subheader>
            </v-col>
            <v-col cols="10">
              <v-radio-group v-model="layout.thOrBh" row>
                <v-radio label="TownHall" value="1"></v-radio>
                <v-radio label="BuilderHall" value="2"></v-radio>
              </v-radio-group>
            </v-col>
          </v-row>
          <v-row align="center" v-if="layout.thOrBh === '1'">
            <v-col cols="2">
              <v-subheader>TH Level</v-subheader>
            </v-col>
            <v-col cols="10">
              <v-btn-toggle v-model="layout.level" mandatory>
                <v-btn large value="th5">TH5</v-btn>
                <v-btn large value="th6">TH6</v-btn>
                <v-btn large value="th7">TH7</v-btn>
                <v-btn large value="th8">TH8</v-btn>
                <v-btn large value="th9">TH9</v-btn>
                <v-btn large value="th10">TH10</v-btn>
                <v-btn large value="th11">TH11</v-btn>
                <v-btn large value="th12">TH12</v-btn>
                <v-btn large value="th13">TH13</v-btn>
              </v-btn-toggle>
            </v-col>
          </v-row>
          <v-row align="center" v-if="layout.thOrBh === '2'">
            <v-col cols="2">
              <v-subheader>BH Level</v-subheader>
            </v-col>
            <v-col cols="10">
              <v-btn-toggle v-model="layout.level" mandatory>
                <v-btn large value="bh4">BH4</v-btn>
                <v-btn large value="bh5">BH5</v-btn>
                <v-btn large value="bh6">BH6</v-btn>
                <v-btn large value="bh7">BH7</v-btn>
                <v-btn large value="bh8">BH8</v-btn>
              </v-btn-toggle>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="2">
              <v-subheader>Copy URL</v-subheader>
            </v-col>
            <v-col cols="4">
              <v-text-field
                v-model="layout.url"
                placeholder="Please input layout copy url."
              ></v-text-field>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="2">
              <v-subheader>Image</v-subheader>
            </v-col>
            <v-col cols="4">
              <v-file-input
                v-model="layout.file"
                @change="imagePreview"
                placeholder="Please attach layout image."
              ></v-file-input>
            </v-col>
          </v-row>

          <v-row v-if="layout.file">
            <v-col cols="2">
              <v-subheader>Preview</v-subheader>
            </v-col>
            <v-col cols="4">
              <img :src="imageUrl" />
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
    layout: {
      type: '1',
      thOrBh: '1',
      level: 'th8',
      file: null,
    },
    imageUrl: '',
  }),
  methods: {
    imagePreview: function() {
      if (!this.layout.file) {
        this.imageUrl = '';
        return;
      }
      const fr = new FileReader();
      fr.readAsDataURL(this.layout.file);
      fr.addEventListener('load', () => {
        this.imageUrl = fr.result;
      });
    },
  },
};
</script>

<style scoped></style>
