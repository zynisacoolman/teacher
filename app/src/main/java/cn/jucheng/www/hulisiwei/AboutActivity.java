package cn.jucheng.www.hulisiwei;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightButton;
import cn.jucheng.www.hulisiwei.customcontrols.FitWidthTextView;
import cn.jucheng.www.hulisiwei.utils.CommUtils;

/**
 * Created by w on 2017-11-23.
 * 关于页面
 */

public class AboutActivity extends MyBaseActivity {

    /**
     * 返回
     */
    @BindView(R.id.back)
    FitWidthTextView back;
    /**
     * 版本号
     */
    @BindView(R.id.about_verson)
    FitWidthTextView aboutVerson;
    /**
     * 确定
     */
    @BindView(R.id.about_ok)
    FitHeightButton aboutOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        initData();
    }

    public void initData(){
        aboutVerson.setText("版本号："+ CommUtils.getVersion(this));
    }

    @Override
    protected void HandlerMessage(Message msg) {

    }

    @Override
    public void exc() {

    }

    @OnClick({R.id.back, R.id.about_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.about_ok:
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
