<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="交易对" prop="pairTrading">
        <el-input
          v-model="queryParams.pairTrading"
          placeholder="请输入交易对"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易币种" prop="symbol">
        <el-input
          v-model="queryParams.symbol"
          placeholder="请输入交易币种"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结算币种" prop="coin">
        <el-input
          v-model="queryParams.coin"
          placeholder="请输入结算币种"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手续费率" prop="feeRate">
        <el-input
          v-model="queryParams.feeRate"
          placeholder="请输入手续费率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易币种精度" prop="symbolPrecision">
        <el-input
          v-model="queryParams.symbolPrecision"
          placeholder="请输入交易币种精度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结算币种精度" prop="coinPrecision">
        <el-input
          v-model="queryParams.coinPrecision"
          placeholder="请输入结算币种精度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最低卖单价" prop="sellMin">
        <el-input
          v-model="queryParams.sellMin"
          placeholder="请输入最低卖单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高买单价" prop="buyMax">
        <el-input
          v-model="queryParams.buyMax"
          placeholder="请输入最高买单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小下单量" prop="orderMin">
        <el-input
          v-model="queryParams.orderMin"
          placeholder="请输入最小下单量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大下单量" prop="orderMax">
        <el-input
          v-model="queryParams.orderMax"
          placeholder="请输入最大下单量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="启用禁用  1=启用 2=禁用" prop="enable">
        <el-input
          v-model="queryParams.enable"
          placeholder="请输入启用禁用  1=启用 2=禁用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="前端是否显示 1=显示  2=隐藏" prop="isShow">
        <el-input
          v-model="queryParams.isShow"
          placeholder="请输入前端是否显示 1=显示  2=隐藏"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否可交易 1=是 2=否" prop="isDeal">
        <el-input
          v-model="queryParams.isDeal"
          placeholder="请输入是否可交易 1=是 2=否"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市价买 1=可以 2=不可以" prop="marketBuy">
        <el-input
          v-model="queryParams.marketBuy"
          placeholder="请输入市价买 1=可以 2=不可以"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市价卖 1=可以 2=不可以" prop="marketSell">
        <el-input
          v-model="queryParams.marketSell"
          placeholder="请输入市价卖 1=可以 2=不可以"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="限价买 1=可以 2=不可以" prop="limitedBuy">
        <el-input
          v-model="queryParams.limitedBuy"
          placeholder="请输入限价买 1=可以 2=不可以"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="限价卖 1=可以 2=不可以" prop="limitedSell">
        <el-input
          v-model="queryParams.limitedSell"
          placeholder="请输入限价卖 1=可以 2=不可以"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="createDate">
        <el-date-picker clearable
          v-model="queryParams.createDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择${comment}">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="${comment}" prop="updateDate">
        <el-date-picker clearable
          v-model="queryParams.updateDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择${comment}">
        </el-date-picker>
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
          v-hasPermi="['bussiness:currency:add']"
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
          v-hasPermi="['bussiness:currency:edit']"
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
          v-hasPermi="['bussiness:currency:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bussiness:currency:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="currencyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="交易对" align="center" prop="pairTrading" />
      <el-table-column label="交易币种" align="center" prop="symbol" />
      <el-table-column label="结算币种" align="center" prop="coin" />
      <el-table-column label="手续费率" align="center" prop="feeRate" />
      <el-table-column label="交易币种精度" align="center" prop="symbolPrecision" />
      <el-table-column label="结算币种精度" align="center" prop="coinPrecision" />
      <el-table-column label="最低卖单价" align="center" prop="sellMin" />
      <el-table-column label="最高买单价" align="center" prop="buyMax" />
      <el-table-column label="最小下单量" align="center" prop="orderMin" />
      <el-table-column label="最大下单量" align="center" prop="orderMax" />
      <el-table-column label="启用禁用  1=启用 2=禁用" align="center" prop="enable" />
      <el-table-column label="前端是否显示 1=显示  2=隐藏" align="center" prop="isShow" />
      <el-table-column label="是否可交易 1=是 2=否" align="center" prop="isDeal" />
      <el-table-column label="市价买 1=可以 2=不可以" align="center" prop="marketBuy" />
      <el-table-column label="市价卖 1=可以 2=不可以" align="center" prop="marketSell" />
      <el-table-column label="限价买 1=可以 2=不可以" align="center" prop="limitedBuy" />
      <el-table-column label="限价卖 1=可以 2=不可以" align="center" prop="limitedSell" />
      <el-table-column label="${comment}" align="center" prop="createDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="${comment}" align="center" prop="updateDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="${comment}" align="center" prop="searchValue" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['bussiness:currency:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['bussiness:currency:remove']"
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

    <!-- 添加或修改币币交易币种配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="交易对" prop="pairTrading">
          <el-input v-model="form.pairTrading" placeholder="请输入交易对" />
        </el-form-item>
        <el-form-item label="交易币种" prop="symbol">
          <el-input v-model="form.symbol" placeholder="请输入交易币种" />
        </el-form-item>
        <el-form-item label="结算币种" prop="coin">
          <el-input v-model="form.coin" placeholder="请输入结算币种" />
        </el-form-item>
        <el-form-item label="手续费率" prop="feeRate">
          <el-input v-model="form.feeRate" placeholder="请输入手续费率" />
        </el-form-item>
        <el-form-item label="交易币种精度" prop="symbolPrecision">
          <el-input v-model="form.symbolPrecision" placeholder="请输入交易币种精度" />
        </el-form-item>
        <el-form-item label="结算币种精度" prop="coinPrecision">
          <el-input v-model="form.coinPrecision" placeholder="请输入结算币种精度" />
        </el-form-item>
        <el-form-item label="最低卖单价" prop="sellMin">
          <el-input v-model="form.sellMin" placeholder="请输入最低卖单价" />
        </el-form-item>
        <el-form-item label="最高买单价" prop="buyMax">
          <el-input v-model="form.buyMax" placeholder="请输入最高买单价" />
        </el-form-item>
        <el-form-item label="最小下单量" prop="orderMin">
          <el-input v-model="form.orderMin" placeholder="请输入最小下单量" />
        </el-form-item>
        <el-form-item label="最大下单量" prop="orderMax">
          <el-input v-model="form.orderMax" placeholder="请输入最大下单量" />
        </el-form-item>
        <el-form-item label="启用禁用  1=启用 2=禁用" prop="enable">
          <el-input v-model="form.enable" placeholder="请输入启用禁用  1=启用 2=禁用" />
        </el-form-item>
        <el-form-item label="前端是否显示 1=显示  2=隐藏" prop="isShow">
          <el-input v-model="form.isShow" placeholder="请输入前端是否显示 1=显示  2=隐藏" />
        </el-form-item>
        <el-form-item label="是否可交易 1=是 2=否" prop="isDeal">
          <el-input v-model="form.isDeal" placeholder="请输入是否可交易 1=是 2=否" />
        </el-form-item>
        <el-form-item label="市价买 1=可以 2=不可以" prop="marketBuy">
          <el-input v-model="form.marketBuy" placeholder="请输入市价买 1=可以 2=不可以" />
        </el-form-item>
        <el-form-item label="市价卖 1=可以 2=不可以" prop="marketSell">
          <el-input v-model="form.marketSell" placeholder="请输入市价卖 1=可以 2=不可以" />
        </el-form-item>
        <el-form-item label="限价买 1=可以 2=不可以" prop="limitedBuy">
          <el-input v-model="form.limitedBuy" placeholder="请输入限价买 1=可以 2=不可以" />
        </el-form-item>
        <el-form-item label="限价卖 1=可以 2=不可以" prop="limitedSell">
          <el-input v-model="form.limitedSell" placeholder="请输入限价卖 1=可以 2=不可以" />
        </el-form-item>
        <el-form-item label="${comment}" prop="createDate">
          <el-date-picker clearable
            v-model="form.createDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="updateDate">
          <el-date-picker clearable
            v-model="form.updateDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择${comment}">
          </el-date-picker>
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
import { listCurrency, getCurrency, delCurrency, addCurrency, updateCurrency } from "@/api/bussiness/currency";

export default {
  name: "Currency",
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
      // 币币交易币种配置表格数据
      currencyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pairTrading: null,
        symbol: null,
        coin: null,
        feeRate: null,
        symbolPrecision: null,
        coinPrecision: null,
        sellMin: null,
        buyMax: null,
        orderMin: null,
        orderMax: null,
        enable: null,
        isShow: null,
        isDeal: null,
        marketBuy: null,
        marketSell: null,
        limitedBuy: null,
        limitedSell: null,
        createDate: null,
        updateDate: null,
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
    /** 查询币币交易币种配置列表 */
    getList() {
      this.loading = true;
      listCurrency(this.queryParams).then(response => {
        this.currencyList = response.rows;
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
        pairTrading: null,
        symbol: null,
        coin: null,
        feeRate: null,
        symbolPrecision: null,
        coinPrecision: null,
        sellMin: null,
        buyMax: null,
        orderMin: null,
        orderMax: null,
        enable: null,
        isShow: null,
        isDeal: null,
        marketBuy: null,
        marketSell: null,
        limitedBuy: null,
        limitedSell: null,
        createBy: null,
        createDate: null,
        updateBy: null,
        updateDate: null,
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
      this.title = "添加币币交易币种配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCurrency(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改币币交易币种配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCurrency(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCurrency(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除币币交易币种配置编号为"' + ids + '"的数据项？').then(function() {
        return delCurrency(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bussiness/currency/export', {
        ...this.queryParams
      }, `currency_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
