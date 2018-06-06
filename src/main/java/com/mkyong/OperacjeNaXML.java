package com.mkyong;

import com.mkyong.util.HibernateUtil;
import org.hibernate.Session;
import smz.zgl.daneref.ud.PraktykaZawodowa;
import smz.zgl.daneref.ud.Status;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OperacjeNaXML {

    public static void main(String[] args) {

        OperacjeNaXML operacjeNaXML = new OperacjeNaXML();
//        operacjeNaXML.wykonajOperacjeXML();

    }

    public List<PraktykaZawodowa> wykonajOperacjeXML(){
        TransformerFactory factory = TransformerFactory.newInstance();

        Source xslt = new StreamSource(new File("src/main/resources/praktyki_import.xsl"));
        Source xml = new StreamSource(new File("src/main/resources/ahmed.xml"));
        Source xmmWynik = new StreamSource(new File("src/main/resources/ahmedWynik.xml"));
        System.out.println(xmmWynik.getSystemId());
        try {
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(xml,new StreamResult(new File("src/main/resources/ahmedWynik.xml")));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        ListaPraktyk uslugodawcaZXML = null;
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(ListaPraktyk.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            uslugodawcaZXML = (ListaPraktyk) unmarshaller.unmarshal(xmmWynik);
            System.out.println("------------ "+uslugodawcaZXML.getPraktykaZawodowa());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("wyslano liste praktyk");
        return uslugodawcaZXML.getPraktykaZawodowa();
    }

    private Status ustawStatusUslugodawcy(PraktykaZawodowa praktykaZawodowa) {
        if (praktykaZawodowa.getDataWykreslenia() == null){
            return Status.AKTUALNY;
        }else {
            return praktykaZawodowa.getDataWykreslenia().compareTo(new Date()) >= 0 ? Status.AKTUALNY : Status.NIEAKTUALNY;//TODO przetestowac to dobrze!
        }
    }

    @XmlRootElement(name="praktyki")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class ListaPraktyk implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        @XmlElement
        private List<PraktykaZawodowa> praktykaZawodowa;

        public List<PraktykaZawodowa> getPraktykaZawodowa() {
            return praktykaZawodowa;
        }

        public void setPraktyka(List<PraktykaZawodowa> praktyka) {
            this.praktykaZawodowa = praktyka;
        }
    }

//    public List<PraktykaZawodowa> pobierzPraktykiZXmlPraktyk(){
//        ListaPraktyk uslugodawcaZXML = null;
//        Source xmmWynik = new StreamSource(new File("src/main/resources/ahmedWynik.xml"));
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(ListaPraktyk.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            uslugodawcaZXML = (ListaPraktyk) unmarshaller.unmarshal(xmmWynik);
//            System.out.println("------------ "+uslugodawcaZXML.getPraktykaZawodowa());
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("wyslano liste praktyk");
//        return uslugodawcaZXML.getPraktykaZawodowa();
//    }
}
