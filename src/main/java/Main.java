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
        // GET DATES FOR
        // User input - jewish holiday dates for now
        // company holidays
        // personal calendar - simchas, etc.
        // take off chol hamoed/ purim?


        // RETURNS - optimizes for money
        // How many sick days you'll have this year - AVOID
        // How many paid days off you'll have this year
    }


    public static void main(String[] args)
    {
        Main main = new Main();
        main.setVisible(true);
    }
}
