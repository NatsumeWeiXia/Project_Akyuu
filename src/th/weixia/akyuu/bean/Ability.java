package th.weixia.akyuu.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Ability {
	private String mCooldown;
	private String mCost;
	private String mEffect;
	private String mHotkey;
	private String mName;
	private String mKey;

	public Ability(JSONObject paramJSONObject) {
		this.mName = paramJSONObject.optString("name");
		this.mEffect = paramJSONObject.optString("effect").replace("法术伤害",
				"魔法伤害");
		this.mHotkey = paramJSONObject.optString("hotkey");
		this.mCooldown = paramJSONObject.optString("cooldown");
		this.mCost = paramJSONObject.optString("cost");
	}

	public static List<Ability> decode(JSONArray paramJSONArray,
			String paramString) {
		List<Ability> localVector = new ArrayList<Ability>();
		for (int i = 0;; i++) {
			if (i >= paramJSONArray.length())
				return localVector;
			Ability localAbility = new Ability(paramJSONArray.optJSONObject(i));
			localAbility.mKey = (paramString + "_" + i);
			localVector.add(localAbility);
		}
	}

	public String getIconName() {
		return "ability_" + mKey + ".jpg";
	}

	public String getShowName() {
		return this.mHotkey + " " + mName;
	}	
	
	public String getCooldownAndCostText(){
		if (this.mCooldown.length() == 0) {
			return "冷却:N/A" + "<br>" + "消耗:N/A";
		}
		return "冷却:" + mCooldown + "<br>" + "消耗:" + mCost;
	}

	public String getEffect(){
		return mEffect;
	}
}