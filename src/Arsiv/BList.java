package Arsiv;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import static Arsiv.Search.minmaxAra;


public class BList {
    public static Node ilkNode = new Node("", false, 0, 0);
    public static Node sonNode = new Node("", false, 0, 0);

    public BList() {
        ilkNode.sonraki = sonNode;
        sonNode.onceki = ilkNode;
        sonNode.sonraki = null;
        ilkNode.onceki = null;
    }

    public static void ekle(String Harf, boolean durum, int minBasamak, int maxBasamak) {
        Node yeninode = new Node(Harf.trim(), durum, minBasamak, maxBasamak);
        yeninode.onceki = sonNode.onceki;
        sonNode.onceki.sonraki = yeninode;
        sonNode.onceki = yeninode;
        yeninode.sonraki = sonNode;
    }


    public static void arayaekle(String Kelime, boolean durum) {
        Node aktif;
        aktif = ilkNode.sonraki;
        Node yeninode = new Node(Kelime.trim(), durum, 0, 0);

        int minAdres = minmaxAra(Kelime);

        while (aktif != null) {
            if (aktif.hashCode() == minAdres) {
                aktif = aktif.onceki;
                aktif.sonraki.onceki = yeninode;
                yeninode.sonraki = aktif.sonraki;
                aktif.sonraki = yeninode;
                yeninode.onceki = aktif.onceki.sonraki;
                break;
            }
            aktif = aktif.sonraki;
        }
    }


    public static void listele() {

        // Burayı görsel anlamda göstermek için Consoll değilde Tree swing kullandım
        // Cünkü Consolldan tam verimli göremiyoruz takip hiç edemiyoruz.


        JFrame deneme = new JFrame("Veri Yapıları");
        deneme.setSize(900, 650);
        deneme.setLocationRelativeTo(null);
        DefaultMutableTreeNode tNode = new DefaultMutableTreeNode("Kütüphane Dizaynı");
        DefaultMutableTreeNode[] dmt = new DefaultMutableTreeNode[1000000];

        Node aktif = sonNode.onceki;
        int sayac = 0;
        int sayacKontrol = 0;

        int sayac1 = 29;
        int sayacKontrol1 = 0;
        int a = 0;

        while (aktif != ilkNode) {
            switch (aktif.Harf.length()) {
                case 1:
                    dmt[a] = new DefaultMutableTreeNode(aktif.Harf + " " + "Adresi: " + aktif.hashCode()
                            + " Sonraki Adresi: " + aktif.onceki.hashCode()
                            + "      Alt grub max adresi: " + aktif.minBasamak
                            + "      Alt grub min adresi: " + aktif.maxBasamak);
                    tNode.add(dmt[a]);
                    a++;
                    break;
                case 2:
                    sayacKontrol++;
                    dmt[a] = new DefaultMutableTreeNode(aktif.Harf + " " + "Adresi: " + aktif.hashCode()
                            + " Sonraki Adresi: " + aktif.onceki.hashCode()
                            + "      Alt grub max adresi: " + aktif.minBasamak
                            + "      Alt grub min adresi: " + aktif.maxBasamak);
                    dmt[sayac].add(dmt[a]);
                    a++;
                    break;
                case 3:
                    if (aktif.durum) {
                        sayacKontrol1++;
                        dmt[a] = new DefaultMutableTreeNode(aktif.Harf + " " + "Adresi: " + aktif.hashCode() + " Sonraki Adresi: " + aktif.onceki.hashCode()
                                + "      Alt grub max adresi: " + aktif.minBasamak
                        );
                        dmt[sayac1].add(dmt[a]);
                        a++;
                        break;
                    }
                default:
                    dmt[a] = new DefaultMutableTreeNode(aktif.Harf + " " + "Adresi: " + aktif.hashCode() + " Sonraki Adresi: " + aktif.sonraki.hashCode());
                    dmt[a-1].add(dmt[a]);
                    break;
            }
            if (sayacKontrol == 29) {
                sayacKontrol = 0;
                sayac++;
            }
            if (sayacKontrol1 == 29) {
                sayacKontrol1 = 0;
                sayac1++;
            }
            aktif = aktif.onceki;
        }
        JTree tree = new JTree(tNode);
        JScrollPane scrollPane = new JScrollPane(tree);
        deneme.getContentPane().

                add(scrollPane);
        deneme.setVisible(true);
    }
}

