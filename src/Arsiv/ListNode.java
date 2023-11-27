package Arsiv;


import static Arsiv.BList.ilkNode;
import static Arsiv.BList.listele;


public class ListNode {

    public static char[] Harfler = {'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'Ğ', 'H', 'I', 'İ', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'R', 'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z'};


    public static void main(String[] args) {


        BList bl = new BList();


        Node aktif; // Node aktif
        Node aktif2; // Node Aktif2

        for (int i = 0; i < Harfler.length; i++) {
            aktif = ilkNode.sonraki;
            aktif2 = ilkNode.sonraki;

            bl.ekle(String.valueOf(Harfler[i]), 0);


            aktif2 = aktif2.sonraki;

            if (i == Harfler.length - 1) {

                for (int j = 0; j < Harfler.length; j++) {

                    for (int k = 0; k < Harfler.length; k++) {
                        bl.ekle((" " + Harfler[j] + Harfler[k]), 0);
                        aktif2 = aktif2.sonraki;
                    }

                    aktif2 = aktif2.onceki;

                    aktif.altbasamak = aktif2.Harf.hashCode();

                    aktif2 = aktif2.sonraki;


                    aktif = aktif.sonraki;


                }

                // Üçüncü for döngüsü (4 harfli kombinasyonlar)
                for (int j = 0; j < Harfler.length; j++) {

                    // Dördüncü for döngüsü
                    for (int k = 0; k < Harfler.length; k++) {

                        // Beşinci for döngüsü
                        for (int l = 0; l < Harfler.length; l++) {


                            bl.ekle((" " + Harfler[j] + Harfler[k] + Harfler[l]), 0);
                            aktif2 = aktif2.sonraki;
                        }

                        // Aktif2'yi bir önceki konumuna getiriyorum
                        aktif2 = aktif2.onceki;

                        // Aktif düğümün alt basamağını mevcut aktif2'nin harf kodu yapıyorum
                        aktif.altbasamak = aktif2.Harf.hashCode();

                        // Dördüncü for döngüsünden sonraki hareketler
                        aktif2 = aktif2.sonraki;
                        aktif = aktif.sonraki;
                    }
                }
            }

        }
        listele();


    }
}
