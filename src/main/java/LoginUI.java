/**
 * Created by saleta on 7/20/2016.
 */
import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginUI extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField password;
    public LoginUI() {
        setSize(new Dimension(300, 300));
        getContentPane().setLayout(null);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(85, 71, 116, 22);
        getContentPane().add(txtUsuario);
        txtUsuario.setColumns(10);

        password = new JPasswordField();
        password.setBounds(85, 118, 116, 22);
        getContentPane().add(password);

        JLabel lblLogin = new JLabel("Cliente Rest");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLogin.setBounds(85, 42, 197, 16);
        getContentPane().add(lblLogin);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Cliente c = new Cliente();
                try {
                    Cliente.Usuario usuario = c.autenticar(txtUsuario.getText(),password.getText());
                    if (usuario.getCodigo().equals("0")){
                        Main.usuario = usuario;
                        PrincipalUI p = new PrincipalUI();
                        p.setVisible(true);
                    }
                    else{
                        txtUsuario.setText("");
                        password.setText("");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnIngresar.setBounds(95, 163, 97, 25);
        getContentPane().add(btnIngresar);
    }
}

