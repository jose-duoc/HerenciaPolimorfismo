package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Duoc
 */
public class PantallaPrincipal extends JFrame{
    private JComboBox<String> comboOpciones;
    private JTextField txtMonto;
    private JTextField txtDatoExtra;
    private JLabel lblDatoExtra;
    private JButton btnPagar;
    private JTextArea txtResultado;
    
    public PantallaPrincipal(){
        setTitle("Menú de Pagos");
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        //Margen y ubicación de elementos
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel lblTitulo = new JLabel("=== MENÚ DE PAGOS ===",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo,gbc);
        
        //ComboBox
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(new JLabel("Seleccione una opción"),gbc);
        comboOpciones = new JComboBox<>(new String[]{"Pago con Tarjeta", "Pago en efectivo","Pago con PayPal"});
        gbc.gridx = 1;
        add(comboOpciones,gbc);
        
        // Monto
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Monto:"),gbc);
        txtMonto = new JTextField();
        gbc.gridx = 1;
        add(txtMonto, gbc);
        
        // Monto2
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Monto:"),gbc);
        txtMonto = new JTextField();
        gbc.gridx = 1;
        add(txtMonto, gbc);
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new PantallaPrincipal().setVisible(true);
            }
        });
    }
}
