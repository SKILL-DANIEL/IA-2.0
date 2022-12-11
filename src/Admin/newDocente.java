package admin;
import Conexion.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

    
public class newDocente extends JPanel implements ActionListener {
    
    private JDateChooser txt_Date;
    private JButton btnGuardar, btnTomarFoto;
    private JLabel j10, j11, j12, j13, j14, j15, j16, j17, j18, re;
    private JTextField txt_id, txt_Nombre, txt_Apellido, txt_Email, txt_Telefono, txt_Programa, txt_Jornada;
    Font fuente = new Font("Times New Roman", 1, 20);
    Font fuente1 = new Font("Times New Roman", 1, 15);
    Font adm = new Font("Times New Roman", 1, 60);
    
    String [] optionsToChoose={"Activo", "Inactivo"};
    
    public JLabel cameraScreen;
    public JButton btnCapture;
    public VideoCapture capture;
    public Mat image;
    public boolean clicked = false;
    
    public newDocente() {
        setSize(1063, 763);
        setVisible(true);
        setLayout(null);
        
        Titulo();
        ID();
        Nombre();
        Apellido();
        Email();
        Telefono();
        fNacimiento();
        Horario();
        Cargo();
        btnGuardar();
        btnTomarFoto();
        

    }
    public void Panel(){
        JFrame jr = new JFrame();
        jr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jr.setLayout(null);
        jr.setSize(new Dimension(640, 560));
        jr.setLocationRelativeTo(null);
        jr.setVisible(true);
        
        cameraScreen = new JLabel();
        cameraScreen.setBounds(0, 0, 640, 480);
        add(cameraScreen);
        
        
        btnCapture = new JButton("capture");
        btnCapture.setBounds(300, 480, 80, 40);
        add(btnCapture);
	
	VideoCapture capture;
	Mat image;
	clicked = false;

        btnCapture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clicked = true;

            }

        });
    }
    public void startCamera() {
        capture = new VideoCapture(0);
        image = new Mat();
        byte[] imageData;

        ImageIcon icon;
        while (true) {
            capture.read(image);

            final MatOfByte buf = new MatOfByte();
            Imgcodecs.imencode(".jpg", image, buf);

            imageData = buf.toArray();

            icon = new ImageIcon(imageData);
            cameraScreen.setIcon(icon);

            if (clicked) {
                String name = JOptionPane.showInputDialog(this, "Enter image name");
                if (name == null) {
                    name = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date());
                } else {
                    Imgcodecs.imwrite("images/" + name + ".jpeg", image);

                }
                clicked = false;

            }
        }
    }
	
    public void main() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                camara camera = new camara();

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        camera.startCamera();

                    }
                }).start();

            }

        });
    }
    public void Titulo(){
        
        j10 = new JLabel("Docente Nuevo");
        j10.setFont(adm);
        j10.setBounds(330, 50, 460, 40);
        add(j10);
        
    }
    public void ID(){
        
        j11 = new JLabel("Numero de Identificación");
        j11.setFont(fuente);
        j11.setBounds(110, 220, 215, 40);
        add(j11);
        
        txt_id = new JFormattedTextField();
        txt_id.setFont(fuente1);
        txt_id.setBounds(70, 260, 300, 20);
        txt_id.setHorizontalAlignment(JFormattedTextField.CENTER);
        add(txt_id);
        
    }
    public void Nombre(){
        
        j12 = new JLabel("Nombre");
        j12.setFont(fuente);
        j12.setBounds(496, 220, 70, 40);
        add(j12);
        txt_Nombre = new JTextField();
        txt_Nombre.setFont(fuente1);
        txt_Nombre.setBounds(382, 260, 300, 20);
        txt_Nombre.setHorizontalAlignment(JTextField.CENTER);
        add(txt_Nombre);
        
    }
    public void Apellido(){
        
        this.j13 = new JLabel("Apellido");
        j13.setFont(fuente);
        j13.setBounds(799, 220, 90, 40);
        add(j13);
        
        this.txt_Apellido = new JTextField();
        txt_Apellido.setFont(fuente1);
        this.txt_Apellido.setBounds(694, 260, 300, 20);
        txt_Apellido.setHorizontalAlignment(JTextField.CENTER);
        add(txt_Apellido);
        
    }
    public void Email(){
        
        j14 = new JLabel("Correo Institucional");
        j14.setFont(fuente);
        j14.setBounds(130, 320, 170, 40);
        add(j14);
        
        txt_Email = new JTextField();
        txt_Email.setFont(fuente1);
        txt_Email.setBounds(70, 360, 300, 20);
        txt_Email.setHorizontalAlignment(JTextField.CENTER);
        add(txt_Email);
        
    }
    public void Telefono(){
        
        j15 = new JLabel("Telefono");
        j15.setBounds(486, 320, 90, 40);
        j15.setFont(fuente);
        add(j15);
        
        txt_Telefono = new JTextField();
        txt_Telefono.setFont(fuente1);
        txt_Telefono.setBounds(382, 360, 300, 20);
        txt_Telefono.setHorizontalAlignment(JTextField.CENTER);
        add(txt_Telefono);
        
    }
    public void fNacimiento(){
        
        j16 = new JLabel("Fecha de Nacimiento");
        j16.setFont(fuente);
        j16.setBounds(754, 320, 180, 40);
        add(j16);
        
        txt_Date = new com.toedter.calendar.JDateChooser();
        txt_Date.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_Date.setDateFormatString("dd/MM/yyyy");
        txt_Date.setBounds(694, 360, 300, 20);
        txt_Date.setFont(fuente1);
        add(txt_Date);
        
    }
    public void Horario(){
        
        j17 = new JLabel("Horario");
        j17.setFont(fuente);
        j17.setBounds(185, 420, 70, 40);
        add(j17);
        
        txt_Programa = new JTextField();
        txt_Programa.setFont(fuente1);
        txt_Programa.setBounds(70, 460, 300, 20);
        txt_Programa.setHorizontalAlignment(JTextField.CENTER);
        add(txt_Programa);
        
    }
    public void Cargo(){
        
        j18 = new JLabel("Cargo");
        j18.setFont(fuente);
        j18.setBounds(497, 420, 70, 40);
        add(j18);
        
        txt_Jornada = new JTextField();
        txt_Jornada.setFont(fuente1);
        txt_Jornada.setBounds(382, 460, 300, 20);
        txt_Jornada.setHorizontalAlignment(JTextField.CENTER);
        add(txt_Jornada);
        
    }
    public void btnTomarFoto() {
        btnTomarFoto = new JButton();
        btnTomarFoto.setText("Tomar Foto");
        btnTomarFoto.setBounds(694, 460, 300, 20);
        add(btnTomarFoto);
        btnTomarFoto.addActionListener(this);
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
        
        this.re = new JLabel("Fundacion Universitaria Compensar P.J Resolución 23625 del 23 de Diciembre 1981 12455 del 9 de julio 2020. - VIGILADA MINIEDUCACIÓN");
        this.re.setBounds(141, 715, 780, 20);
        add(re);
        
    }
    
    public void Limpiar(){
        
        txt_id.setText("");
        txt_Nombre.setText("");
        txt_Apellido.setText("");
        txt_Email.setText("");
        txt_Telefono.setText("");
        txt_Date.setDate(null);
        txt_Programa.setText("");
        txt_Jornada.setText("");
        
    }
    public void verde(){
        txt_id.setBackground(Color.green);
        txt_Nombre.setBackground(Color.green);
        txt_Apellido.setBackground(Color.green);
        txt_Email.setBackground(Color.green);
        txt_Telefono.setBackground(Color.green);
        for( Component c : txt_Date.getComponents()){
            ((JComponent)c).setBackground(Color.green);
        }
        txt_Programa.setBackground(Color.green);
        txt_Jornada.setBackground(Color.green);
    }
    public void blanco(){
        txt_id.setBackground(Color.WHITE);
        txt_Nombre.setBackground(Color.WHITE);
        txt_Apellido.setBackground(Color.WHITE);
        txt_Email.setBackground(Color.WHITE);
        txt_Telefono.setBackground(Color.WHITE);
        for( Component c : txt_Date.getComponents()){
            ((JComponent)c).setBackground(Color.WHITE);
        }
        txt_Programa.setBackground(Color.WHITE);
        txt_Jornada.setBackground(Color.WHITE);
    }
    public void Guardar(){
        
        String nombre, apellido, email, telefono, fNacimiento, horario, cargo;
        int nIdentificacion = Integer.parseInt(txt_id.getText().trim());
        nombre = txt_Nombre.getText().trim();
        apellido = txt_Apellido.getText().trim();    
        email = txt_Email.getText().trim();
        telefono = txt_Telefono.getText().trim();
        fNacimiento = ((JTextField)txt_Date.getDateEditor().getUiComponent()).getText();
        horario = txt_Programa.getText().trim();
        cargo = txt_Jornada.getText().trim();
        
        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_docente from docente where id_docente = '" + nIdentificacion + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_id.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Número de Identifición No Disponible");
                cn.close();
                
            }else if (txt_id.getText().isEmpty()) {
                
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Identificacion Obligatoria");
                    
            }else {

                cn.close();
                try {
                    
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "Insert into docente() Values(?,?,?,?,?,?,?,?)");

                    pst2.setInt(1, nIdentificacion);
                    pst2.setString(2, nombre);
                    pst2.setString(3, apellido);
                    pst2.setString(4, email);
                    pst2.setString(5, telefono);
                    pst2.setString(6, fNacimiento);
                    pst2.setString(7, horario);
                    pst2.setString(8, cargo);
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
        } catch (SQLException e) {
            System.err.println("Error en Validar Número de identifición." + e);
            JOptionPane.showMessageDialog(null, "Error al Comparar La Identificación");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.btnGuardar) {
            Guardar();
        }else if (ae.getSource() == this.btnTomarFoto) {
            main();
        }
     
        
    }
}



