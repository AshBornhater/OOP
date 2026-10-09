public class Silinder extends Lingkaran {
    private double tinggi;
    
    public Silinder(double radius, double tinggi, String warna) {
        super(radius, warna);
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        return super.hitungLuas() * tinggi;
    }

    @Override
    public void printInfo() {
        System.out.printf("Silinder Berwarna %s dengan volume %.5f%n", getWarna(), hitungVolume());
    }
}
