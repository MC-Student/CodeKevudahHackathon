import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainPanelTake2 extends JPanel
{
    private WelcomePanel welcomePanel;
    private ArrayList<Step2Panel> step2Panels;
    private ArrayList<UnpaidHolidayPanel> unpaidHolidayPanels;

    public MainPanelTake2()
    {
        setLayout(new FlowLayout());

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
        if (!welcomePanel.companyTO.getText().equals("")
                && !welcomePanel.mentalHealthDays.getText().equals("")
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
        add(new Step2Panel());

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

        JButton submitUnpaidHolidays = new JButton("NEXT");
        submitUnpaidHolidays.addActionListener(this::onSubmitUnpaidHolidays);
        add(submitUnpaidHolidays);
    }

    private void onSubmitAddMoreUnpaidHolidays(ActionEvent actionEvent)
    {
        removeAll();

        addNewUnpaidHolidayPanel();

        revalidate();
    }

    private void onSubmitUnpaidHolidays(ActionEvent actionEvent)
    {
        removeAll();

        JOptionPane.showMessageDialog(this, "Result goes here");

        revalidate();
    }
}
