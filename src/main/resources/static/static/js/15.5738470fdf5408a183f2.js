webpackJsonp([15],{1018:function(e,r){e.exports={render:function(){var e=this,r=e.$createElement,m=e._self._c||r;return m("div",[m("div",{staticClass:"crumbs"},[m("el-breadcrumb",{attrs:{separator:"/"}},[m("el-breadcrumb-item",[m("i",{staticClass:"el-icon-date"}),e._v(" 会员用户")]),e._v(" "),m("el-breadcrumb-item",[e._v("会员充值")])],1)],1),e._v(" "),m("div",{staticClass:"form-box"},[m("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"80px"}},[m("el-form-item",{attrs:{label:"手机号",prop:"phoneNumber"}},[m("el-input",{attrs:{disabled:"true"},model:{value:e.ruleForm.phoneNumber,callback:function(r){e.$set(e.ruleForm,"phoneNumber",r)},expression:"ruleForm.phoneNumber"}})],1),e._v(" "),m("el-form-item",{attrs:{label:"姓名",prop:"name"}},[m("el-input",{attrs:{disabled:"true"},model:{value:e.ruleForm.name,callback:function(r){e.$set(e.ruleForm,"name",r)},expression:"ruleForm.name"}})],1),e._v(" "),m("el-form-item",{attrs:{label:"ID",prop:"memberId"}},[m("el-input",{attrs:{disabled:"true"},model:{value:e.ruleForm.memberId,callback:function(r){e.$set(e.ruleForm,"memberId",r)},expression:"ruleForm.memberId"}})],1),e._v(" "),m("el-form-item",{attrs:{label:"金额",prop:"memberMeony"}},[m("el-input",{model:{value:e.ruleForm.memberMeony,callback:function(r){e.$set(e.ruleForm,"memberMeony",r)},expression:"ruleForm.memberMeony"}})],1),e._v(" "),m("el-form-item",{attrs:{label:"次数",prop:"memberNumber"}},[m("el-input",{model:{value:e.ruleForm.memberNumber,callback:function(r){e.$set(e.ruleForm,"memberNumber",r)},expression:"ruleForm.memberNumber"}})],1),e._v(" "),m("el-form-item",{attrs:{label:"备注",prop:"remarks"}},[m("el-input",{model:{value:e.ruleForm.remarks,callback:function(r){e.$set(e.ruleForm,"remarks",r)},expression:"ruleForm.remarks"}})],1),e._v(" "),m("el-form-item",{attrs:{label:"类型",prop:"memberType"}},[m("el-input",{attrs:{disabled:"true"},model:{value:e.ruleForm.memberType,callback:function(r){e.$set(e.ruleForm,"memberType",r)},expression:"ruleForm.memberType"}})],1),e._v(" "),m("el-form-item",{attrs:{label:"责任人",prop:"repsoenPerson"}},[m("el-select",{attrs:{placeholder:"请选择"},model:{value:e.ruleForm.repsoenPerson,callback:function(r){e.$set(e.ruleForm,"repsoenPerson",r)},expression:"ruleForm.repsoenPerson"}},e._l(e.person,function(e,r){return m("el-option",{key:r,attrs:{label:e.employeeName,value:e.employeeName}})}),1)],1),e._v(" "),m("el-form-item",[m("el-button",{attrs:{type:"primary"},on:{click:function(r){return e.onSubmit("ruleForm")}}},[e._v("提交")])],1)],1)],1)])},staticRenderFns:[]}},556:function(e,r,m){var o=m(219)(m(592),m(1018),null,null);e.exports=o.exports},592:function(e,r,m){"use strict";Object.defineProperty(r,"__esModule",{value:!0});var o=m(220),l=m.n(o);r.default={data:function(){return{person:"",ruleForm:{memberId:"",memberType:"",memberMeony:"",remarks:"",memberNumber:"",phoneNumber:"",name:"",repsoenPerson:""},rules:{repsoenPerson:[{required:!0,message:"请输入",trigger:"blur"}],memberNumber:[{required:!0,message:"请输入",trigger:"blur"}],memberMeony:[{required:!0,message:"请输入",trigger:"blur"}]}}},mounted:function(){var e=this,r=this.$route.query.memberId,m=this.$route.query.memberType;l.a.get("/api/member/findMemberUserBytypeAndId?memberId="+r+"&memberType="+m).then(function(r){e.ruleForm=r.data,e.ruleForm.repsoenPerson="",e.ruleForm.memberNumber="",e.ruleForm.memberMeony=""}),l.a.get("/api/employee/findAll",this.ruleForm).then(function(r){e.person=r.data,console.log(e.person)})},methods:{onSubmit:function(e){var r=this,m=this;m.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;l.a.post("/api/rechage/save",r.ruleForm).then(function(e){r.user=e.data,e.data?(m.$router.push("/memberList"),r.$message("添加成功")):r.$message("添加失败")})})}}}}});