package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Melyik csigára fogadsz? (Piros[P], Kék[K], Zöld[Z]): ");
        String fogadas = CsigaVersenyJatek.scanner.nextLine();  

        CsigaVersenyJatek jatek = new CsigaVersenyJatek();
        jatek.versenytFuttat(fogadas);
    }
}           