<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="图标" prop="icon">
        <el-input
          v-model="queryParams.icon"
          placeholder="请输入图标"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="天数(如 7,10,30)" prop="days">
        <el-input
          v-model="queryParams.days"
          placeholder="请输入天数(如 7,10,30)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="违约利率" prop="defaultOdds">
        <el-input
          v-model="queryParams.defaultOdds"
          placeholder="请输入违约利率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小日利率百分比" prop="minOdds">
        <el-input
          v-model="queryParams.minOdds"
          placeholder="请输入最小日利率百分比"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大日利率百分比" prop="maxOdds">
        <el-input
          v-model="queryParams.maxOdds"
          placeholder="请输入最大日利率百分比"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每人限购次数，0表示不限" prop="timeLimit">
        <el-input
          v-model="queryParams.timeLimit"
          placeholder="请输入每人限购次数，0表示不限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小金额" prop="limitMin">
        <el-input
          v-model="queryParams.limitMin"
          placeholder="请输入最小金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大金额" prop="limitMax">
        <el-input
          v-model="queryParams.limitMax"
          placeholder="请输入最大金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排序" prop="sort">
        <el-input
          v-model="queryParams.sort"
          placeholder="请输入排序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label=" 购买次数" prop="buyPurchase">
        <el-input
          v-model="queryParams.buyPurchase"
          placeholder="请输入 购买次数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币种 " prop="coin">
        <el-input
          v-model="queryParams.coin"
          placeholder="请输入币种 "
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['bussiness:ming:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['bussiness:ming:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['bussiness:ming:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bussiness:ming:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="mingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="id" />
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="图标" align="center" prop="icon" />
      <el-table-column label="启用禁用(展示在前端)1开0关" align="center" prop="status" />
      <el-table-column label="天数(如 7,10,30)" align="center" prop="days" />
      <el-table-column label="违约利率" align="center" prop="defaultOdds" />
      <el-table-column label="最小日利率百分比" align="center" prop="minOdds" />
      <el-table-column label="最大日利率百分比" align="center" prop="maxOdds" />
      <el-table-column label="每人限购次数，0表示不限" align="center" prop="timeLimit" />
      <el-table-column label="最小金额" align="center" prop="limitMin" />
      <el-table-column label="最大金额" align="center" prop="limitMax" />
      <el-table-column label="排序" align="center" prop="sort" />
      <el-table-column label=" 购买次数" align="center" prop="buyPurchase" />
      <el-table-column label="币种 " align="center" prop="coin" />
      <el-table-column label="标签" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['bussiness:ming:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['bussiness:ming:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改mingProduct对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="图标" prop="icon">
          <el-input v-model="form.icon" placeholder="请输入图标" />
        </el-form-item>
        <el-form-item label="天数(如 7,10,30)" prop="days">
          <el-input v-model="form.days" placeholder="请输入天数(如 7,10,30)" />
        </el-form-item>
        <el-form-item label="违约利率" prop="defaultOdds">
          <el-input v-model="form.defaultOdds" placeholder="请输入违约利率" />
        </el-form-item>
        <el-form-item label="最小日利率百分比" prop="minOdds">
          <el-input v-model="form.minOdds" placeholder="请输入最小日利率百分比" />
        </el-form-item>
        <el-form-item label="最大日利率百分比" prop="maxOdds">
          <el-input v-model="form.maxOdds" placeholder="请输入最大日利率百分比" />
        </el-form-item>
        <el-form-item label="每人限购次数，0表示不限" prop="timeLimit">
          <el-input v-model="form.timeLimit" placeholder="请输入每人限购次数，0表示不限" />
        </el-form-item>
        <el-form-item label="最小金额" prop="limitMin">
          <el-input v-model="form.limitMin" placeholder="请输入最小金额" />
        </el-form-item>
        <el-form-item label="最大金额" prop="limitMax">
          <el-input v-model="form.limitMax" placeholder="请输入最大金额" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label=" 购买次数" prop="buyPurchase">
          <el-input v-model="form.buyPurchase" placeholder="请输入 购买次数" />
        </el-form-item>
        <el-form-item label="币种 " prop="coin">
          <el-input v-model="form.coin" placeholder="请输入币种 " />
        </el-form-item>
        <el-form-item label="标签" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listMing, getMing, delMing, addMing, updateMing } from "@/api/bussiness/ming";

export default {
  name: "Ming",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // mingProduct表格数据
      mingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        icon: null,
        status: null,
        days: null,
        defaultOdds: null,
        minOdds: null,
        maxOdds: null,
        timeLimit: null,
        limitMin: null,
        limitMax: null,
        sort: null,
        buyPurchase: null,
        coin: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          { required: true, message: "标题不能为空", trigger: "blur" }
        ],
        days: [
          { required: true, message: "天数(如 7,10,30)不能为空", trigger: "blur" }
        ],
        timeLimit: [
          { required: true, message: "每人限购次数，0表示不限不能为空", trigger: "blur" }
        ],
        limitMin: [
          { required: true, message: "最小金额不能为空", trigger: "blur" }
        ],
        limitMax: [
          { required: true, message: "最大金额不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询mingProduct列表 */
    getList() {
      this.loading = true;
      listMing(this.queryParams).then(response => {
        this.mingList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        title: null,
        icon: null,
        status: null,
        days: null,
        defaultOdds: null,
        minOdds: null,
        maxOdds: null,
        timeLimit: null,
        limitMin: null,
        limitMax: null,
        sort: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        buyPurchase: null,
        coin: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加mingProduct";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMing(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改mingProduct";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMing(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMing(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除mingProduct编号为"' + ids + '"的数据项？').then(function() {
        return delMing(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bussiness/ming/export', {
        ...this.queryParams
      }, `ming_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
