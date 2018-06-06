package com.mkyong;

import smz.zgl.daneref.ud.PraktykaZawodowa;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PorownanieRpwdl {
    public static void main(String[] args) throws InterruptedException, IOException, TransformerException, JAXBException, XMLStreamException {
        PorownanieRpwdl app = new PorownanieRpwdl();
        //        OperacjeNaXML operacjeNaXML = new OperacjeNaXML();

        app.transformuj();
    }

    private void transformuj() throws TransformerFactoryConfigurationError, TransformerConfigurationException, FactoryConfigurationError, XMLStreamException, FileNotFoundException, IOException, TransformerException, JAXBException, InterruptedException {
        TransformerFactory factory = TransformerFactory.newInstance();

        Source xslt = new StreamSource(new File("src/main/resources/praktyki_import.xsl"));
        Source xml = new StreamSource(new File("src/main/resources/testowy.xml"));

        Transformer transformer = factory.newTransformer(xslt);

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = inputFactory.createXMLEventReader(xml);

        // omijamy root'a
        reader.nextTag();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ByteArrayOutputStream bufor = new ByteArrayOutputStream();
        int count = 0;
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLEventWriter writer = outputFactory.createXMLEventWriter(bufor, "UTF-8");
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();


        JAXBContext jaxbContext = JAXBContext.newInstance(PorownanieRpwdl.ListaPraktyk.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        boolean przetwarzaniePojedynczejPozycji = false;
        int id=0;
        Map<Integer,List<PraktykaZawodowa>> mapaPraktykRpwdl = new HashMap<Integer, List<PraktykaZawodowa>>();
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();

            if (nextEvent.isStartElement() && ((StartElement) nextEvent).getName()
                                                                        .getLocalPart()
                                                                        .equals("uslugodawca")) {
                writer = outputFactory.createXMLEventWriter(bufor, "UTF-8");
                bufor.reset();
                bos.reset();
                writer.add(eventFactory.createStartDocument());
                writer.add(nextEvent);
                przetwarzaniePojedynczejPozycji = true;
            } else if (nextEvent.isEndElement() && ((EndElement) nextEvent).getName()
                                                                           .getLocalPart()
                                                                           .equals("uslugodawca")) {
                writer.add(nextEvent);
                writer.add(eventFactory.createEndDocument());
                writer.flush();
                writer.close();

                ByteArrayInputStream inputStream = new ByteArrayInputStream(bufor.toByteArray());
                transformer.transform(new StreamSource(inputStream), new StreamResult(bos));
                ByteArrayInputStream pojedynczPozycja = new ByteArrayInputStream(bos.toByteArray());
//                przetworzPojedynczaPozycje(unmarshaller, pojedynczPozycja);
                id++;//todo:::::::::::
                dodajPraktykeDoMapy(unmarshaller,pojedynczPozycja,id,mapaPraktykRpwdl);//todo:::::::::::
                przetwarzaniePojedynczejPozycji = false;
                count++;
            } else {
                if (przetwarzaniePojedynczejPozycji) {
                    writer.add(nextEvent);
                }
            }
        }
        wyswietlMapePraktyk(mapaPraktykRpwdl);//todo:::::::::::
    }
    private void dodajPraktykeDoMapy(Unmarshaller unmarshaller,ByteArrayInputStream pojedynczPozycja, Integer id,Map<Integer,List<PraktykaZawodowa>> mapaPraktykRpwdl ) throws JAXBException {
        final ListaPraktyk uslugodawcaZXML = (ListaPraktyk) unmarshaller.unmarshal(pojedynczPozycja);
        if (uslugodawcaZXML.getPraktykaZawodowa() != null && uslugodawcaZXML.getPraktykaZawodowa()
                                                                            .size() > 0) {
            mapaPraktykRpwdl.put(id,uslugodawcaZXML.getPraktykaZawodowa());
        }
    }
    private void wyswietlMapePraktyk( Map<Integer,List<PraktykaZawodowa>> mapaPraktykRpwdl){
        //todo wyswietlanie danch
        for (Map.Entry<Integer,List<PraktykaZawodowa>> entry:mapaPraktykRpwdl.entrySet()
                ) {
            System.out.println("praktyka: "+entry.getKey());
            for (PraktykaZawodowa pz:entry.getValue()
                    ) {
                System.out.println("praktykl: " + pz.getNrKsiegiRejestrowej() + " " + pz.getIdPraktyki());
            }
        }
    }
    @XmlRootElement(name = "praktyki")
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

}
