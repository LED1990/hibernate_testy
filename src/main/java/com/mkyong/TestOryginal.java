//package com.mkyong;
//
//import com.mkyong.util.HibernateUtil;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import smz.zgl.daneref.Adres;
//import smz.zgl.daneref.DaneOsobowe;
//import smz.zgl.daneref.ud.*;
//
//import javax.print.DocFlavor;
//import java.util.*;
//
//public class TestOryginal {
//
//    public static void main(String[] args) {
//
//        TestOryginal test = new TestOryginal();
//
//        System.out.println("Start");
//
//
//        //        Session session = HibernateUtil.getSessionFactory()
//        //                .openSession();
//
//        //        test.zapiszUslugodawce(session);
//        //        test.uaktualnijUslugodawce(session);
//
//        //        test.przykladowaLogikaUpdatu(session);//TODO dziala to jakos
//
//        //TODO test czy mozna dynamicznie robic update listy
//        //        List<PraktykaZawodowa> listaStartowa = test.stwurzListeUslugodawcowRpwdl();
//        //        for (PraktykaZawodowa pz:listaStartowa
//        //             ) {
//        //            pz.setNazwa("SLIM!!!!");
//        //        }
//        //        for (PraktykaZawodowa pz2:listaStartowa
//        //             ) {
//        //            System.out.println(pz2.getNazwa());
//        //        }
//        OperacjeNaXML operacjeNaXML = new OperacjeNaXML();
//        List<PraktykaZawodowa> praktykiRpwdl = operacjeNaXML.wykonajOperacjeXML();
//        List<Uslugodawca> praktykiZBazy = new ArrayList<Uslugodawca>();
//
//        PraktykaZawodowa p1 = test.utworzPraktyKeDlaUslugodawcyBazy(1L,"001");
//        PraktykaZawodowa p2 = test.utworzPraktyKeDlaUslugodawcyBazy(2L,"002");
//        PraktykaZawodowa p3 = test.utworzPraktyKeDlaUslugodawcyBazy(3L,"003");
//        PraktykaZawodowa p4 = test.utworzPraktyKeDlaUslugodawcyBazy(4L,"004");
//
//        Uslugodawca u1= test.utworzUslgodawce(1L,Status.AKTUALNY,p1);
//        Uslugodawca u2= test.utworzUslgodawce(1L,Status.AKTUALNY,p2);
//        Uslugodawca u3= test.utworzUslgodawce(1L,Status.AKTUALNY,p3);
//        Uslugodawca u4= test.utworzUslgodawce(1L,Status.NIEAKTUALNY,p4);
//        praktykiZBazy.add(u1);
//        praktykiZBazy.add(u2);
//        praktykiZBazy.add(u3);
//        praktykiZBazy.add(u4);
//
//        test.logikaSprawdzaniaAdresow(praktykiRpwdl,praktykiZBazy);
////        OperacjeNaXML operacjeNaXML = new OperacjeNaXML();
//
//        System.out.println("GOTOWE!");
//
//    }
//
//    private Uslugodawca utworzUslgodawce(Long id, Status status, PraktykaZawodowa praktykaZawodowa){
//        Uslugodawca uslugodawca = new Uslugodawca();
//        uslugodawca.setId(id);
//        uslugodawca.setStatus(status);
//        uslugodawca.setPraktykaZawodowa(praktykaZawodowa);
//        return uslugodawca;
//    }
//    private PraktykaZawodowa utworzPraktyKeDlaUslugodawcyBazy(Long id, String kodIdentyfikujacy){
//        PraktykaZawodowa praktykaZawodowa = new PraktykaZawodowa();
//        praktykaZawodowa.setId(id);
//        praktykaZawodowa.setKodIdentyfikujacyMiejsceSwiadczenPraktyki(kodIdentyfikujacy);
//        return praktykaZawodowa;
//    }
//
//    private Status ustawStatusUslugodawcy(PraktykaZawodowa praktykaZawodowa) {
//        if (praktykaZawodowa.getDataWykreslenia() == null){
//            return Status.AKTUALNY;
//        }else {
//            return praktykaZawodowa.getDataWykreslenia().compareTo(new Date()) >= 0 ? Status.AKTUALNY : Status.NIEAKTUALNY;//TODO przetestowac to dobrze!
//        }
//    }
//
//    private void logikaSprawdzaniaAdresow(List<PraktykaZawodowa> praktykaZawodowaRpwdl, List<Uslugodawca> uslugodawcyBaza) {
//        Set<String> doZapisu = new HashSet<String>();
//
//        tyleSamo(praktykaZawodowaRpwdl, uslugodawcyBaza, doZapisu);
//        for (String s:doZapisu
//                ) {
//            System.out.println("----- "+s);
//        }
//    }
//
//
//    private void tyleSamo(List<PraktykaZawodowa> praktykiRpwdl, List<Uslugodawca> uslugodawcy, Set<String> doZapisu) {
//        boolean flagaWystapil;
//
//        System.out.println("==================== DANE WEJSCIOWE =================================");
//        for (PraktykaZawodowa pz : praktykiRpwdl) {
//            System.out.println("rpwdl: " + pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki() + " ");
//        }
//        for (Uslugodawca us : uslugodawcy) {
//            System.out.println("baza danych: " + us.getPraktykaZawodowa()
//                                                   .getKodIdentyfikujacyMiejsceSwiadczenPraktyki()+" "+us.getStatus());
//        }
//        System.out.println("============================== WYNIK ===============================");
//
//        //TODO: sprawdzanie zmian w uslugodawcach
//        for (Uslugodawca us : uslugodawcy) {
//            flagaWystapil = false;
//            for (PraktykaZawodowa pz : praktykiRpwdl) {
//                if (pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki()
//                      .equals(us.getPraktykaZawodowa()
//                                .getKodIdentyfikujacyMiejsceSwiadczenPraktyki())) {
//                    flagaWystapil = true;
//
//                    doZapisu.add("aktualizacja uslugodawcy: "+us.getPraktykaZawodowa().getKodIdentyfikujacyMiejsceSwiadczenPraktyki());//TODO po wczesniejszym ustawieniu parametrow!
//                    System.out.println("ustawioneDane");
//                    break;//TODO wiecej sparwdzac nie trzeba
//                }
//            }
//            if (!flagaWystapil) {
//
//                //TODO: ustaw status na nieaktualny!
//                System.out.println("nie wystapil trzeba zmienic status na nieaktualny!!!!");
//                doZapisu.add("zmienic na nieaktualny: "+us.getPraktykaZawodowa().getKodIdentyfikujacyMiejsceSwiadczenPraktyki());
//            }
//        }
//
//        //TODO: sprawdzanie zmian w praktykach
//        for (PraktykaZawodowa pz : praktykiRpwdl) {
//            flagaWystapil = false;
//            for (Uslugodawca us : uslugodawcy) {
//                if (pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki()
//                      .equals(us.getPraktykaZawodowa()
//                                .getKodIdentyfikujacyMiejsceSwiadczenPraktyki())) {
//                    flagaWystapil = true;
//                    break;//TODO nie trzeba dalej sprawdzac
//                }
//            }
//            if (!flagaWystapil) {
//                doZapisu.add("dodac nowa praktyke: "+pz.getKodIdentyfikujacyMiejsceSwiadczenPraktyki());
//                System.out.println("nowa praktyka do dodania!!!!!");
//                //TODO metoda do dodawania nowych praktyk!
//            }
//        }
//    }
//
//
//    private void ustawDaneUslugodawcy(Uslugodawca us, PraktykaZawodowa pz) {
//        //        pz.getAdres().setId(us.getPraktykaZawodowa().getAdres().getId());
//        //        pz.setId(us.getPraktykaZawodowa().getId());
//        //        pz.setKluczPraktyki(us.getPraktykaZawodowa().getKluczPraktyki());
//        //        pz.getPraktykaZawodowaOsoba().setId(us.getPraktykaZawodowa().getPraktykaZawodowaOsoba().getId());
//        //        pz.getPraktykaZawodowaOsoba().getDaneOsobowe().setId(us.getPraktykaZawodowa().getPraktykaZawodowaOsoba().getDaneOsobowe().getId());
//        us.setPraktykaZawodowa(pz);
//        //        us.setStatus(ustawStatusUslugodawcy(pz));
//        //        uslugodawcyDoZapisania.add(us);
//        //        return us;
//
//    }
//
//    private List<Uslugodawca> utworzListeZBazy() {
//        List<Uslugodawca> listaZBazy = new ArrayList<Uslugodawca>();
//        List<PraktykaZawodowa> listaPraktyk = stwurzListeUslugodawcowRpwdl();
//
//        for (PraktykaZawodowa pz : listaPraktyk) {
//            Uslugodawca uslugodawca = new Uslugodawca();
//            uslugodawca.setPraktykaZawodowa(pz);
//            listaZBazy.add(uslugodawca);
//        }
//        return listaZBazy;
//    }
//
//    private void przykladowaLogikaUpdatu(Session session) {
//        List<PraktykaZawodowa> praktykaZawodowaRpwdl = stwurzListeUslugodawcowRpwdl();
//        List<Uslugodawca> uslugodawcyBaza = pobierzUslugodawcowZBazy(session, praktykaZawodowaRpwdl.get(0)
//                                                                                                   .getIdPraktyki());
//        List<Uslugodawca> uslugodawcaDoZapisu = new ArrayList<Uslugodawca>();
//
//        //TODO co jak dojdzie adres !?
//        //TODO co jak zniknie adres !?
//
//        if (uslugodawcyBaza != null) {
//            if (uslugodawcyBaza.size() > 0) {
//                //TODO: to znaczy ze jest co aktualizowac!!
//                //TODO narazie tylko przypadek aktualizacji danych (bez nikania i pojawinia adresow)
//                for (Uslugodawca uslugodawca : uslugodawcyBaza) {
//
//                    //                    String idPraktyki = String.valueOf(uslugodawca.getPraktykaZawodowa().getIdPraktyki()) + uslugodawca.getPraktykaZawodowa().getKodIdentyfikujacyMiejsceSwiadczen();
//                    //                    System.out.println("id = "+idPraktyki);
//                    //TODO tego for each by wypadalo zaminic na strumien!
//                    for (PraktykaZawodowa praktykaZawodowa : praktykaZawodowaRpwdl) {
//                        //TODO: dodanie uslugodawcy do zapisu jezli zgadzaja sie pola od id
//                        if (praktykaZawodowa.getKodIdentyfikujacyMiejsceSwiadczenPraktyki()
//                                            .equals(uslugodawca.getPraktykaZawodowa()
//                                                               .getKodIdentyfikujacyMiejsceSwiadczenPraktyki())) {
//                            Uslugodawca u = uslugodawca;//TODO to chyba jest niepotrzebne! - mozna operowac bezposrednio na uslugodawca z petli!
//                            praktykaZawodowa.getAdres()
//                                            .setId(uslugodawca.getPraktykaZawodowa()
//                                                              .getAdres()
//                                                              .getId());
//                            praktykaZawodowa.setId(uslugodawca.getPraktykaZawodowa()
//                                                              .getId());
//                            u.setPraktykaZawodowa(praktykaZawodowa);
//                            uslugodawcaDoZapisu.add(u);
//                        }
//                    }
//                }
//
//            } else {
//                System.out.println("---- EMPTY ----------");
//            }
//        } else {
//            System.out.println("-------- NULL ------------");
//        }
//
//        //TODO: sprawdzenie!!
//        for (Uslugodawca uslugodawca : uslugodawcaDoZapisu) {
//            System.out.println("spr: uslugodawca id " + uslugodawca.getId());
//            System.out.println("spr: praktyka id " + uslugodawca.getPraktykaZawodowa()
//                                                                .getId());
//            System.out.println("spr: adres id " + uslugodawca.getPraktykaZawodowa()
//                                                             .getAdres()
//                                                             .getId());
//            System.out.println("-----------------------------------------------------------");
//        }
//
//
//        Session sessionUpadte = HibernateUtil.getSessionFactory()
//                                             .openSession();
//        if (uslugodawcaDoZapisu.size() > 0) {
//            //TODO czas na update!!
//            sessionUpadte.beginTransaction();
//            for (Uslugodawca u : uslugodawcaDoZapisu) {
//                sessionUpadte.merge(u);
//                //                session.getTransaction().commit();
//            }
//            sessionUpadte.getTransaction()
//                         .commit();
//            sessionUpadte.close();
//        }
//
//    }
//
//    private List<Uslugodawca> pobierzUslugodawcowZBazy(Session session, int id) {
//        List<Uslugodawca> uslugodawcaZBazy;
//        String hql = "FROM Uslugodawca u " + "LEFT JOIN FETCH u.praktykaZawodowa pz " + "LEFT JOIN FETCH pz.adres a " + "LEFT JOIN FETCH pz.praktykaZawodowaOsoba pzo " + "LEFT JOIN FETCH pzo.daneOsobowe do " + "WHERE pz.idPraktyki = :idPraktyki AND u.status in :status";
//
//        //        Map parametry=new HashMap<String,Object>();
//        //        parametry.put("idPraktyki", 99950);
//        //        parametry.put("status", Status.AKTUALNY);
//
//        session.beginTransaction();
//        Query query = session.createQuery(hql);
//        query.setParameter("idPraktyki", id);
//        //        query.setParameter("idPraktyki", 159874);//TODO: co zwroci jak nie znajdzie? - zwroci PUSTA liste nie null!!!!!
//        query.setParameter("status", Status.AKTUALNY);
//
//        uslugodawcaZBazy = query.list();
//        //        Set result = new LinkedHashSet(session.createQuery(hql).setParameter("idp", idp).list());
//        session.close();
//
//        System.out.println("--------- test QUERY -----------");
//        for (Uslugodawca u : uslugodawcaZBazy) {
//            System.out.println("------------ " + u.getId());
//        }
//
//        return uslugodawcaZBazy;
//    }
//
//    private List<PraktykaZawodowa> stwurzListeUslugodawcowRpwdl() {
//        //TODO: niestety do porownan trafia lista praktyk a nie uslugodawcow... nie ma wszytskich danych
//        List<PraktykaZawodowa> listaPraktykZRpwdl = new ArrayList<PraktykaZawodowa>();
//        PraktykaZawodowa p1 = new PraktykaZawodowa();
//        PraktykaZawodowa p2 = new PraktykaZawodowa();
//        PraktykaZawodowa p3 = new PraktykaZawodowa();
//
//        Adres adres = utworzAdres("nie nie nie", "123451231", "trololo");
//        Adres adres2 = utworzAdres("tak tak tak", "123451231", "trololo");//TODO potem cos zmienic na przyklad
//        Adres adres3 = utworzAdres("tak tak tak", "123451231", "trololo");//TODO potem cos zmienic na przyklad
//
//        p1.setIdPraktyki(99950);
//        p2.setIdPraktyki(99950);
//        p3.setIdPraktyki(99950);
//
//        p1.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("001");
//        p2.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("004");
//        p3.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("003");
//
//        p1.setAdres(adres);
//        p2.setAdres(adres2);
//        p3.setAdres(adres3);
//
//        listaPraktykZRpwdl.add(p1);
//        listaPraktykZRpwdl.add(p2);
//        listaPraktykZRpwdl.add(p3);
//
//        return listaPraktykZRpwdl;
//    }
//
//    private Uslugodawca symulatorRpwdl() {
//        KomorkaOrganizacyjna komorkaOrganizacyjna = new KomorkaOrganizacyjna();
//        komorkaOrganizacyjna.setStatus(Status.AKTUALNY);
//        JednostkaOrganizacyjna jednostkaOrganizacyjna = new JednostkaOrganizacyjna();
//        jednostkaOrganizacyjna.setWirtualna(false);
//        jednostkaOrganizacyjna.setStatus(Status.AKTUALNY);
//        PrzedsiebiorstwoPodmiotuLeczniczego przedsiebiorstwoPodmiotuLeczniczego = new PrzedsiebiorstwoPodmiotuLeczniczego();
//        przedsiebiorstwoPodmiotuLeczniczego.setStatus(Status.AKTUALNY);
//
//        Uslugodawca uslugodawca = utworzUslugodawce();
//        PodmiotWDL podmiotWDL = utworzPodmiotWdl();//TODO: w nim jest informacja potrzebna do identyfikatora praktyki
//
//        PraktykaZawodowa praktykaZawodowa = utwrzPraktykeZawodowa();
//        String idPraktyki = podmiotWDL.getNumerKsiegiRejestrowej() + podmiotWDL.getKodOrganuRejestrowego();
//        praktykaZawodowa.setIdPraktyki(Integer.valueOf(idPraktyki));
//        praktykaZawodowa.setKodIdentyfikujacyMiejsceSwiadczenPraktyki("002");//TODO: kawałek id ktory trzeba dorobic jeszcze
//        Adres adres = utworzAdres("nie nie nie", "123451231", "trololo");
//
//        //TODO: obiekty niżej są tylko p to aby uzystkać fragment ID prakyki zawodowej (kood organu)
//        przedsiebiorstwoPodmiotuLeczniczego.setPodmiotWDL(podmiotWDL);
//        jednostkaOrganizacyjna.setPrzedsiebiorstwoPodmiotuLeczniczego(przedsiebiorstwoPodmiotuLeczniczego);
//        komorkaOrganizacyjna.setJednostkaOrganizacyjna(jednostkaOrganizacyjna);
//
//        praktykaZawodowa.setAdres(adres);
//
//        uslugodawca.setKomorkaOrganizacyjna(komorkaOrganizacyjna);
//        uslugodawca.setPraktykaZawodowa(praktykaZawodowa);
//        uslugodawca.setStatus(Status.AKTUALNY);
//        //TODO: ustawic dane uslugodawcy w rpwdl
//
//        return uslugodawca;
//    }
//
//    private PodmiotWDL utworzPodmiotWdl() {
//        PodmiotWDL podmiotWDL = new PodmiotWDL();
//        podmiotWDL.setKodOrganuRejestrowego("50");
//        podmiotWDL.setNazwa("pomiot WDL!!!");
//        podmiotWDL.setStatus(Status.AKTUALNY);
//        podmiotWDL.setNumerKsiegiRejestrowej("000999");
//        return podmiotWDL;
//    }
//
//    private void uaktualnijUslugodawce(Session session) {
//        session.beginTransaction();
//        Uslugodawca uslugodawca = utworzUslugodawce();
//        PraktykaZawodowa praktykaZawodowa = utwrzPraktykeZawodowa();
//        Adres adres = utworzAdres("nie wiem XXXXXXXXX", "11-523", "lalalalalala");
//
//        praktykaZawodowa.setAdres(adres);
//        praktykaZawodowa.setNazwa("update nazwy!!!");
//        uslugodawca.setPraktykaZawodowa(praktykaZawodowa);
//
//        uslugodawca.setId(1404092L);
//        uslugodawca.getPraktykaZawodowa()
//                   .setId(564193L);
//        uslugodawca.getPraktykaZawodowa()
//                   .getAdres()
//                   .setId(1650135L);
//
//        //        session.saveOrUpdate(uslugodawca);
//        session.merge(uslugodawca);
//        session.getTransaction()
//               .commit();
//        session.close();
//    }
//
//    private void zapiszUslugodawce(Session session) {
//        session.beginTransaction();
//        //        Uslugodawca uslugodawca = utworzUslugodawce();
//        //        PraktykaZawodowa praktykaZawodowa = utwrzPraktykeZawodowa();
//        //        Adres adres = utworzAdres("gmina", "88-222","miejscowosc");
//        //
//        //        praktykaZawodowa.setAdres(adres);
//        //        uslugodawca.setPraktykaZawodowa(praktykaZawodowa);
//
//        Uslugodawca uslugodawca = symulatorRpwdl();
//
//        session.save(uslugodawca);
//        session.getTransaction()
//               .commit();
//        session.close();
//    }
//
//    private Uslugodawca utworzUslugodawce() {
//        Uslugodawca uslugodawca = new Uslugodawca();
//        uslugodawca.setSpozaRejestru(false);
//        uslugodawca.setStatus(Status.AKTUALNY);
//        return uslugodawca;
//    }
//
//    private PraktykaZawodowa utwrzPraktykeZawodowa() {
//        PraktykaZawodowa praktykaZawodowa = new PraktykaZawodowa();
//        praktykaZawodowa.setNazwa("nazwa rpraktyki");
//        praktykaZawodowa.setNazwaOrganuRejestrowego("nazwa organuu!!!");
//        praktykaZawodowa.setNrKsiegiRejestrowej("123456789");
//        //        praktykaZawodowa.setIdPraktyki(1234567);
//        return praktykaZawodowa;
//    }
//
//    private Adres utworzAdres(String gmina, String kodPocztowy, String miejscowosc) {
//        Adres adres = new Adres();
//        adres.setGmina(gmina);
//        adres.setKodPocztowy(kodPocztowy);
//        adres.setMiejscowosc(miejscowosc);
//        return adres;
//    }
//    //-================================================================================================================================
//
//}
