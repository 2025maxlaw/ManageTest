<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="地址" prop="adress">
        <el-input
          v-model="queryParams.adress"
          placeholder="请输入地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投资金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入投资金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投资期限" prop="days">
        <el-input
          v-model="queryParams.days"
          placeholder="请输入投资期限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目id" prop="planId">
        <el-input
          v-model="queryParams.planId"
          placeholder="请输入项目id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目名称" prop="planTitle">
        <el-input
          v-model="queryParams.planTitle"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单编号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到期时间" prop="endTime">
        <el-date-picker clearable
          v-model="queryParams.endTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择到期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结算时间" prop="settleTime">
        <el-date-picker clearable
          v-model="queryParams.settleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择结算时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="累计收益" prop="accumulaEarn">
        <el-input
          v-model="queryParams.accumulaEarn"
          placeholder="请输入累计收益"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小利率" prop="minOdds">
        <el-input
          v-model="queryParams.minOdds"
          placeholder="请输入最小利率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大利率" prop="maxOdds">
        <el-input
          v-model="queryParams.maxOdds"
          placeholder="请输入最大利率"
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
      <el-form-item label="后台用户id" prop="adminUserId">
        <el-input
          v-model="queryParams.adminUserId"
          placeholder="请输入后台用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="collectionOrder">
        <el-input
          v-model="queryParams.collectionOrder"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="orderAmount">
        <el-input
          v-model="queryParams.orderAmount"
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
          v-hasPermi="['system:order:add']"
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
          v-hasPermi="['system:order:edit']"
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
          v-hasPermi="['system:order:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:order:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="id" />
      <el-table-column label="地址" align="center" prop="adress" />
      <el-table-column label="投资金额" align="center" prop="amount" />
      <el-table-column label="投资期限" align="center" prop="days" />
      <el-table-column label="0 收益  1 结算" align="center" prop="status" />
      <el-table-column label="项目id" align="center" prop="planId" />
      <el-table-column label="项目名称" align="center" prop="planTitle" />
      <el-table-column label="订单编号" align="center" prop="orderNo" />
      <el-table-column label="到期时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="累计收益" align="center" prop="accumulaEarn" />
      <el-table-column label="最小利率" align="center" prop="minOdds" />
      <el-table-column label="最大利率" align="center" prop="maxOdds" />
      <el-table-column label="违约利率" align="center" prop="defaultOdds" />
      <el-table-column label="后台用户id" align="center" prop="adminUserId" />
      <el-table-column label="0 质押挖矿 1 非质押挖矿" align="center" prop="type" />
      <el-table-column label="${comment}" align="center" prop="collectionOrder" />
      <el-table-column label="${comment}" align="center" prop="userId" />
      <el-table-column label="${comment}" align="center" prop="orderAmount" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:order:remove']"
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

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="地址" prop="adress">
          <el-input v-model="form.adress" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="投资金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入投资金额" />
        </el-form-item>
        <el-form-item label="投资期限" prop="days">
          <el-input v-model="form.days" placeholder="请输入投资期限" />
        </el-form-item>
        <el-form-item label="项目id" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入项目id" />
        </el-form-item>
        <el-form-item label="项目名称" prop="planTitle">
          <el-input v-model="form.planTitle" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="订单编号" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="到期时间" prop="endTime">
          <el-date-picker clearable
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择到期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结算时间" prop="settleTime">
          <el-date-picker clearable
            v-model="form.settleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结算时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="累计收益" prop="accumulaEarn">
          <el-input v-model="form.accumulaEarn" placeholder="请输入累计收益" />
        </el-form-item>
        <el-form-item label="最小利率" prop="minOdds">
          <el-input v-model="form.minOdds" placeholder="请输入最小利率" />
        </el-form-item>
        <el-form-item label="最大利率" prop="maxOdds">
          <el-input v-model="form.maxOdds" placeholder="请输入最大利率" />
        </el-form-item>
        <el-form-item label="违约利率" prop="defaultOdds">
          <el-input v-model="form.defaultOdds" placeholder="请输入违约利率" />
        </el-form-item>
        <el-form-item label="后台用户id" prop="adminUserId">
          <el-input v-model="form.adminUserId" placeholder="请输入后台用户id" />
        </el-form-item>
        <el-form-item label="${comment}" prop="collectionOrder">
          <el-input v-model="form.collectionOrder" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="orderAmount">
          <el-input v-model="form.orderAmount" placeholder="请输入${comment}" />
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
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/system/order";

export default {
  name: "Order",
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
      // 【请填写功能名称】表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        adress: null,
        amount: null,
        days: null,
        status: null,
        planId: null,
        planTitle: null,
        orderNo: null,
        endTime: null,
        settleTime: null,
        accumulaEarn: null,
        minOdds: null,
        maxOdds: null,
        defaultOdds: null,
        adminUserId: null,
        type: null,
        collectionOrder: null,
        userId: null,
        orderAmount: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        amount: [
          { required: true, message: "投资金额不能为空", trigger: "blur" }
        ],
        days: [
          { required: true, message: "投资期限不能为空", trigger: "blur" }
        ],
        planId: [
          { required: true, message: "项目id不能为空", trigger: "blur" }
        ],
        orderNo: [
          { required: true, message: "订单编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
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
        adress: null,
        amount: null,
        days: null,
        status: null,
        planId: null,
        planTitle: null,
        orderNo: null,
        createTime: null,
        endTime: null,
        settleTime: null,
        accumulaEarn: null,
        updateTime: null,
        minOdds: null,
        maxOdds: null,
        defaultOdds: null,
        adminUserId: null,
        type: null,
        collectionOrder: null,
        userId: null,
        orderAmount: null
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
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrder(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + ids + '"的数据项？').then(function() {
        return delOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/order/export', {
        ...this.queryParams
      }, `order_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
