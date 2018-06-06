package smz.zgl.daneref.ud;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import smz.zgl.daneref.Adres;


/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:57:36
 */
@XmlRootElement(name = "uslugodawca")
@XmlAccessorType(XmlAccessType.FIELD)
public class Uslugodawca implements Serializable{


	private final static Logger LOGGER = LoggerFactory
			.getLogger("SMZ - dane usługodawcy");
	/**
	 *
	 */
	@XmlTransient
	private static final long serialVersionUID = 1L;
	@XmlElement
	private Long id;
	//	@XmlElement
	@Transient
	private String nazwa;
	@XmlElement
	private PraktykaZawodowa praktykaZawodowa;
	@XmlElement
	private KomorkaOrganizacyjna komorkaOrganizacyjna;
	//	private PodmiotWDL podmiotWDL;
	//	@XmlElement
	//	@Transient
	//	private Adres adres;
	@XmlElement
	private Boolean spozaRejestru;
	@XmlElement
	private Status status;

	public Uslugodawca(){

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PraktykaZawodowa getPraktykaZawodowa() {
		return praktykaZawodowa;
	}

	public void setPraktykaZawodowa(PraktykaZawodowa praktykaZawodowa) {
		this.praktykaZawodowa = praktykaZawodowa;
	}

	public Boolean getSpozaRejestru() {
		return spozaRejestru;
	}

	public void setSpozaRejestru(Boolean spozaRejestru) {
		this.spozaRejestru = spozaRejestru;
	}

	public KomorkaOrganizacyjna getKomorkaOrganizacyjna() {
		return komorkaOrganizacyjna;
	}

	public void setKomorkaOrganizacyjna(KomorkaOrganizacyjna komorkaOrganizacyjna) {
		this.komorkaOrganizacyjna = komorkaOrganizacyjna;
	}

	public String getNazwa() {
		String nazwa="";

		try {
			nazwa = this.getPraktykaZawodowa() != null ? this.getPraktykaZawodowa().getNazwa() :
					this.getKomorkaOrganizacyjna()
						.getJednostkaOrganizacyjna()
						.getPrzedsiebiorstwoPodmiotuLeczniczego()
						.getPodmiotWDL().getNazwa()	+ "  " +
							this.getKomorkaOrganizacyjna().getNazwaKomorki();
		} catch (Exception e) {
			LOGGER.error("Problem z pobraniem danych usługodwacy " + e.getMessage());
		}
		return nazwa;
	}

	public Adres getAdres() {
		Adres adres;
		if (praktykaZawodowa != null) {
			adres = praktykaZawodowa.getAdres();
		} else if (komorkaOrganizacyjna != null) {
			adres = komorkaOrganizacyjna.getAdres();
		} else {
			adres = null;
		}
		return adres == null ? new Adres() : adres;
	}

	public String getNrTelefonu() {
		String nrTelefonu;
		if (praktykaZawodowa != null) {
			nrTelefonu = praktykaZawodowa.getNrTelefonu();
		} else if (komorkaOrganizacyjna != null && komorkaOrganizacyjna.getDaneKontaktowe() != null) {
			nrTelefonu = komorkaOrganizacyjna.getDaneKontaktowe().getNrTelefonu();
		} else {
			nrTelefonu = null;
		}
		return nrTelefonu == null ? "" : nrTelefonu;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	//	public void setAdres(Adres adres) {
	//		this.adres = adres;
	//	}
}
