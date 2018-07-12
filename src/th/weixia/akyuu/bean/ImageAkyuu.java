package th.weixia.akyuu.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Image类
 *
 */
public class ImageAkyuu implements Parcelable{

	private String imgId;
	private String imgThumbnailPath;
	private String imgDataPath;
	private boolean selected;
	
	
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public String getImgThumbnailPath() {
		return imgThumbnailPath;
	}
	public void setImgThumbnailPath(String imgThumbnailPath) {
		this.imgThumbnailPath = imgThumbnailPath;
	}
	public String getImgDataPath() {
		return imgDataPath;
	}
	public void setImgDataPath(String imgDataPath) {
		this.imgDataPath = imgDataPath;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(getImgId());
		dest.writeString(getImgThumbnailPath());
		dest.writeString(getImgDataPath());
		dest.writeByte((byte) (isSelected()? 1:0));
	}
	
	
	
}
