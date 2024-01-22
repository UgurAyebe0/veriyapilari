package Arsiv;


import static Arsiv.BList.*;
import static Arsiv.Search.minmaxAra;

public class ListNode {
    public static char[] Harfler = {'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'Ğ', 'H', 'I', 'İ', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'R', 'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z'};

    public static void main(String[] args) {

        // Sakın silme hata verir
        BList bl = new BList();
        Node aktif = ilkNode;


        // 3 kelimeli harfleri buradan ekleyeceğiz. min ve alt 0 kullanacağız
        for (int i = 0; i < Harfler.length; i++) {
            for (int j = 0; j < Harfler.length; j++) {
                for (int k = 0; k < Harfler.length; k++) {
                    ekle(" " + Harfler[i] + Harfler[j] + Harfler[k] , true , aktif.hashCode() , 0);
                    aktif = aktif.sonraki;
//                    System.out.println("Harf: " + Harfler[i] + Harfler[j] + Harfler[k] + " Adres: " + aktif.hashCode());
                }
            }
        }

        aktif = ilkNode;

        // 2 kelimeli harfleri buradan ekleyeceğiz. min ve alt basamak ekledik.
        for (int i = 0; i < Harfler.length; i++) {
            for (int j = 0; j < Harfler.length; j++) {
                aktif = aktif.sonraki;
                int minDeğer = aktif.hashCode();
                for (int e = 0; e < Harfler.length - 1; e++) {
                    aktif = aktif.sonraki;
                }
                ekle(" " + Harfler[i] + Harfler[j],true , minDeğer , aktif.hashCode());
//                System.out.println("Harf" + Harfler[i] + Harfler[j] + " Adresi: "+ sonNode.onceki.hashCode()+ " minDeğer: " + minDeğer + " maxDeğer: " + aktif.hashCode());
            }
        }

        // Tek kelimeli harfleri buradan ekleyeceğiz.
        for (int i = 0; i < Harfler.length; i++) {
            aktif = aktif.sonraki;
            int minDeğer = aktif.hashCode();
            for (int e = 0; e < Harfler.length - 1; e++) {
                aktif = aktif.sonraki;
            }
            ekle(" " + Harfler[i] ,true , minDeğer , aktif.hashCode());
//            System.out.println("Harf" + Harfler[i] + " Adresi: "+ sonNode.onceki.hashCode()+ " minDeğer: " + minDeğer + " maxDeğer: " + aktif.hashCode());
        }

        arayaekle("bilgisayar",false);

        System.out.println("--------");

        minmaxAra("bilgisayar");

        Search.basamak4("bilgisayar",712256162,2054574951);
        listele();
    }
}
