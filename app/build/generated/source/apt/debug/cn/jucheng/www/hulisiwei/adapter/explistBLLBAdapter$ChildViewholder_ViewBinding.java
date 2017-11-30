// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class explistBLLBAdapter$ChildViewholder_ViewBinding implements Unbinder {
  private explistBLLBAdapter.ChildViewholder target;

  @UiThread
  public explistBLLBAdapter$ChildViewholder_ViewBinding(explistBLLBAdapter.ChildViewholder target,
      View source) {
    this.target = target;

    target.fhtvBllbItem = Utils.findRequiredViewAsType(source, R.id.fhtv_bllb_item, "field 'fhtvBllbItem'", FitHeightTextView.class);
    target.llItemBllb = Utils.findRequiredViewAsType(source, R.id.ll_item_bllb, "field 'llItemBllb'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    explistBLLBAdapter.ChildViewholder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fhtvBllbItem = null;
    target.llItemBllb = null;
  }
}
