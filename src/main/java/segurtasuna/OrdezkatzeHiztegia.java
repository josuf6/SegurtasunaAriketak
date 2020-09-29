package segurtasuna;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrdezkatzeHiztegia {

    private String hiztegia = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String gakoa = "ZXCVBNMASDFGHJKLQWERTYUIOP";
    private static String mezua = "EZ GAUDE GERRAREN ALDE";

    public static void main(String[] args) {
        if (args.length > 0) { //Zerbait argumentu bezala sartuz gero sartu (bestela defektuzko mezua erabili)
            mezua = "";
            int i = 0;
            while (i < args.length) {
                mezua += args[i];
                i++;
                if (i != args.length) mezua += " ";
            }
        }
        try {
            OrdezkatzeHiztegia ordezkatzeHiztegia = new OrdezkatzeHiztegia();
            int j = 0;
            while (!ordezkatzeHiztegia.sarreraEgokia(mezua)) { //Letraz osatutako esaldi bat sarrera moduan eman arte
                j++;
                if (j > 5) {
                    throw new Exception();
                }
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader (isr);
                System.out.println("Bakarrik letrak edo hutsuneak onartzen dira sarrera gisa. Berriro saiatu:");
                mezua = br.readLine();
            }
            String zifraketa = ordezkatzeHiztegia.zifratu(mezua);
            String deszifraketa = ordezkatzeHiztegia.deszifratu(zifraketa);
            System.out.println("Lortutako kriptograma: " + zifraketa);
            System.out.println("Kriptograma deszifratuz lortutako mezu argia: " + deszifraketa);
        } catch (Exception e) {
            System.out.println("Ezin dizkizut aukera gehiago eskaini. Agur!");
        }
    }

    public String zifratu(String mezua) {
        String kriptograma = "";
        char letra;
        int i = 0;
        int letraPos;
        while (i < mezua.length()) { //Sartutako mezu osoa karakterez karaktere zeharkatu
            if (mezua.charAt(i) == ' ') { //Aurkitutako espazioak kudeatu
                kriptograma += " ";
            }
            else {
                letra = mezua.charAt(i);
                if (Character.isLowerCase(letra)) { //Begiratutako letra xehea izatekotan sartu
                    letra = Character.toUpperCase(letra);
                    letraPos = hiztegia.indexOf(letra);
                    kriptograma += Character.toLowerCase(gakoa.charAt(letraPos));
                }
                else { //Begiratutako letra larria izatekotan sartu
                    letraPos = hiztegia.indexOf(letra);
                    kriptograma += gakoa.charAt(letraPos);
                }
            }
            i++;
        }
        return kriptograma;
    }

    public String deszifratu(String kripto) {
        String mezuArgia = "";
        char letra;
        int i = 0;
        int letraPos;
        while (i < kripto.length()) { //Sartutako mezu osoa karakterez karaktere zeharkatu
            if (kripto.charAt(i) == ' ') { //Aurkitutako espazioak kudeatu
                mezuArgia += " ";
            }
            else {
                letra = kripto.charAt(i);
                if (Character.isLowerCase(letra)) { //Begiratutako letra xehea izatekotan sartu
                    letra = Character.toUpperCase(letra);
                    letraPos = gakoa.indexOf(letra);
                    mezuArgia += Character.toLowerCase(hiztegia.charAt(letraPos));
                }
                else { //Begiratutako letra larria izatekotan sartu
                    letraPos = gakoa.indexOf(letra);
                    mezuArgia += hiztegia.charAt(letraPos);
                }
            }
            i++;
        }
        return mezuArgia;
    }

    private boolean sarreraEgokia(String mezua) {
        boolean egokia = true;
        int i = 0;
        if (!mezua.isBlank()) { //Sartutako mezua hutsik ez dagoela ziurtatzeko
            while (i < mezua.length() && egokia) { //Letra edo hutsune ez den karakteren bat dagoen ala ez konprobatu
                if (!Character.isLetter(mezua.charAt(i)) && mezua.charAt(i) != ' ') {
                    egokia = false;
                }
                i++;
            }
            System.out.println();
        }
        else {
            egokia = false;
        }
        return egokia;
    }
}
