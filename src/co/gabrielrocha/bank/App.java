package co.gabrielrocha.bank;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");
        // C = Criar conta
        // E = Sair (exit)

        while (true) {
            System.out.println("O que deseja fazer? C = Criar conta, E = Sair do programa");
            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite seu nome");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando invalido, tente novamente");

            }
        }

        List<Account> accountList = santander.getAccounts();
        for(Account cc : accountList) {
            System.out.println(cc);
        }
        santander.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
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