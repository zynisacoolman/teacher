package cn.jucheng.www.hulisiwei.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;


/**
 * 自定义ListView
 */
public class MyList extends ListView {

    public MyList(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }
    /**
     * Integer.MAX_VALUE >> 2,
     * MeasureSpec.AT_MOST的意思就是wrap_content
     * Integer.MAX_VALUE >> 2 是使用最大值的意思,也就表示的无边界模式
     * Integer.MAX_VALUE >> 2 此处表示是福布局能够给他提供的大小
     */
//    @Override
//    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
//                MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, expandSpec);
//
//    }

    public MyList(Context context) {
        this(context, null);
    }


}
