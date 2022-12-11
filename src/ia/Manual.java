package ia;

import Conexion.Conexion;
import com.toedter.calendar.JDateChooser;
import login.Login;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

    
public class Manual extends JPanel implements ActionListener {
     private JButton btnGuardar;
    private JLabel j10,j11, j12, j13, j14, j15, j16, j17, j18,re;
    JFormattedTextField jf1 ;
    private JTextField jf2, jf3, jf4, jf5, jf7, jf8;
    Font fuente = new Font("Times New Roman", 1, 20);
    Font fuente1 = new Font("Times New Roman", 1, 15);
    Font adm = new Font("Times New Roman", 1, 100);
    
    String [] optionsToChoose={"Activo", "Inactivo"};
    
    
    public Manual() {
        
        setSize(1063, 763);
        setVisible(true);
        setLayout(null);
        
        Titulo();
        panelTitulo();
        ID();
        CaracteresEspeciale();
        Nombre();
        Apellido();
        Programa();
        Facultad();
        btnGuardar();
        
    }
    public void Titulo(){
        
        j10 = new JLabel("Ingreso Manual");
        j10.setFont(adm);
        
        
    }
    public void panelTitulo(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 80, 1063, 120);
        panel.setLayout(new FlowLayout());
        panel.add(j10);
        add(panel);
        
    }
    public void ID(){
        
        j11 = new JLabel("Numero de Identificación");
        j11.setFont(fuente);
        j11.setBounds(110, 300, 215, 40);
        add(j11);
        
        jf1 = new JFormattedTextField();
        jf1.setFont(fuente1);
        jf1.setBounds(70, 340, 300, 20);
        jf1.setHorizontalAlignment(JFormattedTextField.CENTER);
        add(jf1);
        
    }
    public void CaracteresEspeciale(){
        jf1.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() >=0 &&  e.getKeyChar() <= 7 ||e.getKeyChar() >= 9 &&  e.getKeyChar() <= 47 || e.getKeyChar() >= 58) {
                    getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten Letras ni Caracteres especiales");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public void Nombre(){
        
        j12 = new JLabel("Nombre");
        j12.setFont(fuente);
        j12.setBounds(496, 300, 70, 40);
        add(j12);
        jf2 = new JTextField();
        jf2.setFont(fuente1);
        jf2.setBounds(382, 340, 300, 20);
        jf2.setHorizontalAlignment(JTextField.CENTER);
        add(jf2);
        
    }
    public void Apellido(){
        
        this.j13 = new JLabel("Apellido");
        j13.setFont(fuente);
        j13.setBounds(799, 300, 90, 40);
        add(j13);
        
        this.jf3 = new JTextField();
        jf3.setFont(fuente1);
        this.jf3.setBounds(694, 340, 300, 20);
        jf3.setHorizontalAlignment(JTextField.CENTER);
        add(jf3);
        
    }
    public void Programa(){
        
        j14 = new JLabel("Facultad");
        j14.setFont(fuente);
        j14.setBounds(185, 400, 90, 40);
        add(j14);
        
        jf4 = new JTextField();
        jf4.setFont(fuente1);
        jf4.setBounds(70, 440, 300, 20);
        jf4.setHorizontalAlignment(JTextField.CENTER);
        add(jf4);
        
    }
    public void Facultad(){
        
        j15 = new JLabel("Carrera");
        j15.setFont(fuente);
        j15.setBounds(497, 400, 69, 40);
        add(j15);
        
        jf5 = new JTextField();
        jf5.setFont(fuente1);
        jf5.setBounds(382, 440, 300, 20);
        jf5.setHorizontalAlignment(JTextField.CENTER);
        add(jf5);
        
    }
    public void btnGuardar(){
        
        Icon Guardar = new ImageIcon(ClassLoader.getSystemResource("Image/Guardar.PNG"));
        btnGuardar = new JButton();
        repaint();
        btnGuardar.setIcon(Guardar);
        btnGuardar.setText("Guardar");
        btnGuardar.setBounds(482, 520, 100, 100);
        btnGuardar.setBorder(null);
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setOpaque(false);
        btnGuardar.setHorizontalTextPosition(JButton.CENTER);
        btnGuardar.setVerticalTextPosition(JButton.BOTTOM);
        btnGuardar.setFont(new Font("Times new roman", Font.BOLD, 20));
        btnGuardar.setIconTextGap(-2);
        add(btnGuardar);
        btnGuardar.addActionListener(this);
        
    }
    public void Resolucion(){
        
        this.re = new JLabel("Fundacion Universitaria Compensar P.J Resolución 23625 del 23 de Diciembre "
                + "1981 12455 del 9 de julio 2020. - VIGILADA MINIEDUCACIÓN");
        this.re.setBounds(141, 715, 780, 20);
        add(re);
        
    }
    
    public void Limpiar(){
        
        jf1.setText("");
        jf2.setText("");
        jf3.setText("");
        jf4.setText("");
        jf5.setText("");
        
    }
    public void verde(){
        jf1.setBackground(Color.green);
        jf2.setBackground(Color.green);
        jf3.setBackground(Color.green);
        jf4.setBackground(Color.green);
        jf5.setBackground(Color.green);
    }
    public void blanco(){
        jf1.setBackground(Color.WHITE);
        jf2.setBackground(Color.WHITE);
        jf3.setBackground(Color.WHITE);
        jf4.setBackground(Color.WHITE);
        jf5.setBackground(Color.WHITE);
    }
    public void Guardar(){
        
        String nombre, apellido, email, telefono, fNacimiento, facultad, carrera;
        int nIdentificacion = Integer.parseInt(jf1.getText().trim());
        nombre = jf2.getText().trim();
        apellido = jf3.getText().trim();    
        facultad = jf4.getText().trim();
        carrera = jf5.getText().trim();
        
        if (jf1.getText().isEmpty()) {

            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Identificacion Obligatoria");

        } else {
            try {

                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "Insert into estudiante() Values(?,?,?,?,?)");

                pst2.setInt(1, nIdentificacion);
                pst2.setString(2, nombre);
                pst2.setString(3, apellido);
                pst2.setString(4, carrera);
                pst2.setString(5, facultad);;
                pst2.executeUpdate();
                cn2.close();

                Limpiar();
                verde();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                blanco();

            } catch (SQLException e) {
                System.err.println("Error en Registrar Usuario. " + e);
                JOptionPane.showMessageDialog(null, "¡¡Error al Registrar!!, Contacte con el Administrador.");
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.btnGuardar) {  
            Guardar();
        }
    }
}
        
