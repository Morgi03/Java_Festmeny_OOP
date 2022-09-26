package hu.petrik.festmenyoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    public static boolean isNum(String stringOrNum) {
        if (stringOrNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(stringOrNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void felhasznaloLicit() {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        String altind = "";
        while (index != -1) {
            System.out.println("Add meg a festmény sorszámát a listában:");
            altind = sc.nextLine();
            if (isNum(altind)) {
                index = Integer.parseInt(altind);
                index = index - 1;

                if (index >= 0 && index < this.festmenyek.size()) {
                    if (!festmenyek.get(index).getElkelt()) {
                        System.out.println("Milyen mértékkel szeretne licitálni (%)?");
                        altind = sc.nextLine();
                        if (isNum(altind) || altind.isEmpty()) {
                            if (altind.isEmpty()) {
                                this.festmenyek.get(index).licit();
                                this.festmenyek.get(index).setElkelt(true);
                            } else {
                                this.festmenyek.get(index).licit(Double.parseDouble(altind));
                                this.festmenyek.get(index).setElkelt(true);
                            }

                        } else {
                            System.out.println("Hiba! A megadott érték nem szám");
                            break;
                        }
                    } else {
                        System.err.println("Hiba! A megadott kép már elkelt");
                    }
                } else if (index == -1) {
                } else {
                    System.err.println("Hiba! A megadott érték nem egy létező sorszám!");
                }

            } else {
                System.err.println("Hiba! A megadott érték nem szám!");
            }
        }
    }

    public void kiir() {
        for (Festmeny f : this.festmenyek) {
            System.out.println(f);
        }
    }

    //3. feladat
    public void getLegdragabbanElkelt() {
        int max = 0;
        for (int i = 0; i < this.festmenyek.size(); i++) {
            if (this.festmenyek.get(max).getElkelt() && this.festmenyek.get(i).getElkelt() && this.festmenyek.get(i).getLiciterteke() > this.festmenyek.get(max).getLiciterteke()) {
                max = i;
            }
        }
        System.out.println(this.festmenyek.get(max));
    }

    public boolean tiznelTobbLicit(){
        for (Festmeny festmeny : this.festmenyek) {
            if (festmeny.getLicitekSzama() > 10) {
                return true;
            }
        }
        return false;
    }

    public int elNemKeltFestmenyekSzama(){
        int num = 0;
        for (Festmeny festmeny : this.festmenyek) {
            if (!festmeny.getElkelt()) {
                num++;
            }
        }
        return num;
    }



    static class festmenyOsszehasonlito implements Comparator<Festmeny> {

        @Override
        public int compare(Festmeny f1, Festmeny f2) {
            return f2.getLiciterteke() - f1.getLiciterteke();
        }
    }
    public void rendezesCsokkenoSorrendbe(){
        List<Festmeny> rendezett = this.festmenyek.stream().sorted(new festmenyOsszehasonlito()).collect(Collectors.toList());
        System.out.println(rendezett);
    }

}
