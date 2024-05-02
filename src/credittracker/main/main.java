package credittracker.main;

import credittracker.models.CreditCard;
import credittracker.models.Purchases;

import java.util.Collections;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);

        System.out.print("Digite o limite do cartão: ");
        double limit = scan.nextDouble();

        CreditCard creditCard = new CreditCard(limit);

        int exit = 1;

        while (exit != 0) {
            System.out.print("\nDigite o item da compra: ");
            String description = scan.next();

            System.out.print("Digite o valor da compra: ");
            double purchasePrice = scan.nextDouble();

            Purchases purchase =  new Purchases(description,purchasePrice);
            boolean purchaseSuccessfull = creditCard.logPurchase(purchase);

            if (purchaseSuccessfull) {
                System.out.println("Compra realizada!");
                toContinue();
                exit = scan.nextInt();

            } else {
                System.out.println("Saldo insuficiente!");
                System.out.println("Seu limite atual é de $" + creditCard.getBalance());
                toContinue();

                exit = scan.nextInt();
            }
        }

        System.out.println("***************************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(creditCard.getPurchasesList());

        for (Purchases p : creditCard.getPurchasesList()){
            System.out.println(p.getDescription().substring(0,1).toUpperCase()
                    + p.getDescription().substring(1)  + " - $" + p.getPrice());
        }

        System.out.println("\n***************************");
        System.out.println("\nSaldo restante do cartão: $"
                + creditCard.getBalance() );

    }

    public static void toContinue(){
        System.out.println(""" 
                                        
                                        Deseja continar?
                                        0 - sair 
                                        1 - continuar
                                        """);

    }


}
