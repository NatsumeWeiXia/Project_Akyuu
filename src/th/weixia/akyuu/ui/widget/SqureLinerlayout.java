package th.weixia.akyuu.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * 方形 Layout 
 *
 */
public class SqureLinerlayout extends RelativeLayout {
		
	public SqureLinerlayout(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
	}

	public SqureLinerlayout(Context context, AttributeSet attrs) {
	    super(context, attrs);
	}

	public SqureLinerlayout(Context context) {
	    super(context);
	}
	    
	    @Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	    setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        // Children are just made to fill our space.
        int childWidthSize = getMeasuredWidth();
        //高度和宽度一�?
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
