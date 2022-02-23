import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberUpdate extends JPanel {

    private final Font mainFont = new Font("Arial", Font.BOLD, 18);
    private final Font inputFont = new Font("Arial", Font.PLAIN, 18);

    public void initialize() {

        JLabel title = new JLabel("To Update a Member, Please Enter Membership ID:");
        title.setFont(mainFont);

        JLabel lbMembershipId = new JLabel("Membership ID");
        lbMembershipId.setFont(mainFont);
        JTextField tfMembershipId = new JTextField();
        tfMembershipId.setFont(inputFont);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2, 10, 10));
        inputPanel.setOpaque(false);
        inputPanel.add(lbMembershipId);
        inputPanel.add(tfMembershipId);

        JButton btnUpdate = new JButton("Update Member");
        btnUpdate.setFont(mainFont);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.als.jpa");
                EntityManager entityManager = entityManagerFactory.createEntityManager();

                Member toUpdate = entityManager.find(Member.class, tfMembershipId.getText());
                MemberUpdateInformation memberUpdateInformation = new MemberUpdateInformation(toUpdate);
                removeAll();
                add(memberUpdateInformation);
                memberUpdateInformation.initialize();
                invalidate();
                repaint();
            }
        });

        JButton backButton = new JButton("Back to Membership Menu");
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
        buttonsPanel.add(btnUpdate);
        buttonsPanel.add(backButton);

        setLayout(new BorderLayout());
        setBackground(new Color(250, 249, 246));
        setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        add(title, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        MemberUpdate memberUpdate = new MemberUpdate();
        memberUpdate.initialize();
    }

}
