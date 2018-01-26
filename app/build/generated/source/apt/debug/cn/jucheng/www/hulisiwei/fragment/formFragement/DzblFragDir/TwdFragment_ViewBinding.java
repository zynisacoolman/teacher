// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TwdFragment_ViewBinding implements Unbinder {
  private TwdFragment target;

  @UiThread
  public TwdFragment_ViewBinding(TwdFragment target, View source) {
    this.target = target;

    target.v1 = Utils.findRequiredView(source, R.id.v_1, "field 'v1'");
    target.hName = Utils.findRequiredViewAsType(source, R.id.h_name, "field 'hName'", TextView.class);
    target.hSex = Utils.findRequiredViewAsType(source, R.id.h_sex, "field 'hSex'", TextView.class);
    target.hAge = Utils.findRequiredViewAsType(source, R.id.h_age, "field 'hAge'", TextView.class);
    target.hDivision = Utils.findRequiredViewAsType(source, R.id.h_division, "field 'hDivision'", TextView.class);
    target.hBednumber = Utils.findRequiredViewAsType(source, R.id.h_bednumber, "field 'hBednumber'", TextView.class);
    target.hIllrecordNum = Utils.findRequiredViewAsType(source, R.id.h_illrecordNum, "field 'hIllrecordNum'", TextView.class);
    target.v2 = Utils.findRequiredView(source, R.id.v_2, "field 'v2'");
    target.hRyrq = Utils.findRequiredViewAsType(source, R.id.h_ryrq, "field 'hRyrq'", TextView.class);
    target.hZyblh = Utils.findRequiredViewAsType(source, R.id.h_zyblh, "field 'hZyblh'", TextView.class);
    target.ll1 = Utils.findRequiredViewAsType(source, R.id.ll_1, "field 'll1'", LinearLayout.class);
    target.v3 = Utils.findRequiredView(source, R.id.v_3, "field 'v3'");
    target.gvTwdRyrq = Utils.findRequiredViewAsType(source, R.id.gv_twd_ryrq, "field 'gvTwdRyrq'", GridView.class);
    target.gvTwdZydays = Utils.findRequiredViewAsType(source, R.id.gv_twd_zydays, "field 'gvTwdZydays'", GridView.class);
    target.gvTwdSshdays = Utils.findRequiredViewAsType(source, R.id.gv_twd_sshdays, "field 'gvTwdSshdays'", GridView.class);
    target.gvTwdHxcs1 = Utils.findRequiredViewAsType(source, R.id.gv_twd_hxcs1, "field 'gvTwdHxcs1'", GridView.class);
    target.gvTwdHxcs2 = Utils.findRequiredViewAsType(source, R.id.gv_twd_hxcs2, "field 'gvTwdHxcs2'", GridView.class);
    target.gvTwdXueya = Utils.findRequiredViewAsType(source, R.id.gv_twd_xueya, "field 'gvTwdXueya'", GridView.class);
    target.gvTwdRuliang = Utils.findRequiredViewAsType(source, R.id.gv_twd_ruliang, "field 'gvTwdRuliang'", GridView.class);
    target.gvTwdChuliang = Utils.findRequiredViewAsType(source, R.id.gv_twd_chuliang, "field 'gvTwdChuliang'", GridView.class);
    target.gvTwdDabian = Utils.findRequiredViewAsType(source, R.id.gv_twd_dabian, "field 'gvTwdDabian'", GridView.class);
    target.gvTwdTizhong = Utils.findRequiredViewAsType(source, R.id.gv_twd_tizhong, "field 'gvTwdTizhong'", GridView.class);
    target.gvTwdShengao = Utils.findRequiredViewAsType(source, R.id.gv_twd_shengao, "field 'gvTwdShengao'", GridView.class);
    target.ll2 = Utils.findRequiredViewAsType(source, R.id.ll_2, "field 'll2'", LinearLayout.class);
    target.rlTwd = Utils.findRequiredViewAsType(source, R.id.rl_twd_, "field 'rlTwd'", RelativeLayout.class);
    target.llTwd = Utils.findRequiredViewAsType(source, R.id.ll_twd, "field 'llTwd'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TwdFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.v1 = null;
    target.hName = null;
    target.hSex = null;
    target.hAge = null;
    target.hDivision = null;
    target.hBednumber = null;
    target.hIllrecordNum = null;
    target.v2 = null;
    target.hRyrq = null;
    target.hZyblh = null;
    target.ll1 = null;
    target.v3 = null;
    target.gvTwdRyrq = null;
    target.gvTwdZydays = null;
    target.gvTwdSshdays = null;
    target.gvTwdHxcs1 = null;
    target.gvTwdHxcs2 = null;
    target.gvTwdXueya = null;
    target.gvTwdRuliang = null;
    target.gvTwdChuliang = null;
    target.gvTwdDabian = null;
    target.gvTwdTizhong = null;
    target.gvTwdShengao = null;
    target.ll2 = null;
    target.rlTwd = null;
    target.llTwd = null;
  }
}
