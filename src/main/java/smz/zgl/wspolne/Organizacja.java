package smz.zgl.wspolne;

import smz.zgl.daneref.Adres;
import smz.zgl.wspolne.enums.PoziomWOrganizacji;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

/**
 * np. PSSE, URPL, WOMP, PSK
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:40
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "organizacja")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organizacja implements Serializable{
	
	@XmlElement
	private Long id;
	/**
	 * Nazwa jednostki organizacyjnej
	 */
	@XmlElement
	private String nazwa;  //lista  enum TYPY np PIS,URPL etc 
	@XmlElement
	private PoziomWOrganizacji poziomEnum; 
	@XmlTransient
	private String poziom;
	/**
	 * np. Państwowa Inspekcja Sanitarna, Urząd Rejestracji Produktów Leczniczych,
	 * Państwowa Służba Krwi, Wojskowe Ośrodki Medycyny Prewencyjnej
	 */
	@XmlElement
	private String nazwaOrganizacji;  //<< jest to inaczej na dialogu nazwa jendostki w dialogu adresata
	@XmlElement
	private Adres adres;
	/**
	 * Referencja do usługodawcy, jeśli dana organizacja jest w bazie usługodawców.
	 */
	@XmlTransient	
	private Integer organizacjaNadrzedna;	
	@XmlTransient
	private Organizacja organizacja;
	@SuppressWarnings("rawtypes")
	@XmlTransient
	private Set organizacjePodrzedne;
	@XmlElement
	private String organizacjaKod;
	@XmlElement
	private String kod;
	@XmlElement
    private Integer wersjaSlownika;
    private Boolean aktualny;

	public Organizacja(String kod, String nazwa, Integer wersjaSlownika) {
		this.kod = kod;
		this.nazwa = nazwa;
		this.wersjaSlownika = wersjaSlownika;
		this.aktualny = true;
	}
	
	
	public Organizacja(){

	}

	public void finalize() throws Throwable {

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

	public String getNazwaOrganizacji() {
		return nazwaOrganizacji;
	}

	public void setNazwaOrganizacji(String nazwaOrganizacji) {
		this.nazwaOrganizacji = nazwaOrganizacji;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public PoziomWOrganizacji getPoziomEnum() {
		return poziomEnum;
	}

	public void setPoziomEnum(PoziomWOrganizacji poziomEnum) {
		this.poziomEnum = poziomEnum;
	}

	public String getPoziom() {
		return poziom;
	}
	
	public void setPoziom(String poziom) {
		this.poziom = poziom;
	}

	@SuppressWarnings("rawtypes")
	public Set getOrganizacjePodrzedne() {
		return organizacjePodrzedne;
	}

	@SuppressWarnings("rawtypes")
	public void setOrganizacjePodrzedne(Set organizacjePodrzedne) {
		this.organizacjePodrzedne = organizacjePodrzedne;
	}

	public Organizacja getOrganizacja() {
		return organizacja;
	}

	public void setOrganizacja(Organizacja organizacja) {
		this.organizacja = organizacja;
	}

	public void setOrganizacjaNadrzedna(Integer organizacjaNadrzedna) {
		this.organizacjaNadrzedna = organizacjaNadrzedna;
	}

	public Integer getOrganizacjaNadrzedna() {
		return organizacjaNadrzedna;
	}

	public String getOrganizacjaKod() {
		return organizacjaKod;
	}

	public void setOrganizacjaKod(String organizacjaKod) {
		this.organizacjaKod = organizacjaKod;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public Integer getWersjaSlownika() {
		return wersjaSlownika;
	}

	public void setWersjaSlownika(Integer wersjaSlownika) {
		this.wersjaSlownika = wersjaSlownika;
	}

	public Boolean getAktualny() {
		return aktualny;
	}

	public void setAktualny(Boolean aktualny) {
		this.aktualny = aktualny;
	}	
	
	
}
