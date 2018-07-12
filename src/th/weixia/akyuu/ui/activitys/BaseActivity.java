package th.weixia.akyuu.ui.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * BaseActivity
 *
 */
public abstract class BaseActivity extends Activity implements OnClickListener{

	protected Intent intentIn;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		intentIn = getIntent();
		initData();
		initLayout();
		initEvents();
	}	
	
	protected abstract void initData();
	
	protected abstract void initLayout();
	
	protected abstract void initEvents();

}
