<template>
  <v-container>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <p class="text-center">Layouts</p>
      </v-col>
      <v-btn-toggle v-model="level" mandatory>
        <v-btn large>TH7</v-btn>
        <v-btn large>TH8</v-btn>
        <v-btn large>TH9</v-btn>
        <v-btn large>TH10</v-btn>
        <v-btn large>TH11</v-btn>
        <v-btn large>TH12</v-btn>
      </v-btn-toggle>
    </v-row>
    <v-spacer></v-spacer>
    <v-row align="center" justify="center">
      <v-btn-toggle v-model="type" mandatory>
        <v-btn large>farming</v-btn>
        <v-btn large>battle</v-btn>
      </v-btn-toggle>
    </v-row>
    <v-row>
      <v-col cols="12" md="6">
        <v-card>
          <v-img
            class="white--text align-end"
            height="300px"
            src="https://coc-utils.s3-ap-northeast-1.amazonaws.com/layouts/th9/farming/0001.PNG"
          ></v-img>
          <v-spacer></v-spacer>
          <v-card-actions>
            <v-btn color="indigo" text block>
              Copy
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col cols="12" md="6">
        <v-card>
          <v-img
            class="white--text align-end"
            height="300px"
            src="https://coc-utils.s3-ap-northeast-1.amazonaws.com/layouts/th9/farming/0001.PNG"
          ></v-img>
          <v-spacer></v-spacer>
          <v-card-actions>
            <v-btn color="indigo" text block>
              Copy
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Layouts',
  data: () => ({
    level: 0,
    type: 0,
  }),
};
</script>

<style scoped></style>
