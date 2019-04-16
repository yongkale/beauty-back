package com.bh.beauty.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * 时间格式化工具类
 * @author Administrator
 *
 */
public class TimeUtil {
	public static final String START_DAY = "startday";
	public static final String END_DAY = "endday";


    public final static String FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    public final static String[] REPLACE_STRING = new String[]{"GMT+0800", "GMT+08:00"};

    public final static String SPLIT_STRING = "(中国标准时间)";

    public static Date str2Date(String dateString) {
        try {
            dateString = dateString.split(Pattern.quote(SPLIT_STRING))[0].replace(REPLACE_STRING[0], REPLACE_STRING[1]);
            SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Date date = sf1.parse(dateString);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("时间转化格式错误" + "[dateString=" + dateString + "]" + "[FORMAT_STRING=" + FORMAT_STRING + "]");
        }
    }

	
	public static String getNowTime() {
		  Date d = new Date();
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		  sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		  return sdf.format(d);
	}
	
	public static void setStartTimeAndEndTime(Map<String, String> map) {
		if (StringUtils.isEmpty(map.get(START_DAY)) && StringUtils.isEmpty(map.get(END_DAY)) ) {
			map.put(START_DAY, TimeUtil.getNowTime());
			map.put(END_DAY, TimeUtil.getNowTime());
		} else if (StringUtils.isEmpty(map.get(END_DAY))) {
			map.put(END_DAY, map.get(START_DAY));
		} else if (StringUtils.isEmpty(map.get(START_DAY))){
			map.put(START_DAY, map.get(END_DAY));
		}
	}
	
}
