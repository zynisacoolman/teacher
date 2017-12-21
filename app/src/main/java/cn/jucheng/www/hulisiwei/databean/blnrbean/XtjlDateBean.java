package cn.jucheng.www.hulisiwei.databean.blnrbean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyn on 2017/12/21.
 */

public class XtjlDateBean {
    private String date="";
    ArrayList<String> list = new ArrayList<String>(){
        {
            add("");
            add("");
        }
    };
    private List<List<String>> data=new ArrayList<List<String>>(){
        {
            add(list);
            add(list);
            add(list);
            add(list);
            add(list);
            add(list);
            add(list);
            add(list);
        }
    };


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<List<String>> getData() {
        return data;
    }

}
