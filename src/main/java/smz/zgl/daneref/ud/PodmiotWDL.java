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
 * Podmiot Wykonujacy Dzialalnosc Lecznicza
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:47
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "podmotWDL")
@XmlAccessorType(XmlAccessType.FIELD)
public class PodmiotWDL implements Serializable{
	
	@XmlElement
	private Long id;
	/**
	 * Identyfikator podmiotu leczniczego z systemu P1.
	 */
	@XmlElement
	private Integer idPodmiotu;
	@XmlElement
	private String nazwa;
	@XmlElement
	private Adres adres;
	@XmlElement
	private String numerKsiegiRejestrowej;
	@XmlElement
	private String kodOrganuRejestrowego;
	@XmlElement
	private String numerRegon;
	@XmlElement
	private String kodFormyOrganizacyjnoPrawnej;
	@XmlElement
	private Status status;
	@XmlElement
	private String nazwaPodmiotuTworzacego;
	@XmlElement
	private String kodPodmiotuTworzacego;
	@XmlElement
	private Set<PrzedsiebiorstwoPodmiotuLeczniczego> przedsiebiorstwoPodmiotuLeczniczego;
	@XmlElement
	private DaneKontaktowe daneKontaktowe;

	public PodmiotWDL(){

	}

	public void finalize() throws Throwable {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getIdPodmiotu() {
		return idPodmiotu;
	}

	public void setIdPodmiotu(Integer idPodmiotu) {
		this.idPodmiotu = idPodmiotu;
	}

	public String getNumerKsiegiRejestrowej() {
		return numerKsiegiRejestrowej;
	}

	public void setNumerKsiegiRejestrowej(String numerKsiegiRejestrowej) {
		this.numerKsiegiRejestrowej = numerKsiegiRejestrowej;
	}

	public String getKodOrganuRejestrowego() {
		return kodOrganuRejestrowego;
	}

	public void setKodOrganuRejestrowego(String kodOrganuRejestrowego) {
		this.kodOrganuRejestrowego = kodOrganuRejestrowego;
	}

	public String getNumerRegon() {
		return numerRegon;
	}

	public void setNumerRegon(String numerRegon) {
		this.numerRegon = numerRegon;
	}

	public String getKodFormyOrganizacyjnoPrawnej() {
		return kodFormyOrganizacyjnoPrawnej;
	}

	public void setKodFormyOrganizacyjnoPrawnej(String kodFormyOrganizacyjnoPrawnej) {
		this.kodFormyOrganizacyjnoPrawnej = kodFormyOrganizacyjnoPrawnej;
	}

	public String getNazwaPodmiotuTworzacego() {
		return nazwaPodmiotuTworzacego;
	}

	public void setNazwaPodmiotuTworzacego(String nazwaPodmiotuTworzacego) {
		this.nazwaPodmiotuTworzacego = nazwaPodmiotuTworzacego;
	}

	public String getKodPodmiotuTworzacego() {
		return kodPodmiotuTworzacego;
	}

	public void setKodPodmiotuTworzacego(String kodPodmiotuTworzacego) {
		this.kodPodmiotuTworzacego = kodPodmiotuTworzacego;
	}

	public Set<PrzedsiebiorstwoPodmiotuLeczniczego> getPrzedsiebiorstwoPodmiotuLeczniczego() {
		return przedsiebiorstwoPodmiotuLeczniczego;
	}

	public void setPrzedsiebiorstwoPodmiotuLeczniczego(
			Set<PrzedsiebiorstwoPodmiotuLeczniczego> przedsiebiorstwoPodmiotuLeczniczego) {
		this.przedsiebiorstwoPodmiotuLeczniczego = przedsiebiorstwoPodmiotuLeczniczego;
	}

	public DaneKontaktowe getDaneKontaktowe() {
		return daneKontaktowe;
	}

	public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
		this.daneKontaktowe = daneKontaktowe;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}