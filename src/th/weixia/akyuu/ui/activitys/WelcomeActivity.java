package th.weixia.akyuu.ui.activitys;

import java.util.Timer;
import java.util.TimerTask;

import android.view.View;
import android.widget.ImageView;
import th.weixia.akyuu.R;

/**
 * 迎客用求妹
 *
 */
public class WelcomeActivity extends BaseActivity {
	
	private ImageView ivWelcome;
	
	@Override
	protected void initData() {
		// TODO Auto-generated method stub		
	}
	
	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_welcome);
		ivWelcome = (ImageView) findViewById(R.id.iv_welcome);
		ivWelcome.setOnClickListener(this);
	}

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				SelecterActivity.startThis(WelcomeActivity.this);
			}
			
		};
		timer.schedule(task, 1500);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		SelecterActivity.startThis(WelcomeActivity.this);
	}
}
