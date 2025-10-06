package interfaces;
import java.time.LocalDate;
/**
 *
 * @author Duoc
 */
public class Pago {
    protected double monto;
    protected LocalDate fecha;
    
    public Pago(double monto){
        this.monto = monto;
        this.fecha = LocalDate.now();
    }
    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }
    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    } 
}