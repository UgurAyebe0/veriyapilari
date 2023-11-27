package Model;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Frame {
    static JFrame deneme = new JFrame();

    public static void main(String[] args) {
        deneme = new JFrame("Deneyecez");
        deneme.setSize(500,500);
        deneme.setLocationRelativeTo(null);


        // Root düğümü
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Kütüphane Dizaynı");

        // Root düğümün altındaki düğümler
        DefaultMutableTreeNode A = new DefaultMutableTreeNode("A");

        DefaultMutableTreeNode AA = new DefaultMutableTreeNode("AA");
        DefaultMutableTreeNode AB = new DefaultMutableTreeNode("AB");
        DefaultMutableTreeNode AC = new DefaultMutableTreeNode("AC");
        DefaultMutableTreeNode ACA = new DefaultMutableTreeNode("ACA");
        DefaultMutableTreeNode ACB = new DefaultMutableTreeNode("ACA");
        A.add(AA);
        A.add(AB);
        A.add(AC);
        AC.add(ACA);
        AC.add(ACB);
        rootNode.add(A);

        // JTree oluştur
        JTree tree = new JTree(rootNode);

        // JTree'yi JScrollPane içine yerleştir
        JScrollPane scrollPane = new JScrollPane(tree);

        // JScrollPane'ı JFrame'e ekle
        deneme.getContentPane().add(scrollPane);


        deneme.setVisible(true);
    }
}
