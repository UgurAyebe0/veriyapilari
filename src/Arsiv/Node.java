package Arsiv;

public class Node {
    public String Harf;
    public int altbasamak;
    public Node onceki;
    public Node sonraki;
    public Node(String Harf, int altbasamak) {
        this.Harf = Harf;
        this.altbasamak = altbasamak;
        this.onceki = null;
        this.sonraki = null;
    }
}
