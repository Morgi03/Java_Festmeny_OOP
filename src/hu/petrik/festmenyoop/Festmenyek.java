package hu.petrik.festmenyoop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Festmenyek {
    private List<Festmeny> festmenyek;

    public Festmenyek() {
        this.festmenyek = new ArrayList<>();
    }

    public void addFestmeny(Festmeny festmeny) {
        this.festmenyek.add(festmeny);
    }

    void addFestmenyFelhasznalo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg, hogy hány darab képet szeretnél a listába rakni:");
        int darabszam = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < darabszam; i++) {
            System.out.println("Add meg a kép nevét:");
            String nev = sc.nextLine();
            System.out.println("Add meg a festő nevét:");
            String festo = sc.nextLine();
            System.out.println("Add meg a kép stílusát:");
            String stilus = sc.nextLine();
            Festmeny festmeny = new Festmeny(nev, festo, stilus);
            this.addFestmeny(festmeny);
            System.out.println("\n\n");
        }
    }

    public void beolvasas(String filenev) throws IOException {
        FileReader fr = new FileReader(filenev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] adatok = sor.split(";");
            Festmeny festmeny = new Festmeny(adatok[0], adatok[1], adatok[2]);
            this.addFestmeny(festmeny);
            sor = br.readLine();
        }
        fr.close();
        br.close();
    }

    public void licitXAlkalommal(int x) {
        Random r = new Random();
        for (Festmeny f : this.festmenyek) {
            for (int i = 0; i < 20; i++) {
                f.licit((r.nextInt(101 - 10) + 10));
            }
        }

    }

    public void felhasznaloLicit() {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (index != -1) {
            System.out.println("Add meg a festmény sorszámát a listában:");
            index = sc.nextInt();
            sc.nextLine();
            index = index - 1;
            if ( index > 0 && index < this.festmenyek.size()) {
                //...
            } else if (index == -1) {
            } else {

            }
        }
    }
}
