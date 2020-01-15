package com.example.test.demo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.regex.Pattern;

public class MobileUtil {

    /**
     * 正则表达式：验证手机号
     */
    private static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0-3,5-9])|(17[0-9]))\\d{8}$";


    /**
     * 判断是否是手机号格式,如果传入的是空串，返回false
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        if(StringUtils.isBlank(mobile)){
            return false;
        }

        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 获取今日的剩余时间，单位是秒
     * @return
     */
    public static Integer getTodaySurplusTime(){
        Calendar c = Calendar.getInstance();
        long now = c.getTimeInMillis();
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long millis = c.getTimeInMillis() - now+2000;

        return (int)(millis/1000);
    }

}
