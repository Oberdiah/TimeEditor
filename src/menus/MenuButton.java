package menus;

public class MenuButton extends Button {
	private static final long serialVersionUID = -5674551293600099873L;
	public String subText;
	public String text;
	public Boolean showSubText = false;
	public Boolean leavePosAlone = false;
	
	public MenuButton(String s, String ss) {
		super(0, 0, 0, 0);
		subText = ss;
		text = s;
	}
	
	public MenuButton subtext(Boolean b) {
		showSubText = b;
		return this;
	}
}
