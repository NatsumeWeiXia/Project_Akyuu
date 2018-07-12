package th.weixia.akyuu.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Person 
{
	public static final HashMap<String, String> mLocateMap = new HashMap<String, String>();
	private List<Ability> abilities;
	private String mAttackType = "";
	private String mBackground;
	private String mCoin = "金币";
	private String mDiamon = "钻石";
	private String mLocate = "定位";
	private String pArmor;
	private String pAttack;
	private String pAttackSpeed;
	private String pCritical;
	private String pHealth;
	private String pMagic;
	private String pMagicResist;
	private String pMana;
	private String pMoveSpeed;
	private String pRange;
	private int sAttack;
	private int sDifficult;
	private int sHealth;
	private int sMagic;
	private int sTeam;
	private String mName;
	private String mKey;
	@SuppressWarnings("unused")
	private Object mPortraitURL;

	static {
		mLocateMap.put("ad", "物理");
		mLocateMap.put("ap", "法系");
		mLocateMap.put("tank", "防御 ");
		mLocateMap.put("supp", "辅助");
		mLocateMap.put("1", "远程");
		mLocateMap.put("0", "近战");
	}

	public Person(JSONObject paramJSONObject) {
		this.mName = paramJSONObject.optString("name");
		this.mKey = paramJSONObject.optString("key");
		this.mLocate = paramJSONObject.optString("locate");
		this.mAttackType = paramJSONObject.optString("attack");
	}

	public static List<Person> getPersons(JSONArray paramJSONArray) {
		if ((paramJSONArray != null) && (paramJSONArray.length() > 0)){
			List<Person> localVector = new ArrayList<Person>();
			for (int i = 0; i < paramJSONArray.length(); i++) {
				Person localPerson = new Person(paramJSONArray.optJSONObject(i));
				localVector.add(localPerson);
			}
			return localVector;
		}
		return null;
	}

	public void decode(JSONObject paramJSONObject) {
		this.abilities = Ability.decode(
				paramJSONObject.optJSONArray("abilities"), this.mKey);
		this.pAttack = paramJSONObject.optString("attack");
		this.pHealth = paramJSONObject.optString("health");
		this.pMana = paramJSONObject.optString("mana");
		this.pMagic = paramJSONObject.optString("magic");
		this.pArmor = paramJSONObject.optString("armor");
		this.pMagicResist = paramJSONObject.optString("magic_resist");
		this.pCritical = paramJSONObject.optString("critical");
		this.pAttackSpeed = paramJSONObject.optString("attack_speed");
		this.pRange = paramJSONObject.optString("range");
		this.pMoveSpeed = paramJSONObject.optString("move_speed");
		this.sAttack = paramJSONObject.optInt("s_attack");
		this.sMagic = paramJSONObject.optInt("s_magic");
		this.sDifficult = paramJSONObject.optInt("s_difficult");
		this.sTeam = paramJSONObject.optInt("s_team");
		this.sHealth = paramJSONObject.optInt("s_health");
		this.mBackground = paramJSONObject.optString("background");
		this.mCoin = paramJSONObject.optString("coin");
		this.mDiamon = paramJSONObject.optString("diamond");
		this.mPortraitURL = paramJSONObject.optString("portait");
	}

	private String getStatsTxt(String paramString1, String paramString2)
	{
		return paramString1 + " : " + "<font color=\"#1f688a\">" + 
				paramString2 + "</font>";
	}
	
	public String getHeroData(){
		StringBuffer localStringBuffer = new StringBuffer();
		localStringBuffer.append("<br>")
			.append(getStatsTxt("移动速度", pMoveSpeed)).append("<br>")
			.append(getStatsTxt("攻击距离", pRange)).append("<br>")
			.append(getStatsTxt("攻击力　", pAttack)).append("<br>")
			.append(getStatsTxt("法术强度", pMagic)).append("<br>")
			.append(getStatsTxt("攻击速度", pAttackSpeed)).append("<br>")
			.append(getStatsTxt("护甲　　", pArmor)).append("<br>")
			.append(getStatsTxt("生命值　", pHealth)).append("<br>")
			.append(getStatsTxt("法术抗性", pMagicResist)).append("<br>")
			.append(getStatsTxt("法力值　", pMana)).append("<br>")
			.append(getStatsTxt("暴击", pCritical));
		return localStringBuffer.toString();
	}
	  
	public String getIconName(){
		return "hero_" + this.mKey + ".jpg";
	}

	public String getHeroName(){
		return mName;
	}
	
	public int[] getHeroGrade(){
		int[] grade = {sHealth, sAttack, sMagic, sTeam, sDifficult};	
		return grade;
	}
	
	public String getHeroInfo(){
		StringBuffer localStringBuffer = new StringBuffer();
		localStringBuffer.append("<font color=\"#1f688a\">")
			.append(mLocate).append(mAttackType).append("</font><br>")
			.append("<small><small><font color=\"#1f688a\">")
			.append("金币:").append(mCoin).append(" 钻石:").append(mDiamon)
			.append("</font></small></small>");
		return localStringBuffer.toString();
	}
	
	public String getHeroBackground(){
		return mBackground;
	}
	
	public List<Ability> getHeroAbilities(){
		return abilities;
	}
}