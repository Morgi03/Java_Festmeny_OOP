package hu.petrik.festmenyoop;

import java.io.IOException;

public class AukcioProjekt {
    public static void main(String[] args) {
        // test
        Festmeny festmeny1 = new Festmeny("A harc", "Gipsz Jakab", "Gótikus");
        festmeny1.licit();
        festmeny1.licit();
        festmeny1.licit(25);
        festmeny1.licit();
        System.out.println(festmeny1);

        //2.feladat
        Festmenyek festmenyek = new Festmenyek();
        festmenyek.addFestmeny(festmeny1);
        Festmeny festmeny2 = new Festmeny("Java óra", "Morgován Nimród", "Futurizmus");
        festmenyek.addFestmeny(festmeny2);
        festmenyek.addFestmenyFelhasznalo();
        try {
            festmenyek.beolvasas("festmenyek.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        festmenyek.licitXAlkalommal(20);

        festmenyek.felhasznaloLicit();
        festmenyek.kiir();

        //3.feladat
        festmenyek.getLegdragabbanElkelt();
        if (festmenyek.tiznelTobbLicit()) {
            System.out.println("Van olyan kép amin 10-nél több licit van");
        } else {
            System.out.println("Nincs olyan kép amin 10-nél több licit van");
        }
        System.out.printf("El nem kelt festmények száma: %d\n", festmenyek.elNemKeltFestmenyekSzama());
        System.out.println("\nRendezett lista:");
        festmenyek.rendezesCsokkenoSorrendbe();
    }
}
