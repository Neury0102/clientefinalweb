/**
 * Created by saleta on 7/21/2016.
 */

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DetallePublicacionUI extends JFrame {
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JTextField txtPrecio;
    private JTextField txtVendedorNombre;
    private JTextField txtVendedorTelefono;
    private JTextField txtVendedorEmail;
    private Cliente.PublicacionInfo publicacion;
    public DetallePublicacionUI(Cliente.PublicacionInfo publicacion) throws IOException {
        this.publicacion = publicacion;
        setSize(new Dimension(670, 440));
        getContentPane().setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(panel);

        scrollPane.setBounds(327, 43, 313, 318);
        for(String imagen: publicacion.getImagenes()){
            InputStream stream = new ByteArrayInputStream(Base64.decode(imagen));
            BufferedImage img = ImageIO.read(stream);
            Image dimg = img.getScaledInstance(300, 155,Image.SCALE_SMOOTH);
            JLabel image = new JLabel(new ImageIcon(dimg));
            panel.add(image);
        }


        getContentPane().add(scrollPane);


        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMarca.setBounds(12, 43, 89, 16);
        getContentPane().add(lblMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblModelo.setBounds(12, 95, 89, 16);
        getContentPane().add(lblModelo);

        JLabel lblAo = new JLabel("A\u00F1o:");
        lblAo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAo.setBounds(12, 144, 68, 16);
        getContentPane().add(lblAo);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrecio.setBounds(12, 196, 68, 16);
        getContentPane().add(lblPrecio);

        JLabel lblVendedor = new JLabel("Vendedor:");
        lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblVendedor.setBounds(12, 249, 89, 16);
        getContentPane().add(lblVendedor);

        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTelefono.setBounds(12, 298, 68, 16);
        getContentPane().add(lblTelefono);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmail.setBounds(12, 345, 68, 16);
        getContentPane().add(lblEmail);

        txtMarca = new JTextField();
        txtMarca.setEditable(false);
        txtMarca.setBounds(92, 41, 223, 22);
        getContentPane().add(txtMarca);
        txtMarca.setColumns(10);

        txtModelo = new JTextField();
        txtModelo.setEditable(false);
        txtModelo.setColumns(10);
        txtModelo.setBounds(92, 95, 223, 22);
        getContentPane().add(txtModelo);

        txtAnio = new JTextField();
        txtAnio.setEditable(false);
        txtAnio.setColumns(10);
        txtAnio.setBounds(92, 144, 223, 22);
        getContentPane().add(txtAnio);

        txtPrecio = new JTextField();
        txtPrecio.setEditable(false);
        txtPrecio.setColumns(10);
        txtPrecio.setBounds(92, 190, 223, 22);
        getContentPane().add(txtPrecio);

        txtVendedorNombre = new JTextField();
        txtVendedorNombre.setEditable(false);
        txtVendedorNombre.setColumns(10);
        txtVendedorNombre.setBounds(92, 243, 223, 22);
        getContentPane().add(txtVendedorNombre);

        txtVendedorTelefono = new JTextField();
        txtVendedorTelefono.setEditable(false);
        txtVendedorTelefono.setColumns(10);
        txtVendedorTelefono.setBounds(92, 292, 223, 22);
        getContentPane().add(txtVendedorTelefono);

        txtVendedorEmail = new JTextField();
        txtVendedorEmail.setEditable(false);
        txtVendedorEmail.setColumns(10);
        txtVendedorEmail.setBounds(92, 339, 223, 22);
        getContentPane().add(txtVendedorEmail);

        txtAnio.setText(String.valueOf(publicacion.getAnio()));
        txtPrecio.setText(String.valueOf(publicacion.getPrecio()));
        txtMarca.setText(publicacion.getMarca());
        txtModelo.setText(publicacion.getModelo());
        txtVendedorEmail.setText(publicacion.getVendedor().getEmail());
        txtVendedorNombre.setText(publicacion.getVendedor().getNombre());
        txtVendedorTelefono.setText(publicacion.getVendedor().getTelefono());
    }
}
