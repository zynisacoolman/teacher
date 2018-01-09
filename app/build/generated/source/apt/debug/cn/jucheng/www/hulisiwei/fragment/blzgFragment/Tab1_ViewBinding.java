// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import com.wjk.tableview.TableView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Tab1_ViewBinding implements Unbinder {
  private Tabztzg target;

  @UiThread
  public Tab1_ViewBinding(Tabztzg target, View source) {
    this.target = target;

    target.tableView = Utils.findRequiredViewAsType(source, R.id.table_layout, "field 'tableView'", TableView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Tabztzg target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tableView = null;
  }
}
