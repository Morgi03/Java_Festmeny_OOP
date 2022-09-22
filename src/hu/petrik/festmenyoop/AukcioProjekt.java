package hu.petrik.festmenyoop;

import java.io.IOException;

public class AukcioProjekt {
    public static void main(String[] args) {
    // test
        Festmeny festmeny1 = new Festmeny("A harc","Gipsz Jakab","Gótikus");
        festmeny1.licit();
        festmeny1.licit();
        festmeny1.licit(25);
        festmeny1.licit();
        System.out.println(festmeny1);

        //2.feladat
        Festmenyek festmenyek = new Festmenyek();
        festmenyek.addFestmeny(festmeny1);
        Festmeny festmeny2 = new Festmeny("Java óra","Morgován Nimród","Futurizmus");
        festmenyek.addFestmeny(festmeny2);
        festmenyek.addFestmenyFelhasznalo();
        try {
            festmenyek.beolvasas("festmenyek.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        festmenyek.licitXAlkalommal(20);

    }
}
