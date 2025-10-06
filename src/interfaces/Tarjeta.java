package interfaces;

/**
 *
 * @author Duoc
 */
public class Tarjeta extends Pago implements Pagable{
    private String numeroTarjeta;
    
    public Tarjeta(double monto, String numeroTarjeta){
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
    }
    
    @Override
    public void pagar(){
        System.out.println("Pagando $" + monto + " con tarjeta: " + numeroTarjeta);
        System.out.println("Fecha: "+getFecha());
    }
}
