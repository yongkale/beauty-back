package com.wechat.controller;
 
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bh.beauty.dao.MemberUserDao;
import com.bh.beauty.entity.MemberUser;
import com.wechat.context.WeChatContext;
import com.wechat.template.AjaxJsonView;
import com.wechat.template.TemplateData;
import com.wechat.template.WeChatTemplate;
import com.wechat.util.WeChatUtil;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
 
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {
	
	public static final String OPENID = "openId";
 
    @Autowired
    private WxMpService wxMpService;
    
    @Autowired
    private MemberUserDao memberUserDao;
    
	@Autowired
	public WeChatContext context;
 
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){
        String url = "http://tyb4yx.natappfree.cc/wechat/userInfo";
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectURL;
    }
 
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl, ServletRequest request) throws Exception {

    	HttpServletRequest req =  (HttpServletRequest)request;
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            throw new Exception(e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        req.getSession().setAttribute(OPENID, openId);

        System.out.println(req.getSession().getAttribute(OPENID));
        return "redirect:" + returnUrl;
    }
    
    @PostMapping("/matchUserInfo")
    public MemberUser matchUserInfo(@RequestBody String phone, ServletRequest request) {
    	MemberUser memberUser = memberUserDao.findByPhoneNumber(phone);
    	HttpServletRequest req =  (HttpServletRequest)request;
    	memberUser.setWeChatNumber((String)req.getSession().getAttribute(OPENID));
    	return memberUserDao.save(memberUser);
    }
    
    @GetMapping("/sendmsg")
    public AjaxJsonView getInfo(ServletRequest request) {
    	HttpServletRequest req =  (HttpServletRequest)request;
//    	boolean preview = pushService.preview((String)req.getSession().getAttribute(OPENID), (String)req.getSession().getAttribute(TOKEN));
//    	boolean preview = pushService.preview("","");
    	
    	
    	String color = "red";
    	
    	AjaxJsonView jsonView = new AjaxJsonView();
		//封装模板消息
		WeChatTemplate tmpl = new WeChatTemplate();
		tmpl.setTopcolor(color);
		tmpl.setUrl("www.baidu.com"); //点击后跳转的网址,留空会存在问题-- 苹果机：点击后跳转到空白页面  安卓：点击没反应
		tmpl.setTemplate_id(context.getTemplateId());//模板ID,需先建立模板
		
		//模板数据
		Map<String, TemplateData> data = new HashMap<String, TemplateData>();
//		data.put("first", new TemplateData(model.getFirst(), color));
//		data.put("alarm_unit", new TemplateData(model.getAlarm_unit(), color));
//		data.put("alarm_type", new TemplateData(model.getAlarm_type(), color)); //事件类型
//		data.put("alarm_level", new TemplateData(model.getAlarm_level(), color)); //事件类型
//		data.put("alarm_time", new TemplateData(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()), color));
//		data.put("remark", new TemplateData(model.getRemark(), color));
		
		
		List<JSONObject> resultMsgs = new ArrayList<JSONObject>();
		
		//获取关注用户openid
		JSONArray openIdArray = WeChatUtil.getOpenIds(context);
		//每个用户循环发送
		for (Object openId : openIdArray) {
			tmpl.setTouser(String.valueOf(openId)); //关注用户的openid
			tmpl.setData(data);
			
			//发送模板数据并记录回执
			JSONObject object = WeChatUtil.sendTmplMsg(tmpl,context);
			resultMsgs.add(object);
		}
		
		jsonView.setObject(JSON.toJSONString(resultMsgs));
		return jsonView;
    }  
}
