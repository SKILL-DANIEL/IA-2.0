package admin;

import Conexion.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Registros extends JPanel implements ActionListener{
    
    private JLabel Titulo;
    private JButton btnWord, btnPDF, btnExcel, btnImprimir;
    private JCheckBox box1, box2, box3;
    Font title = new Font("Times New Roman", 1, 60);
    
    public Registros(){
        setSize(1063, 763);
        setLayout(null);
        Titulo();
        CheckBox();
        Botones();
        Panel();
    }
    
    public void Titulo(){
        
        Titulo = new JLabel("Generar Reportes");
        Titulo.setFont(title);
        Titulo.setBounds(290, 50, 509, 50);
        add(Titulo);
        
    }
    public void CheckBox(){
        box1 = new JCheckBox();
        box1.setText("Estudiante");
        box1.setBounds(346, 200, 95, 50);
        box1.setFocusable(false);
        box1.setBorder(null);
        box1.setOpaque(false);
        box1.setFont(new Font("Times New Roman", 1, 15));
        add(box1);
        
        box2 = new JCheckBox();
        box2.setText("Docente");
        box2.setBounds(491, 200, 80, 50);
        box2.setFocusable(false);
        box2.setBorder(null);
        box2.setOpaque(false);
        box2.setFont(new Font("Times New Roman", 1, 15));
        add(box2);
        
        box3 = new JCheckBox();
        box3.setText("Administrativo");
        box3.setBounds(621, 200, 125, 50);
        box3.setFocusable(false);
        box3.setBorder(null);
        box3.setOpaque(false);
        box3.setFont(new Font("Times New Roman", 1, 15));
        add(box3);
    }
    public void Botones() {
        
//        Icon word = new ImageIcon(ClassLoader.getSystemResource("Image/word.PNG"));
//        btnWord = new JButton();
//        repaint();
//        btnWord.setIcon(word);
//        btnWord.setText("Generar Word");
//        btnWord.setBorder(new BevelBorder(BevelBorder.RAISED));
//        btnWord.setBackground(Color.WHITE);
//        btnWord.setFocusable(false);
//        btnWord.setOpaque(false);
//        btnWord.setFont(new Font("Times new roman", Font.BOLD, 15));
//        btnWord.addActionListener(this);
        
        Icon pdf = new ImageIcon(ClassLoader.getSystemResource("Image/pdf.PNG"));
        btnPDF = new JButton();
        repaint();
        btnPDF.setIcon(pdf);
        btnPDF.setText("Generar PDF");
        btnPDF.setBorder(new BevelBorder(BevelBorder.RAISED));
        btnPDF.setFocusable(false);
        btnPDF.setBackground(Color.WHITE);
        btnPDF.setOpaque(false);
        btnPDF.setFont(new Font("Times new roman", Font.BOLD, 15));
        btnPDF.addActionListener(this);
        
//        Icon excel = new ImageIcon(ClassLoader.getSystemResource("Image/excel.PNG"));
//        btnExcel = new JButton();
//        repaint();
//        btnExcel.setIcon(excel);
//        btnExcel.setText("Generar Excel");
//        btnExcel.setBorder(new BevelBorder(BevelBorder.RAISED));
//        btnExcel.setFocusable(false);
//        btnExcel.setBackground(Color.WHITE);
//        btnExcel.setOpaque(false);
//        btnExcel.setFont(new Font("Times new roman", Font.BOLD, 15));
//        btnExcel.addActionListener(this);
//        
//        Icon print = new ImageIcon(ClassLoader.getSystemResource("Image/imprimir.PNG"));
//        btnImprimir = new JButton(print);
//        repaint();
//        btnImprimir.setIcon(print);
//        btnImprimir.setText("Imprimir");
//        btnImprimir.setBorder(new BevelBorder(BevelBorder.RAISED));
//        btnImprimir.setFocusable(false);
//        btnImprimir.setOpaque(false);
//        btnImprimir.setBackground(Color.WHITE);
//        btnImprimir.setFont(new Font("Times new roman", Font.BOLD, 15));
//        btnImprimir.addActionListener(this);
        
    }
    public void Panel(){
        JPanel panel = new JPanel();
        panel.setBounds(381, 300, 300, 200);
        panel.setLayout(new GridLayout(2, 2, 30,30));
        panel.setBackground(new Color( 192, 197, 193));
//        panel.add(btnWord);
        panel.add(btnPDF);
//        panel.add(btnExcel);
//        panel.add(btnImprimir);
        add(panel);
    }
    public void GenerarPDF(){
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento,new FileOutputStream(ruta+"/Desktop/Reporte_Alumno.pdf"));
            
            Image header = Image.getInstance("src/Image/LogoUni.png");
            header.scaleToFit(300,171);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Fundación Universitaria Compensar \n\n");
            parrafo.setFont(FontFactory.getFont("Times new roman", 20,com.itextpdf.text.Font.NORMAL,BaseColor.DARK_GRAY));
            parrafo.add("Estudiantes Ingresados \n\n");
            
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from estudiante");
                
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(2));
                    } while (rs.next());
                    documento.add(tabla);
                }
                
            } catch (DocumentException | SQLException e) {
                System.out.println("Error al Crear Reporte "+e);
                JOptionPane.showMessageDialog(null, "Error al Crear Reporte, contacte con el Adminstrador");
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }catch (IOException e) {
            System.out.println("Error en la Imagen "+ e);
        }
    }
    private void GenerarWord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void GenerarExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPDF) {
            GenerarPDF();
        }
        else if (e.getSource() == btnWord) {
            GenerarWord();
        }
        else if (e.getSource() == btnExcel) {
            GenerarExcel();
        }
        else if (e.getSource() == btnImprimir) {
            Imprimir();
        }
    }
}
