// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.widget.ExpandableListView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class BllbActivity_ViewBinding<T extends BllbActivity> implements Unbinder {
  protected T target;

  public BllbActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.expandableListView = finder.findRequiredViewAsType(source, R.id.el_bllb, "field 'expandableListView'", ExpandableListView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.expandableListView = null;

    this.target = null;
  }
}
