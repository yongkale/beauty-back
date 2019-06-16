webpackJsonp([16],{1031:function(e,r,o){var t=o(411)(o(1052),o(1089),null,null);e.exports=t.exports},1052:function(e,r,o){"use strict";Object.defineProperty(r,"__esModule",{value:!0});var t=o(412),l=o.n(t);r.default={data:function(){return{person:"",ruleForm:{memberId:"",memberType:"",memberMeony:"",remarks:"",phoneNumber:"",name:"",repsoenPerson:""},rules:{repsoenPerson:[{required:!0,message:"请输入",trigger:"blur"}],phoneNumber:[{validator:function(e,r,o){if(!r)return o(new Error("手机号不能为空"));var t=/^1[3|4|5|7|8][0-9]\d{8}$/;if(console.log(t.test(r)),!t.test(r))return o(new Error("请输入正确的手机号"));o()},trigger:"blur"}],name:[{required:!0,message:"请输入",trigger:"blur"}],remarks:[{required:!0,message:"请输入",trigger:"blur"}],memberMeony:[{required:!0,message:"请输入",trigger:"blur"}]}}},mounted:function(){var e=this;l.a.get("/api/employee/findAll",this.ruleForm).then(function(r){e.person=r.data})},methods:{onSubmit:function(e){var r=this,o=this;o.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;l.a.post("/api/member/save",r.ruleForm).then(function(e){r.user=e.data,e.data?(o.$router.push("/memberList"),r.$message("添加成功")):r.$message("登录失败")})})}}}},1089:function(e,r){e.exports={render:function(){var e=this,r=e.$createElement,o=e._self._c||r;return o("div",[o("div",{staticClass:"crumbs"},[o("el-breadcrumb",{attrs:{separator:"/"}},[o("el-breadcrumb-item",[o("i",{staticClass:"el-icon-date"}),e._v(" 会员用户")]),e._v(" "),o("el-breadcrumb-item",[e._v("添加会员")])],1)],1),e._v(" "),o("div",{staticClass:"form-box"},[o("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"80px"}},[o("el-form-item",{attrs:{label:"手机号",prop:"phoneNumber"}},[o("el-input",{model:{value:e.ruleForm.phoneNumber,callback:function(r){e.$set(e.ruleForm,"phoneNumber",r)},expression:"ruleForm.phoneNumber"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"姓名",prop:"name"}},[o("el-input",{model:{value:e.ruleForm.name,callback:function(r){e.$set(e.ruleForm,"name",r)},expression:"ruleForm.name"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"金额",prop:"memberMeony"}},[o("el-input",{directives:[{name:"numberInt",rawName:"v-numberInt",value:e.ruleForm.memberMeony,expression:"ruleForm.memberMeony"}],model:{value:e.ruleForm.memberMeony,callback:function(r){e.$set(e.ruleForm,"memberMeony",r)},expression:"ruleForm.memberMeony"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"备注",prop:"remarks"}},[o("el-input",{model:{value:e.ruleForm.remarks,callback:function(r){e.$set(e.ruleForm,"remarks",r)},expression:"ruleForm.remarks"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"责任人",prop:"repsoenPerson"}},[o("el-select",{attrs:{placeholder:"请选择"},model:{value:e.ruleForm.repsoenPerson,callback:function(r){e.$set(e.ruleForm,"repsoenPerson",r)},expression:"ruleForm.repsoenPerson"}},e._l(e.person,function(e,r){return o("el-option",{key:r,attrs:{label:e.employeeName,value:e.employeeName}})}),1)],1),e._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:function(r){return e.onSubmit("ruleForm")}}},[e._v("提交")])],1)],1)],1)])},staticRenderFns:[]}}});