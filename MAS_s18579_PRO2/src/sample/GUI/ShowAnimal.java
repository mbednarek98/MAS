package sample.GUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import sample.classes.Animal;
import sample.classes.Client;
import sample.classes.Person;
import sample.classes.enums.Type;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowAnimal extends JFrame{
    private JTextField typeField;
    private JTextField specieField;
    private JTextField specialSignsField;
    private JTextField nameField;
    private JButton OKButton;
    private JButton backButton;
    private JPanel animalPanel;

    public ShowAnimal(String title, Animal animal, CreateTreatment createTreatment) {
        super(title);
        typeField.setText(animal.getType()+"");
        specieField.setText(animal.getSpecies());
        specialSignsField.setText(animal.getSpecialSigns());
        nameField.setText(animal.getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(animalPanel);
        this.pack();
        OKButton.addActionListener(e -> {
            saveOnClick(animal);
            createTreatment.getAnimal();
            dispose();
        });
        backButton.addActionListener(e -> {
            dispose();
        });
    }

    public ShowAnimal(String title, CreateTreatment createTreatment) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(animalPanel);
        this.pack();
        OKButton.addActionListener(e -> {
            Animal newAnimal = new Animal(sample.classes.enums.Type.valueOf(typeField.getText()),specieField.getText(),specialSignsField.getText(),nameField.getText(),null);
            addOnClick(newAnimal);
            createTreatment.getAnimal();
            dispose();
        });
        backButton.addActionListener(e -> {
            dispose();
        });
    }
    private void addOnClick(Animal animal){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(animal);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }

    }

    private void saveOnClick(Animal animal){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery( "UPDATE Animal SET type='"+sample.classes.enums.Type.valueOf(typeField.getText()).ordinal()+"', species='"+specieField.getText()+"', specialSigns='"+specialSignsField.getText()+"', name='"+nameField.getText()+"' WHERE id="+animal.getId()).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }

    }
}
