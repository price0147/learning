package com.wangx.sys.untils;

import java.util.ResourceBundle;

/**
 * @author: wangxu
 * @date: 2020/3/24 10:00
 */
public class PropertFileUntil {
    private ResourceBundle resourcebundle;

    /**
     * todo:这个位置暂时可以用但是后期要换成单利模式(具体原因我还不太清楚)具体要学习完设计模式的吧.
     * todo:好像还涉及到打开多个资源文件.我们现在不考虑这些东西.
     * 方法说明:获取配置文件
     */
    public PropertFileUntil(String fileName) {
        this.resourcebundle = ResourceBundle.getBundle(fileName);
    }

    public String getString(String key) {
        return resourcebundle.getString(key);
    }


}
