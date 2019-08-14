package com.autocode.code.common;

/**
 * @author : shenhao
 * @date : 2019/8/9 13:55
 */
public class StringUtils {

    /**
     * 驼峰命名转换为数据库表对应命名
     * SysUser -> sys_user  ,   userName -> user_name
     */
    public static String changeToSqlStyle(String string){
        if(string.isEmpty()) return string;
        for (int i = 1; i < string.length(); i++) {
            if(Character.isUpperCase(string.charAt(i))){
                String s = string.charAt(i)+"";
                string = string.replace(s,"_"+s);
                i ++ ;
            }
        }
        return string.toLowerCase();
    }

    /**
     * 首字母大写，方便使用get，set方法
     * userName -> UserName
     */
    public static String firstCharUpper(String string){
        if(string.isEmpty()) return string;
        return string.substring(0,1).toUpperCase()+string.substring(1);
    }

}
