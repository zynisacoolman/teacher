// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchBTActivity_ViewBinding implements Unbinder {
  private SearchBTActivity target;

  private View view2131230744;

  private View view2131231187;

  @UiThread
  public SearchBTActivity_ViewBinding(SearchBTActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchBTActivity_ViewBinding(final SearchBTActivity target, View source) {
    this.target = target;

    View view;
    target.progressBarSearchStatus = Utils.findRequiredViewAsType(source, R.id.progressBar_SearchStatus, "field 'progressBarSearchStatus'", ProgressBar.class);
    target.linearlayoutdevices = Utils.findRequiredViewAsType(source, R.id.linearlayout_devices, "field 'linearlayoutdevices'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.back_bluetooth, "method 'onViewClicked'");
    view2131230744 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.serach_buton, "method 'onViewClicked'");
    view2131231187 = view;
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
    SearchBTActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.progressBarSearchStatus = null;
    target.linearlayoutdevices = null;

    view2131230744.setOnClickListener(null);
    view2131230744 = null;
    view2131231187.setOnClickListener(null);
    view2131231187 = null;
  }
}
