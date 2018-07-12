package th.weixia.akyuu.bean;

import org.json.JSONArray;
import org.json.JSONObject;

public class Item {
	private String[] mChildren;
	private String mInfo;
	private String[] mParents;
	private String mPrice;
	private String mPrice_total;
	private String mProp;
	private String mTypes;
	private String mName;
	private String mKey;

	public Item(JSONObject paramJSONObject) {
		this.mName = paramJSONObject.optString("name");
		this.mKey = paramJSONObject.optString("key");
		this.mTypes = paramJSONObject.optString("type");
		this.mChildren = jsonArryToString(paramJSONObject.optString("children"));
		this.mParents = jsonArryToString(paramJSONObject.optString("parents"));
		this.mInfo = paramJSONObject.optString("info");
		this.mProp = paramJSONObject.optString("prop");
		this.mPrice = paramJSONObject.optString("price");
		this.mPrice_total = paramJSONObject.optString("price_total");
	}

	public String getIconName() {
		return "item_" + this.mKey + ".jpg";
	}

	public String getJsonName() {
		return "item_" + this.mKey + ".json";
	}

	private String[] jsonArryToString(String paramString) {
		if (paramString != null) {
			String[] arrayOfString;
			int i;
			try {
				JSONArray localJSONArray = new JSONArray(paramString);
				if (localJSONArray != null) {
					i = localJSONArray.length();
					arrayOfString = new String[i];
					for (int j = 0; j < i; j++) {
						arrayOfString[j] = localJSONArray.optString(j);
					}
					return arrayOfString;
				}
			} catch (Exception localException) {
			}
		}
		return null;
	}

	public String getItemName() {
		return mName;
	}

	public String getPriceText() {
		return "总价:" + mPrice_total + " " + "合成价" + mPrice;
	}
}
