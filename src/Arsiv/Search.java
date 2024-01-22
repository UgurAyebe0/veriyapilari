package Arsiv;

import static Arsiv.BList.sonNode;

public class Search {

    public static int minmaxAra(String kelime) {
        return basamak1(kelime.toUpperCase().trim());
    }
    public static int basamak1(String kelime) {
        String aranan = String.valueOf(kelime.charAt(0));
        Node aktif = sonNode;
        while (aktif != null) {
            if (aranan.equals(aktif.Harf)) {
                System.out.println("Aranan Harf: " + aranan
                        + " Aranan Harf adresi: " + aktif.hashCode()
                        + " Aranan harf min adresi: " + aktif.minBasamak
                        + " Aranan harf min adresi: " + aktif.maxBasamak
                );
                return basamak2(kelime, aktif.maxBasamak, aktif.minBasamak);
            }
            aktif = aktif.onceki;
        }
        return 1;
    }

    public static int basamak2(String kelime, int minBasamak, int maxBasamak) {
        String aranan = String.valueOf(kelime.charAt(0));
        aranan = aranan  + kelime.charAt(1);
        Node aktif = sonNode;

        while (aktif != null) {
            if (minBasamak == aktif.hashCode()) {
                break;
            }
            aktif = aktif.onceki;
        }
        while (aktif.hashCode() != maxBasamak) {
            if (aranan.equals(aktif.Harf)) {

                System.out.println("Aranan Harf: " + aranan
                        + " Aranan Harf adresi: " + aktif.hashCode()
                        + " Aranan harf min adresi: " + aktif.minBasamak
                        + " Aranan harf min adresi: " + aktif.maxBasamak
                );
                return basamak3(kelime, aktif.maxBasamak, aktif.minBasamak);
            }
            aktif = aktif.onceki;
        }
        return 2;
    }

    public static int basamak3(String kelime, int minBasamak, int maxBasamak) {
        String aranan = String.valueOf(kelime.charAt(0));
        aranan = aranan  + kelime.charAt(1);
        aranan = aranan  + kelime.charAt(2);
        Node aktif = sonNode;

        while (aktif != null) {
            if (minBasamak == aktif.hashCode()) {
                break;
            }
            aktif = aktif.onceki;
        }
        while (aktif.hashCode() != maxBasamak) {
            if (aranan.equals(aktif.Harf)) {

                System.out.println("Aranan Harf: " + aranan
                        + " Aranan Harf adresi: " + aktif.hashCode()
                        + " Aranan harf min adresi: " + aktif.hashCode()
                        + " Aranan harf max adresi: " + aktif.onceki.onceki.hashCode()
                );
                return aktif.hashCode();
            }
            aktif = aktif.onceki;
        }
        return minBasamak;
    }




    public static String basamak4(String kelime, int minBasamak, int maxBasamak) {
        Node aktif = sonNode;
        String adres = "Adres mevcut değildir.";

        while (aktif != null) {
            if (minBasamak == aktif.hashCode()) {
                break;
            }
            aktif = aktif.onceki;
        }
        while (aktif.hashCode() != maxBasamak) {
            if (kelime.equals(aktif.Harf)) {
                System.out.println("Aranan Kelime: " + kelime
                        + " Aranan Harf adresi: " + aktif.hashCode()
                );
                adres = String.valueOf(aktif.hashCode());
                return adres;
            }
            aktif = aktif.onceki;
        }
        System.out.println("Aranan adreste " + kelime + " mevcut değildir.");
        return adres;
    }


}
