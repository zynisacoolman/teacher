package cn.jucheng.www.hulisiwei.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.jucheng.jclibs.tools.SubStringUtils;


/**
 * 工具类
 */
public class CommUtils {

    /**
     * 获取版本号
     *
     * @param c
     * @return
     */
    public static String getVersion(Context c) {
        String versionName = "";// 版本号
        try {
            PackageManager pm = c.getPackageManager();
            PackageInfo pi = pm.getPackageInfo("cn.jucheng.www.hulisiwei", 0);
            versionName = pi.versionName;// 获取在AndroidManifest.xml中配置的版本号
        } catch (Exception e) {
            versionName = "";
            e.printStackTrace();
        }
        return versionName;
    }


    /**
     * 解析json数据
     *
     * @param message
     */
    public static List<String> getJson(String message, String key) {
        Map<String, Object> map1 = JSON.parseObject(message, new TypeReference<Map<String, Object>>() {
        });
        List<String> list1 = (List<String>) map1.get(key);
        return list1;
    }
    /**
     * 解析坐标数据
     */
    public static ArrayList[] getDatamap(String str){
        int h0,h1,l0,l1;
        ArrayList[] al=new ArrayList[2];
        al[0]=new ArrayList<Integer>();
        al[1]=new ArrayList<Integer>();
        int count=str.length()/8;//坐标数量
        for(int i=0;i<count;i++){
            h0=Integer.parseInt(SubStringUtils.substring(str,
                            0, 2), 16);
            h1=Integer.parseInt(SubStringUtils.substring(str,
                            2, 4), 16);
            h0=Integer.parseInt(h0+h1+"");
            al[0].add(h0);
            l0=Integer.parseInt(SubStringUtils.substring(str,
                    4, 6), 16);
            l1=Integer.parseInt(SubStringUtils.substring(str,6
                    , 8), 16);
            l0=Integer.parseInt(l0+l1+"");
            al[1].add(l0);

        }
        return al;

    }
    /**
     * 获取list数组某一项内容
     *
     * @param list
     * @param index
     * @return
     */
    public static String getListString(List<String> list, int index) {
        String mesage = "";
        if (list != null && list.size() > 0) {
            if (index < list.size()) {
                if (list.get(index) != null) {
                    mesage = list.get(index);
                } else {
                    mesage = "";
                }
            }
        }
        return mesage;
    }

    /**
     * list转实体类
     * 不要有多余的属性,要不就会出问题了
     * 此list对应是按照下标来对应的 顺序也不能错
     * @param list
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T getBean(List<String> list, T t) {
        Object obj = null;
        try {
            // 拿到该类
            Class<?> clz = t.getClass();
            // 获取实体类的所有属性，返回Field数组
            Field[] fields = clz.getDeclaredFields();
            obj = clz.newInstance();
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                Field field = fields[i];
                // 拿到该属性的settet方法
                Method m = (Method) obj.getClass().getMethod(
                        "set" + getMethodName(field.getName()), String.class);
                m.invoke(obj, s);// 调用setter方法获取属性值
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }

    // 把一个字符串的第一个字母大写、效率是最高的、
    private static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    /**
     * 分页加载
     * @param page
     * @param rows
     * @return
     */
    public static List<List<String>> getDataList(List<List<String>> list, int page, int rows) {
        int size = list.size();
        int fromIndex = (page - 1) * rows;
        int toIndex = fromIndex + rows;

        fromIndex = fromIndex >= size ? size : fromIndex;
        toIndex = toIndex >= size ? size : toIndex;

        return list.subList(fromIndex, toIndex);
    }


}
