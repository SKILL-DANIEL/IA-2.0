
package admin;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BackUpDB extends JPanel {
    
    private JLabel Titulo, paso1, paso2, paso3;
    private JButton BackUp;
    Font title = new Font("Times New Roman", 1, 60);
    Font subtitle = new Font("Times New Roman", 1, 20);
    
    public BackUpDB(){
        setSize(1063, 763);
        setLayout(null);
        Titulo();
        Labels();
        PanelCopia();
        PanelBackUp();
        PanelDescarga();
        Botones();
        
    }
    public void Titulo(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1063, 100);
        panel.setBackground(new Color( 192, 197, 193));
        panel.setLayout(new FlowLayout());
        Titulo = new JLabel("Asistente Copia de Seguridad");
        Titulo.setFont(title);
        panel.add(Titulo);
        add(panel);
    }
    private void Labels(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 200, 1063, 50);
        panel.setBackground(new Color( 192, 197, 193));
        panel.setLayout(new GridLayout(1, 3));
        
        Icon p1 = new ImageIcon(ClassLoader.getSystemResource("Image/numero-uno.png"));
        paso1 = new JLabel();
        paso1.setIcon(p1);
        paso1.setText("BackUp o Restore");
        paso1.setFont(subtitle);
        paso1.setOpaque(true);
        paso1.setBackground(Color.white);
        paso1.setBorder(new LineBorder(new Color( 239,72, 42), 1));
        paso1.setIconTextGap(50);
        
        Icon p2 = new ImageIcon(ClassLoader.getSystemResource("Image/paso2.png"));
        paso2 = new JLabel();
        paso2.setIcon(p2);
        paso2.setText("BackUp Completo o Parcial");;
        paso2.setFont(subtitle);
        paso2.setBorder(new LineBorder(new Color( 239,72, 42), 1));
        paso2.setIconTextGap(50);

        
        Icon p3 = new ImageIcon(ClassLoader.getSystemResource("Image/paso3.png"));
        paso3= new JLabel();
        paso3.setIcon(p3);
        paso3.setText("Descargar");
        paso3.setFont(subtitle);
        paso3.setOpaque(true);
        paso3.setBackground(Color.white);
        paso3.setBorder(new LineBorder(new Color( 239,72, 42), 1));
        paso3.setIconTextGap(50);

        panel.add(paso1);
        panel.add(paso2);
        panel.add(paso3);
        add(panel);
    }
    private void PanelBackUp(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 250, 1063, 300);
        panel.setBackground(new Color( 192, 197, 193));
        panel.setLayout(new GridLayout(1, 3));
    }
    private void PanelCopia(){
        
    }
    private void PanelDescarga(){
        
    }


    private void Botones() {
        Icon bu = new ImageIcon(ClassLoader.getSystemResource("Image/BackUp.png"));
        this.repaint();
        BackUp = new JButton();
        BackUp.setIcon(bu);
        BackUp.setText("BackUP Base de Datos");
        BackUp.setBounds(500, 365, 80, 80);
        BackUp.setBorder(null);
        BackUp.setFocusable(false);
        BackUp.setOpaque(false);
        BackUp.setBackground(Color.WHITE);
        BackUp.setHorizontalTextPosition(JButton.CENTER);
        BackUp.setVerticalTextPosition(JButton.BOTTOM);
        BackUp.setFont(new Font("Times new roman", Font.BOLD, 15));
        BackUp.setIconTextGap(-2);
        add(BackUp);
    }
}

