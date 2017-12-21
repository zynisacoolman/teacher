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

  private View view2131230827;

  private View view2131231018;

  private View view2131230828;

  private View view2131230829;

  private View view2131230830;

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
    view2131230827 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.serach_connent_bluetooh, "method 'onViewClicked'");
    view2131231018 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_network, "method 'onViewClicked'");
    view2131230828 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_usb, "method 'onViewClicked'");
    view2131230829 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.connent_usb_cong, "method 'onViewClicked'");
    view2131230830 = view;
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
    view2131230827.setOnClickListener(null);
    view2131230827 = null;
    view2131231018.setOnClickListener(null);
    view2131231018 = null;
    view2131230828.setOnClickListener(null);
    view2131230828 = null;
    view2131230829.setOnClickListener(null);
    view2131230829 = null;
    view2131230830.setOnClickListener(null);
    view2131230830 = null;
  }
}
