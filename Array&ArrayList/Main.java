import java.util.Scanner;
import java.util.ArrayList;

public class Main { 

    public static void dashboardUI(String username) {
        System.out.println("\n============================================");
        System.out.printf ("|  LOGGED IN AS: %-25s |\n", username);
        System.out.println("============================================");
        System.out.println("|1. DEPOSIT                                |");
        System.out.println("|2. WITHDRAW                               |");
        System.out.println("|3. ACCOUNT BALANCE                        |");
        System.out.println("|4. TOTAL ACCOUNTS                         |");
        System.out.println("|5. LOGOUT                                 |");
        System.out.println("|0. EXIT                                   |");
        System.out.println("============================================");
        System.out.print("Choice: ");
    }

    public static boolean transaction(Scanner scanner, BankAccount activeAcc, ArrayList<BankAccount> acc) {
        while (true) {
            dashboardUI(activeAcc.getUsername());
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Masukkan nominal deposit (Rp): ");
                    if (scanner.hasNextInt()) {
                        activeAcc.deposit(scanner.nextInt());
                    } else {
                        System.out.println("Nominal tidak valid!");
                    }
                    scanner.nextLine();
                    break;

                case "2":
                    System.out.print("Masukkan nominal withdraw (Rp): ");
                    if (scanner.hasNextInt()) {
                        activeAcc.withDraw(scanner.nextInt());
                    } else {
                        System.out.println("Nominal tidak valid!");
                    }
                    scanner.nextLine(); 
                    break;

                case "3":
                    System.out.printf("Current Balance: Rp %d%n", activeAcc.getBalance());
                    break;

                case "4":
                    System.out.printf("Total Accounts Registered: %d akun%n", acc.size());
                    break;

                case "5": 
                    System.out.println("\nLogout berhasil. Kembali ke menu utama...");
                    return true; 

                case "0": 
                    System.out.println("\nTerima kasih telah menggunakan layanan bank. Sampai jumpa!");
                    return false; 

                default:
                    System.out.println("Input tidak valid!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        
        accounts.add(new BankAccount("admin", "1234"));

        appLoop:
        while (true) {
            Auth.authUI();
            String authChoice = scanner.nextLine().trim();

            switch (authChoice) {
                case "1":
                    BankAccount target = Auth.login(scanner, accounts);
                    if (target != null) {
                        boolean keepSession = transaction(scanner, target, accounts);
                        if (!keepSession) {
                            break appLoop;
                        }
                    }
                    break;

                case "2":
                    Auth.register(scanner, accounts);
                    break;

                case "3": 
                    System.out.println("\nTerima kasih telah menggunakan layanan bank. Sampai jumpa!");
                    break appLoop;

                default:
                    System.out.println("\n[!] Pilihan tidak valid. Silakan pilih 1, 2, atau 3.\n");
                    break;
            }
        }

        scanner.close();
    }
}