package cn.jucheng.www.hulisiwei.databean.blnrbean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zyn on 2017/12/11.
 */

public class twdlistbean {
    private HashMap<Integer,Integer> twsz;
    private HashMap<Integer,Integer> mbsz;
    private List<String> other;


    public HashMap<Integer, Integer> getTwsz() {
        return twsz;
    }

    public void setTwsz(HashMap<Integer, Integer> twsz) {
        this.twsz = twsz;
    }

    public HashMap<Integer, Integer> getMbsz() {
        return mbsz;
    }

    public void setMbsz(HashMap<Integer, Integer> mbsz) {
        this.mbsz = mbsz;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }
}
