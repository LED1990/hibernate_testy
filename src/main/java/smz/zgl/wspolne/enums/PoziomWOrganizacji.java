package smz.zgl.wspolne.enums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:50
 */
@XmlRootElement(name = "poziomWOrganizacji")
@XmlAccessorType(XmlAccessType.FIELD)
public enum PoziomWOrganizacji {
	CENTRALNA(1, "jednostka centralna"),
	WOJEWODZKA(2, "jednostka wojewódzka"),
	POWIATOWA(3, "jednostka powiatowa");
	
	private final int code;
	@XmlAttribute
	private final String name;
		
	private PoziomWOrganizacji(int code, String name) {
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
	
}