package login;

import admin.Administrador;
import java.sql.*;
import Conexion.Conexion;
import ia.menuPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    public static String user = "";
    String pass = "";
    
    private JPanel Panel;
    private JButton btnAcceso, btnSalir;
    private JLabel jicon, iUser,iPass, jFondo, icon;
    private JTextField jUser, jpass;
    Font fuente = new Font("Times new roman", Font.BOLD, 15);
    Font fontbtn = new Font("Times New Roman", 1, 20);

    public Login() {
        
        setTitle("Iniciar Sesion");
        //setIconImage(getIconImage());
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Logo();
        Iconos();
        TextFields();
        Buttons();
        Panel();
        adicionar();
        Visualizar();
        accionar();
        Enter();
        
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Image/Logo.png"));
        return retValue;
    }
    public void Panel(){
        //Panel
        jFondo = new JLabel();
        jFondo.setBackground(new Color( 192, 197, 193));
        jFondo.setBounds(0, 0, 600, 600);
        
        Panel = new JPanel();
        Panel.setBounds(0, 0, 600, 600);
        Panel.setLayout(null);
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(new Color( 239,72, 42));
        g.drawLine(200, 283, 400, 283);
        g.setColor(new Color( 239,72, 42));
        g.drawLine(200, 355, 400, 355);
    }
    public void Logo(){
        
        Icon ic = new ImageIcon (ClassLoader.getSystemResource("Image/FACEPASS.PNG"));
        jicon = new JLabel();
        jicon.setIcon(ic);
        jicon.setBounds(200, 15, 200, 111);
        
    }
    public void Iconos(){
        
        Icon iconU = new ImageIcon(ClassLoader.getSystemResource("Image/iconUser.PNG"));
        iUser = new JLabel();
        iUser.setIcon(iconU);
        iUser.setBounds(200, 228, 100, 32);
        iUser.setText("Usuario");
        iUser.setFont(fuente);
        iUser.setIconTextGap(-2);
        
        Icon iconP = new ImageIcon(ClassLoader.getSystemResource("Image/iconPass.PNG"));
        iPass = new JLabel();
        iPass.setIcon(iconP);
        iPass.setBounds(200, 300, 115, 32);
        iPass.setText(" Contraseña");
        iPass.setFont(fuente);
        iPass.setIconTextGap(-2);
        
        Icon ico = new ImageIcon(ClassLoader.getSystemResource("Image/icon.PNG"));
        this.icon = new JLabel(ico);
        this.repaint();
        icon.setBounds(252, 120, 96, 96);
        
    }
    public void TextFields(){
        
        //Usuario
        jUser = new JTextField();
        jUser.setFont(fuente);
        jUser.setBounds(200, 260, 200, 20);
        jUser.setBorder(BorderFactory.createEmptyBorder());
        jUser.setOpaque(false);

        //Contraseña
        jpass = new JPasswordField();
        jpass.setFont(fuente);
        jpass.setBounds(200, 332, 200, 20);
        jpass.setBorder(BorderFactory.createEmptyBorder());
        jpass.setOpaque(false);
        
    }
    public void Buttons(){
        
        Icon iconbtn = new ImageIcon(ClassLoader.getSystemResource("Image/Enter_On.PNG"));
        this.btnAcceso = new JButton();
        btnAcceso.setIcon(iconbtn);
        btnAcceso.setBounds(235, 400, 130, 40);
        btnAcceso.setBackground(Color.WHITE);
        btnAcceso.setOpaque(false);
        btnAcceso.setFocusable(false);
        btnAcceso.setBorder(null);
        
        Icon bSalir = new ImageIcon(ClassLoader.getSystemResource("Image/iconSalir.PNG"));
        this.btnSalir = new JButton(bSalir);
        btnSalir.setIcon(bSalir);
        btnSalir.setBounds(563, 5, 32, 32);
        btnSalir.setBackground(Color.WHITE);
        btnSalir.setOpaque(false);
        btnSalir.setFocusable(false);
        btnSalir.setBorder(null);
        
    }
    public void adicionar() {

        //Icono
        Panel.add(this.jicon);
        Panel.add(this.icon);

        //Boton
        Panel.add(this.btnAcceso);
        Panel.add(this.btnSalir);

        //Usuario y Contraseña
        Panel.add(this.iUser);
        Panel.add(this.jUser);
        Panel.add(this.iPass);
        Panel.add(this.jpass);
        
        Panel.add(this.jFondo);
        add(this.Panel);

    }
    public void Visualizar() {
        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null); 
    }
    public void accionar() {

        this.btnAcceso.addActionListener(this);
        this.btnSalir.addActionListener(this);

    }
    public void Enter(){
        jpass.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Ingresar();
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 255) {
                    getToolkit().beep();
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        jUser.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Ingresar();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 255) {
                    getToolkit().beep();
                    e.consume();   
                }   
            }
        });
    }
    public void Ingresar(){
        user = jUser.getText().trim();
        pass = jpass.getText().trim();

        if (!user.equals("") || !pass.equals("")) {
            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select Cargo from login where usuario = '" + user
                        + "' and contraseña = '" + pass + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    String cargo = rs.getString("cargo");

                    if (cargo.equalsIgnoreCase("Administrativo")) {
                        dispose();
                        new Administrador().setVisible(true);
                    } else if (cargo.equalsIgnoreCase("Seguridad")) {
                        dispose();
                        new menuPrincipal().setVisible(true);
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Datos de acceso Incorrectos.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                    jUser.setText("");
                    jpass.setText("");

                }

            } catch (SQLException e) {

                System.err.println("Error en el Botón Acceder" + e);
                JOptionPane.showMessageDialog(null, "¡¡Error al Iniciar Sesión!!, Contacte con el Administrador", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campor", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.btnAcceso) {
            Ingresar();
        }else if (ae.getSource() == this.btnSalir) {
            System.exit(0);
        }      
    }
}
