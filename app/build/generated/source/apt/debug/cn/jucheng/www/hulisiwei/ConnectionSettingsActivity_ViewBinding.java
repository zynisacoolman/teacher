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

public class ConnectionSettingsActivity_ViewBinding implements Unbinder {
  private ConnectionSettingsActivity target;

  private View view2131099652;

  private View view2131099824;

  private View view2131100076;

  private View view2131099825;

  private View view2131099826;

  private View view2131099827;

  @UiThread
  public ConnectionSettingsActivity_ViewBinding(ConnectionSettingsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConnectionSettingsActivity_ViewBinding(final ConnectionSettingsActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.back, "method 'onViewClicked'");
    view2131099652 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_already_buletooh, "method 'onViewClicked'");
    view2131099824 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.serach_connent_bluetooh, "method 'onViewClicked'");
    view2131100076 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_network, "method 'onViewClicked'");
    view2131099825 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_usb, "method 'onViewClicked'");
    view2131099826 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_usb_cong, "method 'onViewClicked'");
    view2131099827 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131099652.setOnClickListener(null);
    view2131099652 = null;
    view2131099824.setOnClickListener(null);
    view2131099824 = null;
    view2131100076.setOnClickListener(null);
    view2131100076 = null;
    view2131099825.setOnClickListener(null);
    view2131099825 = null;
    view2131099826.setOnClickListener(null);
    view2131099826 = null;
    view2131099827.setOnClickListener(null);
    view2131099827 = null;
  }
}
