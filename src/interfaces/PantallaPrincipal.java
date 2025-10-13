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
        
        //Número de tarjeta
        gbc.gridx = 0; gbc.gridy = 3;
        lblDatoExtra = new JLabel("Número de tarjeta");
        add(lblDatoExtra,gbc);
        txtDatoExtra = new JTextField();
        gbc.gridx = 1;
        add(txtDatoExtra,gbc);
        
        // botón registrar pago
        btnPagar = new JButton("Pagar");
        gbc.gridx= 0; gbc.gridy = 4; gbc.gridwidth = 2; 
        add(btnPagar,gbc);
        
       txtResultado = new JTextArea(5,20);
       txtResultado.setEditable(false);
       txtResultado.setWrapStyleWord(true);
       gbc.gridy = 5;
       add(new JScrollPane(txtResultado),gbc);
       
       //seleccionar el elemento del combo
       comboOpciones.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               actualizarCampo();
           }
       });
       
       //Capturar evento del botón
       btnPagar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               procesarPago();
           }
       });
    }
 
    private void actualizarCampo(){
        String opcion = (String) comboOpciones.getSelectedItem();
        if(opcion.contains("Pago con Tarjeta")){
            lblDatoExtra.setText("Número de tarjeta:");
            txtDatoExtra.setEnabled(true);
        }else if (opcion.contains("PayPal")){
            lblDatoExtra.setText("Email:");
            lblDatoExtra.setEnabled(true);
        }else{
            lblDatoExtra.setText("No se requiere dato adicional");
            txtDatoExtra.setText("");
            txtDatoExtra.setEnabled(false);
        }
    }
    private void procesarPago(){
        try{
            double monto = Double.parseDouble(txtMonto.getText());
            String opcion = (String) comboOpciones.getSelectedItem();
            String datoExtra = txtDatoExtra.getText();
            String mensaje = "";
            Pagable pago;
            if(opcion.contains("Tarjeta")){
                pago = new Tarjeta(monto, datoExtra);
                mensaje = "Pagando $" + monto + "con Tarjeta número: "+ datoExtra;
            }else if (opcion.contains("PayPal")){
                pago = new Paypal(monto, datoExtra);
                mensaje = "Pagando $"+ monto + "mediante PayPal ("+datoExtra+")";
            }else{
                pago = new Efectivo(monto);
                mensaje = "Pagando $"+ monto + "En Efectivo";
            }
            pago.pagar();
            
            txtResultado.append(mensaje + "\n");
            
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Ingrese un monto valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new PantallaPrincipal().setVisible(true);
            }
        });
    }
}
