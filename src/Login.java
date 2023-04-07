import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel lbluser, lblpass;
    JTextField txtuser;
    JPasswordField txtpass;
    JButton btnlogin, btnnew;

    DBConnection dbconn=new DBConnection();
    PreparedStatement pstmt= null;
    ResultSet rs=null;

    Login() throws Exception {
        lbluser= new JLabel("UserName :");
        lblpass= new JLabel("Password :");

        txtuser= new JTextField(20);
        txtpass= new JPasswordField(20);

        btnlogin= new JButton("Login");
        btnnew= new JButton("New");

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

        add(btnnew);
        btnnew.setBounds(200,100,70,25);

        btnlogin.addActionListener(this);
        btnnew.addActionListener(this);

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

        String user= txtuser.getText();
        String pwd= String.valueOf(txtpass.getPassword());

        if(e.getSource()==btnlogin){
            try{
                pstmt= dbconn.conn.prepareStatement("Select * from login");

                rs = pstmt.executeQuery();
                while(rs.next()){
                    if(user.equals(rs.getString(1)) && pwd.equals(rs.getString(2))){
                        JOptionPane.showMessageDialog(null,"Logged In Successfully");
                        new MenuExample();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Username and Password Mismatched TRY AGAIN!!!");
                    }
                }
            }
            catch (Exception ae){
                ae.printStackTrace();
            }
        }

        if(e.getSource()==btnnew){
            try{
                pstmt= dbconn.conn.prepareStatement("Insert Into Login Values (?,?)");
                pstmt.setString(1,txtuser.getText());
                pstmt.setString(2,txtpass.getText());
                int result = pstmt.executeUpdate();
                if(result != -1){
                    JOptionPane.showMessageDialog(null,"New User Added Succesfully");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error Adding User Detail");
                }
            }
            catch(Exception ae){
                ae.printStackTrace();
            }
        }
    }
}
