// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightButton;
import cn.jucheng.www.hulisiwei.customcontrols.FitWidthTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity_ViewBinding implements Unbinder {
  private AboutActivity target;

  private View view2131230742;

  private View view2131230721;

  @UiThread
  public AboutActivity_ViewBinding(AboutActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AboutActivity_ViewBinding(final AboutActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.back, "field 'back' and method 'onViewClicked'");
    target.back = Utils.castView(view, R.id.back, "field 'back'", FitWidthTextView.class);
    view2131230742 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.aboutVerson = Utils.findRequiredViewAsType(source, R.id.about_verson, "field 'aboutVerson'", FitWidthTextView.class);
    view = Utils.findRequiredView(source, R.id.about_ok, "field 'aboutOk' and method 'onViewClicked'");
    target.aboutOk = Utils.castView(view, R.id.about_ok, "field 'aboutOk'", FitHeightButton.class);
    view2131230721 = view;
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
    AboutActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.back = null;
    target.aboutVerson = null;
    target.aboutOk = null;

    view2131230742.setOnClickListener(null);
    view2131230742 = null;
    view2131230721.setOnClickListener(null);
    view2131230721 = null;
  }
}
