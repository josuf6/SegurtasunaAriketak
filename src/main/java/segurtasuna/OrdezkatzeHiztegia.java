package segurtasuna;

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
        OrdezkatzeHiztegia ordezkatzeHiztegia = new OrdezkatzeHiztegia();
        String zifraketa = ordezkatzeHiztegia.zifratu(mezua);
        System.out.println("Lortutako kriptograma: " + zifraketa);
    }

    public String zifratu(String mezua){
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

    public String deszifratu(String kripto){

        return "";
    }
}
