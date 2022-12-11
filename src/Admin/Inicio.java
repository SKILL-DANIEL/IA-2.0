
package admin;

import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import login.Login;

public class Inicio extends JPanel {
    
    String user = Login.user;
    
    private JLabel saludo, fondo;
    Font font = new Font("Times New Roman", 1, 60);

    
    public Inicio(){
        setSize(1063, 763);
        setLayout(null);
        UnitComponents();
    }
    
    public void UnitComponents(){
        
        saludo = new JLabel("Bienvenido - "+user);
        saludo.setFont(font);
        saludo.setBounds(260, 100, 560, 50);
        add(saludo);
        
        Icon fon = new ImageIcon("C:\\Users\\Oscar\\Desktop\\Iconos\\Fondo.PNG");
        fondo = new JLabel(fon);
        fondo.setBounds(0, 0, 1063, 763);
        add(fondo);
        
        
    }
    
}

