package smz.defSlownikow.slowniki;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author michal.kuczkowski@newind.pl
 * @version 1.0
 * @created 03-lip-2015 11:57:17
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "plec")
@XmlAccessorType(XmlAccessType.FIELD)
public class SPlec implements Serializable{

    @XmlTransient
    private Long id;
    @XmlElement(name = "kod")
    private String kod;
    @XmlElement(name = "nazwa")
    private String nazwa;
    @XmlElement(name = "wersjaSlownika")
    private Integer wersjaSlownika;
    private Boolean aktualny;

    public SPlec(){

    }

    public SPlec(String kod){
        this.kod = kod;
    }

    public SPlec(String kod, String nazwa, Integer wersjaSlownika){
        this.kod = kod;
        this.nazwa = nazwa;
        aktualny = true;
        this.wersjaSlownika = wersjaSlownika;
    }

    public void finalize() throws Throwable {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getId());
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof SPlec)) {
            return false;
        }
        if(this.getId()==null){
            return false;
        }
        return this.getId().equals(((SPlec) o).getId());
    }
    public Boolean getAktualny() {
        return aktualny;
    }
    public void setAktualny(Boolean aktualny) {
        this.aktualny = aktualny;
    }
	public Integer getWersjaSlownika() {
		return wersjaSlownika;
	}
	public void setWersjaSlownika(Integer wersjaSlownika) {
		this.wersjaSlownika = wersjaSlownika;
	}
}
