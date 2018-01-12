/**
  * Copyright 2018 bejson.com 
  */
package cn.jucheng.www.hulisiwei.databean.blzgbean.medicine;

import java.util.HashMap;
import java.util.List;

import cn.jucheng.www.hulisiwei.module.UserMessage;


/**
 * Auto-generated: 2018-01-08 22:28:59
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Juchengesp {
    private List<Medicines> medicines;
    public void setMedicines(List<Medicines> medicines) {
        this.medicines = medicines;
    }
    public List<Medicines> getMedicines() {
        return medicines;
    }
    public void initGetAllMedicines() {
        UserMessage.allMedicines = new HashMap<Integer, Medicines>();
        // 得到所有药物,放入map
        if (medicines != null) {
            for (Medicines m : medicines) {
                if (m != null && m.getMedicines() != null) {
                    for (Medicines m1 : m.getMedicines()) {
                        UserMessage.allMedicines.put(m1.getMedicine_id(), m1);
                        if (m1 != null && m1.getMedicines() != null) {
                            for (Medicines m2 : m1.getMedicines()) {
                                UserMessage.allMedicines.put(m2.getMedicine_id(), m2);
                            }
                        }
                    }
                }
            }
        }
    }


}