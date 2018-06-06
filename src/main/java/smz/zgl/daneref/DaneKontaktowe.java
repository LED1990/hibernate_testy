package smz.zgl.daneref;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:55:50
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "daneKontaktowe")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaneKontaktowe implements Serializable{
	
	@XmlElement
	private Long id;
	@XmlElement
	private String nrTelefonu;
	@XmlElement
	private String stronaWww;
	@XmlElement
	private String email;
	@XmlElement
	private String fax;

	public DaneKontaktowe(){

	}

	public void finalize() throws Throwable {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrTelefonu() {
		return nrTelefonu;
	}

	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	public String getStronaWww() {
		return stronaWww;
	}

	public void setStronaWww(String stronaWww) {
		this.stronaWww = stronaWww;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	

}