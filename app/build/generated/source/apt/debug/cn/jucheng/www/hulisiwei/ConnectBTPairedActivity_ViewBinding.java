// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConnectBTPairedActivity_ViewBinding implements Unbinder {
  private ConnectBTPairedActivity target;

  private View view2131099653;

  @UiThread
  public ConnectBTPairedActivity_ViewBinding(ConnectBTPairedActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConnectBTPairedActivity_ViewBinding(final ConnectBTPairedActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.back_already_bluetooth, "method 'onViewClicked'");
    view2131099653 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131099653.setOnClickListener(null);
    view2131099653 = null;
  }
}
