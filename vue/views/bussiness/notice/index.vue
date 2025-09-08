<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="noticeTitle">
        <el-input
          v-model="queryParams.noticeTitle"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评论数" prop="commentsNum">
        <el-input
          v-model="queryParams.commentsNum"
          placeholder="请输入评论数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="浏览数" prop="viewNum">
        <el-input
          v-model="queryParams.viewNum"
          placeholder="请输入浏览数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公告截止时间" prop="expireTime">
        <el-date-picker clearable
          v-model="queryParams.expireTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择公告截止时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="zh:1,cht:2,en:3,pt:4,sa:5,ko:6,ja:7,es:8,th:9,ms:10,id:11,fr:12,ru:13" prop="languageId">
        <el-input
          v-model="queryParams.languageId"
          placeholder="请输入zh:1,cht:2,en:3,pt:4,sa:5,ko:6,ja:7,es:8,th:9,ms:10,id:11,fr:12,ru:13"
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
      <el-form-item label="展示端1=pc 2=h5" prop="source">
        <el-input
          v-model="queryParams.source"
          placeholder="请输入展示端1=pc 2=h5"
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
          v-hasPermi="['bussiness:notice:add']"
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
          v-hasPermi="['bussiness:notice:edit']"
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
          v-hasPermi="['bussiness:notice:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bussiness:notice:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="noticeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="公告ID" align="center" prop="noticeId" />
      <el-table-column label="标题" align="center" prop="noticeTitle" />
      <el-table-column label="公告类型 1=公告信息 2=活动公告 3=首页滚动公告" align="center" prop="noticeType" />
      <el-table-column label="模块类型 1=公告信息 2=活动公告 3=首页滚动公告 
1={1=链接弹窗 2=图文弹窗}, 
2={1=首页轮播活动 2=Defi挖矿活动图},
3={1=首页滚动公告}
注:没有二级的默认给1
二级联动" align="center" prop="modelType" />
      <el-table-column label="内容" align="center" prop="noticeContent" />
      <el-table-column label="评论数" align="center" prop="commentsNum" />
      <el-table-column label="图片" align="center" prop="cover" />
      <el-table-column label="浏览数" align="center" prop="viewNum" />
      <el-table-column label="公告截止时间" align="center" prop="expireTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expireTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="图片链接地址" align="center" prop="imgUrl" />
      <el-table-column label="链接地址" align="center" prop="chainedUrl" />
      <el-table-column label="详情页" align="center" prop="detailUrl" />
      <el-table-column label="zh:1,cht:2,en:3,pt:4,sa:5,ko:6,ja:7,es:8,th:9,ms:10,id:11,fr:12,ru:13" align="center" prop="languageId" />
      <el-table-column label="公告状态" align="center" prop="status" />
      <el-table-column label="排序" align="center" prop="sort" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="展示端1=pc 2=h5" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['bussiness:notice:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['bussiness:notice:remove']"
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

    <!-- 添加或修改通知公告对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="noticeTitle">
          <el-input v-model="form.noticeTitle" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.noticeContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="评论数" prop="commentsNum">
          <el-input v-model="form.commentsNum" placeholder="请输入评论数" />
        </el-form-item>
        <el-form-item label="图片" prop="cover">
          <el-input v-model="form.cover" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="浏览数" prop="viewNum">
          <el-input v-model="form.viewNum" placeholder="请输入浏览数" />
        </el-form-item>
        <el-form-item label="公告截止时间" prop="expireTime">
          <el-date-picker clearable
            v-model="form.expireTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择公告截止时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="图片链接地址" prop="imgUrl">
          <el-input v-model="form.imgUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="链接地址" prop="chainedUrl">
          <el-input v-model="form.chainedUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="详情页" prop="detailUrl">
          <el-input v-model="form.detailUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="zh:1,cht:2,en:3,pt:4,sa:5,ko:6,ja:7,es:8,th:9,ms:10,id:11,fr:12,ru:13" prop="languageId">
          <el-input v-model="form.languageId" placeholder="请输入zh:1,cht:2,en:3,pt:4,sa:5,ko:6,ja:7,es:8,th:9,ms:10,id:11,fr:12,ru:13" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="展示端1=pc 2=h5" prop="source">
          <el-input v-model="form.source" placeholder="请输入展示端1=pc 2=h5" />
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
import { listNotice, getNotice, delNotice, addNotice, updateNotice } from "@/api/bussiness/notice";

export default {
  name: "Notice",
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
      // 通知公告表格数据
      noticeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        noticeTitle: null,
        noticeType: null,
        modelType: null,
        noticeContent: null,
        commentsNum: null,
        cover: null,
        viewNum: null,
        expireTime: null,
        imgUrl: null,
        chainedUrl: null,
        detailUrl: null,
        languageId: null,
        status: null,
        sort: null,
        source: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        noticeTitle: [
          { required: true, message: "标题不能为空", trigger: "blur" }
        ],
        modelType: [
          { required: true, message: "模块类型 1=公告信息 2=活动公告 3=首页滚动公告 
1={1=链接弹窗 2=图文弹窗}, 
2={1=首页轮播活动 2=Defi挖矿活动图},
3={1=首页滚动公告}
注:没有二级的默认给1
二级联动不能为空", trigger: "change" }
        ],
        commentsNum: [
          { required: true, message: "评论数不能为空", trigger: "blur" }
        ],
        viewNum: [
          { required: true, message: "浏览数不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询通知公告列表 */
    getList() {
      this.loading = true;
      listNotice(this.queryParams).then(response => {
        this.noticeList = response.rows;
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
        noticeId: null,
        noticeTitle: null,
        noticeType: null,
        modelType: null,
        noticeContent: null,
        commentsNum: null,
        cover: null,
        viewNum: null,
        expireTime: null,
        imgUrl: null,
        chainedUrl: null,
        detailUrl: null,
        languageId: null,
        status: null,
        sort: null,
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        source: null
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
      this.ids = selection.map(item => item.noticeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加通知公告";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const noticeId = row.noticeId || this.ids
      getNotice(noticeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改通知公告";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.noticeId != null) {
            updateNotice(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addNotice(this.form).then(response => {
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
      const noticeIds = row.noticeId || this.ids;
      this.$modal.confirm('是否确认删除通知公告编号为"' + noticeIds + '"的数据项？').then(function() {
        return delNotice(noticeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bussiness/notice/export', {
        ...this.queryParams
      }, `notice_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
