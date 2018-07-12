package th.weixia.akyuu.ui.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import th.weixia.akyuu.bean.GridViewHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Adapter
 *
 */
public class MGridAdapter extends BaseAdapter {
	
	private Context mContext;
	private List<String> mFiles;
	private List<String> mNames;
	private GridViewHolder viewCashe = null;

	public MGridAdapter(Context context, List<String> Files, List<String> Names) {
		// TODO Auto-generated constructor stub
		mContext = context;
		mFiles = Files;
		mNames = Names;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mNames.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			viewCashe = new GridViewHolder(mContext);
		}else{
			viewCashe = (GridViewHolder) convertView.getTag();
		}
		try {
			InputStream in = mContext.getAssets().open("img/" + mFiles.get(position));
			Bitmap bitmap = BitmapFactory.decodeStream(in); 
			viewCashe.ivItemIcom.setImageBitmap(bitmap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewCashe.tvItemName.setText(mNames.get(position));		
		return viewCashe.mView;
	}

}
