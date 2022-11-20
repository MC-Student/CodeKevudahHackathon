import javax.swing.*;
import java.awt.*;

public class Step2Panel extends JPanel
{
    public Step2Panel()
    {
        setLayout(new FlowLayout());

        String[] paidHolidays = new String[]{"Thanksgiving", "New Years", "Veteran's Day", "Memorial Day", "Other"};
        add(new JComboBox<>(paidHolidays));
        add(new DatePanel());
    }
}
