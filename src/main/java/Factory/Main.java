package Factory;

import AbstraktFactory.Blok;
import AbstraktFactory.BlokFaktoryClass;
import AbstraktFactory.BudimexFactory;
import AbstraktFactory.RobygFactory;

public class Main {
    public static void main(String[] args) {
//        Komputer pc = KomputerFaktory.createKomputer("PCv2","10G", "500MB");
//        Komputer serwer = KomputerFaktory.createKomputer("Server","1000G", "50000MB");
//
//        pc.kimJestem();
//        serwer.kimJestem();

        Blok budimexu = BlokFaktoryClass.getBlok(new BudimexFactory());
        Blok robyga = BlokFaktoryClass.getBlok(new RobygFactory());

        budimexu.jakiDeveloper();
        robyga.jakiDeveloper();

        System.out.println("--------- "+budimexu.getPole()+" ======= "+robyga.getPole());
    }
}

