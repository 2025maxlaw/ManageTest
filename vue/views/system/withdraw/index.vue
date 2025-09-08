<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提现金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入提现金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="ratio">
        <el-input
          v-model="queryParams.ratio"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手续费" prop="fee">
        <el-input
          v-model="queryParams.fee"
          placeholder="请输入手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际金额" prop="realAmount">
        <el-input
          v-model="queryParams.realAmount"
          placeholder="请输入实际金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收款地址" prop="toAdress">
        <el-input
          v-model="queryParams.toAdress"
          placeholder="请输入收款地址"
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
      <el-form-item label="通知字段 0未通知 1通知了" prop="noticeFlag">
        <el-input
          v-model="queryParams.noticeFlag"
          placeholder="请输入通知字段 0未通知 1通知了"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提现说明" prop="withDrawRemark">
        <el-input
          v-model="queryParams.withDrawRemark"
          placeholder="请输入提现说明"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="银行名称" prop="bankName">
        <el-input
          v-model="queryParams.bankName"
          placeholder="请输入银行名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="银行收款人名称" prop="bankUserName">
        <el-input
          v-model="queryParams.bankUserName"
          placeholder="请输入银行收款人名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="bankBranch">
        <el-input
          v-model="queryParams.bankBranch"
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
          v-hasPermi="['system:withdraw:add']"
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
          v-hasPermi="['system:withdraw:edit']"
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
          v-hasPermi="['system:withdraw:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:withdraw:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="withdrawList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="卡ID" align="center" prop="id" />
      <el-table-column label="${comment}" align="center" prop="remark" />
      <el-table-column label="用户" align="center" prop="userId" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="用户名" align="center" prop="address" />
      <el-table-column label="提现金额" align="center" prop="amount" />
      <el-table-column label="0审核中1成功2失败" align="center" prop="status" />
      <el-table-column label="${comment}" align="center" prop="serialId" />
      <el-table-column label="${comment}" align="center" prop="searchValue" />
      <el-table-column label="用户名" align="center" prop="fromAddr" />
      <el-table-column label="0审核中1成功2失败" align="center" prop="type" />
      <el-table-column label="用户名" align="center" prop="coin" />
      <el-table-column label="${comment}" align="center" prop="ratio" />
      <el-table-column label="手续费" align="center" prop="fee" />
      <el-table-column label="用户名" align="center" prop="withdrawId" />
      <el-table-column label="Host" align="center" prop="host" />
      <el-table-column label="实际金额" align="center" prop="realAmount" />
      <el-table-column label="收款地址" align="center" prop="toAdress" />
      <el-table-column label="后台用户id" align="center" prop="adminUserId" />
      <el-table-column label="通知字段 0未通知 1通知了" align="center" prop="noticeFlag" />
      <el-table-column label="提现说明" align="center" prop="withDrawRemark" />
      <el-table-column label="银行名称" align="center" prop="bankName" />
      <el-table-column label="银行收款人名称" align="center" prop="bankUserName" />
      <el-table-column label="${comment}" align="center" prop="bankBranch" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:withdraw:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:withdraw:remove']"
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

    <!-- 添加或修改用户提现对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户" />
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="用户名" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="提现金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入提现金额" />
        </el-form-item>
        <el-form-item label="${comment}" prop="serialId">
          <el-input v-model="form.serialId" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="${comment}" prop="searchValue">
          <el-input v-model="form.searchValue" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户名" prop="fromAddr">
          <el-input v-model="form.fromAddr" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户名" prop="coin">
          <el-input v-model="form.coin" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="${comment}" prop="ratio">
          <el-input v-model="form.ratio" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="手续费" prop="fee">
          <el-input v-model="form.fee" placeholder="请输入手续费" />
        </el-form-item>
        <el-form-item label="用户名" prop="withdrawId">
          <el-input v-model="form.withdrawId" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="Host" prop="host">
          <el-input v-model="form.host" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="实际金额" prop="realAmount">
          <el-input v-model="form.realAmount" placeholder="请输入实际金额" />
        </el-form-item>
        <el-form-item label="收款地址" prop="toAdress">
          <el-input v-model="form.toAdress" placeholder="请输入收款地址" />
        </el-form-item>
        <el-form-item label="后台用户id" prop="adminUserId">
          <el-input v-model="form.adminUserId" placeholder="请输入后台用户id" />
        </el-form-item>
        <el-form-item label="通知字段 0未通知 1通知了" prop="noticeFlag">
          <el-input v-model="form.noticeFlag" placeholder="请输入通知字段 0未通知 1通知了" />
        </el-form-item>
        <el-form-item label="提现说明" prop="withDrawRemark">
          <el-input v-model="form.withDrawRemark" placeholder="请输入提现说明" />
        </el-form-item>
        <el-form-item label="银行名称" prop="bankName">
          <el-input v-model="form.bankName" placeholder="请输入银行名称" />
        </el-form-item>
        <el-form-item label="银行收款人名称" prop="bankUserName">
          <el-input v-model="form.bankUserName" placeholder="请输入银行收款人名称" />
        </el-form-item>
        <el-form-item label="${comment}" prop="bankBranch">
          <el-input v-model="form.bankBranch" placeholder="请输入${comment}" />
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
import { listWithdraw, getWithdraw, delWithdraw, addWithdraw, updateWithdraw } from "@/api/system/withdraw";

export default {
  name: "Withdraw",
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
      // 用户提现表格数据
      withdrawList: [],
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
        address: null,
        amount: null,
        status: null,
        serialId: null,
        searchValue: null,
        fromAddr: null,
        type: null,
        coin: null,
        ratio: null,
        fee: null,
        withdrawId: null,
        host: null,
        realAmount: null,
        toAdress: null,
        adminUserId: null,
        noticeFlag: null,
        withDrawRemark: null,
        bankName: null,
        bankUserName: null,
        bankBranch: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "0审核中1成功2失败不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户提现列表 */
    getList() {
      this.loading = true;
      listWithdraw(this.queryParams).then(response => {
        this.withdrawList = response.rows;
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
        address: null,
        amount: null,
        status: null,
        serialId: null,
        searchValue: null,
        fromAddr: null,
        type: null,
        coin: null,
        ratio: null,
        fee: null,
        withdrawId: null,
        host: null,
        realAmount: null,
        toAdress: null,
        adminUserId: null,
        noticeFlag: null,
        withDrawRemark: null,
        bankName: null,
        bankUserName: null,
        bankBranch: null
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
      this.title = "添加用户提现";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getWithdraw(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户提现";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWithdraw(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWithdraw(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户提现编号为"' + ids + '"的数据项？').then(function() {
        return delWithdraw(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/withdraw/export', {
        ...this.queryParams
      }, `withdraw_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
