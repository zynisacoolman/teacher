// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ItemZtzgAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ItemZtzgAdapter.ViewHolder target;

  @UiThread
  public ItemZtzgAdapter$ViewHolder_ViewBinding(ItemZtzgAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvOrder = Utils.findRequiredViewAsType(source, R.id.tv_order, "field 'tvOrder'", TextView.class);
    target.llYizhu = Utils.findRequiredViewAsType(source, R.id.ll_yizhu, "field 'llYizhu'", LinearLayout.class);
    target.llChukou1 = Utils.findRequiredViewAsType(source, R.id.ll_chukou1, "field 'llChukou1'", LinearLayout.class);
    target.llChukou2 = Utils.findRequiredViewAsType(source, R.id.ll_chukou2, "field 'llChukou2'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ItemZtzgAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvOrder = null;
    target.llYizhu = null;
    target.llChukou1 = null;
    target.llChukou2 = null;
  }
}
