package main;

import java.util.Random;
import java.util.Scanner;

public class CsigaVersenyJatek {

    private Csiga[] csigak;
    private int palyaHossz;
    private Random veletlen;
    static final Scanner scanner = new Scanner(System.in);

    public CsigaVersenyJatek() {
        palyaHossz = 50;
        csigak = new Csiga[3];
        csigak[0] = new Csiga("P");
        csigak[1] = new Csiga("K");
        csigak[2] = new Csiga("Z");
        veletlen = new Random();
    }

    
    public void gyorsitoAd() {
        for (Csiga csiga : csigak) {
            if (veletlen.nextDouble() < 0.2) {
                csiga.gyorsitoAktival();
                System.out.println(csiga.getSzin() + " csiga gyorsítóhoz jutott!");
            }
        }
    }

    public void versenytFuttat(String fogadottSzin) {
        try {

            String fogadottSzinLower = fogadottSzin.toLowerCase();

            if (!fogadottSzinLower.equals("piros")
                    && !fogadottSzinLower.equals("kék")
                    && !fogadottSzinLower.equals("zöld")) {
                throw new IllegalArgumentException("Nem érvényes a fogadás. Kérlek válassz a Piros, Kék, Zöld közül!");
            }


        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void palyaRajzol() {
        for (Csiga csiga : csigak) {
            StringBuilder palya = new StringBuilder();
            int pozicio = Math.min(csiga.getMegtettTav(), palyaHossz - 1);
            for (int i = 0; i < palyaHossz; i++) {
                if (i == pozicio) {
                    palya.append("🐌");
                    if (csiga.isGyorsitoAktiv()) {
                        palya.append("===");
                        i += 3;
                        if (i >= palyaHossz) {
                            break;
                        }
                        continue;
                    }
                } else {
                    palya.append("-");
                }

                if ((i + 1) % 5 == 0) {
                    palya.append("|");
                }
            }
            System.out.println(csiga.getSzin() + " csiga: " + palya.toString());
        }
    }

    private void helyezesekKiir() {

        for (int i = 0; i < csigak.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < csigak.length; j++) {
                if (csigak[j].getMegtettTav() > csigak[maxIndex].getMegtettTav()) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                Csiga temp = csigak[i];
                csigak[i] = csigak[maxIndex];
                csigak[maxIndex] = temp;
            }
        }

        System.out.print("Helyezések: ");
        for (int i = 0; i < csigak.length; i++) {
            System.out.print((i + 1) + ". " + csigak[i].getSzin() + "  ");
        }
        System.out.println();
    }

}
