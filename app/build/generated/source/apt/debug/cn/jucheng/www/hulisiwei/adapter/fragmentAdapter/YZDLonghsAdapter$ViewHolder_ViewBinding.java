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

public class YZDLonghsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private YZDLonghsAdapter.ViewHolder target;

  @UiThread
  public YZDLonghsAdapter$ViewHolder_ViewBinding(YZDLonghsAdapter.ViewHolder target, View source) {
    this.target = target;

    target.fvHssign = Utils.findRequiredViewAsType(source, R.id.fv_hssign, "field 'fvHssign'", FitHeightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    YZDLonghsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fvHssign = null;
  }
}
