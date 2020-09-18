package exercisecoding;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * 通用toString方法
 * @author: wangxu
 * @date: 2020/8/28 14:23
 */
public class ToString {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
        ToString toString = new ToString();
        System.out.println(toString.toString(integers));
    }
    private ArrayList<Object> visited = new ArrayList<>();
    public String toString(Object obj){
        if(obj == null) return "null";
        if(visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        if(cl == String.class) return (String) obj;
        if (cl.isArray()) {
            //返回表示数组组件类型的 Class。如果此类不表示数组类，则此方法返回null
            //也就是返回你数组里面装的数据的数据类型的类名称。这里也就是Integer
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if(i > 0) r += ",";
                Object val = Array.get(obj, i);
                //java.lang.Class.isPrimitive() 确定指定的Class对象表示一个基本类型。
                // 有九种预定义的Class对象代表的八个基本类型和void。这些都是由Java虚拟机创建的，
                // 并且具有相同的名称，它们代表即boolean, byte, char, short, int, long, float, 和double 等原始类型。
                if(cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }
        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;
    }

    private static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
