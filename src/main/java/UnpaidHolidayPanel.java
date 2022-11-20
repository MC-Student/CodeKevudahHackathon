import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class UnpaidHolidayPanel extends JPanel
{
    public JFormattedTextField daysToTakeOff;
    public DatePanel datePanel;

    public UnpaidHolidayPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] yamimTovim = new String[]{"Rosh Hashana", "Yom Kippur", "Sukkos", "Asara B'Teves", "Chanukah", "Purim",
                "Pesach", "Shavuos", "Shiva Asar B'Tamuz", "Tisha B'av", "Other"};

        add(new JComboBox<>(yamimTovim));
        add(new JLabel("Choose the starting date"));
        datePanel = new DatePanel();
        add(datePanel);
        add(new JLabel("How many days do you need to take off"));

        NumberFormatter numberFormatter = new NumberFormatter(new DecimalFormat("#"));
        daysToTakeOff = new JFormattedTextField(numberFormatter);
        daysToTakeOff.setColumns(5);
        add(daysToTakeOff);
    }
}
