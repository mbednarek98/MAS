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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientFrame extends JFrame{
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField phoneNumberField;
    private JTextField emailField;
    private JButton okBtn;
    private JButton cancelBtn;
    private JPanel clientPanel;
    private JList addressList;
    private JButton addBtn;

    public ClientFrame(String title, Person person, Client client, List<Address> addresses, ChooseClient chooseClient) {
        super(title);
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        phoneNumberField.setText(person.getPhoneNumber());
        emailField.setText(client.getEmail());
        ObjectsModel<Address> modelActor = new ObjectsModel<Address>(addresses);
        addressList.setModel(modelActor);
        addressList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(arg0.getClickCount() == 2) {
                    showAddress((Address) addressList.getSelectedValue(), client);
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(clientPanel);
        this.pack();
        cancelBtn.addActionListener(e -> dispose());
        okBtn.addActionListener(e -> {
            saveOnClick(person,client);
            chooseClient.getPersonClient();
            dispose();
        });
        addBtn.addActionListener(e -> {
            showAddress(client);
        });
    }



    public ClientFrame(String title, ChooseClient chooseClient) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(clientPanel);
        this.pack();
        cancelBtn.addActionListener(e -> dispose());
        addBtn.disable();
        okBtn.addActionListener(e -> {
            Person newPerson = new Person(firstNameField.getText(),lastNameField.getText(),phoneNumberField.getText());
            Client newClient = new Client(emailField.getText());
            newPerson.addClient(newClient);
            addOnClick(newPerson,newClient);
            chooseClient.getPersonClient();
            dispose();
        });
    }

    private void showAddress(Address selectedValue, Client client){
        System.out.println(selectedValue.toString());
        JFrame cc = new AddressFrame(selectedValue.toString(), client, selectedValue, this);
        cc.setVisible(true);
    }

    private void showAddress(Client client){
        JFrame cc = new AddressFrame("Nowy adres", client, this);
        cc.setVisible(true);
    }

    public List<Address> getAddressById(long id){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        List<Address> adrDB = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            adrDB = session.createQuery( "SELECT c.addresses FROM Client c inner join c.addresses WHERE c.id="+(int)id ).list();
            System.out.println(adrDB);
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
        ObjectsModel<Address> modelActor = new ObjectsModel<Address>(adrDB);
        addressList.setModel(modelActor);
        return adrDB;
    }

    private void addOnClick(Person person, Client client){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(person);
            session.save(client);
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

    private void saveOnClick(Person person, Client client){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery( "UPDATE Person SET firstName='"+firstNameField.getText()+"', lastName='"+lastNameField.getText()+"', phoneNumber='"+phoneNumberField.getText()+"' WHERE id="+person.getId()).executeUpdate();
            session.createQuery( "UPDATE Client SET email='"+emailField.getText()+"' WHERE id="+client.getId()).executeUpdate();
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
