import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PrincipalUI extends JFrame {
    public PrincipalUI() {
        setSize(new Dimension(431, 217));
        getContentPane().setLayout(null);

        JButton btnPublicar = new JButton("Publicar");
        if(Main.usuario.getPublica().equals("true"))
            btnPublicar.setEnabled(true);
        else
            btnPublicar.setEnabled(false);
        btnPublicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                PublicacionUI p = new PublicacionUI();
                p.setVisible(true);
            }
        });
        btnPublicar.setBounds(46, 61, 136, 69);
        getContentPane().add(btnPublicar);

        JButton btnVerPublicaciones = new JButton("Ver Publicaciones");
        btnVerPublicaciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    VerPublicacionesUI v = new VerPublicacionesUI();
                    v.setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnVerPublicaciones.setBounds(234, 61, 136, 69);
        getContentPane().add(btnVerPublicaciones);

        JLabel lblNewLabel = new JLabel("SuperVehiculos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(150, 13, 153, 16);
        getContentPane().add(lblNewLabel);
    }
}
