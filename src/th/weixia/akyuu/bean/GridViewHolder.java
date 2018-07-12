package th.weixia.akyuu.bean;

import th.weixia.akyuu.R;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ViewHolder
 *
 */
public class GridViewHolder {
	public View mView;
	public ImageView ivItemIcom;
	public TextView tvItemName;
	
	public GridViewHolder(Context context){
		
		mView = View.inflate(context, R.layout.grid_item, null);
		ivItemIcom = (ImageView) mView.findViewById(R.id.iv_item_icon);
		tvItemName = (TextView) mView.findViewById(R.id.tv_item_name);
		mView.setTag(this);
	}
}
