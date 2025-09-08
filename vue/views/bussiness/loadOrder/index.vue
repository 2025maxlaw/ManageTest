<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="贷款商品表id" prop="proId">
        <el-input
          v-model="queryParams.proId"
          placeholder="请输入贷款商品表id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="贷款金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入贷款金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="贷款利率" prop="rate">
        <el-input
          v-model="queryParams.rate"
          placeholder="请输入贷款利率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="利息" prop="interest">
        <el-input
          v-model="queryParams.interest"
          placeholder="请输入利息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后还款日" prop="finalRepayTime">
        <el-date-picker clearable
          v-model="queryParams.finalRepayTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后还款日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="放款日期" prop="disburseTime">
        <el-date-picker clearable
          v-model="queryParams.disburseTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择放款日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="还款日期" prop="returnTime">
        <el-date-picker clearable
          v-model="queryParams.returnTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择还款日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="审批金额" prop="disburseAmount">
        <el-input
          v-model="queryParams.disburseAmount"
          placeholder="请输入审批金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="cardUrl">
        <el-input
          v-model="queryParams.cardUrl"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="cardBackUrl">
        <el-input
          v-model="queryParams.cardBackUrl"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="capitalUrl">
        <el-input
          v-model="queryParams.capitalUrl"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="licenseUrl">
        <el-input
          v-model="queryParams.licenseUrl"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入${comment}"
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
          v-hasPermi="['bussiness:loadOrder:add']"
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
          v-hasPermi="['bussiness:loadOrder:edit']"
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
          v-hasPermi="['bussiness:loadOrder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bussiness:loadOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="loadOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="贷款商品表id" align="center" prop="proId" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="贷款金额" align="center" prop="amount" />
      <el-table-column label="贷款利率" align="center" prop="rate" />
      <el-table-column label="利息" align="center" prop="interest" />
      <el-table-column label="0 进行中 1-已结清 2-已逾期 3 通过  4拒绝" align="center" prop="status" />
      <el-table-column label="最后还款日" align="center" prop="finalRepayTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.finalRepayTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="放款日期" align="center" prop="disburseTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.disburseTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="还款日期" align="center" prop="returnTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.returnTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审批金额" align="center" prop="disburseAmount" />
      <el-table-column label="后台代理ids" align="center" prop="adminParentIds" />
      <el-table-column label="${comment}" align="center" prop="cardUrl" />
      <el-table-column label="${comment}" align="center" prop="cardBackUrl" />
      <el-table-column label="${comment}" align="center" prop="capitalUrl" />
      <el-table-column label="${comment}" align="center" prop="licenseUrl" />
      <el-table-column label="${comment}" align="center" prop="orderNo" />
      <el-table-column label="${comment}" align="center" prop="cycleType" />
      <el-table-column label="用户备注" align="center" prop="remark" />
      <el-table-column label="${comment}" align="center" prop="searchValue" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['bussiness:loadOrder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['bussiness:loadOrder:remove']"
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

    <!-- 添加或修改贷款订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="贷款商品表id" prop="proId">
          <el-input v-model="form.proId" placeholder="请输入贷款商品表id" />
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="贷款金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入贷款金额" />
        </el-form-item>
        <el-form-item label="贷款利率" prop="rate">
          <el-input v-model="form.rate" placeholder="请输入贷款利率" />
        </el-form-item>
        <el-form-item label="利息" prop="interest">
          <el-input v-model="form.interest" placeholder="请输入利息" />
        </el-form-item>
        <el-form-item label="最后还款日" prop="finalRepayTime">
          <el-date-picker clearable
            v-model="form.finalRepayTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后还款日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="放款日期" prop="disburseTime">
          <el-date-picker clearable
            v-model="form.disburseTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择放款日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="还款日期" prop="returnTime">
          <el-date-picker clearable
            v-model="form.returnTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择还款日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批金额" prop="disburseAmount">
          <el-input v-model="form.disburseAmount" placeholder="请输入审批金额" />
        </el-form-item>
        <el-form-item label="后台代理ids" prop="adminParentIds">
          <el-input v-model="form.adminParentIds" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="${comment}" prop="cardUrl">
          <el-input v-model="form.cardUrl" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="cardBackUrl">
          <el-input v-model="form.cardBackUrl" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="capitalUrl">
          <el-input v-model="form.capitalUrl" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="licenseUrl">
          <el-input v-model="form.licenseUrl" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="用户备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="${comment}" prop="searchValue">
          <el-input v-model="form.searchValue" type="textarea" placeholder="请输入内容" />
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
import { listLoadOrder, getLoadOrder, delLoadOrder, addLoadOrder, updateLoadOrder } from "@/api/bussiness/loadOrder";

export default {
  name: "LoadOrder",
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
      // 贷款订单表格数据
      loadOrderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        proId: null,
        userId: null,
        amount: null,
        rate: null,
        interest: null,
        status: null,
        finalRepayTime: null,
        disburseTime: null,
        returnTime: null,
        disburseAmount: null,
        adminParentIds: null,
        cardUrl: null,
        cardBackUrl: null,
        capitalUrl: null,
        licenseUrl: null,
        orderNo: null,
        cycleType: null,
        searchValue: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询贷款订单列表 */
    getList() {
      this.loading = true;
      listLoadOrder(this.queryParams).then(response => {
        this.loadOrderList = response.rows;
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
        proId: null,
        userId: null,
        createTime: null,
        amount: null,
        rate: null,
        interest: null,
        status: null,
        finalRepayTime: null,
        disburseTime: null,
        returnTime: null,
        disburseAmount: null,
        adminParentIds: null,
        cardUrl: null,
        cardBackUrl: null,
        capitalUrl: null,
        licenseUrl: null,
        orderNo: null,
        cycleType: null,
        remark: null,
        createBy: null,
        updateBy: null,
        updateTime: null,
        searchValue: null
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
      this.title = "添加贷款订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLoadOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改贷款订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLoadOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLoadOrder(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除贷款订单编号为"' + ids + '"的数据项？').then(function() {
        return delLoadOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bussiness/loadOrder/export', {
        ...this.queryParams
      }, `loadOrder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
