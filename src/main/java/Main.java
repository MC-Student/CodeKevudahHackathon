import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    public Main()
    {
        setTitle("Jewish Woman Time Off Calculator");
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
