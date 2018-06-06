package smz.zgl.daneref.ud;

import smz.zgl.daneref.Adres;
import smz.zgl.daneref.DaneOsobowe;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:52
 */
@XmlRootElement(name = "praktykaZawodowa")
@XmlAccessorType(XmlAccessType.FIELD)
public class PraktykaZawodowa implements Serializable {

	@XmlAttribute
	private Long id;
	/**
	 * Identyfikator praktyki zawodowej z systemu P1.
	 */
	@XmlAttribute
	private String nazwa;
	@XmlElement
	private Adres adres;
	@XmlAttribute
	private String nrTelefonu;
	@XmlAttribute
	private Integer idPraktyki;
	@XmlAttribute
	private String regon;
	@XmlAttribute
	private String nrKsiegiRejestrowej;
	@XmlAttribute
	private String nazwaOrganuRejestrowego;
	@XmlElement
	private PraktykaZawodowaOsoba praktykaZawodowaOsoba;

	@XmlElement
	private String kodIdentyfikujacyMiejsceSwiadczenPraktyki;
	@Transient
	@XmlElement
	private KodOrganuRejestrowego kodOrganuRejestrowego;

	private String kluczPraktyki;

	@Transient
	private String nazwaRozszerzona;

	@Transient
	@XmlElement
	private Date dataWykreslenia;

	public PraktykaZawodowa() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getIdPraktyki() {
		return idPraktyki;
	}

	public void setIdPraktyki(Integer idPraktyki) {
		this.idPraktyki = idPraktyki;
	}

	public String getRegon() {
		return regon;
	}

	public void setRegon(String regon) {
		this.regon = regon;
	}

	public String getNrKsiegiRejestrowej() {
		return nrKsiegiRejestrowej;
	}

	public void setNrKsiegiRejestrowej(String nrKsiegiRejestrowej) {
		this.nrKsiegiRejestrowej = nrKsiegiRejestrowej;
	}

	public String getNazwaOrganuRejestrowego() {
		return nazwaOrganuRejestrowego;
	}

	public void setNazwaOrganuRejestrowego(String nazwaOrganuRejestrowego) {
		this.nazwaOrganuRejestrowego = nazwaOrganuRejestrowego;
	}

	public PraktykaZawodowaOsoba getPraktykaZawodowaOsoba() {
		return praktykaZawodowaOsoba;
	}

	public void setPraktykaZawodowaOsoba(PraktykaZawodowaOsoba praktykaZawodowaOsoba) {
		this.praktykaZawodowaOsoba = praktykaZawodowaOsoba;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String getNrTelefonu() {
		return nrTelefonu;
	}

	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	public String getNazwaRozszerzona() {
		String nazwaRozszerzona = "";
		if ((this.praktykaZawodowaOsoba != null) && (this.praktykaZawodowaOsoba.getDaneOsobowe() != null)) {
			DaneOsobowe dane = this.praktykaZawodowaOsoba.getDaneOsobowe();
			if (dane.getImie() != null && dane.getNazwisko() != null) {
				nazwaRozszerzona = this.nazwa + " " + dane.getImie() + " " + dane.getNazwisko();
			}
		} else {
			nazwaRozszerzona = this.nazwa;
		}
		return nazwaRozszerzona;
	}

	public void setNazwaRozszerzona(String nazwaRozszerzona) {
		this.nazwaRozszerzona = nazwaRozszerzona;
	}

	public Date getDataWykreslenia() {
		return dataWykreslenia;
	}

	public void setDataWykreslenia(Date dataWykreslenia) {
		this.dataWykreslenia = dataWykreslenia;
	}

	public String getKodIdentyfikujacyMiejsceSwiadczenPraktyki() {
		return kodIdentyfikujacyMiejsceSwiadczenPraktyki;
	}

	public void setKodIdentyfikujacyMiejsceSwiadczenPraktyki(String kodIdentyfikujacyMiejsceSwiadczenPraktyki) {
		this.kodIdentyfikujacyMiejsceSwiadczenPraktyki = kodIdentyfikujacyMiejsceSwiadczenPraktyki;
	}

	public KodOrganuRejestrowego getKodOrganuRejestrowego() {
		return kodOrganuRejestrowego;
	}

	public void setKodOrganuRejestrowego(KodOrganuRejestrowego kodOrganuRejestrowego) {
		this.kodOrganuRejestrowego = kodOrganuRejestrowego;
	}

	public String getKluczPraktyki() {
		return kluczPraktyki;
	}

	public void setKluczPraktyki(String kluczPraktyki) {
		this.kluczPraktyki = kluczPraktyki;
	}
}