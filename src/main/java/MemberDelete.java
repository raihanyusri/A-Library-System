import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberDelete extends JPanel {

    private final Font mainFont = new Font("Arial", Font.BOLD, 18);
    private final Font inputFont = new Font("Arial", Font.PLAIN, 18);

    public void initialize() {

        JLabel title = new JLabel("To Delete Member, Please Enter Membership ID:");
        title.setFont(mainFont);

        JLabel lbMembershipId = new JLabel("Membership ID");
        lbMembershipId.setFont(mainFont);
        JTextField tfMembershipId = new JTextField();
        tfMembershipId.setFont(inputFont);

        JLabel deletedText = new JLabel();
        deletedText.setFont(mainFont);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2, 10, 10));
        inputPanel.setOpaque(false);
        inputPanel.add(lbMembershipId);
        inputPanel.add(tfMembershipId);

        JButton btnDeletion = new JButton("Delete Member");
        btnDeletion.setFont(mainFont);
        btnDeletion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.als.jpa");
                EntityManager entityManager = entityManagerFactory.createEntityManager();

                try {
                    entityManager.getTransaction().begin();
                    Member toRemove = entityManager.find(Member.class, tfMembershipId.getText());
                    String message = "Please Confirm Details to Be Correct \n";
                    message += "Member ID: " + toRemove.getId().toString() +  "\n";
                    message += "Name: " + toRemove.getName().toString() +  "\n";
                    message += "Faculty: " + toRemove.getFaculty().toString() +  "\n";
                    message += "Phone  Number: " + toRemove.getPhoneNumber().toString() +  "\n";
                    message += "Email address: " + toRemove.getEmailAddress().toString();

                    int selected = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);

                    if(selected == JOptionPane.YES_OPTION) {
                        entityManager.remove(toRemove);
                        entityManager.getTransaction().commit();

                        deletedText.setText("Member deleted!");
                    }

                } catch (PersistenceException ex) {
                    deletedText.setText("Error!");
                    MainMenu mainMenu = new MainMenu();
                    JOptionPane.showMessageDialog(mainMenu, "Error! Member has loans, reservations or outstanding fines.");
                }

                entityManagerFactory.close();
            }
        });

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(mainFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                removeAll();
//                MainMenuFrame mainMenu = new MainMenuFrame();
//                mainMenu.initialize();
            }
        });


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(deletedText);
        buttonsPanel.add(btnDeletion);
        buttonsPanel.add(backButton);

        setLayout(new BorderLayout());
        setBackground(new Color(250, 249, 246));
        setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        add(title, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        MemberDelete memberSelect = new MemberDelete();
        memberSelect.initialize();
    }

}