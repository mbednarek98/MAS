package sample.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientMenu extends JFrame{
    private JButton registerBtn;
    private JButton paymentBtn;
    private JPanel clientPanel;

    public ClientMenu(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(clientPanel);
        this.pack();
        registerBtn.addActionListener(e -> {
            JFrame choose = new ChooseClient("Wybierz klienta");
            choose.setVisible(true);
            this.dispose();
        });
    }


}
