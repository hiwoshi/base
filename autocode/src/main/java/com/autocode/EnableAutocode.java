package com.autocode;

import com.autocode.base.WriteFile;
import com.autocode.common.Common;
import com.autocode.common.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author : shenhao
 * @date : 2019/8/7 11:02
 * 默认的文件为
 * service.TetsService.java;
 * service.impl.TestServiceImpl;
 * entity.entity.TestPO;
 * dao.TestDao;
 * controller.TestController;
 */
public class EnableAutocode {

    /**
     * 建表的主语句
     * @param map {columns=[],className=""}
     * @throws IOException
     * @throws TemplateException
     */
    public static void enableAutocode(Map map) throws IOException, TemplateException {
        //map 添加用户名，时间，package
        map.put("author", Common.getUserName());
        map.put("date", LocalDateTime.now().toString());
        map.put("package",Common.getPackage());
        map.put("classNameLower", StringUtils.changeToSqlStyle(map.get("className").toString()));

        Configuration configuration = new Configuration(Configuration.getVersion());
        // 指定configuration对象模板文件存放的路径
        configuration.setClassForTemplateLoading(EnableAutocode.class,"/tpl");
        // 设置config的默认字符集，一般是UTF-8
        configuration.setDefaultEncoding("UTF-8");
        // 设置错误控制器
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        //创建文件
        writeFile(map,configuration);
    }

    public static void writeFile(Map map, Configuration configuration) throws IOException, TemplateException {
        WriteFile.writePO(map,configuration);
        WriteFile.writeDao(map,configuration);
        WriteFile.writeService(map,configuration);
        WriteFile.writeServiceImpl(map,configuration);
        WriteFile.writeController(map,configuration);
    }

    private static String ClassNameToTableName(String className){
        String str = className;
        for (int i = 1; i < className.length(); i++) {
            if(Character.isUpperCase(className.charAt(i))){
                String s = className.charAt(i)+"";
                str = str.replace(s,"_"+s);
            }
        }
        if(str.startsWith("_")) str = str.substring(1);
        return str.toLowerCase();
    }

}
