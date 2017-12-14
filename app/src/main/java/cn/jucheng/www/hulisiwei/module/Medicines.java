package cn.jucheng.www.hulisiwei.module;

import java.util.List;


/**
 * 药物信息
 */
public class Medicines {

	private String cteg_id;
	private String cteg_name;

	private String common_dispose_way;
	private String dose_unit;
	private String dose_value;
	private String effectivetime;
	private String isemergency;
	private String medicine_id;
	private String medicine_name;
	private String medicine_note;

	private List<Medicines> medicines;

	public String getCteg_id() {
		return cteg_id;
	}

	public void setCteg_id(String cteg_id) {
		this.cteg_id = cteg_id;
	}

	public String getCteg_name() {
		return cteg_name;
	}

	public void setCteg_name(String cteg_name) {
		this.cteg_name = cteg_name;
	}

	public String getCommon_dispose_way() {
		return common_dispose_way;
	}

	public void setCommon_dispose_way(String common_dispose_way) {
		this.common_dispose_way = common_dispose_way;
	}

	public String getDose_unit() {
		return dose_unit;
	}

	public void setDose_unit(String dose_unit) {
		this.dose_unit = dose_unit;
	}

	public String getDose_value() {
		return dose_value;
	}

	public void setDose_value(String dose_value) {
		this.dose_value = dose_value;
	}

	public String getEffectivetime() {
		return effectivetime;
	}

	public void setEffectivetime(String effectivetime) {
		this.effectivetime = effectivetime;
	}

	public String getIsemergency() {
		return isemergency;
	}

	public void setIsemergency(String isemergency) {
		this.isemergency = isemergency;
	}

	public String getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(String medicine_id) {
		this.medicine_id = medicine_id;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public String getMedicine_note() {
		return medicine_note;
	}

	public void setMedicine_note(String medicine_note) {
		this.medicine_note = medicine_note;
	}

	public List<Medicines> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicines> medicines) {
		this.medicines = medicines;
	}

}