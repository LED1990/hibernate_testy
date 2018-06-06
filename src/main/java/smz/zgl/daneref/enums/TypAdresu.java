package smz.zgl.daneref.enums;


/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:57:33
 */
public enum TypAdresu {
	POBYTU("P","adres miejsca pobytu"),
	ZAMIESZKANIA("Z", "adres miejsca zamieszkania"),
	ZAMELDOWANIA("M", "adres miejsca zameldowania");

	
	private final String code;
	private final String name;
	
	private TypAdresu(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}