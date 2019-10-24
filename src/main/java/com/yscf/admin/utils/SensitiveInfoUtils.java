package com.yscf.admin.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * 脱敏工具类
 */
public class SensitiveInfoUtils {

    /**
     * [中文姓名] 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
     *
     * @param name
     * @return
     */
    public static String chineseName(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * [身份证号] 显示最后四位，其他隐藏。共计18位或者15位。<例子：4457*********5762>
     *
     * @param id
     * @return
     */
    public static String idCardNum(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        String left = StringUtils.left(id, 4);
        String right = StringUtils.right(id, 4);
        return  left + "********"+right;
    }

    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138******1234>
     *
     * @param num
     * @return
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    /**
     * [银行卡号] 前四位，后四位，其他用星号隐藏每位1个星号<例子:62226**********1234>
     *
     * @param cardNum
     * @return
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 4).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }
    
    /**
     * 
     *
     * @param cardNum
     * @return
     */
    public static String autoSensitive(String name,Integer num) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        String countStars="";
        for(int i=0;i<num;i++) {
        	countStars+="*";
        }
        return StringUtils.left(name, 1).concat(countStars);
    }

    /**
     * 
     *
     * @param cardNum
     * @return
     */
    public static String autoSensitive(String name,Integer leftSensitive,Integer num) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        String countStars="";
        for(int i=0;i<num;i++) {
        	countStars+="*";
        }
        return StringUtils.left(name, leftSensitive).concat(countStars);
    }
    
    
    /**
     * 
     *
     * @param cardNum
     * @return
     */
    public static String autoSensitive(String name,Integer leftSensitive,Integer rightSensitive,Integer num) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        String countStars="";
        for(int i=0;i<num;i++) {
        	countStars+="*";
        }
        return StringUtils.left(name, leftSensitive).concat(countStars).concat(StringUtils.right(name, rightSensitive));
    }
    
    public static void main(String[] args) {
    	String licence="粤YL38383";
    	System.out.println(autoSensitive(licence,2,2,3));
	}
    
}
