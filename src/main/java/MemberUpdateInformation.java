import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberUpdateInformation extends JPanel {

    private final Font mainFont = new Font("Arial", Font.BOLD, 18);
    private final Font inputFont = new Font("Arial", Font.PLAIN, 18);
    private Member member;

    public MemberUpdateInformation(Member member) {
        this.member = member;
    }

    public void initialize() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.als.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        JLabel title = new JLabel("Please Enter Requested Information Below:");
        title.setFont(mainFont);

        JLabel lbMembershipId = new JLabel("Membership ID");
        lbMembershipId.setFont(mainFont);
        JLabel tfMembershipId = new JLabel(member.getId());
        tfMembershipId.setFont(inputFont);

        JLabel lbName = new JLabel("Name");
        lbName.setFont(mainFont);
        JTextField tfName = new JTextField(member.getName());
        tfName.setFont(inputFont);

        JLabel lbFaculty = new JLabel("Faculty");
        lbFaculty.setFont(mainFont);
        JTextField tfFaculty = new JTextField(member.getFaculty());
        tfFaculty.setFont(inputFont);

        JLabel lbPhoneNumber = new JLabel("Phone Number");
        lbPhoneNumber.setFont(mainFont);
        JTextField tfPhoneNumber = new JTextField(member.getPhoneNumber());
        tfPhoneNumber.setFont(inputFont);

        JLabel lbEmailAddress = new JLabel("Email Address");
        lbEmailAddress.setFont(mainFont);
        JTextField tfEmailAddress = new JTextField(member.getEmailAddress());
        tfEmailAddress.setFont(inputFont);

        JLabel createdText = new JLabel();
        createdText.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setOpaque(false);
        formPanel.add(lbMembershipId);
        formPanel.add(tfMembershipId);
        formPanel.add(lbName);
        formPanel.add(tfName);
        formPanel.add(lbFaculty);
        formPanel.add(tfFaculty);
        formPanel.add(lbPhoneNumber);
        formPanel.add(tfPhoneNumber);
        formPanel.add(lbEmailAddress);
        formPanel.add(tfEmailAddress);

        JButton btnUpdate = new JButton("Update Member");
        btnUpdate.setFont(mainFont);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Member toUpdate = entityManager.find(Member.class, member.getId());
                    if (toUpdate.getId().equals(member.getId()) && (tfMembershipId.getText().length() > 0 && tfName.getText().length() > 0 && tfFaculty.getText().length() > 0 && tfPhoneNumber.getText().length() > 0 && tfEmailAddress.getText().length() > 0)) {
                        String message = "Please Confirm Details to Be Correct \n";
                        message += "Member ID: " + tfMembershipId.getText() +  "\n";
                        message += "Name: " + tfName.getText() +  "\n";
                        message += "Faculty: " + tfFaculty.getText() +  "\n";
                        message += "Phone  Number: " + tfPhoneNumber.getText() +  "\n";
                        message += "Email address: " + tfEmailAddress.getText();

                        int selected = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);

                        if(selected == JOptionPane.YES_OPTION) {
                            entityManager.getTransaction().begin();
                            toUpdate.setName(tfName.getText());
                            toUpdate.setFaculty(tfFaculty.getText());
                            toUpdate.setPhoneNumber(tfPhoneNumber.getText());
                            toUpdate.setEmailAddress(tfEmailAddress.getText());
                            entityManager.getTransaction().commit();

                            MainMenu mainMenu = new MainMenu();
                            JOptionPane.showMessageDialog(mainMenu, "Success! ALS Membership updated.");
                        }
                    } else {
                        throw new PersistenceException();
                    }

                } catch (PersistenceException ex) {
                    MainMenu mainMenu = new MainMenu();
                    JOptionPane.showMessageDialog(mainMenu, "Error! Missing or Incomplete fields.");
                }

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
        add(formPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }


}
