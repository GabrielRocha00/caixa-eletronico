package co.gabrielrocha.bank;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // depositar, saque, sair

        Account account = new Account("0001", "1234", "Seu madruga");
        // D = deposito
        // S = saque
        // E = sair (exit)

        while (true) {
            System.out.println("o que deseja fazer? D = DEPOSITO, S = SAQUE, E = SAIR DA CONTA");
            String op = scanner.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar? ");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Ops, nao foi possivel sacar o valor de R$" + value);
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando invalido, tente novamente");
            }
            scanner = new Scanner(System.in);

        }
    }
}
