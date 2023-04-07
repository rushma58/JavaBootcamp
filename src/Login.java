import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel lbluser, lblpass;
    JTextField txtuser;
    JPasswordField txtpass;
    JButton btnlogin, btnreset;

    Login(){
        lbluser= new JLabel("UserName :");
        lblpass= new JLabel("Password :");

        txtuser= new JTextField(20);
        txtpass= new JPasswordField(20);

        btnlogin= new JButton("Login");
        btnreset= new JButton("Reset");

        add(lbluser);
        lbluser.setBounds(20,20,70,25);

        add(txtuser);
        txtuser.setBounds(110,20,250,25);

        add(lblpass);
        lblpass.setBounds(20,60,70,25);

        add(txtpass);
        txtpass.setBounds(110,60,250,25);

        add(btnlogin);
        btnlogin.setBounds(110,100,70,25);

        add(btnreset);
        btnreset.setBounds(200,100,70,25);

        btnlogin.addActionListener(this);
        btnreset.addActionListener(this);

        setLayout(null);
        setTitle("Student Information Info");
        setVisible(true);
        setSize(400,250);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) throws Exception {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username="Alex";
        String password= "alex123";

        String user= txtuser.getText();
        String pwd= String.valueOf(txtpass.getPassword());

        if(e.getSource()==btnlogin){
            if(user.equals(username) && pwd.equals(password)){
                JOptionPane.showMessageDialog(null,"Login Credential matched");
                new MenuExample();
            }
            else{
                JOptionPane.showMessageDialog(null,"Credential Mismatched");
            }

        }
        if(e.getSource()==btnreset){
            txtuser.setText("");
            txtpass.setText("");
        }
    }
}
