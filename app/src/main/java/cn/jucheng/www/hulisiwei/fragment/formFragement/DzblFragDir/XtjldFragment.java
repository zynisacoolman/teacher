package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.BlxqActivity;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.adapter.fragmentAdapter.XTJLDFragmentAdapter;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.base.MyList;
import cn.jucheng.www.hulisiwei.databean.blnrbean.XtjlDateBean;
import cn.jucheng.www.hulisiwei.interfaca.OnformDateUpdate;
import cn.jucheng.www.hulisiwei.interfaca.OnformHeadUpdate;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;

/**
 * Created by zyn on 2017/12/16.
 * 临时医嘱单
 */

public class XtjldFragment extends BaseFragment implements OnformDateUpdate,OnformHeadUpdate,AbsListView.OnScrollListener {
    protected final  String  TAG="XtjldFragment";
    @BindView(R.id.fragment_fitlist)
    MyList xtjld;

    Unbinder unbinder;
    private View view;

    /**
     * 数据源
     */
    XTJLDFragmentAdapter adapter;

    int pages=1;


    @Override
    public int getID() {
        return R.id.fragment_fitlist;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_fitlist, null);
        getPage();
        adapter=new XTJLDFragmentAdapter(getActivity(),pages);
        xtjld.setAdapter(adapter);
        return view;
    }

    /**
     * 计算页数
     */
    public void getPage() {
        int a = UserMessage.XTJLD.size() / 18;
        if (UserMessage.XTJLD.size() > 18) {
            pages = pages + a;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        String number = (firstVisibleItem+1)+"/" + pages;
        BlxqActivity.setPageNumber(number);
    }

    @Override
    public void OnformDateUpdate(String string) {
        int lenth = Integer.parseInt(SubStringUtils.substring(string, 48, 52), 16);//有效位长度
        int formtype = Integer.parseInt(SubStringUtils.substring(string, 52, 54), 16);//表单类型
        int page = Integer.parseInt(SubStringUtils.substring(string, 54, 58), 16);//页面号
        int line = Integer.parseInt(SubStringUtils.substring(string, 58, 62), 16);//行号
        int colnum = Integer.parseInt(SubStringUtils.substring(string, 62, 66), 16);//列号
        String json = SubStringUtils.substring(string, 66, 52 + lenth * 2);
        List<String> specialList = CommUtils.getJson(json, "xuetangjiludan");
        //记录血糖
        if (formtype == 7) {
            //如果血糖记录总数多于 传来的数据
            int num =(page-1)*18+line;
            if (UserMessage.XTJLD.size() >= num) {
                //将血糖记录替换为接受到的值，我初始化链表为空
                UserMessage.XTJLD.get(num).getData().set(colnum - 1, specialList.subList(1, 3));
                Log.d("血糖记录数据", "HandlerMessage:"+string);
                //如果日期没有赋值
                if(UserMessage.XTJLD.get(num).getDate().equals("")){
                    UserMessage.XTJLD.get(num).setDate(specialList.get(0));
                }else{
                    if(UserMessage.XTJLD.get(num).getDate().equals(specialList.get(0))){
                        Log.e(TAG, "HandlerMessage: 发生错误,日期冲突");
                    }
                }
            }else {
                XtjlDateBean xtjlDateBean=new XtjlDateBean();
                xtjlDateBean.getData().set(colnum-1,specialList.subList(1,3));
                xtjlDateBean.setDate(specialList.get(0));
                UserMessage.XTJLD.add(xtjlDateBean);
            }
        }
    }

    @Override
    public void OnformHeadUpdate(String string) {
        int bdt = Integer.parseInt(SubStringUtils.substring(string, 48, 52), 16);
        String jsont = HexadecimalConver.decode(
                SubStringUtils.substring(string, 52, 52 + bdt * 2));

        UserMessage.fragmentHead = CommUtils.getJson(jsont, "baseinfo");
        adapter.notifyDataSetChanged();
    }
}
