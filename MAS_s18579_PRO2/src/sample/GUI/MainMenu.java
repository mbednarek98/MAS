package sample.GUI;

import javax.swing.*;

public class MainMenu extends JFrame{
    private JTextField login;
    private JPasswordField password;
    private JButton loginBtn;
    private JPanel mainPanel;

    public MainMenu(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        loginBtn.addActionListener(e -> {
            switch (login.getText()) {
                case "vet":
                    System.out.println("Vet is logging to system");
                    break;
                case "nurse":
                    System.out.println("Nurse is logging to system");
                    break;
                case "client":
                    JFrame client = new ClientMenu("Menu klienta");
                    client.setVisible(true);
                    this.dispose();
                    System.out.println("Client is logging to system");
                    break;
                default:
                    System.out.println("Someone is trying to log to system");
            }
        });
    }


}
