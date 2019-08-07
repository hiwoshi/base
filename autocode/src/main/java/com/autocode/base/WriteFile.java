package com.autocode.base;

import com.autocode.common.Common;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author : shenhao
 * @date : 2019/8/7 13:05
 */
public class WriteFile {

    public static void writePO(Map map, Configuration configuration) throws IOException, TemplateException {
        Template template = configuration.getTemplate("/entity/po/PO.ftl");
        String outFile = "/entity/po/"+map.get("className")+"PO.java";
        writeFil(map,outFile,template);
    }

    public static void writeDao(Map map, Configuration configuration) throws IOException, TemplateException {
        Template template = configuration.getTemplate("/dao/Dao.ftl");
        String outFile = "/dao/"+map.get("className")+"Dao.java";
        writeFil(map,outFile,template);
    }

    public static void writeService(Map map, Configuration configuration) throws IOException, TemplateException {
        Template template = configuration.getTemplate("/service/Service.ftl");
        String outFile = "/service/"+map.get("className")+"Service.java";
        writeFil(map,outFile,template);
    }

    public static void writeServiceImpl(Map map, Configuration configuration) throws IOException, TemplateException {
        Template template = configuration.getTemplate("/service/impl/ServiceImpl.ftl");
        String outFile = "/service/impl/"+map.get("className")+"ServiceImpl.java";
        writeFil(map,outFile,template);
    }

    public static void writeController(Map map, Configuration configuration) throws IOException, TemplateException {
        Template template = configuration.getTemplate("/controller/Controller.ftl");
        String outFile = "/controller/"+map.get("className")+"Controller.java";
        writeFil(map,outFile,template);
    }

    private static void writeFil(Map map, String outFile, Template template) throws IOException, TemplateException {
        File file = new File(Common.getSimpleOutFile() +outFile);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try(Writer writer = new FileWriter(new File(Common.getSimpleOutFile() + outFile)) ){
            template.process(map, writer);
        }
    }

}
