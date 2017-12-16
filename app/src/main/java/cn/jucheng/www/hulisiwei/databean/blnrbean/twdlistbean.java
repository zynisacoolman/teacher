package cn.jucheng.www.hulisiwei.databean.blnrbean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyn on 2017/12/11.
 */

public class twdlistbean {
    private ArrayList<Integer>[] twsz;
    private ArrayList<Integer>[] mbsz;
    private List<String> other;


    public ArrayList<Integer>[] getTwsz() {
        return twsz;
    }

    public void setTwsz(ArrayList<Integer>[] twsz) {
        this.twsz = twsz;
    }

    public ArrayList<Integer>[] getMbsz() {
        return mbsz;
    }

    public void setMbsz(ArrayList<Integer>[] mbsz) {
        this.mbsz = mbsz;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }
}
