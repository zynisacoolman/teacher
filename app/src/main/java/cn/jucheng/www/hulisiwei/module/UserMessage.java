package cn.jucheng.www.hulisiwei.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jucheng.www.hulisiwei.databean.blnrbean.twdlistbean;

/**
 * Created by w on 2017-11-29.
 * 表单信息
 */

public class UserMessage {

    //表头信息
    public static List<String> fragmentHead = new ArrayList<String>();
    public static String biaodan_message = "";//表单信息

    //注射单信息
    public static List<List<String>> inject_Message = new ArrayList<>();
    //治疗单信息
    public static List<List<String>> cure_Message = new ArrayList<>();
    //服药单信息
    public static List<List<String>> takemedicine_Message = new ArrayList<>();
    //输液信息
    public static List<List<String>> transfusion_Message = new ArrayList<>();
    //医嘱执行信息
    public static List<List<String>> medicalord_Message = new ArrayList<>();
    //输血观察记录信息
    public static List<List<String>> bloodrecord_Message = new ArrayList<>();
    //输液记录信息
    public static List<List<String>> transfusincord_Message = new ArrayList<>();
    //药物信息
    public static Map<String, Object> drug_Message_Map = new HashMap<>();
    //体温单信息
    public static twdlistbean twd_twdbean=new twdlistbean();
}