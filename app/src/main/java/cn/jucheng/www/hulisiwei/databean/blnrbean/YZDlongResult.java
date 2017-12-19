package cn.jucheng.www.hulisiwei.databean.blnrbean;

import java.util.List;

/**
 * Created by zyn on 2017/12/18.
 */

public class YZDlongResult {
    private List<JryzdBean> jryzList;
    private List<tzyzdBean> tzyzList;

    public List<JryzdBean> getJryzList() {
        return jryzList;
    }

    public void setJryzList(List<JryzdBean> jryzList) {
        this.jryzList = jryzList;
    }

    public List<tzyzdBean> getTzyzList() {
        return tzyzList;
    }

    public void setTzyzList(List<tzyzdBean> tzyzList) {
        this.tzyzList = tzyzList;
    }

    public static class JryzdBean {
        private int page;
        private int lines;
        private String date;
        private String time;
        private String yizhu;
        private String yishiqianzi;
        private String hushiqianzi;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLines() {
            return lines;
        }

        public void setLines(int lines) {
            this.lines = lines;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getYizhu() {
            return yizhu;
        }

        public void setYizhu(String yizhu) {
            this.yizhu = yizhu;
        }

        public String getYishiqianzi() {
            return yishiqianzi;
        }

        public void setYishiqianzi(String yishiqianzi) {
            this.yishiqianzi = yishiqianzi;
        }

        public String getHushiqianzi() {
            return hushiqianzi;
        }

        public void setHushiqianzi(String hushiqianzi) {
            this.hushiqianzi = hushiqianzi;
        }
    }
    public static class tzyzdBean {
        private int page;
        private int lines;
        private String date;
        private String time;
        private String yishiqianzi;
        private String hushiqianzi;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLines() {
            return lines;
        }

        public void setLines(int lines) {
            this.lines = lines;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }


        public String getYishiqianzi() {
            return yishiqianzi;
        }

        public void setYishiqianzi(String yishiqianzi) {
            this.yishiqianzi = yishiqianzi;
        }

        public String getHushiqianzi() {
            return hushiqianzi;
        }

        public void setHushiqianzi(String hushiqianzi) {
            this.hushiqianzi = hushiqianzi;
        }
    }

}
