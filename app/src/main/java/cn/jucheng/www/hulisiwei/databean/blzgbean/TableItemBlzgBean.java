package cn.jucheng.www.hulisiwei.databean.blzgbean;

import java.util.ArrayList;

/**
 * Created by zyn on 2018/1/11.
 */

public class TableItemBlzgBean {
    private ArrayList<String> 遗嘱内容;
    private ArrayList<Exitdispose> 出口状态概率;

    public ArrayList<String> get遗嘱内容() {
        return 遗嘱内容;
    }

    public void set遗嘱内容(ArrayList<String> 遗嘱内容) {
        this.遗嘱内容 = 遗嘱内容;
    }

    public ArrayList<Exitdispose> get出口状态概率() {
        return 出口状态概率;
    }

    public void set出口状态概率(ArrayList<Exitdispose> 出口状态概率) {
        this.出口状态概率 = 出口状态概率;
    }

    public static class Exitdispose{
        private String 出口状态;
        private int 出口概率;

        public String get出口状态() {
            return 出口状态;
        }

        public void set出口状态(String 出口状态) {
            this.出口状态 = 出口状态;
        }

        public int get出口概率() {
            return 出口概率;
        }

        public void set出口概率(int 出口概率) {
            this.出口概率 = 出口概率;
        }
    }
}
