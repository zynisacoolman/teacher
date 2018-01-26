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

  private View view2131230742;

  private View view2131230920;

  private View view2131231225;

  private View view2131230921;

  private View view2131230922;

  private View view2131230923;

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
    view2131230742 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_already_buletooh, "method 'onViewClicked'");
    view2131230920 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.serach_connent_bluetooh, "method 'onViewClicked'");
    view2131231225 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_network, "method 'onViewClicked'");
    view2131230921 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_usb, "method 'onViewClicked'");
    view2131230922 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_usb_cong, "method 'onViewClicked'");
    view2131230923 = view;
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


    view2131230742.setOnClickListener(null);
    view2131230742 = null;
    view2131230920.setOnClickListener(null);
    view2131230920 = null;
    view2131231225.setOnClickListener(null);
    view2131231225 = null;
    view2131230921.setOnClickListener(null);
    view2131230921 = null;
    view2131230922.setOnClickListener(null);
    view2131230922 = null;
    view2131230923.setOnClickListener(null);
    view2131230923 = null;
  }
}
