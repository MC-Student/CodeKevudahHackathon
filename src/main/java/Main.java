import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    public Main()
    {
        setTitle("My Frum Calendar");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new MainPanel());
    }


    public static void main(String[] args)
    {
        Main main = new Main();
        main.setVisible(true);
    }
}
