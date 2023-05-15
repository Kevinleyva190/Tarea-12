package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.DoubleBuffer;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblGenero;
    private JLabel lblPeso;
    private JLabel lblPlataforma;
    private JLabel lblDesarollador;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtGenero;
    private JTextField txtPeso;
    private JTextField txtplataforma;
    private JTextField txtDesarollador;
    private JButton btnAgrergar;
    private GridLayout layout;
    private JPanel panle1;
    private JPanel panle2;
    private ModeloTablaJuego modelo;
    private ArrayList<VideoJuego> info;
    private JScrollPane scroll;
    private JTable tbltabla;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(600,700);
        layout= new GridLayout(2,1);
        this.setLayout(layout);
        // panel1
        panle1= new JPanel(new FlowLayout());
        panle1.setBackground(new Color(188,227,166));
        lblId= new JLabel("Id:");
        txtId= new JTextField(4);
        panle1.add(lblId);
        panle1.add(txtId);
        lblNombre= new JLabel("Nombre:");
        txtNombre= new JTextField(30);
        panle1.add(lblNombre);
        panle1.add(txtNombre);
        lblGenero= new JLabel("Genero:");
        txtGenero= new JTextField(15);
        panle1.add(lblGenero);
        panle1.add(txtGenero);
        lblPeso= new JLabel("Peso en Gb:");
        txtPeso= new JTextField(5);
        panle1.add(lblPeso);
        panle1.add(txtPeso);
        lblPlataforma= new JLabel("Plataforma:");
        txtplataforma= new JTextField(15);
        panle1.add(lblPlataforma);
        panle1.add(txtplataforma);
        lblDesarollador= new JLabel("Desarrolador: ");
        txtDesarollador= new JTextField(25);
        panle1.add(lblDesarollador);
        panle1.add(txtDesarollador);
        btnAgrergar= new JButton("Agregar juego");
        panle1.add(btnAgrergar);
        this.getContentPane().add(panle1,0);
        // panel2
        panle2=new JPanel(new FlowLayout());
        panle2.setBackground(new Color(201,195,241));
        info= new ArrayList<>();
        info.add(new VideoJuego(1,"League of Legend","MOBA",
                4.5,"PC","Riot"));
        modelo= new ModeloTablaJuego(info);
        tbltabla=new JTable(modelo);
        scroll= new JScrollPane(tbltabla);
        panle2.add(scroll);
        this.getContentPane().add(panle2,1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.btnAgrergar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VideoJuego nuevo= new VideoJuego();
                nuevo.setId(Integer.parseInt(txtId.getText()));
                nuevo.setNombre(txtNombre.getText());
                nuevo.setGenero(txtGenero.getText());
                nuevo.setPesoEngb(Double.parseDouble(txtPeso.getText()));
                nuevo.setPlataforma(txtplataforma.getText());
                nuevo.setDesarrollador(txtDesarollador.getText());
                modelo.agregarJuego(nuevo);
                tbltabla.updateUI();
            }
        });
        this.setVisible(true);
    }
}