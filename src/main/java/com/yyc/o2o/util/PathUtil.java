package com.yyc.o2o.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:Cc
 * @Date: 2020/01/31/21:56
 */
@Configuration
public class PathUtil {
    //获取系统文件分隔符
    public static String seperator=System.getProperty("file.separator");
    private static String winPath;
    private static String linuxPath;
    private static String shopPath;
    @Value("${win.base.path}")
    public  void setWinPath(String winPath) {
        PathUtil.winPath = winPath;
    }
    @Value("${linux.base.path}")
    public  void setLinuxPath(String linuxPath) {
        linuxPath = linuxPath;
    }
    @Value("${shop.relevant.path}")
    public  void setShopPath(String shopPath) {
        PathUtil.shopPath = shopPath;
    }


    //basePath路径处理(返回图片根路径)
    public static String getImgBasePath(){
    //获取系统名称
        String os=System.getProperty("os.name");
        String basePath="";
    if(os.toLowerCase().startsWith("win")){
        //windows系统路径
        basePath=winPath;
    }else {
        //其他系统路径
        basePath=linuxPath;
    }
        //将分隔符替换成该系统的分隔符
        basePath=basePath.replace("/",seperator);
        return basePath;
    }

    /**
     *返回项目图片子路径
     * 获取店铺图片存储路径
     *一个店铺一个路径（用shopId区分）
     */
    public static String getShopImagePath(long shopId){
        String imagePath=shopPath+shopId+seperator;
        return imagePath.replace("/",seperator);
    }
}
