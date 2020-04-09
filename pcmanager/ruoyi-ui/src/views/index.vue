<template>
  <div class="pc-map-container">
    <div class="pc-map-search">
      <el-input  v-model="mapInput" autofocus="true" placeholder="请输入项目名称" prefix-icon="el-icon-search" clearable></el-input>
    </div>
    <div class="pc-map-toolbox">
      <ul>
        <li @click="getToolBoxDistance">测距</li>
        <li @click="getToolBoxArea">测面</li>
        <li @click="getToolBoxClear">清除</li>
      </ul>
    </div>
    <div id="mapId" ref="onlineMap"></div>
  </div>
</template>

<script>
  import mapConfigResult from '../../public/config/mapConfig'
export default {
  name: 'Index',
  data() {
    return {
      mapInput:'',
      shpResults: [

      ]
    }
  },
  mounted(){
    this.getAreaMap();
    this.initShp()
  },
  methods: {
    getAreaMap(){
      /*let mapConfig=new MapPlatForm.Base.MapConfig();
      this.map=mapConfig.createMap(this.$refs.onlineMap,mapConfigResult).map;*/
      this.map=new TMap.Map(this.$refs.onlineMap,{
        projection: "EPSG:900913",
        maxResolution: 156543.0339,
        units: 'm',
        minZoom: 6,
        maxZoom: 20,
        //extent:[89.01,27.92,131.06,43.40]
      });
      let m_Layer_google = new OpenLayers.Layer.OSM("google地图", "http://mt1.google.cn/vt?pb=!1m4!1m3!1i${z}!2i${x}!3i${y}!2m3!1e0!2sm!3i285000000!3m9!2szh-CN!3sCN!5e18!12m1!1e47!12m3!1e37!2m1!1ssmartmaps!4e0", {
        numZoomLevels: 22,
        alpha: true,
        isBaseLayer: true,
        visibility: false
      });
      this.map._mapAdapter.map.addLayer(m_Layer_google);
      let center = new TMap.Geometry.Point(108.06724211621082,34.028866298074895);
      this.map.setCenter(center, 5);
      this.map.addControl(new TMap.Controls.ScaleControl());
      this.map.addControl(new TMap.Controls.MousePositionControl());
      this.mapTools= new TMap.Tools.MeasureTool(this.map.id, {
        lengthUnit: TMap.MAP_UNITS_METERS, //长度单位
        areaUnit: TMap.MAP_UNITS_SQUARE_KILOMETERS	//面积单位
      });
      this.$store.dispatch('GenerateMap',this.map);
    },
    async initShp() {
      let that = this;
      await shapefile.open("../data/北塬行政界线.shp")
        .then(source => source.read()
          .then(function log(result) {
            if (result.done) return;
            that.shpResults.push({
              properties:result.value.properties,
              geom:GeoJSON.read(result.value)
            });
            return source.read().then(log);
          }))
        .catch(error => console.error(error.stack));
      if (this.shpResults) {
        let overlay = new TMap.Layers.OverlayLayer("ds");
        this.map.addLayer(overlay)
        this.shpResults.forEach(val => {
          overlay.addOverlay(val.geom);
          val.geom.addEventListener(TMap.POLYGON_EVENT_CLICK, () => {
            console.log(val.properties);
          })
        })
      }
    },
    getToolBoxDistance(){
      this.mapTools.setMode(TMap.MEASURE_MODE_DISTANCE);
    },
    getToolBoxArea(){
      this.mapTools.setMode(TMap.MEASURE_MODE_AREA);
    },
    getToolBoxClear(){
      this.mapTools.cancel();
    }
  },
  beforeDestroy(){
    this.map&&this.map.destroyMap();
  }
}
</script>

<style lang="scss">
  .pc-map-container{
    .pc-map-search{
      position: absolute;
      top: 16px;
      left: 20px;
      z-index: 1000;
      padding: 2px 0;
      .el-input{
        width: 350px;
        .el-input__inner{
          border: 0;
        }
      }

    }
    .pc-map-toolbox{
      position: absolute;
      top: 16px;
      right: 20px;
      z-index: 1000;
      text-align: center;
      background-color: #fff;
      color: #656565;
      ul{
        li{
          padding: 8px 19px;
          display: inline-flex;
          &:hover{
            cursor: pointer;
            color: blue;
          }
        }
      }
    }
    .pc-shp-import{
      position: absolute;
      left: 50%;
      width: 300px;
      margin: 100px 0 0 -250px;
      z-index: 1000;
      border-radius: 5px;
      background-color: #fff;
      .shp-import-header{
        width: 100%;
        height: 40px;
        line-height: 40px;
        background-color: #304156;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        color: #fff;
      }
      .shp-import-content{
        margin: 10px 0;
        .demo-input-suffix{
          padding: 0px 8px;
          margin-top: -16px;
          font-size: 14px;
          color: #7d7d7d;
          .el-input__inner{
            width: 200px;
            height: 25px;
          }
        }
      }
    }
    #mapId{
      min-height: calc(100vh - 50px);
      height: 0;
      z-index: 1;
    }
  }

</style>
