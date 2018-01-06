/**
  * Copyright 2018 bejson.com 
  */
package cn.jucheng.www.hulisiwei.databean.blzgbean;
import java.util.List;

/**
 * Auto-generated: 2018-01-03 20:42:14
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlzgBean {

    private int lineType;
    private List<BlzgItemBean> datas;
    private int startId;
    public void setLineType(int lineType) {
         this.lineType = lineType;
     }
     public int getLineType() {
         return lineType;
     }

    public void setDatas(List<BlzgItemBean> datas) {
         this.datas = datas;
     }
     public List<BlzgItemBean> getDatas() {
         return datas;
     }

    public void setStartId(int startId) {
         this.startId = startId;
     }
     public int getStartId() {
         return startId;
     }

}