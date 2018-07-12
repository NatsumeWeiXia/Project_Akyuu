package th.weixia.akyuu.ui.adapter;

import java.util.List;

import th.weixia.akyuu.ui.widget.MatrixImageView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * PagerAdapter
 *
 */
public class MatrixImagePagerAdapter extends PagerAdapter {

private List<MatrixImageView> mData;
	
	public MatrixImagePagerAdapter(List<MatrixImageView> data) {
		mData = data;
	}

	@Override
	public int getCount() {
		return mData.size();
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(mData.get(position));
		return mData.get(position);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

}
