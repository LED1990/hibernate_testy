package com.mkyong;

import com.mkyong.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import smz.adm.Wniosek;
import smz.zgl.daneref.ud.PraktykaZawodowa;
import smz.zgl.daneref.ud.Status;
import smz.zgl.daneref.ud.Uslugodawca;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Naprawianie {
    @PersistenceContext
    protected EntityManager entityManager;

    public static void main(String[] args) throws InterruptedException, IOException, TransformerException, JAXBException, XMLStreamException {
        Session session = HibernateUtil.getSessionFactory()
                                       .openSession();
        Naprawianie app = new Naprawianie();
//        OperacjeNaXML operacjeNaXML = new OperacjeNaXML();
        PrownanieRpwdlBinarySearch rpwdl = new PrownanieRpwdlBinarySearch();
//        List<Uslugodawca> uslugodawcyBaza = app.pobierzUslugodawcowPraktyki(session, Status.PRZETWARZANY);
        //        System.out.println("rozmiar listy wynkowej: "+uslugodawcyBaza.size());

        //        Wniosek wniosek = app.pobierzWniosek(session,"2018/3");
        //        app.zmienWniosek(wniosek);
        //TODO pobrac wsyztskich z bazy danych


//        List<Uslugodawca> wszyscyUslugodawcyZBazy = app.pobierzUslugodawcowPraktykiZBazy(session,numerKsiegi);
        String nazwPlikuRpwdl = "nowySkrocony.xml";
        List<PraktykaZawodowa> listaPraktykRpwdlStary = new ArrayList<PraktykaZawodowa>();
        rpwdl.transformuj(listaPraktykRpwdlStary,nazwPlikuRpwdl,new HashMap<Integer, String>());
        System.out.println("size rpwdl: "+listaPraktykRpwdlStary.size());
//
//        //TODO porownac wszystkich z bazy z rpwdl ostatnim wgranym!!
//        List<PraktykaZawodowa> listaPraktyk = operacjeNaXML.wykonajOperacjeXML();
//        List<Wniosek> wnioskiPraktykZBazy = app.pobierzWniskiPraktykZawodowych();
//        app.porownajBazeZRpwdl(wszyscyUslugodawcyZBazy, listaPraktyk, wnioskiPraktykZBazy);

//        app.testSetBazy();

    }



    private void porownajBazeZRpwdl(List<Uslugodawca> listaZBazy, List<PraktykaZawodowa> listaRpwdl, List<Wniosek> listaWnioskowPraktyk) {
        //todo wewnatrz orzetworz pojedyncza pozycje
        //todo porownac baze z rpwdl i namierzyc klony!
        int count = 0;
        System.out.println("lista z bazy size: " + listaZBazy.size());
        System.out.println("lista praktyk size: " + listaRpwdl.size());
        List<Uslugodawca> tacySamiUslugodawcy = new ArrayList<Uslugodawca>();
        for (Uslugodawca us : listaZBazy) {
            for (PraktykaZawodowa pz : listaRpwdl) {
                //todo po czym rozpoznawac praktyki??!
                if (us.getPraktykaZawodowa()
                      .getNrKsiegiRejestrowej()
                      .equals(pz.getNrKsiegiRejestrowej()) && us.getPraktykaZawodowa()
                                                                .getIdPraktyki()
                                                                .equals(pz.getIdPraktyki()) && us.getPraktykaZawodowa()
                                                                                                 .getPraktykaZawodowaOsoba()
                                                                                                 .getNip()
                                                                                                 .equals(pz.getPraktykaZawodowaOsoba()
                                                                                                           .getNip())) {
                    count++;
                    //todo mozna dodac dodatkowe sprawdzenie czy na pewno sa klony (np po adresach czy danych osobowych)
//                    //todo zakladam ze to wystarczy by okreslic praktyke
//                    if (tacySamiUslugodawcy.size() == 0) {
//                        tacySamiUslugodawcy.add(us);
//                    } else {
//                        //todo na wszelki wypadek sprawdzac czy kazdy kolejny jest faktycznie klonem pierwszego - MOZNA DODAC WIECEJ WARUNKOW
//                        PraktykaZawodowa usPierwszy = tacySamiUslugodawcy.get(0)
//                                                                         .getPraktykaZawodowa();
//                        if (us.getPraktykaZawodowa()
//                              .getNrKsiegiRejestrowej()
//                              .equals(usPierwszy.getNrKsiegiRejestrowej()) && us.getPraktykaZawodowa()
//                                                                                .getIdPraktyki()
//                                                                                .equals(usPierwszy.getIdPraktyki()) && us.getPraktykaZawodowa()
//                                                                                                                         .getPraktykaZawodowaOsoba()
//                                                                                                                         .getNip()
//                                                                                                                         .equals(usPierwszy.getPraktykaZawodowaOsoba()
//                                                                                                                                           .getNip())) {
//                        }
//                    }
                    tacySamiUslugodawcy.add(us);
                    break;
                }
            }
        }
        System.out.println("---------------------- liczba takich samych praktyk: " + count);
        System.out.println("=================== przed nadaniem kluczy =====================");
        wyswietlListeUslugodawcow(tacySamiUslugodawcy);
        if (tacySamiUslugodawcy.size() > 0) {
            okreslKluczIIdMiejscaNaPodstawieAdresu(tacySamiUslugodawcy, listaRpwdl);
        }
        System.out.println("=================== po nadaniu kluczy =====================");
        wyswietlListeUslugodawcow(tacySamiUslugodawcy);

        Set<Wniosek> wnioskiDoUpadte = new HashSet<Wniosek>();
        Set<Uslugodawca> uslugowcyDoUpdate = new HashSet<Uslugodawca>();//im dodac klucz i id
        Set<Uslugodawca> uslugodawcyDoUsuniecia = new HashSet<Uslugodawca>();//dla nich sprawdzic czy sa wnioski i przekierwac do aktualnych

        //todo po nadaniu kluczy trzeba przepiac wnioski do aktualnych i wywalic niepotrzebnych uslugodawcow
        okreslWnioskiDoUpdatu(tacySamiUslugodawcy, wnioskiDoUpadte, listaWnioskowPraktyk);
        okreslUslugodawcowDoUpdateIUsuniecia(tacySamiUslugodawcy, uslugowcyDoUpdate, uslugodawcyDoUsuniecia);

        wykonajOperacjeNaBazie(wnioskiDoUpadte, uslugowcyDoUpdate, uslugodawcyDoUsuniecia);
        if (true)
        {
            System.out.println("KONIEC");
        }
    }

    private void updateWnioskow(Set<Wniosek> wnioskiDoUpadte){

    }

    private void wykonajOperacjeNaBazie(Set<Wniosek> wnioskiDoUpadte, Set<Uslugodawca> uslugowcyDoUpdate, Set<Uslugodawca> uslugodawcyDoUsuniecia) {
        Session session = HibernateUtil.getSessionFactory()
                                       .openSession();
        session.beginTransaction();
//todo update wnioskow
//        for (Wniosek wn : wnioskiDoUpadte) {
//            session.merge(wn);
//        }
//        session.getTransaction()
//               .commit();
        //todo update uslugodawcow
        for (Uslugodawca us : uslugowcyDoUpdate) {
            session.merge(us);
        }
        session.getTransaction()
               .commit();
        //todo usuniecie niepotrzebnych praktyk - NIE MOZNA USUWAC BO NIE WIADOMO JAKIE SA POWIAZANA
//        for (Uslugodawca us : uslugodawcyDoUsuniecia) {
//            session.delete(us);
//        }
//        session.getTransaction()
//               .commit();
        session.close();
    }

    private void okreslUslugodawcowDoUpdateIUsuniecia(List<Uslugodawca> tacySamiUslugodawcy, Set<Uslugodawca> uslugowcyDoUpdate, Set<Uslugodawca> uslugodawcyDoUsuniecia) {
        for (Uslugodawca us : tacySamiUslugodawcy) {
            if (us.getStatus() == Status.AKTUALNY) {
                uslugowcyDoUpdate.add(us);
            }
            if (us.getStatus() == Status.NIEAKTUALNY) {
                uslugodawcyDoUsuniecia.add(us);
            }
        }
    }

    private void okreslWnioskiDoUpdatu(List<Uslugodawca> tacySamiUslugodawcy, Set<Wniosek> wnioskiDoUpadte, List<Wniosek> listaWnioskowPraktyk) {
        for (Wniosek w : listaWnioskowPraktyk) {
            for (Uslugodawca us : tacySamiUslugodawcy) {
                if (w.getUslugowawca()
                     .getId()
                     .equals(us.getId()) && us.getStatus() == Status.NIEAKTUALNY) {
                    //todo znajdz aktualna wersje nieaktualnego uslugodawcy
                    System.out.println("usid: " + us.getId() + " wUsId: " + w.getUslugowawca()
                                                                             .getId());
                    for (Uslugodawca us2 : tacySamiUslugodawcy) {
                        if (us.getPraktykaZawodowa()
                              .getKodIdentyfikujacyMiejsceSwiadczenPraktyki()
                              .equals(us2.getPraktykaZawodowa()
                                         .getKodIdentyfikujacyMiejsceSwiadczenPraktyki()) && us2.getStatus() == Status.AKTUALNY) {
                            w.setUslugowawca(us2);
                            wnioskiDoUpadte.add(w);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void okreslKluczIIdMiejscaNaPodstawieAdresu(List<Uslugodawca> usTacySami, List<PraktykaZawodowa> praktykiRpwdl) {
        for (Uslugodawca us : usTacySami) {
            for (PraktykaZawodowa pz : praktykiRpwdl) {
                if (us.getPraktykaZawodowa()
                      .getAdres()
                      .getKodPocztowy()
                      .equals(pz.getAdres()
                                .getKodPocztowy()) && us.getPraktykaZawodowa()
                                                        .getAdres()
                                                        .getUlica()
                                                        .equals(pz.getAdres()
                                                                  .getUlica()) && us.getPraktykaZawodowa()
                                                                                    .getAdres()
                                                                                    .getWojewodztwo()
                                                                                    .equals(pz.getAdres()
                                                                                              .getWojewodztwo())) {

                    if (us.getPraktykaZawodowa().getKodIdentyfikujacyMiejsceSwiadczenPraktyki() == null){
                        String kluczPraktyki = pz.getNrKsiegiRejestrowej() + pz.getKodOrganuRejestrowego()
                                                                               .getKod();
                        us.getPraktykaZawodowa()
                          .setKluczPraktyki(kluczPraktyki);
                        us.getPraktykaZawodowa()
                          .setKodIdentyfikujacyMiejsceSwiadczenPraktyki(pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki());
                    }
                }
            }
        }
    }

    private void wyswietlListeUslugodawcow(List<Uslugodawca> lista) {
        for (Uslugodawca us : lista) {
            System.out.println("id: " + us.getId() + " status: " + us.getStatus() + " klucz: " + us.getPraktykaZawodowa()
                                                                                                   .getKluczPraktyki() + " kod: " + us.getPraktykaZawodowa()
                                                                                                                                      .getKodIdentyfikujacyMiejsceSwiadczenPraktyki());
        }
    }

    private void zmienWniosek(Wniosek wniosek) {
        Session session = HibernateUtil.getSessionFactory()
                                       .openSession();

        System.out.println(wniosek.getId());
        wniosek.getUslugowawca()
               .setId(1L);

        session.beginTransaction();
        session.merge(wniosek);
        session.getTransaction()
               .commit();
        session.close();
    }

    public List<Uslugodawca> pobierzUslugodawcowPraktykiZBazy(Session session, String numerKsiegirejestrowej) {
        String hql = "FROM Uslugodawca u " + "LEFT JOIN FETCH u.praktykaZawodowa pz "+"" + "LEFT JOIN FETCH pz.adres a " + "" + "" + "WHERE u.komorkaOrganizacyjna is null "+"and pz.nrKsiegiRejestrowej = :numerKsiegi";
        List<Uslugodawca> uslugodawcaZBazy;
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("numerKsiegi",numerKsiegirejestrowej);
        uslugodawcaZBazy = query.list();
        session.close();
        return uslugodawcaZBazy;
    }

    private List<Wniosek> pobierzWniskiPraktykZawodowych() {
        Session session = HibernateUtil.getSessionFactory()
                                       .openSession();
        List<Wniosek> wniskiZBazy;
        String hql = "FROM Wniosek " + "WHERE uslugowawca is not null";
        session.beginTransaction();
        Query query = session.createQuery(hql);
        wniskiZBazy = query.list();
        session.close();
        return wniskiZBazy;
    }

    public Wniosek pobierzWniosek(Session session, String idWniosku) {
        Map<String, Object> params = new HashMap<String, Object>();
        String hql = "SELECT w FROM Wniosek w" + " LEFT JOIN w.organizacja o" + " LEFT JOIN w.uslugowawca u" + " LEFT JOIN u.praktykaZawodowa pz" + " LEFT JOIN u.komorkaOrganizacyjna ko" + " LEFT JOIN o.adres oa" + " LEFT JOIN pz.adres pza" + " LEFT JOIN ko.adres koa" + " WHERE w.idWniosku = :idWniosku";
        Wniosek wniosek;
        params.put("idWniosku", idWniosku);

        session.beginTransaction();

        Query query = session.createQuery(hql);
        query.setParameter("idWniosku", idWniosku);

        wniosek = (Wniosek) query.list()
                                 .get(0);

        session.close();

        return wniosek;
    }
    private void testSetBazy() {
        Session session = HibernateUtil.getSessionFactory()
                                       .openSession();
        String hql = "UPDATE ParametryKonfiguracyjne pk SET pk.wartosc = :komorka WHERE pk.id = :param";
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("komorka","wowowo");
        query.setParameter("param",99L);
        session.getTransaction().commit();
        session.close();
    }
}
