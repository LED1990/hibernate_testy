package smz.defSlownikow.slowniki;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;


/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:57:11
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "kraj")
@XmlAccessorType(XmlAccessType.FIELD)
public class SKraj implements Serializable {
	
	@XmlAttribute
	private Long id;
	@XmlAttribute
	private String kod;
	@XmlAttribute
	private String nazwa;
	@XmlAttribute
	private Integer wersjaSlownika;
	private Boolean aktualny;

	public SKraj(){

	}
	
	public SKraj(String kod, String nazwa, Integer wersjaSlownika){
        this.kod = kod;
        this.nazwa = nazwa;
        aktualny = true;
        this.wersjaSlownika = wersjaSlownika;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof SKraj && id != null && id.equals(((SKraj) other).getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public Boolean getAktualny() {
		return aktualny;
	}

	public void setAktualny(Boolean aktualny) {
		this.aktualny = aktualny;
	}

	public Integer getWersjaSlownika() {
		return wersjaSlownika;
	}

	public void setWersjaSlownika(Integer wersjaSlownika) {
		this.wersjaSlownika = wersjaSlownika;
	}
}
