<template>
    <div class="app-container">
      <el-form :inline="true">
        <el-form-item label="项目名称">
          <el-input
            v-model="queryParams.projectName"
            placeholder="请输入项目名称"
            clearable
            size="small"
            style="width: 240px"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="项目类型">
          <el-input
            v-model="queryParams.projectType"
            placeholder="请输入项目类型"
            clearable
            size="small"
            style="width: 240px"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="创建时间">
          <el-date-picker
            v-model="dateRange"
            size="small"
            style="width: 240px"
            value-format="yyyy-MM-dd"
            type="daterange"
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button
            type="primary"
            icon="el-icon-plus"
            size="mini"
            @click="handleAdd"
            v-hasPermi="['system:role:add']"
          >新增</el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="loading" :data="projectData">
        <el-table-column label="项目名称" prop="projectName" width="120" />
        <el-table-column label="项目类型" prop="projectType" :show-overflow-tooltip="true" width="150" />
        <el-table-column label="操作员" prop="projectPerson" :show-overflow-tooltip="true" width="180" />
        <el-table-column label="创建时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
            >修改</el-button>
          </template>
        </el-table-column>
      </el-table>
      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination=""
      />
      <!-- 添加项目对话框 -->
      <el-dialog title="添加项目" :visible.sync="open" width="500px">
        <el-form ref="form"  label-width="80px">
          <el-form-item label="项目名称" prop="projectName">
            <el-input v-model="form.projectName" placeholder="请输入项目名称" />
          </el-form-item>
          <el-form-item label="项目类型" prop="projectType">
            <el-input v-model="form.projectType" placeholder="请输入项目类型" />
          </el-form-item>
          <el-form-item label="操作人" prop="projectPerson">
            <el-input v-model="form.projectPerson" placeholder="请输入操作人" />
          </el-form-item>
          <el-form-item label="附件上传" prop="projectPerson">
            <el-input v-model="form.projectPerson" placeholder="请输入操作人" />
          </el-form-item>
        </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="submitForm">确 定</el-button>
            <el-button @click="cancel">取 消</el-button>
          </div>
      </el-dialog>
    </div>
</template>

<script>
  import {getOwnerProject} from '../../../api/project'
export default {
  name: "projectManager",
  components:{

  },
  data(){
    return{
      // 遮罩层
      loading: false,
      // 总条数
      total: 0,
      open:false,
      dateRange:[],
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: undefined,
        projectType: undefined
      },
      dateRange: [],
      projectData:[
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        },
        {
          "projectName":"北塬行政边界",
          "projectType":"",
          "projectPerson":"XX",
          "data":"2020-3-20"
        }
      ],
      form:[]
    }
  },

   mounted(){
    //this.getProject();
  },
  methods:{
    getProject(){
      getOwnerProject().then(()=>{
        console.log(val);
        //this.projectData=val;
      })
    },
    handleQuery(){

    },
    handleAdd(){
      this.open=true;
    },
    submitForm(){

    },
    cancel(){

    }
  }
}
</script>

<style lang="scss" scoped>
.app-container{
  .pc-multiple-search{
    margin: 20px 0;
    display: inline-flex;
    border-radius: 5px;
    background-color: #f8f8f9;
    .pc-multiple-time,.pc-multiple-button{
      padding: 17px 50px;
    }
  }
}
</style>
