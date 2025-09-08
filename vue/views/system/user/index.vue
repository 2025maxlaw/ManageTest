<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="loginName">
        <el-input
          v-model="queryParams.loginName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="登陆密码" prop="loginPassword">
        <el-input
          v-model="queryParams.loginPassword"
          placeholder="请输入登陆密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="0-正常 1-测试" prop="isTest">
        <el-input
          v-model="queryParams.isTest"
          placeholder="请输入0-正常 1-测试"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="秒合约打码量" prop="totleAmont">
        <el-input
          v-model="queryParams.totleAmont"
          placeholder="请输入秒合约打码量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="0正常 1包赢 2包输" prop="buff">
        <el-input
          v-model="queryParams.buff"
          placeholder="请输入0正常 1包赢 2包输"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="代理地址" prop="fatherAddr">
        <el-input
          v-model="queryParams.fatherAddr"
          placeholder="请输入代理地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="代理id" prop="fatherId">
        <el-input
          v-model="queryParams.fatherId"
          placeholder="请输入代理id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邀请码" prop="activeCode">
        <el-input
          v-model="queryParams.activeCode"
          placeholder="请输入邀请码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="注册ip" prop="registerIp">
        <el-input
          v-model="queryParams.registerIp"
          placeholder="请输入注册ip"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="注册域名" prop="host">
        <el-input
          v-model="queryParams.host"
          placeholder="请输入注册域名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="后台代理id" prop="systemUserId">
        <el-input
          v-model="queryParams.systemUserId"
          placeholder="请输入后台代理id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="vip等级 " prop="level">
        <el-input
          v-model="queryParams.level"
          placeholder="请输入vip等级 "
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
          v-hasPermi="['system:user:add']"
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
          v-hasPermi="['system:user:edit']"
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
          v-hasPermi="['system:user:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:user:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="userId" />
      <el-table-column label="姓名" align="center" prop="loginName" />
      <el-table-column label="登陆密码" align="center" prop="loginPassword" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="0-正常 1-测试" align="center" prop="isTest" />
      <el-table-column label="盐" align="center" prop="salt" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="地址类型 ETH TRC" align="center" prop="walletType" />
      <el-table-column label="0正常1冻结" align="center" prop="status" />
      <el-table-column label="秒合约打码量" align="center" prop="totleAmont" />
      <el-table-column label="0正常 1包赢 2包输" align="center" prop="buff" />
      <el-table-column label="代理树" align="center" prop="tree" />
      <el-table-column label="代理地址" align="center" prop="fatherAddr" />
      <el-table-column label="代理id" align="center" prop="fatherId" />
      <el-table-column label="邀请码" align="center" prop="activeCode" />
      <el-table-column label="注册ip" align="center" prop="registerIp" />
      <el-table-column label="注册域名" align="center" prop="host" />
      <el-table-column label="后台代理id" align="center" prop="systemUserId" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="vip等级 " align="center" prop="level" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="${comment}" align="center" prop="searchValue" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:user:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:user:remove']"
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

    <!-- 添加或修改玩家用户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="loginName">
          <el-input v-model="form.loginName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="登陆密码" prop="loginPassword">
          <el-input v-model="form.loginPassword" placeholder="请输入登陆密码" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="0-正常 1-测试" prop="isTest">
          <el-input v-model="form.isTest" placeholder="请输入0-正常 1-测试" />
        </el-form-item>
        <el-form-item label="盐" prop="salt">
          <el-input v-model="form.salt" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="秒合约打码量" prop="totleAmont">
          <el-input v-model="form.totleAmont" placeholder="请输入秒合约打码量" />
        </el-form-item>
        <el-form-item label="0正常 1包赢 2包输" prop="buff">
          <el-input v-model="form.buff" placeholder="请输入0正常 1包赢 2包输" />
        </el-form-item>
        <el-form-item label="代理树" prop="tree">
          <el-input v-model="form.tree" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="代理地址" prop="fatherAddr">
          <el-input v-model="form.fatherAddr" placeholder="请输入代理地址" />
        </el-form-item>
        <el-form-item label="代理id" prop="fatherId">
          <el-input v-model="form.fatherId" placeholder="请输入代理id" />
        </el-form-item>
        <el-form-item label="邀请码" prop="activeCode">
          <el-input v-model="form.activeCode" placeholder="请输入邀请码" />
        </el-form-item>
        <el-form-item label="注册ip" prop="registerIp">
          <el-input v-model="form.registerIp" placeholder="请输入注册ip" />
        </el-form-item>
        <el-form-item label="注册域名" prop="host">
          <el-input v-model="form.host" placeholder="请输入注册域名" />
        </el-form-item>
        <el-form-item label="后台代理id" prop="systemUserId">
          <el-input v-model="form.systemUserId" placeholder="请输入后台代理id" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="vip等级 " prop="level">
          <el-input v-model="form.level" placeholder="请输入vip等级 " />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
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
import { listUser, getUser, delUser, addUser, updateUser } from "@/api/system/user";

export default {
  name: "User",
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
      // 玩家用户表格数据
      userList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        loginName: null,
        loginPassword: null,
        phone: null,
        isTest: null,
        salt: null,
        address: null,
        walletType: null,
        status: null,
        totleAmont: null,
        buff: null,
        tree: null,
        fatherAddr: null,
        fatherId: null,
        activeCode: null,
        registerIp: null,
        host: null,
        systemUserId: null,
        email: null,
        level: null,
        searchValue: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "0正常1冻结不能为空", trigger: "change" }
        ],
        activeCode: [
          { required: true, message: "邀请码不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询玩家用户列表 */
    getList() {
      this.loading = true;
      listUser(this.queryParams).then(response => {
        this.userList = response.rows;
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
        userId: null,
        loginName: null,
        loginPassword: null,
        phone: null,
        isTest: null,
        salt: null,
        address: null,
        walletType: null,
        status: null,
        totleAmont: null,
        buff: null,
        tree: null,
        fatherAddr: null,
        fatherId: null,
        activeCode: null,
        registerIp: null,
        host: null,
        systemUserId: null,
        email: null,
        level: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
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
      this.ids = selection.map(item => item.userId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加玩家用户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userId = row.userId || this.ids
      getUser(userId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改玩家用户";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userId != null) {
            updateUser(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUser(this.form).then(response => {
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
      const userIds = row.userId || this.ids;
      this.$modal.confirm('是否确认删除玩家用户编号为"' + userIds + '"的数据项？').then(function() {
        return delUser(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/user/export', {
        ...this.queryParams
      }, `user_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
