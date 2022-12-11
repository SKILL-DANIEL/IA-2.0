package ia;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EtchedBorder;
import login.Login;

    
public class menuPrincipal extends JFrame implements ActionListener {
    
    JPanel inicio = new JPanel();
    JPanel pnlIngreso = new JPanel();
    JPanel pnlSalida = new JPanel();
    JPanel pnlManual = new JPanel();;
    
    Ingreso in;
    Salida sa;
    Manual ma;
    
    private JPanel panel, panelContenido;
    private JButton btnIngreso, btnSalida, btnManual, btnCerrar;
    private JLabel j1NewUser, j1GestionUser, j1Registro, icono, jlad, re, facepass;
    Font fuente = new Font("Times New Roman", 1, 20);
    Font adm = new Font("Times New Roman", 1, 60);
    
    
    public menuPrincipal() {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(getIconImage());
        PanelLateral();
        PanelInicio();
        PanelIngreso();
        PanelSalida();
        PanelManual();
        accionar();
        
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Image/Logo.png"));
        return retValue;
    }
    public void PanelLateral(){
        
        panel = new JPanel();
        panel.setBounds(1, 2, 299, 766);
        panel.setBorder(new EtchedBorder());
        
        panel.setLayout(null);       
        add(panel);
        
        
        //------------Boton Registrar Ingreso------------\\
        Icon iconn = new ImageIcon(ClassLoader.getSystemResource("Image/ingreso.PNG"));
        this.btnIngreso = new JButton();
        repaint();
        btnIngreso.setIcon(iconn);
        btnIngreso.setText("Registrar Ingreso");
        btnIngreso.setBounds(1, 216, 297, 96);
        btnIngreso.setBorder(null);
        btnIngreso.setFocusable(false);
        btnIngreso.setOpaque(false);
        btnIngreso.setBackground(Color.WHITE);
        btnIngreso.setHorizontalTextPosition(JButton.CENTER);
        btnIngreso.setVerticalTextPosition(JButton.BOTTOM);
        btnIngreso.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnIngreso.setIconTextGap(-1);
        panel.add(btnIngreso);
        
        
        //------------Boton Registrar Salida------------\\
        Icon iconn2 = new ImageIcon(ClassLoader.getSystemResource("Image/salida.PNG"));
        this.btnSalida = new JButton(iconn2);
        this.repaint();
        btnSalida.setIcon(iconn2);
        btnSalida.setText("Registrar Salida");
        btnSalida.setBounds(1, 312, 297, 96);
        btnSalida.setBorder(null);
        btnSalida.setFocusable(false);
        btnSalida.setOpaque(false);
        btnSalida.setBackground(Color.WHITE);
        btnSalida.setHorizontalTextPosition(JButton.CENTER);
        btnSalida.setVerticalTextPosition(JButton.BOTTOM);
        btnSalida.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnSalida.setIconTextGap(-1);
        panel.add(btnSalida);
        
        
        //------------Boton Registro Manual------------\\
        Icon iconn3 = new ImageIcon(ClassLoader.getSystemResource("Image/manual.PNG"));
        this.btnManual = new JButton();
        this.repaint();
        btnManual.setIcon(iconn3);
        btnManual.setText("Registro Manual");
        btnManual.setBounds(1, 408, 297, 96);
        btnManual.setBorder(null);
        btnManual.setFocusable(false);
        btnManual.setOpaque(false);
        btnManual.setBackground(Color.WHITE);
        btnManual.setHorizontalTextPosition(JButton.CENTER);
        btnManual.setVerticalTextPosition(JButton.BOTTOM);
        btnManual.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnManual.setIconTextGap(-1);
        panel.add(btnManual);
        
        //------------Boton Cerrar Sesion------------\\
        Icon iconn5 = new ImageIcon(ClassLoader.getSystemResource("Image/Cerrar.PNG"));
        btnCerrar = new JButton();
        this.repaint();
        btnCerrar.setIcon(iconn5);
        btnCerrar.setText("Salir");
        btnCerrar.setBounds(1, 504, 297, 96);
        btnCerrar.setBorder(null);
        btnCerrar.setFocusable(false);
        btnCerrar.setOpaque(false);
        btnCerrar.setBackground(Color.WHITE);
        btnCerrar.setHorizontalTextPosition(JButton.CENTER);
        btnCerrar.setVerticalTextPosition(JButton.BOTTOM);
        btnCerrar.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnCerrar.setIconTextGap(-1);
        panel.add(btnCerrar);
        
        //------------Logo------------\\
        Icon icon = new ImageIcon(ClassLoader.getSystemResource("Image/FACEPASS.PNG"));
        icono = new JLabel(icon);
        this.repaint();
        icono.setBounds(49, 30, 200, 111);
        panel.add(icono);
        
        
    }
    public void PanelInicio(){
        inicio.setBorder(new EtchedBorder());
        inicio.setBounds(300, 2, 1066, 766);
        inicio.setLayout(null);
        inicio.setVisible(true);
        add(inicio);
    }
    public void PanelIngreso(){
        
        pnlIngreso.setBorder(new EtchedBorder());
        pnlIngreso.setBounds(300, 2, 1066, 766);
        pnlIngreso.setLayout(null);
        in = new Ingreso();
        in.setBounds(1, 1, 1063, 763);
        pnlIngreso.add(in);
        pnlIngreso.setVisible(false);
        add(pnlIngreso);
    }
    
    public void PanelSalida(){
        
        pnlSalida.setBorder(new EtchedBorder());
        pnlSalida.setBounds(300, 2, 1066, 766);
        pnlSalida.setLayout(null);
        sa = new Salida();
        sa.setBounds(1, 1, 1063, 763);
        pnlSalida.add(sa);
        pnlSalida.setVisible(false);
        add(pnlSalida);
        
    }
    public void PanelManual(){
        
        pnlManual.setBorder(new EtchedBorder());
        pnlManual.setBounds(300, 2, 1066, 707);
        pnlManual.setLayout(null);
        ma = new Manual();
        ma.setBounds(1, 1, 1063, 763);
        pnlManual.add(ma);
        pnlManual.setVisible(false);
        add(pnlManual);
        
    }
    public void accionar() {
        
        this.btnIngreso.addActionListener(this);
        this.btnSalida.addActionListener(this);
        this.btnManual.addActionListener(this);
        this.btnCerrar.addActionListener(this);
        
    }
    public void MostrarIngreso(){
        //------------Panel Ingreso------------\\
        pnlIngreso.setVisible(true);
        btnIngreso.setOpaque(true);
        btnIngreso.setBackground(new Color(253, 184, 87));
        //------------Panel Salida------------\\
        pnlSalida.setVisible(false);
        btnSalida.setOpaque(false);
        btnSalida.setBackground(Color.white);
        //------------Panel Inicio------------\\
        inicio.setVisible(false);
        //------------Panel Manual------------\\
        pnlManual.setVisible(false);
        btnManual.setOpaque(false);
        btnManual.setBackground(Color.white);
        
    }
    public void MostrarSalida(){
        //------------Panel Salida------------\\
        pnlSalida.setVisible(true);
        btnSalida.setOpaque(true);
        btnSalida.setBackground(new Color(253, 184, 87));
        //------------Panel Ingreso------------\\
        pnlIngreso.setVisible(false);
        btnIngreso.setOpaque(false);
        btnIngreso.setBackground(Color.white);
        //------------Panel Inicio------------\\
        inicio.setVisible(false);
        //------------Panel Manual------------\\
        pnlManual.setVisible(false);
        btnManual.setOpaque(false);
        btnManual.setBackground(Color.white);
    }
    public void MostrarManual(){
        //------------Panel Manual------------\\
        pnlManual.setVisible(true);
        btnManual.setOpaque(true);
        btnManual.setBackground(new Color(253, 184, 87));
        //------------Panel Ingreso------------\\
        pnlIngreso.setVisible(false);
        btnIngreso.setOpaque(false);
        btnIngreso.setBackground(Color.white);
        //------------Panel Salida------------\\
        pnlSalida.setVisible(false);
        btnSalida.setOpaque(false);
        btnSalida.setBackground(Color.white);
        //------------Panel Inicio------------\\
        inicio.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.btnIngreso) {
            MostrarIngreso(); 
        }else if (ae.getSource() == this.btnSalida) {
            MostrarSalida();
        }else if (ae.getSource() == this.btnManual) {
            MostrarManual();
        }else if (ae.getSource() == this.btnCerrar) {
            dispose();
            new Login().setVisible(true); 
            
        }
    } 
}

