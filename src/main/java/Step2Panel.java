import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Step2Panel extends JPanel
{
    public DatePanel datePanel;

    public Step2Panel()
    {
        setLayout(new FlowLayout());

        String[] paidHolidays = new String[]{"Thanksgiving", "New Years", "Veteran's Day", "Memorial Day", "Other"};
        add(new JComboBox<>(paidHolidays));
        datePanel = new DatePanel();
        add(datePanel);


    }
}
