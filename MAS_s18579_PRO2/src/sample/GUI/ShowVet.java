package sample.GUI;

import sample.classes.Person;
import sample.classes.Vet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowVet extends JFrame{
    private JTextField firstNameText;
    private JTextField lastNameText;
    private JTextField phoneNumberText;
    private JTextField specText;
    private JTextField qualText;
    private JButton backButton;
    private JPanel vetPanel;

    public ShowVet(String title, Person person, Vet vet) {
        super(title);
        firstNameText.setText(person.getFirstName());
        lastNameText.setText(person.getLastName());
        phoneNumberText.setText(person.getPhoneNumber());
        specText.setText(vet.getSpecialization()+"");
        qualText.setText(vet.getQualification());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(vetPanel);
        this.pack();
        backButton.addActionListener(e -> dispose());
    }
}
