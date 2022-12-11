
package ia;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ingreso extends JPanel implements ActionListener {

    private JLabel j11, j12, j13, j14, j15, jia, re,jIngreso;
    private JButton btnActivar, btnReconocer, btnRegistar;
    JPanel Panel = new JPanel();
    Font fuente = new Font("Times New Roman", 1, 20);
    Font welcome = new Font("Times New Roman", 1, 60);
    
    public Ingreso() {
        
        setSize(1063, 763);
        setVisible(true);
        setLayout(null);
        
        Botones();
        Iconos();
        Label();
        Registros();
        Resolucion();
        adicionar();
        Panel();

    }
    public void Botones(){
        //------------Boton Activar Camara------------\\
        Icon ac = new ImageIcon(ClassLoader.getSystemResource("Image/activar.png"));
        btnActivar = new JButton();
        btnActivar.setIcon(ac);
        btnActivar.setText("Activar");
        btnActivar.setBounds(170, 620, 100, 100);
        btnActivar.setBorder(null);
        btnActivar.setFocusable(false);
        btnActivar.setOpaque(false);
        btnActivar.setBackground(Color.WHITE);
        btnActivar.setHorizontalTextPosition(JButton.CENTER);
        btnActivar.setVerticalTextPosition(JButton.EAST);
        btnActivar.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnActivar.setIconTextGap(-2);
        add(btnActivar);
        btnActivar.addActionListener(this);
        //------------Boton Reconocer Persona------------\\
        Icon rc = new ImageIcon(ClassLoader.getSystemResource("Image/reconocer.png"));
        btnReconocer = new JButton();
        btnReconocer.setIcon(rc);
        btnReconocer.setText("Reconocer");
        btnReconocer.setBounds(330, 620, 100, 100);
        btnReconocer.setBorder(null);
        btnReconocer.setFocusable(false);
        btnReconocer.setOpaque(false);
        btnReconocer.setBackground(Color.WHITE);
        btnReconocer.setHorizontalTextPosition(JButton.CENTER);
        btnReconocer.setVerticalTextPosition(JButton.EAST);
        btnReconocer.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnReconocer.setIconTextGap(-2);
        add(btnReconocer);
        btnReconocer.addActionListener(this);
        btnReconocer.setEnabled(false);
        //------------Boton Registrar Persona------------\\
        Icon reg = new ImageIcon(ClassLoader.getSystemResource("Image/registrar.png"));
        btnRegistar = new JButton();
        btnRegistar.setIcon(reg);
        btnRegistar.setText("Registrar");
        btnRegistar.setBounds(750, 620, 100, 100);
        btnRegistar.setBorder(null);
        btnRegistar.setFocusable(false);
        btnRegistar.setOpaque(false);
        btnRegistar.setBackground(Color.WHITE);
        btnRegistar.setHorizontalTextPosition(JButton.CENTER);
        btnRegistar.setVerticalTextPosition(JButton.EAST);
        btnRegistar.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnRegistar.setIconTextGap(-2);
        add(btnRegistar);
        btnRegistar.addActionListener(this);
        btnRegistar.setEnabled(false);
    }
    public void Iconos() {
        //------------Camara------------\\
        Icon icon1 = new ImageIcon(ClassLoader.getSystemResource("Image/ia.jpeg"));
        jia = new JLabel(icon1);
        jia.setBounds(80, 175, 433, 439);
        
    }
    public void Panel(){
        Panel.setBounds(640, 175, 300, 439);
        Panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
        Panel.add(j11);
        Panel.add(j12);
        Panel.add(j13);
        Panel.add(j14);
        Panel.add(j15);
        Panel.add(jIngreso);
    }
    public void Label(){
        
        //------------Saludo------------\\
        j11 = new JLabel();
        j11.setFont(welcome);
        //------------Nombre------------\\
        j12 = new JLabel();
        j12.setFont(fuente);
        //------------Carrera------------\\
        j13 = new JLabel();
        j13.setFont(fuente);
        //------------Facultad------------\\
        j14 = new JLabel();
        j14.setFont(fuente);
        
    }
    public void Registros(){
        //------------Hora de Entrada------------\\
        j15 = new JLabel();
        j15.setFont(fuente);
        //------------Fecha y Hora------------\\
        jIngreso = new JLabel();
        jIngreso.setFont(fuente);
    }
    public void Resolucion(){
        //------------Resolución------------\\
        re = new JLabel();
        re.setText("Fundacion Universitaria Compensar P.J Resolución 23625 del 23 de Diciembre "
                + "1981 12455 del 9 de julio 2020. - VIGILADA MINIEDUCACIÓN");
        re.setBounds(141, 736, 780, 20);
    }
    public void adicionar() {
        add(this.jia);
        add(this.re);
        add(Panel);  
    }
    public void Reconocer(){
        Panel.setVisible(true);
        this.j11.setVisible(true);
        this.j11.setText("Welcome!!");
        this.j12.setVisible(true);
        this.j12.setText("Cesar Luis Rodriguez Solera");
        this.j13.setVisible(true);
        this.j13.setText("Ingeniería de Sistemas");
        this.j14.setVisible(true);
        this.j14.setText("Facultad de ingenieria");
        this.j15.setVisible(true);
        this.j15.setText("Hora Entrada");
        this.jia.setVisible(true);

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String horaActual = formateador.format(LocalDateTime.now());
        this.jIngreso.setText(horaActual);
    }
    public void Registrar(){
        int input = JOptionPane.showConfirmDialog(null,
                "Usuario Registrado Correctamente", "Alerta",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        Limpiar();
    }
    public void ActivarCamara(){
        Icon icno = new ImageIcon(ClassLoader.getSystemResource("Image/desactivar.png"));
            btnActivar.setIcon(icno);
    }
    public void Limpiar(){
        Panel.setVisible(false);;
        this.j11.setText("");
        this.j12.setText("");
        this.j13.setText("");;
        this.j14.setText("");
        this.j15.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.btnReconocer){
            Reconocer();
            btnRegistar.setEnabled(true);
        }else if(ae.getSource() == this.btnRegistar){
            Registrar();
        }else if(ae.getSource() == this.btnActivar){
            ActivarCamara();
            btnReconocer.setEnabled(true);
        }
    }
}



