/**
  * Copyright 2018 bejson.com 
  */
package cn.jucheng.www.hulisiwei.databean.blzgbean.phyexam;
import java.util.List;

/**
 * Auto-generated: 2018-01-08 22:33:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Physical {

    private String name;
    private int partid;
    private List<Item> item;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setPartid(int partid) {
         this.partid = partid;
     }
     public int getPartid() {
         return partid;
     }

    public void setItem(List<Item> item) {
         this.item = item;
     }
     public List<Item> getItem() {
         return item;
     }

}