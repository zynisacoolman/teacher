// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConnectIPActivity_ViewBinding implements Unbinder {
  private ConnectIPActivity target;

  private View view2131230745;

  private View view2131230811;

  @UiThread
  public ConnectIPActivity_ViewBinding(ConnectIPActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConnectIPActivity_ViewBinding(final ConnectIPActivity target, View source) {
    this.target = target;

    View view;
    target.inputIp = Utils.findRequiredViewAsType(source, R.id.editTextInputIp, "field 'inputIp'", FitHeightEditText.class);
    target.inputPort = Utils.findRequiredViewAsType(source, R.id.editTextInputPort, "field 'inputPort'", FitHeightEditText.class);
    target.relativeLayout1 = Utils.findRequiredViewAsType(source, R.id.relativeLayout1, "field 'relativeLayout1'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.back_network, "method 'onViewClicked'");
    view2131230745 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.buttonConnectIP, "method 'onViewClicked'");
    view2131230811 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ConnectIPActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.inputIp = null;
    target.inputPort = null;
    target.relativeLayout1 = null;

    view2131230745.setOnClickListener(null);
    view2131230745 = null;
    view2131230811.setOnClickListener(null);
    view2131230811 = null;
  }
}
