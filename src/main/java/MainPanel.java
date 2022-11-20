import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainPanel extends JPanel
{
    private WelcomePanel welcomePanel;
    private ArrayList<PaidHolidayPanel> step2Panels;
    private ArrayList<UnpaidHolidayPanel> unpaidHolidayPanels;

    public MainPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        unpaidHolidayPanels = new ArrayList<>();
        step2Panels = new ArrayList<>();

        welcomePanel = new WelcomePanel();
        add(welcomePanel);

        JButton submitButton = new JButton("NEXT");
        submitButton.addActionListener(this::onSubmitWelcome);
        add(submitButton);
    }

    private void onSubmitWelcome(ActionEvent actionEvent)
    {
        if (!welcomePanel.mentalHealthDays.getText().equals("")
                && !welcomePanel.sickDays.getText().equals("")
                && !welcomePanel.paidDays.getText().equals(""))
        {
            removeAll();

            addNewStep2Panel();

            revalidate();
        } else
        {
        } // validation
    }

    private void addNewStep2Panel()
    {
        PaidHolidayPanel step2Panel = new PaidHolidayPanel();
        add(step2Panel);
        step2Panels.add(step2Panel);

        JButton addMorePaidHolidays = new JButton("Add more paid holidays");
        addMorePaidHolidays.addActionListener(this::onSubmitAddMorePaidHolidays);
        add(addMorePaidHolidays);

        JButton submitPaidHolidays = new JButton("NEXT");
        submitPaidHolidays.addActionListener(this::onSubmitPaidHolidays);
        add(submitPaidHolidays);
    }

    private void onSubmitAddMorePaidHolidays(ActionEvent actionEvent)
    {
        removeAll();

        addNewStep2Panel();

        revalidate();
    }

    private void onSubmitPaidHolidays(ActionEvent actionEvent)
    {
        removeAll();

        addNewUnpaidHolidayPanel();

        for (int i = 0; i < step2Panels.size(); i++)
        {
            System.out.println(step2Panels.get(i).datePanel.getCorrespondingNumber());
        }

        revalidate();
    }

    private void addNewUnpaidHolidayPanel()
    {
        UnpaidHolidayPanel unpaidHolidayPanel = new UnpaidHolidayPanel();
        add(unpaidHolidayPanel);
        unpaidHolidayPanels.add(unpaidHolidayPanel);

        JButton addMoreUnpaidHolidays = new JButton("Add more unpaid holidays");
        addMoreUnpaidHolidays.addActionListener(this::onSubmitAddMoreUnpaidHolidays);
        add(addMoreUnpaidHolidays);

        JButton submitUnpaidHolidays = new JButton("Calculate Calendar");
        submitUnpaidHolidays.addActionListener(this::onSubmitUnpaidHolidays);
        add(submitUnpaidHolidays);
    }

    private void onSubmitAddMoreUnpaidHolidays(ActionEvent actionEvent)
    {
        removeAll();

        addNewUnpaidHolidayPanel();

        for (int i = 0; i < unpaidHolidayPanels.size(); i++)
        {
            System.out.println(unpaidHolidayPanels.get(i).datePanel.getCorrespondingNumber());
        }

        revalidate();
    }

    private void onSubmitUnpaidHolidays(ActionEvent actionEvent)
    {
        removeAll();

        int year = welcomePanel.getYear();
        boolean isLeap = year % 400 == 0 && year % 100 != 0 && year % 4 == 0;

        Calculator calculator = new Calculator(isLeap, Integer.parseInt(welcomePanel.paidDays.getText()),
                Integer.parseInt(welcomePanel.sickDays.getText()),
                Integer.parseInt(welcomePanel.mentalHealthDays.getText()), step2Panels, unpaidHolidayPanels);
        JOptionPane.showMessageDialog(this,
                "Lost days: " + calculator.calculateLostDays(unpaidHolidayPanels) +
        "\nPaid Time Off Remaining: " + calculator.PTO + "\nSick Days Remaining: " + calculator.sickDays +
        "\nMental Health Days Remaining: " + calculator.mentalHealth);

        add(new JLabel("All done!"));

        revalidate();
    }
}
