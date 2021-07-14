package sample;


import sample.GUI.MainMenu;
import sample.examples.ExampleData;

import javax.swing.*;

public class Main  {
    public static void main(String[] args) {
        JFrame frame = new MainMenu("Menu logowania");
        frame.setVisible(true);
        //ExampleData.setExampleData();
    }
}
