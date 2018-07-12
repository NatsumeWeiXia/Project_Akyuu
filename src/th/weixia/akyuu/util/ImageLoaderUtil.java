package th.weixia.akyuu.util;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * com.nostra13.universalimageloader 图片加载工具
 * ImageLoader帮助
 * String imageUri = "http://site.com/image.png"; // from Web  
 * String imageUri = "file://+路径"; // from SD card  
 * String imageUri = "content://media/external/audio/albumart/13"; // from content provider  
 * String imageUri = "assets://image.png"; // from assets  
 * String imageUri = "drawable://" + R.drawable.image; // from drawables (only images, non-9patch)
 */
public class ImageLoaderUtil {
	private static ImageLoaderUtil sInstance;
	private ImageLoader mImageLoader;
	private DisplayImageOptions mOptions;
	
	private ImageLoaderUtil() {
		mImageLoader = ImageLoader.getInstance();
		mOptions = new DisplayImageOptions.Builder()  
//        .showImageOnLoading(R.drawable.grid_item_pictures_no)//设置图片在下载期间显示的图片  
//        .showImageForEmptyUri(R.drawable.grid_item_pictures_no)//设置图片Uri为空或是错误的时候显示的图片  
//        .showImageOnFail(R.drawable.grid_item_pictures_no)//设置图片加载/解码过程中错误时候显示的图片
        .cacheInMemory(true)//设置下载的图片是否缓存在内存�?  
        .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡中  
        .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转�?
        .imageScaleType(ImageScaleType.IN_SAMPLE_INT)//设置图片以如何的编码方式显示  
        .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类�?
        //.decodingOptions(BitmapFactory.Options decodingOptions)//设置图片的解码配�?  
        .delayBeforeLoading(0)//int delayInMillis为你设置的下载前的延迟时�?
        //.preProcessor(BitmapProcessor preProcessor)//设置图片加入缓存前，对bitmap进行设置
        .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复�?  
        //.displayer(new RoundedBitmapDisplayer(20))//不推荐用！！！！是否设置为圆角，弧度为多�?  
        .displayer(new FadeInBitmapDisplayer(200))//是否图片加载好后渐入的动画时间，可能会出现闪�?
        .build();//构建完成
	}
	
	public static ImageLoaderUtil getInstance() {
		if (sInstance == null) {
			sInstance = new ImageLoaderUtil();
		}
		return sInstance;
	}
	
	public ImageLoader getImageLoader() {
		return mImageLoader;
	}
	
	public DisplayImageOptions getImageOptions() {
		return mOptions;
	}
	
}
