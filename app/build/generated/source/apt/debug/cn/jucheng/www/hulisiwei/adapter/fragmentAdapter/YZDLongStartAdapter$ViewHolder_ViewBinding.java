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

public class YZDLongStartAdapter$ViewHolder_ViewBinding implements Unbinder {
  private YZDLongStartAdapter.ViewHolder target;

  @UiThread
  public YZDLongStartAdapter$ViewHolder_ViewBinding(YZDLongStartAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.fvData = Utils.findRequiredViewAsType(source, R.id.fv_data, "field 'fvData'", FitHeightTextView.class);
    target.fvTime = Utils.findRequiredViewAsType(source, R.id.fv_time, "field 'fvTime'", FitHeightTextView.class);
    target.fvYz = Utils.findRequiredViewAsType(source, R.id.fv_yz, "field 'fvYz'", FitHeightTextView.class);
    target.fvYsqm = Utils.findRequiredViewAsType(source, R.id.fv_tsign, "field 'fvYsqm'", FitHeightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    YZDLongStartAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fvData = null;
    target.fvTime = null;
    target.fvYz = null;
    target.fvYsqm = null;
  }
}
