package sample.GUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import sample.classes.Address;
import sample.classes.Client;
import sample.classes.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressFrame extends JFrame{
    private JTextField streetText;
    private JTextField streetNumberText;
    private JTextField houseNumberText;
    private JTextField townText;
    private JButton addBtn;
    private JButton cancelBtn;
    private JPanel adresPanel;

    public AddressFrame(String title,Client client, Address address, ClientFrame clientFrame) {
        super(title);
        streetText.setText(address.getStreet());
        streetNumberText.setText(""+address.getHouseNumber());
        houseNumberText.setText(""+address.getApartamentNumber());
        townText.setText(address.getTown());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adresPanel);
        this.pack();
        addBtn.addActionListener(e -> {
            saveOnClick(address);
            clientFrame.getAddressById(client.getId());
            dispose();
        });
        cancelBtn.addActionListener(e -> {
            dispose();
        });
    }

    public AddressFrame(String title, Client client, ClientFrame clientFrame) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adresPanel);
        this.pack();
        addBtn.addActionListener(e -> {
            Address newAddress = new Address(streetText.getText(),Integer.parseInt(streetNumberText.getText()),Integer.parseInt(houseNumberText.getText()),townText.getText());
            client.addAddress(newAddress);
            addOnClick(newAddress);
            clientFrame.getAddressById(client.getId());
            dispose();
        });
        cancelBtn.addActionListener(e -> {
            dispose();
        });
    }

    public AddressFrame(String title, ClientFrame clientFrame) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adresPanel);
        this.pack();
        addBtn.disable();
        cancelBtn.addActionListener(e -> {
            dispose();
        });
    }

    private void addOnClick(Address address) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
    }

    private void saveOnClick(Address address){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery( "UPDATE Address SET street='"+streetText.getText()+"', houseNumber="+streetNumberText.getText()+", apartamentNumber="+houseNumberText.getText()+", town='"+townText.getText()+"' WHERE id="+address.getId()).executeUpdate();
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
