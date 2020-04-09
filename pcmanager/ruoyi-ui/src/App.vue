<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default  {
  name:  'App'
}
</script>
<style lang="scss">
  ul{
    list-style: none;
  }
  .demo-input-suffix{
    padding: 10px 20px;
    display: inline-flex;
    line-height: 50px;
    white-space: nowrap;
  }
</style>
