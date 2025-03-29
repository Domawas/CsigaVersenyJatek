package main;

public class Csiga {

    private String szin;
    private int megtettTav;
    private boolean gyorsitoAktiv;
    private int gyorsitoKorokSzama;

    public Csiga(String szin) {
        this.szin = szin;
        this.megtettTav = 0;
        this.gyorsitoAktiv = false;
        this.gyorsitoKorokSzama = 0;
    }

    public String getSzin() {
        return szin;
    }

    public int getMegtettTav() {
        return megtettTav;
    }

    public boolean isGyorsitoAktiv() {
        return gyorsitoAktiv;
    }

    
    public void gyorsitoAktival() {
        gyorsitoAktiv = true;
        gyorsitoKorokSzama = 1;
    }

    
    public void gyorsitoCsokkent() {
        if (gyorsitoKorokSzama > 0) {
            gyorsitoKorokSzama--;
            if (gyorsitoKorokSzama == 0) {
                gyorsitoAktiv = false;
            }
        }
    }

 
    public void halad() {
        int lepes = gyorsitoAktiv ? 10 : 5;
        megtettTav += lepes;
    }
}
