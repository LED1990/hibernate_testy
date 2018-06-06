package smz.zgl.daneref.ud;


import smz.zgl.daneref.Adres;
import smz.zgl.daneref.DaneKontaktowe;

import javax.persistence.Transient;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:12
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "komorkaOrganizacyjna")
@XmlAccessorType(XmlAccessType.FIELD)
public class KomorkaOrganizacyjna implements Serializable{
	
	@XmlElement
	private Long id;
	@XmlElement
	private String kodKomorki;
	@XmlElement
	private String nazwaKomorki;
	@XmlElement
	private Status status;
	@XmlElement
	private Integer idKomorki;
	@XmlElement
	private Set<SpecjalnoscKomorkiOrganizacyjnej> specjalnoscKomorkiOrganizacyjnej;
	@XmlElement
	private DaneKontaktowe daneKontaktowe;
	@XmlElement
	private Adres adres;
//	private Long idJednostkaOrganizacyjna;
	@XmlElement
	private JednostkaOrganizacyjna jednostkaOrganizacyjna;
	@Transient
	@XmlTransient
	private String kodSpecjalnosciKomorkiOrganizacyjnej;

	public KomorkaOrganizacyjna(){

	}

	public void finalize() throws Throwable {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKodKomorki() {
		return kodKomorki;
	}

	public void setKodKomorki(String kodKomorki) {
		this.kodKomorki = kodKomorki;
	}

	public String getNazwaKomorki() {
		return nazwaKomorki;
	}

	public void setNazwaKomorki(String nazwaKomorki) {
		this.nazwaKomorki = nazwaKomorki;
	}

	public Set<SpecjalnoscKomorkiOrganizacyjnej> getSpecjalnoscKomorkiOrganizacyjnej() { 
		return specjalnoscKomorkiOrganizacyjnej;
	}

	public void setSpecjalnoscKomorkiOrganizacyjnej(
			Set<SpecjalnoscKomorkiOrganizacyjnej> specjalnoscKomorkiOrganizacyjnej) {
		this.specjalnoscKomorkiOrganizacyjnej = specjalnoscKomorkiOrganizacyjnej;
	}

	public DaneKontaktowe getDaneKontaktowe() {
		return daneKontaktowe;
	}

	public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
		this.daneKontaktowe = daneKontaktowe;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

//	public Long getIdJednostkaOrganizacyjna() {
//		return idJednostkaOrganizacyjna;
//	}
//
//	public void setIdJednostkaOrganizacyjna(Long idJednostkaOrganizacyjna) {
//		this.idJednostkaOrganizacyjna = idJednostkaOrganizacyjna;
//	}

	public JednostkaOrganizacyjna getJednostkaOrganizacyjna() {
		return jednostkaOrganizacyjna;
	}

	public void setJednostkaOrganizacyjna(JednostkaOrganizacyjna jednostkaOrganizacyjna) {
		this.jednostkaOrganizacyjna = jednostkaOrganizacyjna;
	}

	public String getKodSpecjalnosciKomorkiOrganizacyjnej() {
		
		this.kodSpecjalnosciKomorkiOrganizacyjnej = ""; 
		Iterator<SpecjalnoscKomorkiOrganizacyjnej> iterator = specjalnoscKomorkiOrganizacyjnej.iterator();
		while (iterator.hasNext()) {
			SpecjalnoscKomorkiOrganizacyjnej s = iterator.next();
			this.kodSpecjalnosciKomorkiOrganizacyjnej = (this.kodSpecjalnosciKomorkiOrganizacyjnej != null && kodSpecjalnosciKomorkiOrganizacyjnej.length() > 0) ? this.kodSpecjalnosciKomorkiOrganizacyjnej + ", " + s.getKodSpecjalnosci() + " - " + s.getNazwaSpecjalnosci() : s.getKodSpecjalnosci() + " - " + s.getNazwaSpecjalnosci();
		}
		return kodSpecjalnosciKomorkiOrganizacyjnej;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getIdKomorki() {
		return idKomorki;
	}

	public void setIdKomorki(Integer idKomorki) {
		this.idKomorki = idKomorki;
	}
}