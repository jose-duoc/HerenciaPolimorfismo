package interfaces;
/**
 *
 * @author Duoc
 */
public class Paypal extends Pago implements Pagable{
    private String email;
    
    public Paypal(double monto, String email){
        super(monto);
        this.email = email;
    }
    
    @Override
    public void pagar(){
        System.out.println("Pagando $"+ monto+ " a través de PayPal: " + email);
    }
}
