package cn.jucheng.www.hulisiwei.interfaca;

import java.util.ArrayList;

/**
 * Created by zyn on 2018/1/14.
 */

public class MessageEventblzg {
    private  int type ;
    private ArrayList al;

    public MessageEventblzg(int mtype,ArrayList mal){

        type = mtype;
        al =mal;
    }

    public int getType() {
        return type;
    }

    public ArrayList getAl() {
        return al;
    }
}
