// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BlzgActivity_ViewBinding implements Unbinder {
  private BlzgActivity target;

  @UiThread
  public BlzgActivity_ViewBinding(BlzgActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BlzgActivity_ViewBinding(BlzgActivity target, View source) {
    this.target = target;

    target.tv_close = Utils.findRequiredViewAsType(source, R.id.tv_close, "field 'tv_close'", FitHeightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BlzgActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_close = null;
  }
}
