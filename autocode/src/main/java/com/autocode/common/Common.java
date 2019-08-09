package com.autocode.common;

/**
 * @author : shenhao
 * @date : 2019/8/7 10:20
 */
public class Common {

    private static String userName = System.getProperty("user.name");

    /**
     * 这个是运行项目路径，在哪个项目下跑的，获取的就是哪个项目
     */
    private static String projectDir = System.getProperty("user.dir").replace("\\","/");

    private static String javaFile = "/src/main/java";

    private static String baseFile = "/com/demo";

    public static String getSimpleOutFile(){
        return projectDir+javaFile+baseFile;
    }

    public static String getPackage(){
        String str = baseFile.replace("/",".");
        if(str.startsWith(".")) str = str.substring(1);
        if(str.endsWith(".")) str = str.substring(0,str.length()-1);
        return str;
    }

    public static void setJavaFile(String javaFile) {
        Common.javaFile = javaFile;
    }

    public static void setBaseFile(String baseFile) {
        Common.baseFile = baseFile;
    }

    public static String getUserName() {
        return userName;
    }

}
