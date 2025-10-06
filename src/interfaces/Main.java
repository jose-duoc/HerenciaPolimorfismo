package interfaces;

import java.util.Scanner;

/**
 *
 * @author Duoc
 */
public class Main {
    public static void main(String[] args){
        
        
       
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== MENÚ DE PAGOS ===");
        System.out.println("1.- Pago con Tarjea");
        System.out.println("2.- Pago con Efectivo");
        System.out.println("3.- Pago con Paypal");
        System.out.println("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        
        switch(opcion){
            case 1->{
                System.out.println("Ingrese Monto: ");
                double monto = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese número de tarjeta: ");
                String numero = sc.nextLine();
                Pagable p1 = new Tarjeta(monto,numero);
                p1.pagar();
            } 
            case 2->{
                System.out.println("Ingrese monto: ");
                double monto = sc.nextDouble();
                sc.nextLine();
                Pagable p2 = new Efectivo(monto);
                p2.pagar();
            }
            case 3 ->{
                System.out.println("Ingrese monto");
                double monto = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese email: ");
                String email = sc.nextLine();
                Pagable p3 = new Paypal(monto, email);
                p3.pagar();
            }
        }
    }
}
