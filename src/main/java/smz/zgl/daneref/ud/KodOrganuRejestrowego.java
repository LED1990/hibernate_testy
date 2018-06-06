package smz.zgl.daneref.ud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "kodOrganuRejestrowego")
@XmlAccessorType(XmlAccessType.FIELD)
public class KodOrganuRejestrowego implements Serializable{

    @XmlAttribute
    private String kod;

    @XmlAttribute
    private String opis;

    public void finalize() throws Throwable {
        super.finalize();
    }

    public KodOrganuRejestrowego() {
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
