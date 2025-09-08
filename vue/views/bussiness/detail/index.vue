<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="真实姓名" prop="realName">
        <el-input
          v-model="queryParams.realName"
          placeholder="请输入真实姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号码" prop="idCard">
        <el-input
          v-model="queryParams.idCard"
          placeholder="请输入身份证号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证正面照片" prop="frontUrl">
        <el-input
          v-model="queryParams.frontUrl"
          placeholder="请输入身份证正面照片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="国际" prop="country">
        <el-input
          v-model="queryParams.country"
          placeholder="请输入国际"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手持身份证照片" prop="handelUrl">
        <el-input
          v-model="queryParams.handelUrl"
          placeholder="请输入手持身份证照片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证反面照片" prop="backUrl">
        <el-input
          v-model="queryParams.backUrl"
          placeholder="请输入身份证反面照片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户交易密码" prop="userTardPwd">
        <el-input
          v-model="queryParams.userTardPwd"
          placeholder="请输入用户交易密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="初级验证状态" prop="auditStatusPrimary">
        <el-input
          v-model="queryParams.auditStatusPrimary"
          placeholder="请输入初级验证状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="高级验证状态" prop="auditStatusAdvanced">
        <el-input
          v-model="queryParams.auditStatusAdvanced"
          placeholder="请输入高级验证状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="信用分" prop="credits">
        <el-input
          v-model="queryParams.credits"
          placeholder="请输入信用分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户充值地址" prop="userRechargeAddress">
        <el-input
          v-model="queryParams.userRechargeAddress"
          placeholder="请输入用户充值地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="连赢场次" prop="winNum">
        <el-input
          v-model="queryParams.winNum"
          placeholder="请输入连赢场次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="连输场次" prop="loseNum">
        <el-input
          v-model="queryParams.loseNum"
          placeholder="请输入连输场次"
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
          v-hasPermi="['bussiness:detail:add']"
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
          v-hasPermi="['bussiness:detail:edit']"
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
          v-hasPermi="['bussiness:detail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bussiness:detail:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="detailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="" align="center" prop="id" />
      <el-table-column label="" align="center" prop="userId" />
      <el-table-column label="真实姓名" align="center" prop="realName" />
      <el-table-column label="身份证号码" align="center" prop="idCard" />
      <el-table-column label="身份证正面照片" align="center" prop="frontUrl" />
      <el-table-column label="国际" align="center" prop="country" />
      <el-table-column label="" align="center" prop="cardType" />
      <el-table-column label="手持身份证照片" align="center" prop="handelUrl" />
      <el-table-column label="身份证反面照片" align="center" prop="backUrl" />
      <el-table-column label="用户交易密码" align="center" prop="userTardPwd" />
      <el-table-column label="" align="center" prop="remark" />
      <el-table-column label="" align="center" prop="searchValue" />
      <el-table-column label="初级验证状态" align="center" prop="auditStatusPrimary" />
      <el-table-column label="高级验证状态" align="center" prop="auditStatusAdvanced" />
      <el-table-column label="信用分" align="center" prop="credits" />
      <el-table-column label="用户充值地址" align="center" prop="userRechargeAddress" />
      <el-table-column label="连赢场次" align="center" prop="winNum" />
      <el-table-column label="连输场次" align="center" prop="loseNum" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['bussiness:detail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['bussiness:detail:remove']"
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

    <!-- 添加或修改用户详细信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="真实姓名" prop="realName">
          <el-input v-model="form.realName" placeholder="请输入真实姓名" />
        </el-form-item>
        <el-form-item label="身份证号码" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号码" />
        </el-form-item>
        <el-form-item label="身份证正面照片" prop="frontUrl">
          <el-input v-model="form.frontUrl" placeholder="请输入身份证正面照片" />
        </el-form-item>
        <el-form-item label="国际" prop="country">
          <el-input v-model="form.country" placeholder="请输入国际" />
        </el-form-item>
        <el-form-item label="手持身份证照片" prop="handelUrl">
          <el-input v-model="form.handelUrl" placeholder="请输入手持身份证照片" />
        </el-form-item>
        <el-form-item label="身份证反面照片" prop="backUrl">
          <el-input v-model="form.backUrl" placeholder="请输入身份证反面照片" />
        </el-form-item>
        <el-form-item label="用户交易密码" prop="userTardPwd">
          <el-input v-model="form.userTardPwd" placeholder="请输入用户交易密码" />
        </el-form-item>
        <el-form-item label="" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="" prop="searchValue">
          <el-input v-model="form.searchValue" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="初级验证状态" prop="auditStatusPrimary">
          <el-input v-model="form.auditStatusPrimary" placeholder="请输入初级验证状态" />
        </el-form-item>
        <el-form-item label="高级验证状态" prop="auditStatusAdvanced">
          <el-input v-model="form.auditStatusAdvanced" placeholder="请输入高级验证状态" />
        </el-form-item>
        <el-form-item label="信用分" prop="credits">
          <el-input v-model="form.credits" placeholder="请输入信用分" />
        </el-form-item>
        <el-form-item label="用户充值地址" prop="userRechargeAddress">
          <el-input v-model="form.userRechargeAddress" placeholder="请输入用户充值地址" />
        </el-form-item>
        <el-form-item label="连赢场次" prop="winNum">
          <el-input v-model="form.winNum" placeholder="请输入连赢场次" />
        </el-form-item>
        <el-form-item label="连输场次" prop="loseNum">
          <el-input v-model="form.loseNum" placeholder="请输入连输场次" />
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
import { listDetail, getDetail, delDetail, addDetail, updateDetail } from "@/api/bussiness/detail";

export default {
  name: "Detail",
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
      // 用户详细信息表格数据
      detailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        realName: null,
        idCard: null,
        frontUrl: null,
        country: null,
        cardType: null,
        handelUrl: null,
        backUrl: null,
        userTardPwd: null,
        searchValue: null,
        auditStatusPrimary: null,
        auditStatusAdvanced: null,
        credits: null,
        userRechargeAddress: null,
        winNum: null,
        loseNum: null
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
    /** 查询用户详细信息列表 */
    getList() {
      this.loading = true;
      listDetail(this.queryParams).then(response => {
        this.detailList = response.rows;
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
        userId: null,
        realName: null,
        idCard: null,
        frontUrl: null,
        country: null,
        cardType: null,
        handelUrl: null,
        backUrl: null,
        userTardPwd: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        searchValue: null,
        auditStatusPrimary: null,
        auditStatusAdvanced: null,
        credits: null,
        userRechargeAddress: null,
        winNum: null,
        loseNum: null
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
      this.title = "添加用户详细信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户详细信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDetail(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDetail(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户详细信息编号为"' + ids + '"的数据项？').then(function() {
        return delDetail(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bussiness/detail/export', {
        ...this.queryParams
      }, `detail_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
