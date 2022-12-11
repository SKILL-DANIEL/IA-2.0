package admin;

import Conexion.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class gestionEstudiante extends JPanel implements ActionListener {
    
    private JButton btnModificar, btnEliminar, btnActualizar;
    private JLabel lb_id, lb_Nombre, lb_Apellido, lb_Email, lb_Telefono, lb_Date, lb_Programa, lb_Jornada, lb_Buscar, label_GE, re;
    JFormattedTextField txt_id;
    private JTextField txt_Nombre, txt_Apellido, txt_Email, txt_Telefono, txt_Programa, txt_Jornada, txt_Buscar;
    private JTable table;
    private JDateChooser txt_Date;
    private JComboBox comboBox;
    Font fuente = new Font("Times New Roman", 1, 20);
    Font fuente1 = new Font("Times New Roman", 1, 15);
    Font GE = new Font("Times New Roman", 1, 60);
    String [] optionsToChoose={"Activo", "Inactivo"};
    
    public gestionEstudiante() {
        
        setSize(1063, 763);
        setLayout(null);
        
        Titulo();
        ID();
        Nombre();
        Apellido();
        Email();
        Telefono();
        fNacimiento();
        Programa();
        Jornada();
        Desplegable();
        Botones();
        Busqueda();
        Tabla();
        Panel();
        Mostrar("");
        accionarTabla();
        Buscar();
        
    }
    public void Titulo(){
        
        label_GE = new JLabel("Gestión de Estudiantes");
        label_GE.setFont(GE);
        label_GE.setBounds(260, 50, 600, 50);
        add(label_GE);
        
    }
    public void ID(){
        
        lb_id = new JLabel("Numero de Identificación");
        lb_id.setFont(fuente);
        lb_id.setBounds(110, 50, 215, 40);
        
        txt_id = new JFormattedTextField();
        txt_id.setFont(fuente1);
        txt_id.setBounds(70, 90, 300, 20);
        txt_id.setHorizontalAlignment(JFormattedTextField.CENTER);
        
    }
    public void Nombre(){
        
        lb_Nombre = new JLabel("Nombre");
        lb_Nombre.setFont(fuente);
        lb_Nombre.setBounds(496, 50, 70, 40);
        
        txt_Nombre = new JTextField();
        txt_Nombre.setFont(fuente1);
        txt_Nombre.setBounds(382, 90, 300, 20);
        txt_Nombre.setHorizontalAlignment(JTextField.CENTER);
        
    }
    public void Apellido(){
        
        lb_Apellido = new JLabel("Apellido");
        lb_Apellido.setFont(fuente);
        lb_Apellido.setBounds(799, 50, 90, 40);
        
        txt_Apellido = new JTextField();
        txt_Apellido.setFont(fuente1);
        txt_Apellido.setBounds(694, 90, 300, 20);
        txt_Apellido.setHorizontalAlignment(JTextField.CENTER);
        
    }
    public void Email(){
        
        lb_Email = new JLabel("Correo Institucional");
        lb_Email.setFont(fuente);
        lb_Email.setBounds(130, 120, 170, 40);
        
        txt_Email = new JTextField();
        txt_Email.setFont(fuente1);
        txt_Email.setBounds(70, 160, 300, 20);
        txt_Email.setHorizontalAlignment(JTextField.CENTER);
        
    }
    public void Telefono(){
        
        lb_Telefono = new JLabel("Telefono");
        lb_Telefono.setBounds(486, 120, 90, 40);
        lb_Telefono.setFont(fuente);
        
        txt_Telefono = new JTextField();
        txt_Telefono.setFont(fuente1);
        txt_Telefono.setBounds(382, 160, 300, 20);
        txt_Telefono.setHorizontalAlignment(JTextField.CENTER);
        
    }
    public void fNacimiento(){
        
        lb_Date = new JLabel("Fecha de Nacimiento");
        lb_Date.setFont(fuente);
        lb_Date.setBounds(754, 120, 180, 40);
        
        txt_Date = new com.toedter.calendar.JDateChooser();
        txt_Date.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_Date.setDateFormatString("dd/MM/yyyy");
        txt_Date.setBounds(694, 160, 300, 20);
        txt_Date.setFont(fuente1);
        
    }
    public void Programa(){
        
        lb_Programa = new JLabel("Carrera");
        lb_Programa.setFont(fuente);
        lb_Programa.setBounds(185, 190, 70, 40);
        
        txt_Programa = new JTextField();
        txt_Programa.setFont(fuente1);
        txt_Programa.setBounds(70, 230, 300, 20);
        txt_Programa.setHorizontalAlignment(JTextField.CENTER);
        
    }
    public void Jornada(){
        
        lb_Jornada = new JLabel("Jornada");
        lb_Jornada.setFont(fuente);
        lb_Jornada.setBounds(497, 190, 69, 40);
        
        txt_Jornada = new JTextField();
        txt_Jornada.setFont(fuente1);
        txt_Jornada.setBounds(382, 230, 300, 20);
        txt_Jornada.setHorizontalAlignment(JTextField.CENTER);
    }
    public void Desplegable(){
        comboBox = new JComboBox(optionsToChoose);
        comboBox.setFont(fuente);
        comboBox.setBounds(694, 230, 100, 20);
    }
    public void Resolucion(){
        
        this.re = new JLabel("Fundacion Universitaria Compensar P.J Resolución 23625 del 23 de Diciembre 1981 12455 del 9 de julio 2020. - VIGILADA MINIEDUCACIÓN");
        this.re.setBounds(141, 715, 780, 20);
        
    }
    public void Botones() {
        Icon mo = new ImageIcon(ClassLoader.getSystemResource("Image/editar.PNG"));
        btnModificar = new JButton();
        btnModificar.setIcon(mo);
        btnModificar.setText("Modificar");
        btnModificar.setBounds(820, 198, 80, 80);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setOpaque(false);
        btnModificar.setFocusable(false);
        btnModificar.setBorder(null);
        btnModificar.setHorizontalTextPosition(JButton.CENTER);
        btnModificar.setVerticalTextPosition(JButton.BOTTOM);
        btnModificar.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnModificar.setIconTextGap(-2);
        btnModificar.addActionListener(this);
        
        Icon el = new ImageIcon(ClassLoader.getSystemResource("Image/eliminar.PNG"));
        btnEliminar = new JButton();
        btnEliminar.setIcon(el);
        btnEliminar.setText("Eliminar");
        btnEliminar.setBounds(910, 198, 80, 80);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setOpaque(false);
        btnEliminar.setFocusable(false);
        btnEliminar.setBorder(null);
        btnEliminar.setHorizontalTextPosition(JButton.CENTER);
        btnEliminar.setVerticalTextPosition(JButton.BOTTOM);
        btnEliminar.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnEliminar.setIconTextGap(-2);
        btnEliminar.addActionListener(this);
        
        Icon ac = new ImageIcon(ClassLoader.getSystemResource("Image/actualizar.PNG"));
        btnActualizar = new JButton();
        btnActualizar.setIcon(ac);
        btnActualizar.setText("Actualizar");
        btnActualizar.setBounds(10, 150, 50, 50);
        btnActualizar.setBackground(Color.WHITE);
        btnActualizar.setOpaque(false);
        btnActualizar.setFocusable(false);
        btnActualizar.setBorder(null);
        btnActualizar.setHorizontalTextPosition(JButton.CENTER);
        btnActualizar.setVerticalTextPosition(JButton.BOTTOM);
        btnActualizar.setFont(new Font("Times new roman", Font.BOLD, 10));
        btnActualizar.setIconTextGap(1);
        btnActualizar.addActionListener(this);
        add(btnActualizar);
        
    }
    public void Busqueda(){
        
        lb_Buscar = new JLabel("Buscar");
        lb_Buscar.setFont(fuente);
        lb_Buscar.setBounds(131, 150, 60, 30);
        add(lb_Buscar);
        
        txt_Buscar = new JTextField(); 
        txt_Buscar.setBounds(200, 155, 872, 20);
        txt_Buscar.setBorder(BorderFactory.createEmptyBorder());
        txt_Buscar.setOpaque(false);
        add(txt_Buscar);
        
    }
    public void Tabla(){    
        
        table = new JTable();
        table.setBounds(10, 200, 1043, 200);
        table.setFont(new Font("Times New Roman", 1, 10));
        table.setBorder(null);
        table.setAutoResizeMode(3);
        JTableHeader theader = table.getTableHeader();
        theader.setBackground(new Color(239, 72, 42));
        theader.setForeground(Color.white);
        JScrollPane scrollPane1 = new JScrollPane(table);
        scrollPane1.setColumnHeaderView(null);
        scrollPane1.setBounds(10, 200, 1043, 200);
        add(scrollPane1);
        
    }
    public void ActualizarTabla(){
        Mostrar("");
    }
    public void accionarTabla(){
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 1) {
                    Modificar();
                }
                if (e.getClickCount() == 2) {
                    System.out.println("Se ha hecho doble click");
                }
            }
        });
    }
    public void Buscar(){
        txt_Buscar.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 255 ) {
                    getToolkit().beep();
                    e.consume();   
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                Mostrar(txt_Buscar.getText());
            }
        
        });
            
    }
    
    public void Panel(){
        JPanel Panel = new JPanel();
        Panel.setBorder(null);
        Panel.setBounds(0, 410, 1066, 353);
        Panel.setBackground(new Color( 192, 197, 193));
        Panel.setLayout(null);
        Panel.add(txt_id);
        Panel.add(txt_Nombre);
        Panel.add(txt_Nombre);
        Panel.add(txt_Apellido);
        Panel.add(txt_Email);
        Panel.add(txt_Telefono);
        Panel.add(txt_Date);
        Panel.add(txt_Programa);
        Panel.add(txt_Jornada);
        Panel.add(lb_id);
        Panel.add(lb_Nombre);
        Panel.add(lb_Apellido);
        Panel.add(lb_Email);
        Panel.add(lb_Telefono);
        Panel.add(lb_Date);
        Panel.add(lb_Programa);
        Panel.add(lb_Jornada);
        Panel.add(comboBox);
        Panel.add(btnModificar);
        Panel.add(btnEliminar);
        Panel.setVisible(true);
        add(Panel);
        
    }
    public void Mostrar(String Nombre){
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        modelo.addColumn("Identificación");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Programa");
        modelo.addColumn("Jornada");
        modelo.addColumn("Situación");
        table.setModel(modelo);
        String sql= "";
        if (Nombre.equals("")) {
            sql = "Select * from estudiante";
            
        }else {
            sql = "Select * from estudiante where nombre like '%"+Nombre+"%'";
        }
        String Usuario[] = new String[9];
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario[0] = rs.getString(1);
                Usuario[1] = rs.getString(2);
                Usuario[2] = rs.getString(3);
                Usuario[3] = rs.getString(4);
                Usuario[4] = rs.getString(5);
                Usuario[5] = rs.getString(6);
                Usuario[6] = rs.getString(7);
                Usuario[7] = rs.getString(8);
                Usuario[8] = rs.getString(9);
                modelo.addRow(Usuario);   
            }
            table.setModel(modelo);
                
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al Mostrar Los Datos´"+e);
        }  
    }
    public void Modificar(){ 
        int fila = table.getSelectedRow();
        if (fila >= 0) {
            txt_id.setText(table.getValueAt(fila,0).toString());
            txt_Nombre.setText(table.getValueAt(fila, 1).toString());
            txt_Apellido.setText(table.getValueAt(fila, 2).toString());
            txt_Email.setText(table.getValueAt(fila, 3).toString());
            txt_Telefono.setText(table.getValueAt(fila, 4).toString());
//            fecha.setDate(table.getValueAt(fila, 5));
            txt_Programa.setText(table.getValueAt(fila, 6).toString());
            txt_Jornada.setText(table.getValueAt(fila, 7).toString());
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione Fila ");
        }
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
    public void Update(){
        int cmb;
        String estado_string = null;
        String nombre, apellido, email, telefono, fNacimiento, carrera, jornada;
        int nIdentificacion = Integer.parseInt(txt_id.getText());
        nombre = txt_Nombre.getText().trim();
        apellido = txt_Apellido.getText().trim();    
        email = txt_Email.getText().trim();
        telefono = txt_Telefono.getText().trim();
        fNacimiento = ((JTextField)txt_Date.getDateEditor().getUiComponent()).getText();
        carrera = txt_Programa.getText().trim();
        jornada = txt_Jornada.getText().trim();
        cmb = comboBox.getSelectedIndex()+1;
        
        if (cmb == 1) {
            estado_string = "Activo";
        }
        else if (cmb == 2) {
            estado_string = "Inactivo";
        }
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
            "Update estudiante set id_estudiante=?, nombre=?, apellido=?, correo=?, telefono=?, fecha_nacimiento=?,programa=?, jornada=?, situacion=?"
            + "where id_estudiante = '" + nIdentificacion + "'");

            pst2.setInt(1, nIdentificacion);
            pst2.setString(2, nombre);
            pst2.setString(3, apellido);
            pst2.setString(4, email);
            pst2.setString(5, telefono);
            pst2.setString(6, fNacimiento);
            pst2.setString(7, carrera);
            pst2.setString(8, jornada);
            pst2.setString(9, estado_string);
            pst2.executeUpdate();
            cn2.close();

            Mostrar("");
            Limpiar();
            verde();
            JOptionPane.showMessageDialog(null, "Actualización Exitoso");
            blanco();

        } catch (SQLException e) {
            System.err.println("Error Al Actualizar. " + e);
            JOptionPane.showMessageDialog(null, "Error al Comparar La Identificación");
        }
    }
    public void Delete(){
        int nIdentificacion = Integer.parseInt(txt_id.getText());
        int n = JOptionPane.showConfirmDialog(null, "Desea Eliminar el Registro","Registro",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (n == JOptionPane.YES_NO_OPTION) {
        
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "Delete from estudiante where id_estudiante = '" + nIdentificacion + "'");

                pst.executeUpdate();
                cn.close();

                Mostrar("");
                Limpiar();
                verde();
                JOptionPane.showMessageDialog(null, "Eliminación Exitoso");
                blanco();

            } catch (SQLException e) {
                System.err.println("Error al Eliminar. " + e);
                JOptionPane.showMessageDialog(null, "Error al Comparar La Identificación");
            }
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(new Color( 239,72, 42));
        g.drawLine(200, 175, 872, 175);
        g.drawLine(10, 410, 1053, 410);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnModificar) {
            Update();
        }
        else if (ae.getSource() == btnEliminar) {
            Delete();
        }
        else if (ae.getSource() == btnActualizar) {
            ActualizarTabla();
        }
        
    }
}
