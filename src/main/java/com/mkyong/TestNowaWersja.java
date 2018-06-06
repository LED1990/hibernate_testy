package com.mkyong;

import smz.zgl.daneref.ud.KodOrganuRejestrowego;
import smz.zgl.daneref.ud.PraktykaZawodowa;
import smz.zgl.daneref.ud.Status;
import smz.zgl.daneref.ud.Uslugodawca;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestNowaWersja {
    public static void main(String[] args) {

        TestNowaWersja app = new TestNowaWersja();
        OperacjeNaXML operacjeNaXML = new OperacjeNaXML();

        List<Uslugodawca> listaZBazy = new ArrayList<Uslugodawca>();
        List<PraktykaZawodowa> praktykiRpwdl = operacjeNaXML.wykonajOperacjeXML();
        Set<String> wynik = new HashSet<String>();

        app.przygotujDaneZBazy(listaZBazy);

        app.przetworzUslugodawce(praktykiRpwdl,listaZBazy,wynik);

        System.out.println("+++++++++++ WYNIK +++++++++++++++++++");
        for (String us:wynik
             ) {
            System.out.println(us);
        }
    }

    private void przygotujDaneZBazy(List<Uslugodawca> listaZBazy) {
        PraktykaZawodowa p1 = new PraktykaZawodowa();
        PraktykaZawodowa p2 = new PraktykaZawodowa();
        PraktykaZawodowa p3 = new PraktykaZawodowa();
        PraktykaZawodowa p4 = new PraktykaZawodowa();

        p1.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("001");
        p2.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("002");
        p3.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("003");
        p4.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("004");

        listaZBazy.add(utworzUslgodawce(1L,Status.AKTUALNY,p1));
        listaZBazy.add(utworzUslgodawce(1L,Status.AKTUALNY,p2));
        listaZBazy.add(utworzUslgodawce(1L,Status.AKTUALNY,p3));
        listaZBazy.add(utworzUslgodawce(1L,Status.NIEAKTUALNY,p4));

    }


    public void przetworzUslugodawce(List<PraktykaZawodowa> praktykiZawodowe, List<Uslugodawca> uslugodawcyPraktykZBazy, Set<String> wynik) {
        String kluczPraktyki = praktykiZawodowe.get(0)
                                               .getNrKsiegiRejestrowej() + praktykiZawodowe.get(0)
                                                                                           .getKodOrganuRejestrowego()
                                                                                           .getKod();
        //        List<Uslugodawca> uslugodawcyPraktykZBazy = uslugodawcaUsluga.pobierzUslugodawcowPraktyki(kluczPraktyki, Status.PRZETWARZANY, Status.AKTUALNY);//TODO QUERY
        Set<Uslugodawca> uslugodawcyDoZapisania = new HashSet<Uslugodawca>();

        if (uslugodawcyPraktykZBazy == null || uslugodawcyPraktykZBazy.isEmpty()) {
            dodajNowaPraktykiDoZapisania(praktykiZawodowe, uslugodawcyDoZapisania, kluczPraktyki);
        } else {
            //TODO tu moze byc tak że liczba adresow sie zwiekszyla lub zmniejszyla, trzeba bedzie dodac na to logike! (uslugodawcyPraktykZBazy < lub > praktykiZawodowe
            porownajBazeZRpwdl(praktykiZawodowe, uslugodawcyPraktykZBazy, uslugodawcyDoZapisania, kluczPraktyki,wynik);
            porownajRpwdlZBaza(praktykiZawodowe, uslugodawcyPraktykZBazy, uslugodawcyDoZapisania, kluczPraktyki,wynik);
        }
//        uslugodawcaUsluga.zapiszWieluUslugodawcow(uslugodawcyDoZapisania);//TODO ostatni krok
    }

    private void porownajRpwdlZBaza(List<PraktykaZawodowa> praktykiZawodowe, List<Uslugodawca> uslugodawcyPraktykZBazy, Set<Uslugodawca> uslugodawcyDoZapisania, String kluczPraktyki,Set<String> wynik) {
        boolean praktykaWystapila;
        for (PraktykaZawodowa pz : praktykiZawodowe) {
            praktykaWystapila = false;
            for (Uslugodawca us : uslugodawcyPraktykZBazy) {
                if (us.getPraktykaZawodowa()
                      .getKodIdentyfikujacyMiejsceSwiadczenPraktyki()
                      .equals(pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki())) {
                    praktykaWystapila = true;
                    ustawDaneUslugodawcy(us,pz);
                    uslugodawcyDoZapisania.add(us);
                    wynik.add("jest w rpwdl i w bazie - porwnac statusy i zmienic w razie potrzeby");//TODO
                    break;
                    //TODO: sprawdzic czy wszystkie zagniezdzone klasy dobrze sie aktualizauja!!!!!!!!!!
                }
            }
            if (!praktykaWystapila) {
                //trzeba dodac nowa praktyke do bazy!
                uslugodawcyDoZapisania.add(utworzNowegoUslugodawce(pz, kluczPraktyki));
            }
        }
    }

    private void porownajBazeZRpwdl(List<PraktykaZawodowa> praktykiZawodowe, List<Uslugodawca> uslugodawcyPraktykZBazy, Set<Uslugodawca> uslugodawcyDoZapisania, String kluczPraktyki,Set<String> wynik) {
        boolean uslugodawcaWystapil;
        for (Uslugodawca us : uslugodawcyPraktykZBazy) {
            uslugodawcaWystapil = false;
            for (PraktykaZawodowa pz : praktykiZawodowe) {
                if (pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki()
                      .equals(us.getPraktykaZawodowa()
                                .getKodIdentyfikujacyMiejsceSwiadczenPraktyki())) {
                    uslugodawcaWystapil = true;
                    ustawDaneUslugodawcy(us, pz);
                    uslugodawcyDoZapisania.add(us);
                    wynik.add("aktualizacja istniejacego + zmiana statusow jak trzeba");
                    break;
                    //TODO: sprawdzic czy wszystkie zagniezdzone klasy dobrze sie aktualizauja!!!!!!!!!!
                }
            }
            if (!uslugodawcaWystapil) {
                //trzeba zmienic status na nieaktualny - w nowym rpwdl nie ma adresu z bazy
                us.setStatus(Status.NIEAKTUALNY);
                uslugodawcyDoZapisania.add(us);
            }
        }
    }

    private void ustawDaneUslugodawcy(Uslugodawca us, PraktykaZawodowa pz) {
//        pz.getAdres()
//          .setId(us.getPraktykaZawodowa()
//                   .getAdres()
//                   .getId());
//        pz.setId(us.getPraktykaZawodowa()
//                   .getId());
//        pz.setKluczPraktyki(us.getPraktykaZawodowa()
//                              .getKluczPraktyki());
//        pz.getPraktykaZawodowaOsoba()
//          .setId(us.getPraktykaZawodowa()
//                   .getPraktykaZawodowaOsoba()
//                   .getId());
//        pz.getPraktykaZawodowaOsoba()
//          .getDaneOsobowe()
//          .setId(us.getPraktykaZawodowa()
//                   .getPraktykaZawodowaOsoba()
//                   .getDaneOsobowe()
//                   .getId());
        us.setPraktykaZawodowa(pz);
        us.setStatus(ustawStatusUslugodawcy(pz));
    }

    private Set<Uslugodawca> dodajNowaPraktykiDoZapisania(List<PraktykaZawodowa> praktykiZawodowe, Set<Uslugodawca> uslugodawcyDoZapisania, String kluczPraktyki) {
        for (PraktykaZawodowa pz : praktykiZawodowe) {
            uslugodawcyDoZapisania.add(utworzNowegoUslugodawce(pz, kluczPraktyki));
        }
        return uslugodawcyDoZapisania;
    }

    private Uslugodawca utworzNowegoUslugodawce(PraktykaZawodowa pz, String kluczPraktyki) {
        Uslugodawca uslugodawcaDoZapisu = new Uslugodawca();
        uslugodawcaDoZapisu.setSpozaRejestru(false);
        pz.setKluczPraktyki(kluczPraktyki);
        uslugodawcaDoZapisu.setPraktykaZawodowa(pz);
        uslugodawcaDoZapisu.setStatus(ustawStatusUslugodawcy(pz));
        return uslugodawcaDoZapisu;
    }

    private Status ustawStatusUslugodawcy(PraktykaZawodowa praktykaZawodowa) {
        if (praktykaZawodowa.getDataWykreslenia() == null) {
            return Status.AKTUALNY;
        } else {
            return praktykaZawodowa.getDataWykreslenia()
                                   .compareTo(new Date()) >= 0 ? Status.AKTUALNY : Status.NIEAKTUALNY;//TODO przetestowac to dobrze!
        }
    }

    private Uslugodawca utworzUslgodawce(Long id, Status status, PraktykaZawodowa praktykaZawodowa) {
        Uslugodawca uslugodawca = new Uslugodawca();
        uslugodawca.setId(id);
        uslugodawca.setStatus(status);
        uslugodawca.setPraktykaZawodowa(praktykaZawodowa);
        return uslugodawca;
    }

    private PraktykaZawodowa utworzPraktyKeDlaUslugodawcyBazy(Long id, String kodIdentyfikujacy) {
        KodOrganuRejestrowego kodOrganuRejestrowego = new KodOrganuRejestrowego();
        kodOrganuRejestrowego.setKod("50");
        PraktykaZawodowa praktykaZawodowa = new PraktykaZawodowa();
        praktykaZawodowa.setId(id);
        praktykaZawodowa.setKodIdentyfikujacyMiejsceSwiadczenPraktyki(kodIdentyfikujacy);
        praktykaZawodowa.setNrKsiegiRejestrowej("000000028910");
        praktykaZawodowa.setKodOrganuRejestrowego(kodOrganuRejestrowego);
        return praktykaZawodowa;
    }
}
