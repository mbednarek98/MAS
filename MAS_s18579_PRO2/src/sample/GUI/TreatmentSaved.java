package sample.GUI;

import sample.classes.Payment;
import sample.classes.Person;
import sample.classes.Treatment;
import sample.classes.Vet;

import javax.swing.*;

public class TreatmentSaved extends JFrame {
    private JLabel vetLabel;
    private JLabel dataLabel;
    private JLabel paymentLabel;
    private JPanel alertPanel;
    public TreatmentSaved(String title, Person person, Treatment treatment, Payment payment) {
        super(title);
        dataLabel.setText(treatment.getDate().toString());
        vetLabel.setText(person.toString());
        paymentLabel.setText(payment.getType());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(alertPanel);
        this.pack();
    }
}
