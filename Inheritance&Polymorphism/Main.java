import java.util.Scanner;

public class Main {

    static void printMenu() {
        System.out.print("========= Shape Calculator =========\n");
        System.out.print("1. Bujur Sangkar\n");
        System.out.print("2. Lingkaran\n");
        System.out.print("3. Silinder\n");
        System.out.print("0. Exit\n");
        System.out.print("====================================\n");
        System.out.print("Pilih bentuk: ");
    }

    static double readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Input tidak valid. Silakan masukkan angka.");
            scanner.nextLine(); 
            System.out.print(prompt);
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); 
        return input;
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    static void pressEnter(Scanner scanner) {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1":
                    double sisi = readNumber(scanner, "\nMasukkan panjang sisi: ");
                    scanner.nextLine();
                    System.out.print("Masukkan warna: ");
                    String warnaBujurSangkar = scanner.nextLine();
                    BujurSangkar bujurSangkar = new BujurSangkar(sisi, warnaBujurSangkar);
                    bujurSangkar.printInfo();
                    pressEnter(scanner);
                    clearScreen();
                    break;
                case "2":
                    double radius = readNumber(scanner, "Masukkan jari-jari: ");
                    System.out.print("Masukkan warna: ");
                    String warnaLingkaran = scanner.nextLine();
                    Lingkaran lingkaran = new Lingkaran(radius, warnaLingkaran);
                    lingkaran.printInfo();
                    pressEnter(scanner);
                    clearScreen();
                    break;
                case "3":
                    double radiusSilinder = readNumber(scanner, "Masukkan jari-jari: ");
                    double tinggi = readNumber(scanner, "Masukkan tinggi: ");
                    System.out.print("Masukkan warna: ");
                    String warnaSilinder = scanner.nextLine();
                    Silinder silinder = new Silinder(radiusSilinder, tinggi, warnaSilinder);
                    silinder.printInfo();
                    pressEnter(scanner);
                    clearScreen();
                    break;
                case "0":
                    System.out.println("= = = Thanks = = =");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!.");
                    clearScreen();
            }
        }

    }
}
