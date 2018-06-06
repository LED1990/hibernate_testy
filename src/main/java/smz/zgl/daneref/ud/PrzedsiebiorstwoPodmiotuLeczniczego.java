package smz.zgl.daneref.ud;


import smz.zgl.daneref.Adres;
import smz.zgl.daneref.DaneKontaktowe;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:54
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "przedsiebiorstwoPodmiotuLeczniczego")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrzedsiebiorstwoPodmiotuLeczniczego implements Serializable{
	
	@XmlAttribute
	private Long id;
	@XmlAttribute
	private String rodzajDzialalnosciLeczniczej;
	@XmlAttribute
	private String kodRodzajuDzialalnosciLeczniczej;
	@XmlElement
	private Integer idPrzedsiebiorstwa;
	@XmlElement
	private Status status;
	@XmlElement
	private Set<JednostkaOrganizacyjna> jednostkaOrganizacyjna;
	@XmlElement
	private DaneKontaktowe daneKontaktowe;
	@XmlElement
	private Adres adres;
	@XmlElement
	private PodmiotWDL podmiotWDL;
	

	public PrzedsiebiorstwoPodmiotuLeczniczego(){

	}

	public void finalize() throws Throwable {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRodzajDzialalnosciLeczniczej() {
		return rodzajDzialalnosciLeczniczej;
	}

	public void setRodzajDzialalnosciLeczniczej(String rodzajDzialalnosciLeczniczej) {
		this.rodzajDzialalnosciLeczniczej = rodzajDzialalnosciLeczniczej;
	}

	public String getKodRodzajuDzialalnosciLeczniczej() {
		return kodRodzajuDzialalnosciLeczniczej;
	}

	public void setKodRodzajuDzialalnosciLeczniczej(String kodRodzajuDzialalnosciLeczniczej) {
		this.kodRodzajuDzialalnosciLeczniczej = kodRodzajuDzialalnosciLeczniczej;
	}	
	
	public Set<JednostkaOrganizacyjna> getJednostkaOrganizacyjna() {
		return jednostkaOrganizacyjna;
	}

	public void setJednostkaOrganizacyjna(
			Set<JednostkaOrganizacyjna> jednostkaOrganizacyjna) {
		this.jednostkaOrganizacyjna = jednostkaOrganizacyjna;
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

	public PodmiotWDL getPodmiotWDL() {
		return podmiotWDL;
	}

	public void setPodmiotWDL(PodmiotWDL podmiotWDL) {
		this.podmiotWDL = podmiotWDL;
	}

	public Integer getIdPrzedsiebiorstwa() {
		return idPrzedsiebiorstwa;
	}

	public void setIdPrzedsiebiorstwa(Integer idPrzedsiebiorstwa) {
		this.idPrzedsiebiorstwa = idPrzedsiebiorstwa;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	
	
	
}