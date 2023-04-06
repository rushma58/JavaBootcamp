import javax.swing.*;

public class MenuExample extends JFrame{
    JMenuBar mb;
    JMenu mro;
    JMenuItem add, modify, delete;
    public MenuExample(){
        mb= new JMenuBar();

        mro= new JMenu("Record Operation");

        add= new JMenuItem("Add Record");
        modify = new JMenuItem("Modify Record");
        delete = new JMenuItem("Delete Record");

        mro.add(add);
        mro.add(modify);
        mro.add(delete);

        mb.add(mro);

        setJMenuBar(mb);

        setTitle("MainFrame");

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
