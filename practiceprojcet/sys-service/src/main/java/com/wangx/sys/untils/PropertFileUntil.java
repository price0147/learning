package com.wangx.sys.untils;

import java.util.ResourceBundle;

/**
 * @author: wangxu
 * @date: 2020/3/24 10:00
 */
public class PropertFileUntil {

    private static PropertFileUntil propertFileUntil;

    private ResourceBundle resourcebundle;

    private PropertFileUntil() {}

    /**
     * 单例模式
     * @return
     */
    public static PropertFileUntil getPropertFileUntil(){
        if (propertFileUntil == null) {
            propertFileUntil = new PropertFileUntil();
        }
        return propertFileUntil;

    }

    /**
     * 方法说明:获取配置文件
     */
    public String getString(String fileName,String key) {
        this.resourcebundle = ResourceBundle.getBundle(fileName);
        return resourcebundle.getString(key);
    }

}
