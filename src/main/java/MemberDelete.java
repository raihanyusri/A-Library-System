import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

                entityManager.getTransaction().begin();
                Member toRemove = entityManager.find(Member.class, tfMembershipId.getText());
                entityManager.remove(toRemove);
                entityManager.getTransaction().commit();

                deletedText.setText("Member deleted!");

                entityManagerFactory.close();
            }
        });

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(mainFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                MainMenu mainMenu = new MainMenu();
                mainMenu.initialize();
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

//        add(mainPanel);
//
//        setTitle("ALS");
//        setSize(1250,750);
//        setMinimumSize(new Dimension(300,400));
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setVisible(true);
    }

    public static void main(String[] args) {
        MemberDelete memberSelect = new MemberDelete();
        memberSelect.initialize();
    }

}
