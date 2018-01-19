// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HLJL2itemAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HLJL2itemAdapter.ViewHolder target;

  @UiThread
  public HLJL2itemAdapter$ViewHolder_ViewBinding(HLJL2itemAdapter.ViewHolder target, View source) {
    this.target = target;

    target.ftRq = Utils.findRequiredViewAsType(source, R.id.ft_rq, "field 'ftRq'", FitHeightTextView.class);
    target.ftSj = Utils.findRequiredViewAsType(source, R.id.ft_sj, "field 'ftSj'", FitHeightTextView.class);
    target.ftTw = Utils.findRequiredViewAsType(source, R.id.ft_tw, "field 'ftTw'", FitHeightTextView.class);
    target.ftMb = Utils.findRequiredViewAsType(source, R.id.ft_mb, "field 'ftMb'", FitHeightTextView.class);
    target.ftHx = Utils.findRequiredViewAsType(source, R.id.ft_hx, "field 'ftHx'", FitHeightTextView.class);
    target.ftXy = Utils.findRequiredViewAsType(source, R.id.ft_xy, "field 'ftXy'", FitHeightTextView.class);
    target.ftXybhd = Utils.findRequiredViewAsType(source, R.id.ft_xybhd, "field 'ftXybhd'", FitHeightTextView.class);
    target.ftLeft = Utils.findRequiredViewAsType(source, R.id.ft_left, "field 'ftLeft'", FitHeightTextView.class);
    target.ftRight = Utils.findRequiredViewAsType(source, R.id.ft_right, "field 'ftRight'", FitHeightTextView.class);
    target.ftBqgc = Utils.findRequiredViewAsType(source, R.id.ft_bqgc, "field 'ftBqgc'", FitHeightTextView.class);
    target.ftSign = Utils.findRequiredViewAsType(source, R.id.ft_sign, "field 'ftSign'", FitHeightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HLJL2itemAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ftRq = null;
    target.ftSj = null;
    target.ftTw = null;
    target.ftMb = null;
    target.ftHx = null;
    target.ftXy = null;
    target.ftXybhd = null;
    target.ftLeft = null;
    target.ftRight = null;
    target.ftBqgc = null;
    target.ftSign = null;
  }
}
