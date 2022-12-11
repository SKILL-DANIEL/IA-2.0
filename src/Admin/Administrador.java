package admin;

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
import javax.swing.JTabbedPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EtchedBorder;
import login.Login;

    
public class Administrador extends JFrame implements ActionListener {
    
    JPanel inicio = new JPanel();
    JPanel pnlNewUser = new JPanel();
    JPanel pnlGestionUser = new JPanel();
    JPanel pnlRegistros = new JPanel();
    JPanel pnlBackUp = new JPanel();
    
    Inicio in;
    newEstudiante  newEst;
    newDocente newDoc;
    newAdministrativo newAdm;
    JTabbedPane pestañas;
    
    gestionEstudiante gesEst;
    gestionDocente gesDoc;
    gestionAdministrativo gesAdm;
    JTabbedPane gestionPestañas;
    
    gestionEstudiante gu;
    Registros reg;
    BackUpDB db;
    
    private JPanel panel, panelContenido;
    private JButton btnNewUser, btnGestionUser, btnRegistro, btnBackUp, btnCerrar;
    private JLabel j1NewUser, j1GestionUser, j1Registro, icono, jlad, re;
    Font fuente = new Font("Times New Roman", 1, 20);
    Font adm = new Font("Times New Roman", 1, 60);
    
    public Administrador() {
        String user = Login.user;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(getIconImage());
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        PanelLateral();
        PanelInicio();
        PanelNewUser();
        PanelGestionUser();
        PanelRegistros();
        PanelBackUp();
        accionar();
        
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Image/Logo.png"));
        return retValue;
    }
    public void PanelLateral(){
        
        panel = new JPanel();//------------Inicializa el Panel------------\\
        panel.setBounds(1, 2, 299, 766);//------------Dimensionar Panel------------\\
        panel.setBorder(new EtchedBorder());//------------Agregar Borde al Panel------------\\
        panel.setLayout(null);//------------Panel Con Layout Null------------\\       
        add(panel);//------------Añadir Panel Al JFrame------------\\
        
        //------------Boton Crear Usuarios------------\\
        Icon iconn = new ImageIcon(ClassLoader.getSystemResource("Image/newUser.PNG"));
        btnNewUser = new JButton();
        repaint();
        btnNewUser.setIcon(iconn);
        btnNewUser.setText("Usuario Nuevo");
        btnNewUser.setBounds(1, 180, 296, 96);
        btnNewUser.setBorder(null);
        btnNewUser.setFocusable(false);
        btnNewUser.setOpaque(false);
        btnNewUser.setBackground(Color.WHITE);
        btnNewUser.setHorizontalTextPosition(JButton.CENTER);
        btnNewUser.setVerticalTextPosition(JButton.BOTTOM);
        btnNewUser.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnNewUser.setIconTextGap(-2);
        panel.add(btnNewUser);
        
        //------------Boton Gestinar Usuarios------------\\
        Icon iconn2 = new ImageIcon(ClassLoader.getSystemResource("Image/gestionUser.PNG"));
        btnGestionUser = new JButton();
        repaint();
        btnGestionUser.setIcon(iconn2);
        btnGestionUser.setText("Gestión De Usuarios");
        btnGestionUser.setBounds(1, 276, 297, 96);
        btnGestionUser.setBorder(null);
        btnGestionUser.setFocusable(false);
        btnGestionUser.setOpaque(false);
        btnGestionUser.setBackground(Color.WHITE);
        btnGestionUser.setHorizontalTextPosition(JButton.CENTER);
        btnGestionUser.setVerticalTextPosition(JButton.BOTTOM);
        btnGestionUser.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnGestionUser.setIconTextGap(-2);
        panel.add(btnGestionUser);
        
        //------------Boton De Reportes------------\\
        Icon iconn3 = new ImageIcon(ClassLoader.getSystemResource("Image/Reporte.PNG"));
        btnRegistro = new JButton();
        this.repaint();
        btnRegistro.setIcon(iconn3);
        btnRegistro.setText("Reportes");
        btnRegistro.setBounds(1, 372, 297, 96);
        btnRegistro.setBorder(null);
        btnRegistro.setFocusable(false);
        btnRegistro.setOpaque(false);
        btnRegistro.setBackground(Color.WHITE);
        btnRegistro.setHorizontalTextPosition(JButton.CENTER);
        btnRegistro.setVerticalTextPosition(JButton.BOTTOM);
        btnRegistro.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnRegistro.setIconTextGap(-2);
        panel.add(btnRegistro);
        
        //------------Boton De BackUp Base de Datos------------\\
        Icon iconn4 = new ImageIcon(ClassLoader.getSystemResource("Image/ConfBackUp.PNG"));
        btnBackUp = new JButton();
        this.repaint();
        btnBackUp.setIcon(iconn4);
        btnBackUp.setText("Base de Datos");
        btnBackUp.setBounds(1, 468, 297, 96);
        btnBackUp.setBorder(null);
        btnBackUp.setFocusable(false);
        btnBackUp.setOpaque(false);
        btnBackUp.setBackground(Color.WHITE);
        btnBackUp.setHorizontalTextPosition(JButton.CENTER);
        btnBackUp.setVerticalTextPosition(JButton.BOTTOM);
        btnBackUp.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnBackUp.setIconTextGap(-2);
        panel.add(btnBackUp);
        
        //------------Boton Cerrar Sesion------------\\
        Icon iconn5 = new ImageIcon(ClassLoader.getSystemResource("Image/Cerrar.PNG"));
        btnCerrar = new JButton();
        this.repaint();
        btnCerrar.setIcon(iconn5);
        btnCerrar.setText("Salir");
        btnCerrar.setBounds(1, 564, 297, 96);
        btnCerrar.setBorder(null);
        btnCerrar.setFocusable(false);
        btnCerrar.setOpaque(false);
        btnCerrar.setBackground(Color.WHITE);
        btnCerrar.setHorizontalTextPosition(JButton.CENTER);
        btnCerrar.setVerticalTextPosition(JButton.BOTTOM);
        btnCerrar.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnCerrar.setIconTextGap(-2);
        panel.add(btnCerrar);
        
        //------------Logo------------\\
        Icon icon = new ImageIcon(ClassLoader.getSystemResource("Image/FACEPASS.PNG"));
        icono = new JLabel();
        repaint();
        icono.setIcon(icon);
        icono.setBounds(49, 30, 200, 111);
        panel.add(icono);
    }
    public void PanelInicio(){
        inicio.setBorder(new EtchedBorder());
        inicio.setBounds(300, 2, 1066, 766);
        inicio.setLayout(null);
        inicio.setVisible(true);
        in = new Inicio();
        in.setBackground(new Color( 192, 197, 193));
        in.setBounds(1, 1, 1063, 763);
        inicio.add(in);
        add(inicio);
    }
    public void PanelNewUser(){
        //------------Panel------------\\
        pnlNewUser.setBorder(new EtchedBorder());
        pnlNewUser.setBounds(300, 2, 1066, 766);
        pnlNewUser.setLayout(null);
        //------------Inicializar JTabbedPane------------\\
        pestañas = new JTabbedPane();
        newEst = new newEstudiante();
        newEst.setBackground(new Color( 192, 197, 193));
        newDoc = new newDocente();
        newDoc.setBackground(new Color( 192, 197, 193));
        newAdm = new newAdministrativo();
        newAdm.setBackground(new Color( 192, 197, 193));
        
        pestañas.addTab("Estudiante", newEst);
        pestañas.addTab("Docente", newDoc);
        pestañas.addTab("Administrativo", newAdm);
        pestañas.setBounds(1, 0, 1063, 763);
        pnlNewUser.add(pestañas);
        pnlNewUser.setVisible(false);
        add(pnlNewUser);
    }
    
    public void PanelGestionUser(){
        
        //------------Panel------------\\
        pnlGestionUser.setBorder(new EtchedBorder());
        pnlGestionUser.setBounds(300, 2, 1066, 766);
        pnlGestionUser.setLayout(null);
        //------------Inicializar JTabbedPane------------\\
        gestionPestañas = new JTabbedPane();
        gesEst = new gestionEstudiante();
        gesEst.setBackground(new Color( 192, 197, 193));
        gesDoc = new gestionDocente();
        gesDoc.setBackground(new Color( 192, 197, 193));
        gesAdm = new gestionAdministrativo();
        gesAdm.setBackground(new Color( 192, 197, 193));
        
        gestionPestañas.addTab("Estudiante", gesEst);
        gestionPestañas.addTab("Docente", gesDoc);
        gestionPestañas.addTab("Administrativo", gesAdm);
        gestionPestañas.setBounds(1, 0, 1063, 763);
        pnlGestionUser.add(gestionPestañas);
        pnlGestionUser.setVisible(false);
        add(pnlGestionUser);
        
    }
    private void PanelRegistros() {
        
        pnlRegistros.setBorder(new EtchedBorder());
        pnlRegistros.setBounds(300, 2, 1066, 766);
        pnlRegistros.setLayout(null);
        reg = new Registros();
        reg.setBackground(new Color( 192, 197, 193));
        reg.setBounds(1, 1, 1063, 763);
        pnlRegistros.add(reg);
        pnlRegistros.setVisible(false);
        add(pnlRegistros); 
        
    }

    private void PanelBackUp() {
        
        pnlBackUp.setBorder(new EtchedBorder());
        pnlBackUp.setBounds(300, 2, 1066, 766);
        pnlBackUp.setLayout(null);
        db = new BackUpDB();
        db.setBackground(new Color( 192, 197, 193));
        db.setBounds(1, 1, 1063, 763);
        pnlBackUp.add(db);
        pnlBackUp.setVisible(false);
        add(pnlBackUp); 
        
    }
    public void accionar() {
        
        this.btnNewUser.addActionListener(this);
        this.btnGestionUser.addActionListener(this);
        this.btnRegistro.addActionListener(this);
        this.btnBackUp.addActionListener(this);
        this.btnCerrar.addActionListener(this);
        
    }
    public void MostrarNewUser(){
        //------------Panel New User------------\\
        pnlNewUser.setVisible(true);
        btnNewUser.setOpaque(true);
        btnNewUser.setBackground(new Color(253, 184, 87));
        //------------Panel Gestion User------------\\
        pnlGestionUser.setVisible(false);
        btnGestionUser.setOpaque(false);
        btnGestionUser.setBackground(Color.white);
        //------------Panel Inicio------------\\
        inicio.setVisible(false);
        //------------Panel Registros------------\\
        pnlRegistros.setVisible(false);
        btnRegistro.setOpaque(false);
        btnRegistro.setBackground(Color.white);
        //------------Panel BackUp------------\\
        pnlBackUp.setVisible(false);
        btnBackUp.setOpaque(false);
        btnBackUp.setBackground(Color.white);
    }
    public void MostrarGestionUser(){
        //------------Panel Gestion User------------\\
        pnlGestionUser.setVisible(true);
        btnGestionUser.setOpaque(true);
        btnGestionUser.setBackground(new Color(253, 184, 87));
        //------------Panel New User------------\\
        pnlNewUser.setVisible(false);
        btnNewUser.setOpaque(false);
        btnNewUser.setBackground(Color.white);
        //------------Panel Inicio------------\\
        inicio.setVisible(false);
        //------------Panel Registros------------\\
        pnlRegistros.setVisible(false);
        btnRegistro.setOpaque(false);
        btnRegistro.setBackground(Color.white);
        //------------Panel BackUp------------\\
        pnlBackUp.setVisible(false);
        btnBackUp.setOpaque(false);
        btnBackUp.setBackground(Color.white);
    }
    public void MostrarRegistros(){
        //------------Panel Registros------------\\
        pnlRegistros.setVisible(true);
        btnRegistro.setOpaque(true);
        btnRegistro.setBackground(new Color(253, 184, 87));
        //------------Panel New User------------\\
        pnlNewUser.setVisible(false);
        btnNewUser.setOpaque(false);
        btnNewUser.setBackground(Color.white);
        //------------Panel Gestion User------------\\
        pnlGestionUser.setVisible(false);
        btnGestionUser.setOpaque(false);
        btnGestionUser.setBackground(Color.white);
        //------------Panel Inicio------------\\
        inicio.setVisible(false);
        //------------Panel BackUp------------\\
        pnlBackUp.setVisible(false);
        btnBackUp.setOpaque(false);
        btnBackUp.setBackground(Color.white);
    }
    public void MostrarBackUp(){
        //------------Panel BackUp------------\\
        pnlBackUp.setVisible(true);
        btnBackUp.setOpaque(true);
        btnBackUp.setBackground(new Color(253, 184, 87));
        //------------Panel Registros------------\\
        pnlRegistros.setVisible(false);
        btnRegistro.setOpaque(false);
        btnRegistro.setBackground(Color.white);
        //------------Panel New User------------\\
        pnlNewUser.setVisible(false);
        btnNewUser.setOpaque(false);
        btnNewUser.setBackground(Color.white);
        //------------Panel Gestion User------------\\
        pnlGestionUser.setVisible(false);
        btnGestionUser.setOpaque(false);
        btnGestionUser.setBackground(Color.white);
        //------------Panel Inicio------------\\
        inicio.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.btnNewUser) {
            MostrarNewUser();
        }else if (ae.getSource() == this.btnGestionUser) {
            MostrarGestionUser();
        }else if (ae.getSource() == this.btnRegistro) {
            MostrarRegistros();
        }else if (ae.getSource() == this.btnBackUp) {
            MostrarBackUp();
        }else if (ae.getSource() == this.btnCerrar) {
            dispose();
            new Login().setVisible(true); 
        }
    }  
}



