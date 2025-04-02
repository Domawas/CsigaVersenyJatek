package test;
import main.Csiga;

public class CsigaVersenyTest {
    public static void main(String[] args) {
        CsigaVersenyTest test = new CsigaVersenyTest();
        test.testGyorsitoAktival();
  
        test.testHalad();
    }
    
    void testGyorsitoAktival(){
        Csiga csiga = new Csiga("Zöld");
        
        assert !csiga.isGyorsitoAktiv() : "A gyorsító kezdetben nem lehet aktív!";
        assert csiga.getMegtettTav() == 0 : "A csiga kezdeti megtett távja nem 0!";

        csiga.gyorsitoAktival();
        
        assert csiga.isGyorsitoAktiv() : "A gyorsító nem lett aktív!";
        assert csiga.getMegtettTav() == 0 : "A gyorsító aktiválásával nem változott meg a táv!";
    }
    
 
    
    void testHalad(){
        Csiga csiga = new Csiga("Zöld");
        
        assert csiga.getMegtettTav() == 0 : "A csiga kezdetben nem tett meg semmit!";
        
        csiga.halad();
        assert csiga.getMegtettTav() == 10 : "Ha nincs gyorsító, akkor 5 lépést kell megtennie!";
        
        csiga.gyorsitoAktival();
        
        csiga.halad();
        assert csiga.getMegtettTav() == 15 : "Gyorsítóval 10 lépést kell megtennie!";
        
        csiga.gyorsitoCsokkent();
        csiga.halad();
        assert csiga.getMegtettTav() == 20 : "Ha a gyorsító deaktiválódik, akkor már csak 5 lépést kell tennie!";
        
        System.out.println("Minden teszt sikeresen lefutott!");
    }
}
