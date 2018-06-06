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
import java.util.*;

public class PrownanieRpwdlBinarySearch {
    public static void main(String[] args) throws InterruptedException, IOException, TransformerException, JAXBException, XMLStreamException {
        PrownanieRpwdlBinarySearch app = new PrownanieRpwdlBinarySearch();
        //        OperacjeNaXML operacjeNaXML = new OperacjeNaXML();
        List<PraktykaZawodowa> listaPraktykRpwdlStary = new ArrayList<PraktykaZawodowa>();
        List<PraktykaZawodowa> listaPraktykRpwdlAktualny = new ArrayList<PraktykaZawodowa>();
//        String staryRpwdl = "stary.xml";
//        String aktualnyRpwdl = "nowy.xml";
//        String aktualnyRpwdl = "najnowszy.xml";
        String aktualnyRpwdl = "nowy_zle_id.xml";
//                String staryRpwdl = "starySkrocony.xml";
//                String aktualnyRpwdl = "nowySkrocony.xml";
//        app.transformuj(listaPraktykRpwdlStary, staryRpwdl);
        Map<Integer,String> listaKluczy=new HashMap<Integer, String>();
        app.transformuj(listaPraktykRpwdlAktualny, aktualnyRpwdl,listaKluczy);
        app.porownajKlucze(listaKluczy);

//        System.out.println("stare ================================== " + listaPraktykRpwdlStary.size());
//                app.wyswietlMapePraktyk(listaPraktykRpwdlStary);//todo:::::::::::
//        System.out.println("nowe ================================== " + listaPraktykRpwdlAktualny.size());
//                app.wyswietlMapePraktyk(listaPraktykRpwdlAktualny);//todo:::::::::::
//        app.porownajRpwdle(listaPraktykRpwdlStary,listaPraktykRpwdlAktualny);


    }
    private void porownajKlucze(Map<Integer,String>listaKluczy){
        System.out.println("start porownanie kluczy "+listaKluczy.size());
        int count;
        List<String>takieSameKlucze = new ArrayList<String>();
        int countTemp =0;
        for(Map.Entry<Integer, String> entry : listaKluczy.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
//            System.out.println("------- ZEW: "+key+" "+value);
            count=0;
            for(Map.Entry<Integer, String> entryIn : listaKluczy.entrySet()) {
                Integer keyIn = entryIn.getKey();
                String valueIn = entryIn.getValue();
//                System.out.println("WEW: "+keyIn+" "+valueIn);
                if (value.equals(valueIn)){
                    count++;
                }
                if (count>1){
                    if (key==keyIn){
                        //do nothing
                    }else {
                        System.out.println("kolny: numer: "+key+" "+keyIn);
                    }
                    break;
                }
            }
        }
        System.out.println("porownanie kluczy stop");
    }

    private void porownajRpwdle(List<PraktykaZawodowa> listaPraktykRpwdlStary, List<PraktykaZawodowa> listaPraktykRpwdlAktualny) {
        int counterRozne = 0;
        int countCoIleStare =100;
        Integer countTakieSameAdresy = 0;
        Set<PraktykaZawodowa> roznaPraktyki = new HashSet<PraktykaZawodowa>();
        boolean praktyka;
        boolean praktykaOrazAdres;
        for (PraktykaZawodowa pzNowa:listaPraktykRpwdlAktualny
             ) {
            for (PraktykaZawodowa pz:listaPraktykRpwdlStary
                 ) {
                if (pzNowa.getNrKsiegiRejestrowej().equals(pz.getNrKsiegiRejestrowej())
                        && pzNowa.getKodOrganuRejestrowego().getKod().equals(pz.getKodOrganuRejestrowego().getKod())){
                    //todo:ta sama praktyka! - trzeba sprawdzac adresy
//                    countTakieSamePraktyki++;
                    praktyka = true;
                    if (pz.getAdres().getMiejscowosc()!=null && pzNowa.getAdres().getMiejscowosc()!=null){
                        if (pz.getAdres().getMiejscowosc().equals(pzNowa.getAdres().getMiejscowosc())){
                            if (pz.getAdres().getNrDomu()!=null && pzNowa.getAdres().getNrDomu()!=null){
                                if (pz.getAdres().getNrDomu().equals(pzNowa.getAdres().getNrDomu())){
                                    //todo takie same nadac identyifkator
                                    //                             System.out.println("nowy id: "+pzNowa.getKodIdentyfikujacyMiejsceSwiadczenPraktyki());
                                    countTakieSameAdresy++;
                                    praktykaOrazAdres=true;
                                    break;
                                }
                            }else {
                                if (pz.getAdres().getNrLokalu()!=null && pzNowa.getAdres().getNrLokalu()!=null){
                                    if (pz.getAdres().getNrLokalu().equals(pzNowa.getAdres().getNrLokalu())){
                                        //todo takie same nadac identyifkator
                                        //                                                System.out.println("nowy id: "+pzNowa.getKodIdentyfikujacyMiejsceSwiadczenPraktyki());
                                        countTakieSameAdresy++;
                                        praktykaOrazAdres=true;
                                        break;
                                    }
                                }else {
                                    counterRozne++;
                                    praktykaOrazAdres=false;
                                }
                            }
                        }
                    }
                }else {
                    praktyka = false;
                }
            }
            if (countCoIleStare < countTakieSameAdresy){
                System.out.println("stare-> "+countCoIleStare);
                countCoIleStare+=100;
            }
        }
        System.out.println("stare ================================== " + listaPraktykRpwdlStary.size());
        //                app.wyswietlMapePraktyk(listaPraktykRpwdlStary);//todo:::::::::::
        System.out.println("nowe ================================== " + listaPraktykRpwdlAktualny.size());
//        System.out.println("liczba takich samych praktyk przed sprawdzeniem adresow: "+countTakieSamePraktyki);
        System.out.println("liczba takich samych praktyk po sprawdzeniu adresow: "+countTakieSameAdresy);
        System.out.println("liczba nowych nie znalezionych w starych: "+counterRozne);
    }

    public void transformuj(List<PraktykaZawodowa> listaPraktykRpwdl, String nazwaPliku,Map<Integer,String>listaKluczy) throws TransformerFactoryConfigurationError, TransformerConfigurationException, FactoryConfigurationError, XMLStreamException, FileNotFoundException, IOException, TransformerException, JAXBException, InterruptedException {
        TransformerFactory factory = TransformerFactory.newInstance();

        Source xslt = new StreamSource(new File("src/main/resources/praktyki_import.xsl"));
        Source xml = new StreamSource(new File("src/main/resources/" + nazwaPliku));

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


        JAXBContext jaxbContext = JAXBContext.newInstance(PrownanieRpwdlBinarySearch.ListaPraktyk.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        boolean przetwarzaniePojedynczejPozycji = false;
        int id = 0;//todo:::::::::::
        List<String> ksiegiRejestroweBlednychPraktyk = new ArrayList<String>();
        int liczbaSprawdzonych = 0;
        int temp = 100;
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
//                sprawdzPoprawnoscRpwdl(unmarshaller, pojedynczPozycja,ksiegiRejestroweBlednychPraktyk);//todo!!!!!!!!!!!!!! do poprawnosci rpwdl id
                liczbaSprawdzonych++;
                stworzListeKluczy(unmarshaller, pojedynczPozycja,listaKluczy,liczbaSprawdzonych); //todo!!!!!!!!!!!!!! do poprawnosci rpwdl klucze
//                dodajPraktykeDoListy(unmarshaller, pojedynczPozycja, listaPraktykRpwdl);//todo:::::::::::
//                sprawdzNowePrzypadki(unmarshaller, pojedynczPozycja);
                przetwarzaniePojedynczejPozycji = false;
                count++;
                if (liczbaSprawdzonych>temp){
                    System.out.println("sprawdzono: "+liczbaSprawdzonych);
                    temp=liczbaSprawdzonych+200;
                }
            } else {
                if (przetwarzaniePojedynczejPozycji) {
                    writer.add(nextEvent);
                }
            }
        }
//        bledneRpwdle(ksiegiRejestroweBlednychPraktyk);//todo!!!!!!!!!!!!!! do poprawnosci rpwdl id
    }

    private void sprawdzNowePrzypadki(Unmarshaller unmarshaller, ByteArrayInputStream pojedynczPozycja) throws JAXBException {
        final ListaPraktyk uslugodawcaZXML = (ListaPraktyk) unmarshaller.unmarshal(pojedynczPozycja);
        System.out.println("size listy na podstawie rodzaje dzialanosci: "+uslugodawcaZXML.getPraktykaZawodowa().size());
        if (uslugodawcaZXML.getPraktykaZawodowa() != null && uslugodawcaZXML.getPraktykaZawodowa()
                .size() > 0) {
            for (PraktykaZawodowa pz:uslugodawcaZXML.getPraktykaZawodowa()
                 ) {
                System.out.println(" wynik: "+pz.toString());
                System.out.println("----------------------- ");
            }
        }
    }

    private void bledneRpwdle(List<String> ksiegiRejestroweBlednychPraktyk){
        System.out.println("rozmiar blednej listy: "+ksiegiRejestroweBlednychPraktyk.size());
        if (ksiegiRejestroweBlednychPraktyk.size()>0){
            for (String numery:ksiegiRejestroweBlednychPraktyk
                 ) {
                System.out.println("bledna ksiega: "+numery);
            }
        }else {
            System.out.println("WSZYTKIE SA OK");
        }
    }
    private void sprawdzPoprawnoscRpwdl(Unmarshaller unmarshaller, ByteArrayInputStream pojedynczPozycja, List<String> ksiegiRejestroweBlednychPraktyk) throws JAXBException {
        final ListaPraktyk uslugodawcaZXML = (ListaPraktyk) unmarshaller.unmarshal(pojedynczPozycja);
        if (uslugodawcaZXML.getPraktykaZawodowa() != null && uslugodawcaZXML.getPraktykaZawodowa()
                .size() > 0) {
            int count;
            boolean blad =false;
            for (PraktykaZawodowa pz:uslugodawcaZXML.getPraktykaZawodowa()
                 ) {
                count=0;
                if (blad){
                    break;
                }
                for (PraktykaZawodowa pz2:uslugodawcaZXML.getPraktykaZawodowa()
                     ) {
                    if (pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki().equals(pz2.getKodIdentyfikujacyMiejsceSwiadczenPraktyki())){
                        count++;
                    }
                    if (count > 1 ){
                        ksiegiRejestroweBlednychPraktyk.add(pz.getNrKsiegiRejestrowej());
                        blad = true;
                        break;
                    }
                }
            }
        }
    }
    private void stworzListeKluczy(Unmarshaller unmarshaller, ByteArrayInputStream pojedynczPozycja, Map<Integer,String>klucze, int liczbaSprawdzonych) throws JAXBException {
        final ListaPraktyk uslugodawcaZXML = (ListaPraktyk) unmarshaller.unmarshal(pojedynczPozycja);
        List<String> brakDanychDoKlucza = new ArrayList<String>();
        List<String> uslugodawcaBezPraktyki = new ArrayList<String>();
        Map<Integer,String> takiesameKlucze= new HashMap<Integer, String>();
        List<Long> numerPraktyk = new ArrayList<Long>();
        if (uslugodawcaZXML.getPraktykaZawodowa()!=null && uslugodawcaZXML.getPraktykaZawodowa().size() > 0){
            if (uslugodawcaZXML.getPraktykaZawodowa().get(0).getNrKsiegiRejestrowej()==null || uslugodawcaZXML.getPraktykaZawodowa().get(0).getKodOrganuRejestrowego().getKod()==null){
                brakDanychDoKlucza.add(uslugodawcaZXML.getPraktykaZawodowa().get(0).getNrKsiegiRejestrowej());
            }else {
                String kluczPraktyki = uslugodawcaZXML.getPraktykaZawodowa().get(0).getNrKsiegiRejestrowej() + uslugodawcaZXML.getPraktykaZawodowa().get(0).getKodOrganuRejestrowego().getKod();
                klucze.put(liczbaSprawdzonych,kluczPraktyki);
            }
        }else {
            System.out.println("praktyka null.... omg numer praktyki: "+liczbaSprawdzonych);
        }
        for (String s:brakDanychDoKlucza
             ) {
            System.out.println("bledna praktyka, brak elementu klucza: "+s);
        }
    }

    private void dodajPraktykeDoListy(Unmarshaller unmarshaller, ByteArrayInputStream pojedynczPozycja, List<PraktykaZawodowa> listaPraktykRpwdl) throws JAXBException {
        final ListaPraktyk uslugodawcaZXML = (ListaPraktyk) unmarshaller.unmarshal(pojedynczPozycja);
        if (uslugodawcaZXML.getPraktykaZawodowa() != null && uslugodawcaZXML.getPraktykaZawodowa()
                                                                            .size() > 0) {
            listaPraktykRpwdl.addAll(uslugodawcaZXML.getPraktykaZawodowa());
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
