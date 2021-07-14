package sample.GUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import sample.classes.Client;

import javax.swing.*;
import java.util.List;

public class ChooseClient extends JFrame{
    private JList clientList;
    private JButton showBtn;
    private JButton addBtn;
    private JButton editBtn;
    private JButton deleteBtn;
    private JPanel choosePanel;

    public ChooseClient(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(choosePanel);
        this.pack();
        List<String> clientDb = getListClients();
        ObjectsModel<String> modelActor = new ObjectsModel<String>(clientDb);
        clientList.setModel(modelActor);
    }

    private List<String> getListClients(){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        List<String> clientDb = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            clientDb = session.createQuery( "Select firstName || ' ' || lastName  FROM Client e inner join e.person" ).list();
            System.out.println(clientDb);
            for(Object client : clientDb){
                System.out.println(client);
            }
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
        return clientDb;
    }

}
