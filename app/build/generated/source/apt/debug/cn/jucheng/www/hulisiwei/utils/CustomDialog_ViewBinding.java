// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.utils;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomDialog_ViewBinding implements Unbinder {
  private CustomDialog target;

  private View view2131230816;

  private View view2131231209;

  @UiThread
  public CustomDialog_ViewBinding(CustomDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CustomDialog_ViewBinding(final CustomDialog target, View source) {
    this.target = target;

    View view;
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", FitHeightTextView.class);
    target.nowTime = Utils.findRequiredViewAsType(source, R.id.now_time, "field 'nowTime'", FitHeightTextView.class);
    target.yourTime = Utils.findRequiredViewAsType(source, R.id.your_time, "field 'yourTime'", FitHeightTextView.class);
    view = Utils.findRequiredView(source, R.id.cancel, "field 'cancel' and method 'onViewClicked'");
    target.cancel = Utils.castView(view, R.id.cancel, "field 'cancel'", FitHeightTextView.class);
    view2131230816 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.submit, "field 'submit' and method 'onViewClicked'");
    target.submit = Utils.castView(view, R.id.submit, "field 'submit'", FitHeightTextView.class);
    view2131231209 = view;
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
    CustomDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.nowTime = null;
    target.yourTime = null;
    target.cancel = null;
    target.submit = null;

    view2131230816.setOnClickListener(null);
    view2131230816 = null;
    view2131231209.setOnClickListener(null);
    view2131231209 = null;
  }
}
