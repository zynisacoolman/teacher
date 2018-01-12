/**
 * Copyright 2018 bejson.com
 */
package cn.jucheng.www.hulisiwei.databean.blzgbean.medicine;

import java.util.List;

/**
 * Auto-generated: 2018-01-09 14:42:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Medicines {

    private int common_dispose_way;
    private int dose_unit;
    private float dose_value;
    private int effectivetime;
    private int isemergency;
    private int medicine_id;
    private String medicine_name;
    private String medicine_note;
    private int cteg_id;
    private String cteg_name;
    private List<Medicines> medicines;
    public void setCteg_id(int cteg_id) {
        this.cteg_id = cteg_id;
    }
    public int getCteg_id() {
        return cteg_id;
    }
    public void setCteg_name(String cteg_name) {
        this.cteg_name = cteg_name;
    }
    public String getCteg_name() {
        return cteg_name;
    }
    public void setMedicines(List<Medicines> medicines) {
        this.medicines = medicines;
    }
    public List<Medicines> getMedicines() {
        return medicines;
    }
    public void setCommon_dispose_way(int common_dispose_way) {
        this.common_dispose_way = common_dispose_way;
    }
    public int getCommon_dispose_way() {
        return common_dispose_way;
    }

    public void setDose_unit(int dose_unit) {
        this.dose_unit = dose_unit;
    }
    public int getDose_unit() {
        return dose_unit;
    }

    public void setDose_value(float dose_value) {
        this.dose_value = dose_value;
    }
    public float getDose_value() {
        return dose_value;
    }

    public void setEffectivetime(int effectivetime) {
        this.effectivetime = effectivetime;
    }
    public int getEffectivetime() {
        return effectivetime;
    }

    public void setIsemergency(int isemergency) {
        this.isemergency = isemergency;
    }
    public int getIsemergency() {
        return isemergency;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }
    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }
    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_note(String medicine_note) {
        this.medicine_note = medicine_note;
    }
    public String getMedicine_note() {
        return medicine_note;
    }

}