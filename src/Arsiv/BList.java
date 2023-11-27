package Arsiv;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class BList {
    public static Node ilkNode = new Node("", ' ');
    public static Node sonNode = new Node("", ' ');

    public BList() {
        ilkNode.sonraki = sonNode;
        sonNode.onceki = ilkNode;
        sonNode.sonraki = null;
        ilkNode.onceki = null;
    }

    public static void ekle(String Harf, int altbasamak) {
        Node yeninode = new Node(Harf, altbasamak);
        yeninode.onceki = sonNode.onceki;
        sonNode.onceki.sonraki = yeninode;
        sonNode.onceki = yeninode;
        yeninode.sonraki = sonNode;
    }

    public static void listele() {
        JFrame deneme = new JFrame("Veri Yapıları");
        deneme.setSize(500, 500);
        deneme.setLocationRelativeTo(null);
        DefaultMutableTreeNode tNode = new DefaultMutableTreeNode("Kütüphane Dizaynı");
        char[] Harflers = {'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'Ğ', 'H', 'I', 'İ', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'R', 'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z'};
        DefaultMutableTreeNode[][][][] dmt = new DefaultMutableTreeNode[30][30][30][30];
        Node aktif = ilkNode.sonraki;
        int a, b, c;
        int ka = 0;


        while (aktif != sonNode) {
            for (a = 1; a < Harflers.length + 1; a++) {
                for (b = 1; b < Harflers.length + 1; b++) {
                    for (c = 1; c < Harflers.length + 1; c++) {
                        if (aktif != sonNode) {
                            int length = aktif.Harf.length();

                            dmt[a][b][c][length] = new DefaultMutableTreeNode(aktif.Harf + " "
                                    + " A: " + a
                                    + " B: " + b
                                    + " C: " + c
                                    + " İ: " + length
                            );

                            switch (length) {
                                case 1:
                                    tNode.add(dmt[1][1][c][1]);
                                    break;
                                case 3:
                                    ka++;
                                    if (b - 1 == 0) {
                                        System.out.println(b);
                                        System.out.println(aktif.Harf + " "
                                                + " A: " + a
                                                + " B: " + b
                                                + " C: " + c
                                                + " İ: " + length
                                        );
                                        System.out.println(b-1);
                                        dmt[1][1][b -1][1].add(dmt[1][b][c][3]);
                                        break;
                                    } else {
                                        dmt[1][1][b - 1][1].add(dmt[1][b][c][3]);
                                        break;
                                    }
                                default:
                                    tNode.add(dmt[a][b][c][length]);
                                    break;
                            }

                            aktif = aktif.sonraki;
                        }
                    }
                }
            }
        }
        JTree tree = new JTree(tNode);
        JScrollPane scrollPane = new JScrollPane(tree);
        deneme.getContentPane().add(scrollPane);
        deneme.setVisible(true);
    }
}

