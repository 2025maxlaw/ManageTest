<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易对" prop="symbol">
        <el-input
          v-model="queryParams.symbol"
          placeholder="请输入交易对"
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
      <el-form-item label="用户地址" prop="userAddress">
        <el-input
          v-model="queryParams.userAddress"
          placeholder="请输入用户地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开奖结果" prop="openResult">
        <el-input
          v-model="queryParams.openResult"
          placeholder="请输入开奖结果"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投注金额" prop="betAmount">
        <el-input
          v-model="queryParams.betAmount"
          placeholder="请输入投注金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="获奖金额" prop="rewardAmount">
        <el-input
          v-model="queryParams.rewardAmount"
          placeholder="请输入获奖金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="赔偿金额" prop="compensationAmount">
        <el-input
          v-model="queryParams.compensationAmount"
          placeholder="请输入赔偿金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开盘价格" prop="openPrice">
        <el-input
          v-model="queryParams.openPrice"
          placeholder="请输入开盘价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关盘价格" prop="closePrice">
        <el-input
          v-model="queryParams.closePrice"
          placeholder="请输入关盘价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开盘时间" prop="openTime">
        <el-input
          v-model="queryParams.openTime"
          placeholder="请输入开盘时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关盘时间" prop="closeTime">
        <el-input
          v-model="queryParams.closeTime"
          placeholder="请输入关盘时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易币符号" prop="coinSymbol">
        <el-input
          v-model="queryParams.coinSymbol"
          placeholder="请输入交易币符号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结算币符号" prop="baseSymbol">
        <el-input
          v-model="queryParams.baseSymbol"
          placeholder="请输入结算币符号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单标记 0正常  1包赢  2包输" prop="sign">
        <el-input
          v-model="queryParams.sign"
          placeholder="请输入订单标记 0正常  1包赢  2包输"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否人工干预 0是 1否" prop="manualIntervention">
        <el-input
          v-model="queryParams.manualIntervention"
          placeholder="请输入是否人工干预 0是 1否"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="rate">
        <el-input
          v-model="queryParams.rate"
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
          v-hasPermi="['bussiness:order:add']"
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
          v-hasPermi="['bussiness:order:edit']"
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
          v-hasPermi="['bussiness:order:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bussiness:order:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="id" />
      <el-table-column label="订单号" align="center" prop="orderNo" />
      <el-table-column label="交易对" align="center" prop="symbol" />
      <el-table-column label="类型" align="center" prop="type" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="用户地址" align="center" prop="userAddress" />
      <el-table-column label="预测方向:0 涨 1跌" align="center" prop="betContent" />
      <el-table-column label="开奖结果" align="center" prop="openResult" />
      <el-table-column label="订单状态 0参与中 1已开奖 2已撤销" align="center" prop="status" />
      <el-table-column label="投注金额" align="center" prop="betAmount" />
      <el-table-column label="获奖金额" align="center" prop="rewardAmount" />
      <el-table-column label="赔偿金额" align="center" prop="compensationAmount" />
      <el-table-column label="开盘价格" align="center" prop="openPrice" />
      <el-table-column label="关盘价格" align="center" prop="closePrice" />
      <el-table-column label="开盘时间" align="center" prop="openTime" />
      <el-table-column label="关盘时间" align="center" prop="closeTime" />
      <el-table-column label="交易币符号" align="center" prop="coinSymbol" />
      <el-table-column label="结算币符号" align="center" prop="baseSymbol" />
      <el-table-column label="订单标记 0正常  1包赢  2包输" align="center" prop="sign" />
      <el-table-column label="是否人工干预 0是 1否" align="center" prop="manualIntervention" />
      <el-table-column label="${comment}" align="center" prop="rate" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['bussiness:order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['bussiness:order:remove']"
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

    <!-- 添加或修改秒合约订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单号" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="交易对" prop="symbol">
          <el-input v-model="form.symbol" placeholder="请输入交易对" />
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="用户地址" prop="userAddress">
          <el-input v-model="form.userAddress" placeholder="请输入用户地址" />
        </el-form-item>
        <el-form-item label="预测方向:0 涨 1跌">
          <editor v-model="form.betContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="开奖结果" prop="openResult">
          <el-input v-model="form.openResult" placeholder="请输入开奖结果" />
        </el-form-item>
        <el-form-item label="投注金额" prop="betAmount">
          <el-input v-model="form.betAmount" placeholder="请输入投注金额" />
        </el-form-item>
        <el-form-item label="获奖金额" prop="rewardAmount">
          <el-input v-model="form.rewardAmount" placeholder="请输入获奖金额" />
        </el-form-item>
        <el-form-item label="赔偿金额" prop="compensationAmount">
          <el-input v-model="form.compensationAmount" placeholder="请输入赔偿金额" />
        </el-form-item>
        <el-form-item label="开盘价格" prop="openPrice">
          <el-input v-model="form.openPrice" placeholder="请输入开盘价格" />
        </el-form-item>
        <el-form-item label="关盘价格" prop="closePrice">
          <el-input v-model="form.closePrice" placeholder="请输入关盘价格" />
        </el-form-item>
        <el-form-item label="开盘时间" prop="openTime">
          <el-input v-model="form.openTime" placeholder="请输入开盘时间" />
        </el-form-item>
        <el-form-item label="关盘时间" prop="closeTime">
          <el-input v-model="form.closeTime" placeholder="请输入关盘时间" />
        </el-form-item>
        <el-form-item label="交易币符号" prop="coinSymbol">
          <el-input v-model="form.coinSymbol" placeholder="请输入交易币符号" />
        </el-form-item>
        <el-form-item label="结算币符号" prop="baseSymbol">
          <el-input v-model="form.baseSymbol" placeholder="请输入结算币符号" />
        </el-form-item>
        <el-form-item label="订单标记 0正常  1包赢  2包输" prop="sign">
          <el-input v-model="form.sign" placeholder="请输入订单标记 0正常  1包赢  2包输" />
        </el-form-item>
        <el-form-item label="是否人工干预 0是 1否" prop="manualIntervention">
          <el-input v-model="form.manualIntervention" placeholder="请输入是否人工干预 0是 1否" />
        </el-form-item>
        <el-form-item label="${comment}" prop="rate">
          <el-input v-model="form.rate" placeholder="请输入${comment}" />
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
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/bussiness/order";

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
      // 秒合约订单表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderNo: null,
        symbol: null,
        type: null,
        userId: null,
        userAddress: null,
        betContent: null,
        openResult: null,
        status: null,
        betAmount: null,
        rewardAmount: null,
        compensationAmount: null,
        openPrice: null,
        closePrice: null,
        openTime: null,
        closeTime: null,
        coinSymbol: null,
        baseSymbol: null,
        sign: null,
        manualIntervention: null,
        rate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        orderNo: [
          { required: true, message: "订单号不能为空", trigger: "blur" }
        ],
        symbol: [
          { required: true, message: "交易对不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "类型不能为空", trigger: "change" }
        ],
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
        userAddress: [
          { required: true, message: "用户地址不能为空", trigger: "blur" }
        ],
        betContent: [
          { required: true, message: "预测方向:0 涨 1跌不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "订单状态 0参与中 1已开奖 2已撤销不能为空", trigger: "change" }
        ],
        betAmount: [
          { required: true, message: "投注金额不能为空", trigger: "blur" }
        ],
        rewardAmount: [
          { required: true, message: "获奖金额不能为空", trigger: "blur" }
        ],
        compensationAmount: [
          { required: true, message: "赔偿金额不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询秒合约订单列表 */
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
        orderNo: null,
        symbol: null,
        type: null,
        userId: null,
        userAddress: null,
        betContent: null,
        openResult: null,
        status: null,
        betAmount: null,
        rewardAmount: null,
        compensationAmount: null,
        createTime: null,
        openPrice: null,
        closePrice: null,
        openTime: null,
        closeTime: null,
        coinSymbol: null,
        baseSymbol: null,
        sign: null,
        manualIntervention: null,
        rate: null
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
      this.title = "添加秒合约订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改秒合约订单";
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
      this.$modal.confirm('是否确认删除秒合约订单编号为"' + ids + '"的数据项？').then(function() {
        return delOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bussiness/order/export', {
        ...this.queryParams
      }, `order_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
