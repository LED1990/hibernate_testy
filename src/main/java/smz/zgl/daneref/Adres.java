package smz.zgl.daneref;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import smz.zgl.daneref.enums.TypAdresu;

/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:55:38
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "Adres")
@XmlAccessorType(XmlAccessType.FIELD)
public class Adres implements Serializable{

	@XmlElement
	private Long id;
	@XmlElement
	private String kodPocztowy;
	@XmlElement
	private String nazwaPoczty;
	@XmlElement
	private String wojewodztwo;
	@XmlElement
	private String powiat;
	@XmlElement
	private String gmina;
	@XmlElement
	private String miejscowosc;
	@XmlElement
	private String ulica;
	@XmlElement
	private String nrDomu;
	@XmlElement
	private String nrLokalu;
	@XmlElement
	private String kraj;
	/**
	 * teryt lub kod nieterytowy
	 */
	@XmlTransient
	private String kodTerytorialnyMsw;
	@XmlTransient
	private TypAdresu typAdresu;
	@XmlElement
	private String kodTerytTerc;
	@XmlElement
	private String kodTerytSimc;
	@Transient
	@XmlTransient
	private String prezentujAdres;


	public Adres(){

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getNazwaPoczty() {
		return nazwaPoczty;
	}

	public void setNazwaPoczty(String nazwaPoczty) {
		this.nazwaPoczty = nazwaPoczty;
	}



	public String getPowiat() {
		return powiat;
	}

	public void setPowiat(String powiat) {
		this.powiat = powiat;
	}

	public String getGmina() {
		return gmina;
	}

	public void setGmina(String gmina) {
		this.gmina = gmina;
	}



	public String getNrDomu() {
		return nrDomu;
	}

	public void setNrDomu(String nrDomu) {
		this.nrDomu = nrDomu;
	}

	public String getNrLokalu() {
		return nrLokalu;
	}

	public void setNrLokalu(String nrLokalu) {
		this.nrLokalu = nrLokalu;
	}



	public String getKodTerytorialnyMsw() {
		return kodTerytorialnyMsw;
	}

	public void setKodTerytorialnyMsw(String kodTerytorialnyMsw) {
		this.kodTerytorialnyMsw = kodTerytorialnyMsw;
	}

	public TypAdresu getTypAdresu() {
		return typAdresu;
	}

	public void setTypAdresu(TypAdresu typAdresu) {
		this.typAdresu = typAdresu;
	}

	public String getKodTerytTerc() {
		return kodTerytTerc;
	}

	public void setKodTerytTerc(String kodTerytTerc) {
		this.kodTerytTerc = kodTerytTerc;
	}

	public String getKodTerytSimc() {
		return kodTerytSimc;
	}

	public void setKodTerytSimc(String kodTerytSimc) {
		this.kodTerytSimc = kodTerytSimc;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getWojewodztwo() {
		return wojewodztwo;
	}

	public void setWojewodztwo(String wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}

	public String getPrezentujAdres() {
		this.prezentujAdres = "ul. " + this.ulica + " " + this.nrDomu;
		this.prezentujAdres = this.prezentujAdres + ((this.nrLokalu != null && !this.nrLokalu.isEmpty()) ? ("/" + this.nrLokalu) : "");
		this.prezentujAdres = this.prezentujAdres + ", " + this.kodPocztowy + " " + this.miejscowosc;
		return prezentujAdres;
	}
}
