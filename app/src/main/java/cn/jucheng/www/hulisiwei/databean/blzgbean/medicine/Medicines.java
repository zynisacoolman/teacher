/**
  * Copyright 2018 bejson.com 
  */
package cn.jucheng.www.hulisiwei.databean.blzgbean.medicine;
import java.util.List;

/**
 * Auto-generated: 2018-01-08 22:28:59
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Medicines {

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

}