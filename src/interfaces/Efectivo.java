package interfaces;

/**
 *
 * @author Duoc
 */
public class Efectivo extends Pago implements Pagable{
    public Efectivo(double monto){
        super(monto);
    }
    @Override
    public void pagar(){
        System.out.println("Pagando $" + monto + " en efectivo.");
    }
}
