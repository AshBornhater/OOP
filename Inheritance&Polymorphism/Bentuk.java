public abstract class Bentuk {
    public String warna;

    public Bentuk(String warna) {
        this.warna = warna;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void printInfo() {
        System.out.printf("Bentuk Berwarna %s%n", warna);
    }

    public abstract double hitungLuas();
}
