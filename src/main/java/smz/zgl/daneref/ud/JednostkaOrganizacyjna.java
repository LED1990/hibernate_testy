package smz.zgl.daneref.ud;



import smz.zgl.daneref.Adres;
import smz.zgl.daneref.DaneKontaktowe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:11
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JednostkaOrganizacyjna implements Serializable{
	
	@XmlElement
	private Long id;
	@XmlElement
	private String kodJednostki;
	@XmlElement
	private String nazwaJednostki;
	@XmlElement
	private Integer idJednostki;
//	@XmlTransient
//	private List<KomorkaOrganizacyjna> komorkaOrganizacyjna;
	@XmlElement
	private Set<KomorkaOrganizacyjna> komorkaOrganizacyjna;
	@XmlElement
	private DaneKontaktowe daneKontaktowe;
	@XmlElement
	private Adres adres;
	@XmlElement
	private PrzedsiebiorstwoPodmiotuLeczniczego przedsiebiorstwoPodmiotuLeczniczego;
//	private Long idPrzedsiebiorstwoPodmiotuLeczniczego;
	@XmlElement
	private Boolean wirtualna;
	@XmlElement
	private Status status;
	
	public JednostkaOrganizacyjna(){

	}

	public void finalize() throws Throwable {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKodJednostki() {
		return kodJednostki;
	}

	public void setKodJednostki(String kodJednostki) {
		this.kodJednostki = kodJednostki;
	}

	public String getNazwaJednostki() {
		return nazwaJednostki;
	}

	public void setNazwaJednostki(String nazwaJednostki) {
		this.nazwaJednostki = nazwaJednostki;
	}
	
//	public List<KomorkaOrganizacyjna> getKomorkaOrganizacyjna() {
//		return komorkaOrganizacyjna;
//	}
//
//	public void setKomorkaOrganizacyjna(List<KomorkaOrganizacyjna> komorkaOrganizacyjna) {
//		this.komorkaOrganizacyjna = komorkaOrganizacyjna;
//	}	

	public DaneKontaktowe getDaneKontaktowe() {
		return daneKontaktowe;
	}

	public Set<KomorkaOrganizacyjna> getKomorkaOrganizacyjna() {
		return komorkaOrganizacyjna;
	}

	public void setKomorkaOrganizacyjna(
			Set<KomorkaOrganizacyjna> komorkaOrganizacyjna) {
		this.komorkaOrganizacyjna = komorkaOrganizacyjna;
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

	public PrzedsiebiorstwoPodmiotuLeczniczego getPrzedsiebiorstwoPodmiotuLeczniczego() {
		return przedsiebiorstwoPodmiotuLeczniczego;
	}

	public void setPrzedsiebiorstwoPodmiotuLeczniczego(
			PrzedsiebiorstwoPodmiotuLeczniczego przedsiebiorstwoPodmiotuLeczniczego) {
		this.przedsiebiorstwoPodmiotuLeczniczego = przedsiebiorstwoPodmiotuLeczniczego;
	}

	public Boolean getWirtualna() {
		return wirtualna;
	}

	public void setWirtualna(Boolean wirtualna) {
		this.wirtualna = wirtualna;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getIdJednostki() {
		return idJednostki;
	}

	public void setIdJednostki(Integer idJednostki) {
		this.idJednostki = idJednostki;
	}
	
	
	
}