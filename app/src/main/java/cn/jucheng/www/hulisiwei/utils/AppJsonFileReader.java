package cn.jucheng.www.hulisiwei.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import cn.jucheng.www.hulisiwei.module.Medicines;
import cn.jucheng.www.hulisiwei.module.UserMessage;

/**
 * Created by w on 2017-11-29.
 */

public class AppJsonFileReader {

    /**
     * 读取本地json文件
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String readLocalJson(Context context, String fileName) {
        String json = "";
        try {

            AssetManager s = context.getAssets();
            try {
                InputStream is = s.open(fileName);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                json = new String(buffer, "utf-8");
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 解析药物信息
     *
     * @param medicines
     * @param map
     */
    public static void createData(List<Medicines> medicines, Map<String, Object> map) {
        for (Medicines medicine : medicines) {
            List<Medicines> medicines2 = medicine.getMedicines();
            if (medicines2 == null) {
                map.put(medicine.getMedicine_id(), medicine.getMedicine_name());
            } else {
                createData(medicines2, map);
            }
        }
    }

    /**
     * 解析药物信息
     *
     * @param id
     * @return
     */
    public static String getDrugData(String id) {
        String drug_Name = "";
        //遍历是否有此id，并且取出药物名字
        if (UserMessage.drug_Message_Map.size() > 0) {
            if (UserMessage.drug_Message_Map.get(id) != null) {
                drug_Name = (String) UserMessage.drug_Message_Map.get(id);
            }
        }
        return drug_Name;
    }

}
