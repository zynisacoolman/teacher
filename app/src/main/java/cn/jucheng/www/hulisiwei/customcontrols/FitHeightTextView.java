package cn.jucheng.www.hulisiwei.customcontrols;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;
import cn.jucheng.www.hulisiwei.R;

/**
 * Created by akitaka on 2017/9/20.
 *
 * @filename FitHeightTextView
 * @describe 根据高度自适应字体文字大小
 * @email 960576866@qq.com
 */

@SuppressLint("AppCompatCustomView")
public class FitHeightTextView extends TextView {
	private Paint mTextPaint;
	private float mMaxTextSize; // 获取当前所设置文字大小作为最大文字大小
	private float mMinTextSize = 8; // 最小的字体大小
	private int attr2;
	AssetManager mgr=getContext().getAssets();
	Typeface tf=Typeface.createFromAsset(mgr, "fonts/msyh.ttf");

	public FitHeightTextView(Context context) {
		super(context);
	}

	public FitHeightTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		getAttrs(context, attrs);
		setGravity(getGravity() | Gravity.CENTER_VERTICAL); // 默认水平居中
		setLines(1);
		setTypeface(tf);
		initialise();
	}

	private void initialise() {
		mTextPaint = new TextPaint();
		mTextPaint.set(this.getPaint());
		// 默认的大小是设置的大小，如果撑不下了 就改变
		mMaxTextSize = this.getTextSize();
	}

	// 文字改变的时候
	@Override
	protected void onTextChanged(CharSequence text, int start,
			int lengthBefore, int lengthAfter) {
		refitText(text.toString(), this.getHeight()); // textview视图的高度
		super.onTextChanged(text, start, lengthBefore, lengthAfter);
	}

	private void refitText(String textString, int height) {
		if (height > 0) {
			int availableHeight = height - this.getPaddingTop()
					- this.getPaddingBottom(); // 减去边距为字体的实际高度
			float trySize = mMaxTextSize;
			mTextPaint.setTextSize(trySize);
			while (mTextPaint.descent() - mTextPaint.ascent() > availableHeight) { // 测量的字体高度过大，不断地缩放
				trySize -= 1; // 字体不断地减小来适应
				if (trySize <= mMinTextSize) {
					trySize = mMinTextSize; // 最小为这个
					break;
				}
				mTextPaint.setTextSize(trySize);
			}
			setTextSize(px2sp(getContext(), (int) (trySize * (1 - 0.1 * attr2))));
		}
	}

	// 大小改变的时候
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		if (h != oldh) {
			refitText(this.getText().toString(), h);
		}
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 */
	public static float px2sp(Context context, float pxValue) {
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (pxValue / fontScale);
	}

	/**
	 * 得到属性值
	 * 
	 * @param context
	 * @param attrs
	 */
	private void getAttrs(Context context, AttributeSet attrs) {
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.myViewDefinedAttr);
		attr2 = ta.getInt(R.styleable.myViewDefinedAttr_attr2, 0);
		ta.recycle();
	}
}
