/**
  * Copyright 2017 bejson.com 
  */
package cn.jucheng.www.hulisiwei.databean.bllbbean;

import android.util.ArrayMap;

import java.util.List;
import java.util.Map;

import cn.jucheng.www.hulisiwei.module.UserMessage;

/**
 * Auto-generated: 2017-12-02 23:7:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Statesinfo {

    private List<States> states;
    public void setStates(List<States> states) {
         this.states = states;
     }
     public List<States> getStates() {
         return states;
     }
     public void 初始化状态转归Map(){
         for (States states:states) {
             UserMessage.searchmapStatetransfer.put(states.getId(),states.getStates_transfer());
         }
     }
     public void 初始化状态名称Map(){
         for (States states:states) {
             UserMessage.searchmapStatename.put(states.getId(),states.getName());
         }
     }
    public void 初始化状态参数map(){
         for(States states:states){
             Map<Integer,Numbervalue> map = new ArrayMap<>();
             if(states.getPhysical_examination_info()!=null){
                 for(Physical_examination_info pei:states.getPhysical_examination_info()){
                     map.put(pei.getIndex_id(),pei.getNumbervalue());
                 }
                 UserMessage.searchExamResult.put(states.getId(),map);
             }
         }
    }


}