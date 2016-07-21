/**
 * Created by saleta on 7/21/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class VerPublicacionesUI extends JFrame {
    Cliente c = new Cliente();
    Cliente.PublicacionInfo[] publicaciones = c.getPublicaciones();
    JList publicacionesList;
    public VerPublicacionesUI() throws IOException {

        setSize(new Dimension(414, 344));
        getContentPane().setLayout(null);
        DefaultListModel<Cliente.PublicacionInfo> model = new DefaultListModel<>();
        publicacionesList = new JList(model);
        publicacionesList.setBounds(113, 44, 173, 179);
        getContentPane().add(publicacionesList);
        for (Cliente.PublicacionInfo p : publicaciones){
            model.addElement(p);
        }
        JButton btnVerPublicacion = new JButton("Ver Publicaci\u00F3n");
        btnVerPublicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Cliente.PublicacionInfo p = (Cliente.PublicacionInfo)publicacionesList.getSelectedValue();
                DetallePublicacionUI dp = null;
                try {
                    dp = new DetallePublicacionUI(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                dp.setVisible(true);
            }
        });
        btnVerPublicacion.setBounds(113, 249, 173, 25);
        getContentPane().add(btnVerPublicacion);
        JLabel lblPublicacionesDisponibles = new JLabel("Publicaciones Disponibles");
        lblPublicacionesDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPublicacionesDisponibles.setBounds(102, 15, 237, 16);
        getContentPane().add(lblPublicacionesDisponibles);
    }

}
