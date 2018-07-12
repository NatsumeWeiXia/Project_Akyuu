package th.weixia.akyuu.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 由子控件决定是否可以进行左右滑动
 * 目前和MatrixImageView一起使用，偷懒就直接 public static 了
 * 
 */
public class ScrollControledViewPager extends ViewPager {

	public static boolean ableToTAB = true;
	
	public ScrollControledViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
		return ableToTAB? super.onInterceptTouchEvent(arg0):false;
	}

}
