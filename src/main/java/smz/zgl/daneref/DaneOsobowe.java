package smz.zgl.daneref;

import smz.defSlownikow.slowniki.SKraj;
import smz.defSlownikow.slowniki.SPlec;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Dane usługobiorcy z P1
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:55:53
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "daneOsobowe")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaneOsobowe implements Serializable {
	
	@XmlElement(name = "id")
	private Long id;
	@XmlElement(name = "nazwisko")
	private String nazwisko;
	@XmlElement(name = "imie")
	private String imie;
	@XmlElement
	private SPlec plec;
	@XmlElement(name = "dataUrodzenia")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dataUrodzenia;
	@XmlElement(name = "pesel")
	private String nrPesel;
	@XmlElement(name = "innyDokument")
	private String nrIdentyfikacyjnyInnegoDokumentu;
	@XmlElement
	private SKraj obywatelstwo;
	@XmlElement
	private Adres adres;
	@XmlElement(name = "bezdomny")
	private Boolean bezdomny;
	@XmlElement
	private DaneKontaktowe daneKontaktowe;
	private Long daneOsoboweDpId;
	
//	private DaneOsoboweDepersonalizacja daneOsoboweDepersonalizacja;

	public DaneOsobowe(){
	}

	@Override
	public void finalize() throws Throwable {

	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwisko() {
		return nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}

	public SPlec getPlec() {
		return plec;
	}
	
	public void setPlec(SPlec plec) {
		this.plec = plec;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}
	
	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public String getNrPesel() {
		return nrPesel;
	}
	
	public void setNrPesel(String nrPesel) {
		this.nrPesel = nrPesel;
	}
	
	public String getNrIdentyfikacyjnyInnegoDokumentu() {
		return nrIdentyfikacyjnyInnegoDokumentu;
	}
	
	public void setNrIdentyfikacyjnyInnegoDokumentu(
			String nrIdentyfikacyjnyInnegoDokumentu) {
		this.nrIdentyfikacyjnyInnegoDokumentu = nrIdentyfikacyjnyInnegoDokumentu;
	}
	
	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Boolean getBezdomny() {
		return bezdomny;
	}
	
	public void setBezdomny(Boolean bezdomny) {
		this.bezdomny = bezdomny;
	}

	public DaneKontaktowe getDaneKontaktowe() {
		return daneKontaktowe;
	}

	public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
		this.daneKontaktowe = daneKontaktowe;
	}

	public SKraj getObywatelstwo() {
		return obywatelstwo;
	}
	
	public void setObywatelstwo(SKraj obywatelstwo) {
		this.obywatelstwo = obywatelstwo;
	}
	
	@Transient
	public String getImieNazwisko(){
		String results = "";
		if(this.imie != null && this.imie.length() > 0)
			results = imie;
		if(this.nazwisko != null && this.nazwisko.length() > 0)
			results += " " + nazwisko;
		return results;
	}

	public Long getDaneOsoboweDpId() {
		return daneOsoboweDpId;
	}

	public void setDaneOsoboweDpId(Long daneOsoboweDpId) {
		this.daneOsoboweDpId = daneOsoboweDpId;
	}

//	public DaneOsoboweDepersonalizacja getDaneOsoboweDepersonalizacja() {
//		return daneOsoboweDepersonalizacja;
//	}
//
//	public void setDaneOsoboweDepersonalizacja(DaneOsoboweDepersonalizacja daneOsoboweDepersonalizacja) {
//		this.daneOsoboweDepersonalizacja = daneOsoboweDepersonalizacja;
//	}
}