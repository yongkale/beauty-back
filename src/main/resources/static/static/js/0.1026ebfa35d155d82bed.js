webpackJsonp([0],{1035:function(e,r){e.exports={render:function(){var e=this,r=e.$createElement,o=e._self._c||r;return o("div",[o("div",{staticClass:"crumbs"},[o("el-breadcrumb",{attrs:{separator:"/"}},[o("el-breadcrumb-item",[o("i",{staticClass:"el-icon-date"}),e._v(" 普通用户")]),e._v(" "),o("el-breadcrumb-item",[e._v("添加消费")])],1)],1),e._v(" "),o("div",{staticClass:"form-box"},[o("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"80px"}},[o("el-form-item",{attrs:{label:"金额",prop:"payMoney"}},[o("el-input",{model:{value:e.ruleForm.payMoney,callback:function(r){e.$set(e.ruleForm,"payMoney",r)},expression:"ruleForm.payMoney"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"导师",prop:"leaderPerson"}},[o("el-select",{attrs:{placeholder:"请选择"},model:{value:e.ruleForm.leaderPerson,callback:function(r){e.$set(e.ruleForm,"leaderPerson",r)},expression:"ruleForm.leaderPerson"}},e._l(e.person,function(e,r){return o("el-option",{key:r,attrs:{label:e.employeeName,value:e.employeeName}})}),1)],1),e._v(" "),o("el-form-item",{attrs:{label:"助理",prop:"assginPerson"}},[o("el-select",{attrs:{placeholder:"请选择"},model:{value:e.ruleForm.assginPerson,callback:function(r){e.$set(e.ruleForm,"assginPerson",r)},expression:"ruleForm.assginPerson"}},e._l(e.person,function(e,r){return o("el-option",{key:r,attrs:{label:e.employeeName,value:e.employeeName}})}),1)],1),e._v(" "),o("el-form-item",{attrs:{label:"责任人",prop:"repsoenPerson"}},[o("el-select",{attrs:{placeholder:"请选择"},model:{value:e.ruleForm.repsoenPerson,callback:function(r){e.$set(e.ruleForm,"repsoenPerson",r)},expression:"ruleForm.repsoenPerson"}},e._l(e.person,function(e,r){return o("el-option",{key:r,attrs:{label:e.employeeName,value:e.employeeName}})}),1)],1),e._v(" "),o("el-form-item",{attrs:{label:"类型",prop:"costType"}},[o("el-select",{attrs:{placeholder:"请选择"},model:{value:e.ruleForm.costType,callback:function(r){e.$set(e.ruleForm,"costType",r)},expression:"ruleForm.costType"}},[o("el-option",{key:"bbk",attrs:{label:"美容",value:"美容"}}),e._v(" "),o("el-option",{key:"xtc",attrs:{label:"美发",value:"美发"}}),e._v(" "),o("el-option",{key:"imoo",attrs:{label:"美甲",value:"美甲"}})],1)],1),e._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:function(r){return e.onSubmit("ruleForm")}}},[e._v("提交")])],1)],1)],1)])},staticRenderFns:[]}},222:function(e,r,o){var l=o(219)(o(579),o(1035),null,null);e.exports=l.exports},579:function(e,r,o){"use strict";Object.defineProperty(r,"__esModule",{value:!0});var l=o(220),t=o.n(l);r.default={data:function(){return{ruleForm:{costType:"",payMoney:"",assginPerson:"",leaderPerson:"",repsoenPerson:""},person:"",rules:{repsoenPerson:[{required:!0,message:"请输入",trigger:"blur"}],leaderPerson:[{required:!0,message:"请输入",trigger:"blur"}],assginPerson:[{required:!0,message:"请输入",trigger:"blur"}],payMoney:[{required:!0,message:"请输入",trigger:"blur"}]}}},mounted:function(){var e=this;t.a.get("/api/employee/findAll",this.ruleForm).then(function(r){e.person=r.data,console.log(e.person)})},methods:{onSubmit:function(e){var r=this,o=this;o.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;t.a.post("/api/commmonuser/save?type=create",r.ruleForm).then(function(e){r.user=e.data,e.data?(localStorage.setItem("ms_username",r.user.userName),o.$router.push("/vuetable"),r.$message("添加成功")):r.$message("登录失败")})})}}}}});