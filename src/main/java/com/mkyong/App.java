//package com.mkyong;
//
//import smz.zgl.daneref.ud.Status;
//import com.mkyong.util.HibernateUtil;
//import org.hibernate.Session;
//import smz.zgl.daneref.Adres;
//import smz.zgl.daneref.DaneOsobowe;
//import smz.zgl.daneref.ud.PraktykaZawodowa;
//import smz.zgl.daneref.ud.PraktykaZawodowaOsoba;
//import smz.zgl.daneref.ud.Uslugodawca;
//
//import java.util.*;
//
//public class App {
//    public static void main(String[] args) {
//
//        App app = new App();
//
//        System.out.println("Hibernate one to many (XML Mapping)");
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        app.zapiszAktualizujUslugodawce(session,true);//TODO: dodanie uslugodawcy
////        app.wyswietlDaneUslugodawcy(session, 1404146L);//TODO: wyswietlanie informacji
////        app.uzyjCustomQuery(session,1234567L);//TODO: query z left join do pobrania uslugodawcow po id praktyki
////        app.queryOAdresy(1);
//        System.out.println("GOTOWE!");
//    }
//
//    private void zapiszAktualizujUslugodawce(Session session, boolean savOrUpdate) {//TODO: czyli aktualizuj praktyke
//        session.beginTransaction();
//
//        Uslugodawca uslugodawca = przygotujUslugodawdce();
//        PraktykaZawodowa praktykaZawodowa = przygotujPraktykeZawodowa();
//
//        uslugodawca.setPraktykaZawodowa(praktykaZawodowa);
//        praktykaZawodowa.setUslugodawca(uslugodawca);
//        praktykaZawodowa.setPraktykaZawodowaOsoba(przygotujPraktykeOsoboowa());
//
//
//        Set<Adres> listaAdresow;
//        listaAdresow = przygotujListeAdresow(praktykaZawodowa);
//        praktykaZawodowa.setListaAdresow(listaAdresow);
//
////        session.update(uslugodawca);//TODO jezeli nie zadziala zapisac jeszcze praktyke
//        if (savOrUpdate){
////            TODO:saveOrupdate
//            uslugodawca.setId(1404098L);
//            uslugodawca.getPraktykaZawodowa().setId(564210L);
//            uslugodawca.getPraktykaZawodowa().getListaAdresow().clear();
//            uslugodawca.getPraktykaZawodowa().setListaAdresow(przygotujAdresyDoUpdatu());
//
//            session.update(uslugodawca);//TODO jezeli nie zadziala zapisac jeszcze praktyke
//        }else {
////            TODO:save
//            session.save(uslugodawca);//TODO: zapisanie uslugodawcy
//        }
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    private void wyswietlDaneUslugodawcy(Session session, Long idUslugodawcy) {
//        session.beginTransaction();
//        Uslugodawca uslugodawca = (Uslugodawca) session.get(Uslugodawca.class, idUslugodawcy);
//
////        System.out.println("dane usługodawcy: "+uslugodawca.toString());
//        System.out.println("wynik: " + uslugodawca.getId());
//        System.out.println("wynik: " + uslugodawca.getSpozaRejestru());
//        System.out.println("wynik: " + uslugodawca.getStatus());
//        System.out.println("wynik: " + uslugodawca.getPraktykaZawodowa());
//        System.out.println("wynik: " + uslugodawca.getPraktykaZawodowa().getNazwa());
//        System.out.println("wynik: " + uslugodawca.getPraktykaZawodowa().getIdPraktyki());
//        System.out.println("wynik: " + uslugodawca.getPraktykaZawodowa().getRegon());
//        System.out.println("wynik: " + uslugodawca.getPraktykaZawodowa().getListaAdresow());
////        System.out.println("wynik: "+uslugodawca.getPraktykaZawodowa().getListaAdresow());
//        session.close();
//    }
//
//    private Set<Adres> przygotujAdresyDoUpdatu(){
//        //TODO ta metoda zwraca set adresow z id z bazy danych (recznie wpisane) - zeby sprawdzić czy update dziala dla wsyztskich elementow
//        Set<Adres> noweDresy = new HashSet<Adres>();
//        Adres adres1=new Adres();
//        Adres adres2=new Adres();
//        Adres adres3=new Adres();
//
//        adres1.setId(1650165L);
//        adres1.setGmina("nowa gmina");
//        adres1.setUlica("nowa ulica");
//        adres2.setId(1650166L);
//        adres2.setGmina("nowa gmina2");
//        adres2.setUlica("nowa ulica2");
//        adres3.setId(1650167L);
//        adres3.setGmina("nowa gmina3");
//        adres3.setUlica("nowa ulica3");
//        noweDresy.add(adres1);
//        noweDresy.add(adres2);
//        noweDresy.add(adres3);
//        return noweDresy;
//    }
//    private Uslugodawca przygotujUslugodawdce() {
//        Uslugodawca uslugodawca = new Uslugodawca();
//        uslugodawca.setKomorkaOrganizacyjna(null);
//        uslugodawca.setSpozaRejestru(false);
//        uslugodawca.setStatus(Status.AKTUALNY);
//        uslugodawca.setIdPraktykiZawodowej(10002L);//TODO: to id to ma byc to złożone z 3 elementów
////        uslugodawca.setPraktykaZawodowa();
//        return uslugodawca;
//    }
//
//    private PraktykaZawodowa przygotujPraktykeZawodowa() {
//        PraktykaZawodowa praktykaZawodowa = new PraktykaZawodowa();
////        praktykaZawodowa.setId(1000L);
////        praktykaZawodowa.setAdres(null);
//        praktykaZawodowa.setIdPraktyki(10002L);//TODO: to by mogło być tym dziwnym złożeniem
//        praktykaZawodowa.setNazwa("slim shady");
//        praktykaZawodowa.setRegon("12345678");
//        return praktykaZawodowa;
//    }
//
//    private DaneOsobowe przygotujDaneOsobowe() {
//        DaneOsobowe daneOsobowe = new DaneOsobowe();
//        daneOsobowe.setBezdomny(false);
//        daneOsobowe.setImie("jarek ");
//        daneOsobowe.setNazwisko("z zadupia");
//        daneOsobowe.setNrPesel("963852741");
//        return daneOsobowe;
//    }
//
//    private Adres przygotujAdres() {
//        Adres adres = new Adres();
//        adres.setGmina("dlaska");
//        adres.setMiejscowosc("kunegunda");
//        adres.setKodPocztowy("11-777");
//        return adres;
//    }
//
//    private Set<Adres> przygotujListeAdresow(PraktykaZawodowa praktykaZawodowa) {
//        Set<Adres> listaAdresow = new HashSet<Adres>();
//        listaAdresow.add(przygotujAdresDoListy("999", "11-111", "jajajaj", praktykaZawodowa));
//        listaAdresow.add(przygotujAdresDoListy("888", "88-222", "sidudsaihd", praktykaZawodowa));
//        listaAdresow.add(przygotujAdresDoListy("666", "31-333", "jasfasfina", praktykaZawodowa));
//        return listaAdresow;
//    }
//
//    private Adres przygotujAdresDoListy(String gmina, String kodPocztowy, String miejscoweosc, PraktykaZawodowa praktykaZawodowa) {
//        Adres adres = new Adres();
//        adres.setKodPocztowy(kodPocztowy);
//        adres.setMiejscowosc(miejscoweosc);
//        adres.setGmina(gmina);
////        adres.setPraktykaid(666666);
//        adres.setPraktykaZawodowa(praktykaZawodowa);
//        return adres;
//    }
//
//    private PraktykaZawodowaOsoba przygotujPraktykeOsoboowa() {
//        PraktykaZawodowaOsoba praktykaZawodowaOsoba = new PraktykaZawodowaOsoba();
//        praktykaZawodowaOsoba.setNip("8878756464");
//        praktykaZawodowaOsoba.setNrPWZ("2416584");
//        praktykaZawodowaOsoba.setSpecjalizacje("jeszcze inna jaka");
//        praktykaZawodowaOsoba.setDaneOsobowe(przygotujDaneOsobowe());
//        return praktykaZawodowaOsoba;
//    }
//
//    private void queryOAdresy(int idPraktyki) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        idPraktyki = 564298;
//        Long idp = 987987L;
//        session.beginTransaction();
//        String hql = "FROM PraktykaZawodowa pz"
//                + " right join fetch pz.listaAdresow adr"
//                + " where pz.idPraktyki=:idp";
//
//        Set result = new LinkedHashSet(session.createQuery(hql).setParameter("idp", idp).list());//TODO zeby uniknąc duplikatow hibernata trzeba tak robic query jak jest jeden do wiele
//        System.out.println(result.size());
//        Set<PraktykaZawodowa> wtnikowaLista = result;
////        List<PraktykaZawodowa> ostatecznyWynik =  result;
//        for (PraktykaZawodowa praktykaZawodowa : wtnikowaLista) {
//            System.out.println(" -------- " + praktykaZawodowa.getListaAdresow());
//            for (Adres adres : praktykaZawodowa.getListaAdresow()
//                    ) {
//                System.out.println("---adres--- " + adres.getMiejscowosc() + " " + adres.getGmina());
//            }
//        }
//        session.close();
//    }
//
//    private void uzyjCustomQuery(Session session, Long idPraktyki) {
//        session.beginTransaction();
//        String hql = "FROM Uslugodawca u "
//                + "LEFT JOIN FETCH u.praktykaZawodowa pz "
//                + "WHERE pz.idPraktyki = :idPraktyki";
//
//        Set result = new LinkedHashSet(session.createQuery(hql).setParameter("idPraktyki", idPraktyki).list());
//
////        Query query = session.createQuery(hql).setParameter("idPraktyki", idPraktyki);
//        Set<Uslugodawca> wynikUslugodawca = result;
//
//        System.out.println(result.size());
//        for (Uslugodawca u : wynikUslugodawca
//                ) {
//            System.out.println("znleziony uslugodawca: " + u.getStatus());
//            System.out.println("znleziony uslugodawca: " + u.getIdPraktykiZawodowej());
//            System.out.println("znleziony uslugodawca: " + u.getPraktykaZawodowa().getIdPraktyki());
//            System.out.println("znleziony uslugodawca: " + u.getPraktykaZawodowa().getNazwa());
//            System.out.println("znleziony uslugodawca adresy: " + u.getPraktykaZawodowa().getListaAdresow());
//
//            for (Adres adres : u.getPraktykaZawodowa().getListaAdresow()
//                    ) {
//                System.out.println("znaleziony uslugodawca adres: " + adres.getMiejscowosc());
//                System.out.println("znaleziony uslugodawca adres: " + adres.getGmina());
//            }
//        }
//        session.close();
//    }
//}
