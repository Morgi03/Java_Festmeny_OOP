package hu.petrik.festmenyoop;

public class AukcioProjekt {
    public static void main(String[] args) {
    // test
        Festmeny festmeny1 = new Festmeny("A harc","Gipsz Jakab","Gótikus");
        festmeny1.licit();
        festmeny1.licit();
        festmeny1.licit(25);
        festmeny1.licit();
        System.out.println(festmeny1);
    }
}
