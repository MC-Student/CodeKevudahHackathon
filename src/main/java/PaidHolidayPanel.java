import javax.swing.*;
import java.awt.*;

public class PaidHolidayPanel extends JPanel
{
    public DatePanel datePanel;

    public PaidHolidayPanel()
    {
        setLayout(new FlowLayout());

        String[] paidHolidays = new String[]{"New Years", "Thanksgiving", "Veteran's Day", "Memorial Day", "Other"};
        add(new JComboBox<>(paidHolidays));
        datePanel = new DatePanel();
        add(datePanel);
    }
}
