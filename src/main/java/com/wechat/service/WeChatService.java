package com.wechat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wechat.context.WeChatContext;
import com.wechat.template.AjaxJsonView;
import com.wechat.template.TemplateData;
import com.wechat.template.WeChatTemplate;
import com.wechat.util.WeChatUtil;

@Service
public class WeChatService {
    
	@Autowired
	public WeChatContext context;
	
	public AjaxJsonView notifyUserCustomerCount(String openId, int money,String Type) {
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
		

		tmpl.setTouser(String.valueOf(openId)); //关注用户的openid
		tmpl.setData(data);
		
		//发送模板数据并记录回执
		JSONObject object = WeChatUtil.sendTmplMsg(tmpl,context);
		resultMsgs.add(object);
			
		jsonView.setObject(JSON.toJSONString(resultMsgs));
		return jsonView;
	}
}
