<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="所有者ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入所有者ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入充值金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="bonus">
        <el-input
          v-model="queryParams.bonus"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="第三方支付订单号" prop="txId">
        <el-input
          v-model="queryParams.txId"
          placeholder="请输入第三方支付订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入充值地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币总" prop="coin">
        <el-input
          v-model="queryParams.coin"
          placeholder="请输入币总"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入款地址" prop="toAddress">
        <el-input
          v-model="queryParams.toAddress"
          placeholder="请输入入款地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区块时间" prop="blockTime">
        <el-date-picker clearable
          v-model="queryParams.blockTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择区块时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="${comment}" prop="host">
        <el-input
          v-model="queryParams.host"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际到账金额" prop="realAmount">
        <el-input
          v-model="queryParams.realAmount"
          placeholder="请输入实际到账金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值凭证" prop="fileName">
        <el-input
          v-model="queryParams.fileName"
          placeholder="请输入充值凭证"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="rechargeRemark">
        <el-input
          v-model="queryParams.rechargeRemark"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="通知字段 0未通知 1通知了" prop="noticeFlag">
        <el-input
          v-model="queryParams.noticeFlag"
          placeholder="请输入通知字段 0未通知 1通知了"
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
          v-hasPermi="['system:recharge:add']"
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
          v-hasPermi="['system:recharge:edit']"
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
          v-hasPermi="['system:recharge:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:recharge:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="rechargeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="卡ID" align="center" prop="id" />
      <el-table-column label="${comment}" align="center" prop="remark" />
      <el-table-column label="所有者ID" align="center" prop="userId" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="充值金额" align="center" prop="amount" />
      <el-table-column label="${comment}" align="center" prop="bonus" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="订单号" align="center" prop="serialId" />
      <el-table-column label="第三方支付订单号" align="center" prop="txId" />
      <el-table-column label="类型" align="center" prop="type" />
      <el-table-column label="${comment}" align="center" prop="searchValue" />
      <el-table-column label="充值地址" align="center" prop="address" />
      <el-table-column label="${comment}" align="center" prop="tree" />
      <el-table-column label="币总" align="center" prop="coin" />
      <el-table-column label="入款地址" align="center" prop="toAddress" />
      <el-table-column label="区块时间" align="center" prop="blockTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.blockTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="${comment}" align="center" prop="host" />
      <el-table-column label="实际到账金额" align="center" prop="realAmount" />
      <el-table-column label="充值凭证" align="center" prop="fileName" />
      <el-table-column label="${comment}" align="center" prop="rechargeRemark" />
      <el-table-column label="通知字段 0未通知 1通知了" align="center" prop="noticeFlag" />
      <el-table-column label="app代理ids" align="center" prop="appParentIds" />
      <el-table-column label="后台代理ids" align="center" prop="adminParentIds" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:recharge:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:recharge:remove']"
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

    <!-- 添加或修改用户充值对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="所有者ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入所有者ID" />
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="充值金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入充值金额" />
        </el-form-item>
        <el-form-item label="${comment}" prop="bonus">
          <el-input v-model="form.bonus" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="订单号" prop="serialId">
          <el-input v-model="form.serialId" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="第三方支付订单号" prop="txId">
          <el-input v-model="form.txId" placeholder="请输入第三方支付订单号" />
        </el-form-item>
        <el-form-item label="${comment}" prop="searchValue">
          <el-input v-model="form.searchValue" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="充值地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入充值地址" />
        </el-form-item>
        <el-form-item label="${comment}" prop="tree">
          <el-input v-model="form.tree" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="币总" prop="coin">
          <el-input v-model="form.coin" placeholder="请输入币总" />
        </el-form-item>
        <el-form-item label="入款地址" prop="toAddress">
          <el-input v-model="form.toAddress" placeholder="请输入入款地址" />
        </el-form-item>
        <el-form-item label="区块时间" prop="blockTime">
          <el-date-picker clearable
            v-model="form.blockTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择区块时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="host">
          <el-input v-model="form.host" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="实际到账金额" prop="realAmount">
          <el-input v-model="form.realAmount" placeholder="请输入实际到账金额" />
        </el-form-item>
        <el-form-item label="充值凭证" prop="fileName">
          <el-input v-model="form.fileName" placeholder="请输入充值凭证" />
        </el-form-item>
        <el-form-item label="${comment}" prop="rechargeRemark">
          <el-input v-model="form.rechargeRemark" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="通知字段 0未通知 1通知了" prop="noticeFlag">
          <el-input v-model="form.noticeFlag" placeholder="请输入通知字段 0未通知 1通知了" />
        </el-form-item>
        <el-form-item label="app代理ids" prop="appParentIds">
          <el-input v-model="form.appParentIds" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="后台代理ids" prop="adminParentIds">
          <el-input v-model="form.adminParentIds" type="textarea" placeholder="请输入内容" />
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
import { listRecharge, getRecharge, delRecharge, addRecharge, updateRecharge } from "@/api/system/recharge";

export default {
  name: "Recharge",
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
      // 用户充值表格数据
      rechargeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        username: null,
        amount: null,
        bonus: null,
        status: null,
        serialId: null,
        txId: null,
        type: null,
        searchValue: null,
        address: null,
        tree: null,
        coin: null,
        toAddress: null,
        blockTime: null,
        host: null,
        realAmount: null,
        fileName: null,
        rechargeRemark: null,
        noticeFlag: null,
        appParentIds: null,
        adminParentIds: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "所有者ID不能为空", trigger: "blur" }
        ],
        amount: [
          { required: true, message: "充值金额不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" }
        ],
        serialId: [
          { required: true, message: "订单号不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "类型不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户充值列表 */
    getList() {
      this.loading = true;
      listRecharge(this.queryParams).then(response => {
        this.rechargeList = response.rows;
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
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        userId: null,
        username: null,
        amount: null,
        bonus: null,
        status: null,
        serialId: null,
        txId: null,
        type: null,
        searchValue: null,
        address: null,
        tree: null,
        coin: null,
        toAddress: null,
        blockTime: null,
        host: null,
        realAmount: null,
        fileName: null,
        rechargeRemark: null,
        noticeFlag: null,
        appParentIds: null,
        adminParentIds: null
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
      this.title = "添加用户充值";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRecharge(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户充值";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRecharge(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecharge(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户充值编号为"' + ids + '"的数据项？').then(function() {
        return delRecharge(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/recharge/export', {
        ...this.queryParams
      }, `recharge_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
