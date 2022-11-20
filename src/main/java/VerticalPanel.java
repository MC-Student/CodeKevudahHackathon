import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class VerticalPanel extends JPanel
{
    private JPanel horizontalPanel;
    public VerticalPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new FlowLayout());

        String[] paidHolidays = new String[]{ "Thanksgiving", "New Years", "Veteran's Day", "Memorial Day", "Other"};

        horizontalPanel.add(new JComboBox<>(paidHolidays));
        horizontalPanel.add(new DatePanel());

        add(horizontalPanel);

        JButton submitButton = new JButton("Submit all paid holidays");
        submitButton.addActionListener(this::onClickSubmit);

        add(submitButton);
    }

    private void onClickSubmit(ActionEvent actionEvent)
    {
        horizontalPanel.removeAll();

        String[] yamimTovim = new String[]{"Rosh Hashana", "Yom Kippur", "Sukkos", "Asara B'Teves", "Chanukah", "Purim",
                "Pesach", "Shavuos", "Shiva Asar B'Tamuz", "Tisha B'av", "Other"};

        JButton submitButton = new JButton("Submit all paid holidays");
        submitButton.addActionListener(this::onClickSubmit);
        add(new JComboBox<>(yamimTovim));

        add(new JLabel("Choose the starting date"));
        add(new DatePanel());
        add(new JLabel("How many days do you need to take off"));

        NumberFormatter numberFormatter = new NumberFormatter(new DecimalFormat("#"));
        JFormattedTextField textField = new JFormattedTextField(numberFormatter);
        textField.setColumns(5);
        add(textField);

        add(submitButton);

        this.revalidate();

    }
}
