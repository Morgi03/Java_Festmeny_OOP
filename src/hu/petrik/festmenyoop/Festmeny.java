package hu.petrik.festmenyoop;

import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.elkelt = false;
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean getElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    private double liciterteke = 0;

    public double getLiciterteke() {
        return liciterteke;
    }

    public void licit() {
        if (!this.elkelt) {
            if (licitekSzama == 0) {
                this.licitekSzama++;
                this.legutolsoLicitIdeje = LocalDateTime.now();
                liciterteke = 100;
            } else {
                this.licitekSzama++;
                this.legutolsoLicitIdeje = LocalDateTime.now();
                liciterteke = Math.round((liciterteke + (liciterteke * 0.1))/10)*10;
                int hossz = String.valueOf(liciterteke).length();
                if (hossz > 5 && liciterteke % 1000 != 0) {
                    liciterteke = Math.round(liciterteke / 100) * 100;
                }
            }
        } else {
            System.err.println("Hiba! A festmény már elkelt, nem lehet licitálni rá!");
        }
    }


    public void licit(double mertek) {
        if (!this.elkelt && mertek >= 10 && mertek <= 100) {
            if (licitekSzama == 0) {
                this.licitekSzama++;
                this.legutolsoLicitIdeje = LocalDateTime.now();
                liciterteke = mertek;
            } else {
                this.licitekSzama++;
                this.legutolsoLicitIdeje = LocalDateTime.now();
                double novelendo = (mertek/100);
                liciterteke = Math.round(((liciterteke + (liciterteke * novelendo))/10)*10);
                int hossz = String.valueOf(liciterteke).length();
                if (hossz > 5 && liciterteke % 1000 != 0) {
                    liciterteke = Math.round(liciterteke / 100) * 100;
                }
            }
        } else {
            System.err.println("Hiba! A festmény már elkelt, vagy hibás mértéket adott meg!");
        }
    }

    @Override
    public String toString() {
        return this.festo+": "+this.cim+" ("+this.stilus+")\n"+((this.elkelt) ? "elkelt\n" : "nem kelt el\n"+this.liciterteke+"$ - "+this.legutolsoLicitIdeje+" (összesen: "+this.licitekSzama+" db)");
    }
}
