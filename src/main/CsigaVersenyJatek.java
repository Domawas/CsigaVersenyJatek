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
        csigak[0] = new Csiga("Piros");
        csigak[1] = new Csiga("Kék");
        csigak[2] = new Csiga("Zöld");
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
        int korokSzama = 10;
        for (int kor = 1; kor <= korokSzama; kor++) {
            System.out.println("\n------ " + kor + ". kör ------");

          
            gyorsitoAd();

      
            for (Csiga csiga : csigak) {
                csiga.halad();
            }

          
            palyaRajzol();

      
            helyezesekKiir();

     
            for (Csiga csiga : csigak) {
                csiga.gyorsitoCsokkent();
            }
        }

     
        Csiga gyoztes = csigak[0];
        for (int i = 1; i < csigak.length; i++) {
            if (csigak[i].getMegtettTav() > gyoztes.getMegtettTav()) {
                gyoztes = csigak[i];
            }
        }

   
        System.out.println("\nA verseny győztese: " + gyoztes.getSzin() + " csiga!");
        if (gyoztes.getSzin().equalsIgnoreCase(fogadottSzin)) {
            System.out.println("Gratulálunk, nyert a fogadásod!");
        } else {
            System.out.println("Sajnos nem nyert a fogadásod.");
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
