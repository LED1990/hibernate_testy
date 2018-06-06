package smz.zgl.daneref.ud;

import smz.zgl.daneref.DaneOsobowe;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Dane osoby prowadzacej praktykę zawodową
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:56:53
 */
@XmlRootElement(name = "praktykaZawodowaOsoba")
@XmlAccessorType(XmlAccessType.FIELD)
public class PraktykaZawodowaOsoba implements Serializable{//extends DaneOsobowe
	
	@XmlAttribute
	private Long id;
	@XmlAttribute
	private String tytul;
	@XmlAttribute
	private String nip;
	@XmlAttribute
	private String nrPWZ;
	/**
	 * Lista specjalizacji wraz ze stopniem
	 */
	@XmlAttribute
	private String specjalizacje;
	@XmlElement
	private DaneOsobowe daneOsobowe;

	public PraktykaZawodowaOsoba(){

	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNrPWZ() {
		return nrPWZ;
	}

	public void setNrPWZ(String nrPWZ) {
		this.nrPWZ = nrPWZ;
	}

	public String getSpecjalizacje() {
		return specjalizacje;
	}

	public void setSpecjalizacje(String specjalizacje) {
		this.specjalizacje = specjalizacje;
	}

	public DaneOsobowe getDaneOsobowe() {
		return daneOsobowe;
	}

	public void setDaneOsobowe(DaneOsobowe daneOsobowe) {
		this.daneOsobowe = daneOsobowe;
	}
	

}