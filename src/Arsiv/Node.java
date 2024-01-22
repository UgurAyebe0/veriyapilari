    package Arsiv;
    public class Node {
        public String Harf;
        public boolean durum;
        public Node onceki;
        public int minBasamak;
        public int maxBasamak;
        public Node sonraki;
        public Node(String Harf, boolean durum, int minBasamak, int maxBasamak) {
            this.Harf = Harf;
            this.durum = durum;
            this.minBasamak = minBasamak;
            this.maxBasamak = maxBasamak;
            this.onceki = null;
            this.sonraki = null;
        }
    }

    // Burada nodemi oluşturuyorum...