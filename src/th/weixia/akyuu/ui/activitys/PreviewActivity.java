package th.weixia.akyuu.ui.activitys;

import android.content.Context;
import android.content.Intent;


/**
 *  预览
 *
 */
public class PreviewActivity extends BaseActivity {

	public static void startThis(Context context){
		Intent intent = new Intent();
		intent.setClass(context, PreviewActivity.class);
		context.startActivity(intent);
	}
	
	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		
	}


}
