import java.util.ArrayList;
import java.util.Scanner;

public class Auth {
    public static void authUI() {
        System.out.println("=============================");
        System.out.println("|    WELCOME TO THE BANK    |");
        System.out.println("=============================");
        System.out.println("|1. LOGIN                   |");
        System.out.println("|2. REGISTER                |");
        System.out.println("|3. EXIT                    |");
        System.out.println("=============================");
        System.out.print("Choice: ");
    }

    public static BankAccount login(Scanner scanner, ArrayList<BankAccount> accounts) {
        System.out.print("Enter Username: ");
        String user = scanner.nextLine().trim();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine().trim();

        BankAccount target = BankAccount.findAccount(accounts, user);

        if (target != null && target.validatePassword(pass)) {
            System.out.println("\nLogin berhasil! Selamat datang, " + target.getUsername() + ".");
            return target;
        } else {
            System.out.println("\n[!] Login gagal: Username atau password salah.\n");
            return null;
        }
    }

    public static void register(Scanner scanner, ArrayList<BankAccount> accounts) {
        System.out.print("Enter New Username: ");
        String newUser = scanner.nextLine().trim();

        if (newUser.isEmpty()) {
            System.out.println("\n[!] Username tidak boleh kosong.\n");
            return;
        }

        if (BankAccount.findAccount(accounts, newUser) != null) {
            System.out.println("\n[!] Registrasi gagal: Username sudah terdaftar!\n");
            return;
        }

        System.out.print("Enter Password: ");
        String newPass = scanner.nextLine().trim();

        BankAccount createdAcc = new BankAccount(newUser, newPass);
        accounts.add(createdAcc);
        System.out.println("\nRegistrasi berhasil! Silakan login dengan akun Anda.\n");
    }

}
