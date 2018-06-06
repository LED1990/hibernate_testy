package smz.zgl.daneref.ud;

import smz.zgl.daneref.ud.KomorkaOrganizacyjna;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:57:16
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecjalnoscKomorkiOrganizacyjnej implements Serializable {
	
	@XmlElement
	private Long id;
	@XmlElement
	private Integer kodSpecjalnosci;
	@XmlElement
	private String nazwaSpecjalnosci;
	@XmlTransient
	private KomorkaOrganizacyjna komorkaOrganizacyjna;
	
	public SpecjalnoscKomorkiOrganizacyjnej(){

	}

	public void finalize() throws Throwable {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKodSpecjalnosci() {
		return kodSpecjalnosci;
	}

	public void setKodSpecjalnosci(Integer kodSpecjalnosci) {
		this.kodSpecjalnosci = kodSpecjalnosci;
	}

	public String getNazwaSpecjalnosci() {
		return nazwaSpecjalnosci;
	}

	public void setNazwaSpecjalnosci(String nazwaSpecjalnosci) {
		this.nazwaSpecjalnosci = nazwaSpecjalnosci;
	}

	public KomorkaOrganizacyjna getKomorkaOrganizacyjna() {
		return komorkaOrganizacyjna;
	}

	public void setKomorkaOrganizacyjna(KomorkaOrganizacyjna komorkaOrganizacyjna) {
		this.komorkaOrganizacyjna = komorkaOrganizacyjna;
	}
	

}