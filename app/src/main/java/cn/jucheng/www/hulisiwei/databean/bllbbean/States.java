/**
  * Copyright 2017 bejson.com 
  */
package cn.jucheng.www.hulisiwei.databean.bllbbean;
import java.util.List;

/**
 * Auto-generated: 2017-12-02 23:7:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class States {

    private int InheritStatus;
    private List<Assistant_examination_info> assistant_examination_info;
    private int default_state;
    private String description;
    private int id;
    private String name;
    private List<Integer> need_assexam;
    private List<Physical_examination_info> physical_examination_info;
    private int state_waitingtime;
    private List<Changqiyizhu> changqiyizhu;
    private List<linshiyizhu> linshiyizhu;
    private List<States_transfer> states_transfer;
    public void setInheritStatus(int InheritStatus) {
         this.InheritStatus = InheritStatus;
     }
     public int getInheritStatus() {
         return InheritStatus;
     }

    public void setAssistant_examination_info(List<Assistant_examination_info> assistant_examination_info) {
         this.assistant_examination_info = assistant_examination_info;
     }
     public List<Assistant_examination_info> getAssistant_examination_info() {
         return assistant_examination_info;
     }

    public void setDefault_state(int default_state) {
         this.default_state = default_state;
     }
     public int getDefault_state() {
         return default_state;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setNeed_assexam(List<Integer> need_assexam) {
         this.need_assexam = need_assexam;
     }
     public List<Integer> getNeed_assexam() {
         return need_assexam;
     }

    public void setPhysical_examination_info(List<Physical_examination_info> physical_examination_info) {
         this.physical_examination_info = physical_examination_info;
     }
     public List<Physical_examination_info> getPhysical_examination_info() {
         return physical_examination_info;
     }

    public void setState_waitingtime(int state_waitingtime) {
         this.state_waitingtime = state_waitingtime;
     }
     public int getState_waitingtime() {
         return state_waitingtime;
     }

    public void setChangqiyizhu(List<Changqiyizhu> changqiyizhu) {
         this.changqiyizhu = changqiyizhu;
     }
     public List<Changqiyizhu> getChangqiyizhu() {
         return changqiyizhu;
     }

    public void setStates_transfer(List<States_transfer> states_transfer) {
         this.states_transfer = states_transfer;
     }
     public List<States_transfer> getStates_transfer() {
         return states_transfer;
     }

    public List<linshiyizhu> getLinshiyizhu() {
        return linshiyizhu;
    }

    public void setLinshiyizhu(List<linshiyizhu> linshiyizhu) {
        this.linshiyizhu = linshiyizhu;
    }

}