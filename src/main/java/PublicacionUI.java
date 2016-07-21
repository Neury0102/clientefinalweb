import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;



public class PublicacionUI extends JFrame {


    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    File[] img;

    public PublicacionUI() {

        setSize(new Dimension(423, 537));
        getContentPane().setLayout(null);

        JButton btnPrimer = new JButton("Agregar");
        btnPrimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif");
                chooser.setFileFilter(filter);
                chooser.setMultiSelectionEnabled(true);
                int returnVal = chooser.showOpenDialog(PublicacionUI.this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            chooser.getSelectedFile().getName());

                   // try {
//                        ByteArrayOutputStream os = new ByteArrayOutputStream();
//                        BufferedImage img = ImageIO.read(chooser.getSelectedFile());
//                        ImageIO.write(img, "jpg", os);
//
//                        PublicacionUI.this.img = Base64.encode(os.toByteArray());

                        PublicacionUI.this.img = chooser.getSelectedFiles();


//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    };
                }
            }
        });
        btnPrimer.setBounds(58, 409, 89, 23);
        getContentPane().add(btnPrimer);

        textField = new JTextField();
        textField.setBounds(20, 89, 171, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Marca");
        lblNewLabel.setBounds(20, 19, 52, 23);
        getContentPane().add(lblNewLabel);

        Cliente c = new Cliente();
        Cliente.Marca[] marcas = {};
        try {
            marcas = c.getMarcas();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final JComboBox comboBox = new JComboBox(marcas);
        comboBox.setBounds(20, 40, 171, 23);
        getContentPane().add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("A\u00F1o");
        lblNewLabel_1.setBounds(20, 72, 131, 20);
        getContentPane().add(lblNewLabel_1);

        JLabel lblCantidad = new JLabel("Cantidad de Pasajeros");
        lblCantidad.setBounds(20, 120, 131, 23);
        getContentPane().add(lblCantidad);

        textField_1 = new JTextField();
        textField_1.setBounds(20, 141, 171, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Tipo de Combustible");
        lblNewLabel_2.setBounds(20, 172, 131, 23);
        getContentPane().add(lblNewLabel_2);



        String [] combustible ={"Gasolina","Gas Natural","Biodisel","Diesel","Electricidad","Etanol","Hidrógeno","GLP","Metanol"};
        final JComboBox comboBox_1 = new JComboBox(combustible);
        comboBox_1.setBounds(20, 192, 171, 23);
        getContentPane().add(comboBox_1);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(20, 228, 131, 23);
        getContentPane().add(lblPrecio);

        textField_2 = new JTextField();
        textField_2.setBounds(20, 247, 171, 20);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(20, 273, 131, 23);
        getContentPane().add(lblTipo);
        Cliente.Tipo[] tipos = {};
        try {
            tipos = c.getTipos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final JComboBox comboBox_2 = new JComboBox(tipos);
        comboBox_2.setBounds(19, 291, 172, 23);
        getContentPane().add(comboBox_2);

        JLabel lblObservacionesParticulares = new JLabel("Observaciones Particulares");
        lblObservacionesParticulares.setBounds(20, 320, 131, 23);
        getContentPane().add(lblObservacionesParticulares);

        textField_3 = new JTextField();
        textField_3.setBounds(20, 342, 372, 56);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(221, 19, 171, 23);
        getContentPane().add(lblModelo);

        textField_4 = new JTextField();
        textField_4.setBounds(221, 41, 171, 20);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Uso(KM)");
        lblNewLabel_3.setBounds(221, 71, 171, 23);
        getContentPane().add(lblNewLabel_3);

        textField_5 = new JTextField();
        textField_5.setBounds(221, 89, 171, 20);
        getContentPane().add(textField_5);
        textField_5.setColumns(10);

        JLabel lblCantidadDe = new JLabel("Cantidad de Cilindros ");
        lblCantidadDe.setBounds(221, 120, 171, 23);
        getContentPane().add(lblCantidadDe);

        textField_6 = new JTextField();
        textField_6.setBounds(221, 141, 171, 20);
        getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JLabel lblTipoDeTrasmicion = new JLabel("Tipo de Transmision");
        lblTipoDeTrasmicion.setBounds(221, 172, 171, 23);
        getContentPane().add(lblTipoDeTrasmicion);


        String [] TTransmision ={"Automática","Manual","Doble embrague","Semi-automática"};
        final JComboBox comboBox_3 = new JComboBox(TTransmision);
        comboBox_3.setBounds(221, 192, 171, 23);
        getContentPane().add(comboBox_3);

        JLabel lblNewLabel_4 = new JLabel("Duracion de Publicacion");
        lblNewLabel_4.setBounds(221, 228, 171, 23);
        getContentPane().add(lblNewLabel_4);

        textField_7 = new JTextField();
        textField_7.setBounds(221, 247, 171, 20);
        getContentPane().add(textField_7);
        textField_7.setColumns(10);

        JLabel lblFotos = new JLabel("Fotos");
        lblFotos.setBounds(20, 409, 41, 23);
        getContentPane().add(lblFotos);



        JButton btnPublicar = new JButton("Publicar");
        btnPublicar.setBounds(157, 450, 89, 23);
        getContentPane().add(btnPublicar);
        btnPublicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente ct =new Cliente();
                try {
                    ct.initClient(((Cliente.Marca)(comboBox.getSelectedItem())).getId(),textField.getText(),textField_1.getText(),comboBox_1.getSelectedItem().toString(),textField_2.getText(),((Cliente.Tipo)(comboBox_2.getSelectedItem())).getId(),textField_4.getText(),textField_5.getText(),textField_6.getText(),comboBox_3.getSelectedItem().toString(),textField_7.getText(),textField_3.getText(),img);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

}
