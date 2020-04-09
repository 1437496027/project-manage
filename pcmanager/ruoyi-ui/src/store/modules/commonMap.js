const commonMap ={
  state:{
    map:''
  },
  mutations:{
    SET_MAP:(state,map)=>{
      state.map=map
    }
  },
  actions: {
    GenerateMap({commit},map) {
      return new Promise(resolve => {
        commit('SET_MAP',map);
      })
    }
  }
}
export default commonMap
