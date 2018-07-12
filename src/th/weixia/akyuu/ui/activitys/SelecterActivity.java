package th.weixia.akyuu.ui.activitys;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import th.weixia.akyuu.R;
import th.weixia.akyuu.bean.Person;
import th.weixia.akyuu.ui.adapter.MGridAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.GridView;

/**
 *  选择/查看
 *
 */
public class SelecterActivity extends BaseActivity {
	
	private GridView gridView;	
//	private ProgressDialog mProgressDialog;
//	private Point size;
//	private int mDetailWidth;
	private List<Person> mHeroes;
	private List<String> mHeroNames;
	private List<String> mIconNames;
	private static final String heroFileName = "json/heroes.json";

	public static void startThis(Context context){
		Intent intent = new Intent();
		intent.setClass(context, SelecterActivity.class);
		context.startActivity(intent);
	}
	
	@Override
	protected void initData() {
		// TODO Auto-generated method stub	
		try {
			InputStream in = getResources().getAssets().open(heroFileName);
			int lenght = in.available();
			byte[]  buffer = new byte[lenght];
			in.read(buffer);
			String json = new String(buffer);
			mHeroes = new ArrayList<Person>();
			mHeroes = Person.getPersons(new JSONArray(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mHeroNames = new ArrayList<String>();
		mIconNames = new ArrayList<String>();
		for(Person hero:mHeroes){
			mHeroNames.add(hero.getHeroName());
			mIconNames.add(hero.getIconName());
		}
	
//		WindowManager wm = this.getWindowManager();
//		size = new Point();
//	    wm.getDefaultDisplay().getSize(size);
//	    mDetailWidth = (int) (0.55 * size.x);
	}
	
	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_selecter);
		gridView = (GridView) findViewById(R.id.gv_selecter);
		gridView.setAdapter(new MGridAdapter(this, mIconNames, mHeroNames));
		
		SlidingMenu mSlidingMenu = new SlidingMenu(this);
		mSlidingMenu.setMode(SlidingMenu.LEFT);
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  
		mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);  
		mSlidingMenu.setShadowDrawable(R.drawable.shadow);  
		mSlidingMenu.setBehindOffsetRes(R.dimen.leftslidingmenu_offset);  
		mSlidingMenu.setFadeDegree(0.35f);   
		mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);  
		mSlidingMenu.setMenu(R.layout.left_slidemenu); 
	}

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			PreviewActivity.startThis(this);
	}
	
}
