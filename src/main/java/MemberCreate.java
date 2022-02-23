import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.*;
import javax.swing.*;

public class MemberCreate extends JPanel {

    private final Font labelFont = new Font("Arial", Font.BOLD, 18);
    private final Font inputFont = new Font("Arial", Font.PLAIN, 18);
    private static Member member;

    public void initialize() {

        JLabel title = new JLabel("To Create Member, Please Enter Requested Information Below:");
        title.setFont(labelFont);

        JLabel lbMembershipId = new JLabel("Membership ID");
        lbMembershipId.setFont(labelFont);
        JTextField tfMembershipId = new JTextField();
        tfMembershipId.setFont(inputFont);
//        tfMembershipId.setBounds(10, 231, 370, 22);
//        tfMembershipId.setSize(20,10);
//        tfMembershipId.setPreferredSize(new Dimension( 20,10 ));

        JLabel lbName = new JLabel("Name");
        lbName.setFont(labelFont);
        JTextField tfName = new JTextField();
        tfName.setFont(inputFont);

        JLabel lbFaculty = new JLabel("Faculty");
        lbFaculty.setFont(labelFont);
        JTextField tfFaculty = new JTextField();
        tfFaculty.setFont(inputFont);

        JLabel lbPhoneNumber = new JLabel("Phone Number");
        lbPhoneNumber.setFont(labelFont);
        JTextField tfPhoneNumber = new JTextField();
        tfPhoneNumber.setFont(inputFont);

        JLabel lbEmailAddress = new JLabel("Email Address");
        lbEmailAddress.setFont(labelFont);
        JTextField tfEmailAddress = new JTextField();
        tfEmailAddress.setFont(inputFont);

        JLabel createdText = new JLabel();
        createdText.setFont(labelFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 5, 5));
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

        JButton createMemberButton = new JButton("Create Member");
        createMemberButton.setFont(labelFont);
        createMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.als.jpa");
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                try{
                    member = new Member();
                    if(tfMembershipId.getText().length() > 0 && tfName.getText().length() > 0 && tfFaculty.getText().length() > 0 && tfPhoneNumber.getText().length() > 0 && tfEmailAddress.getText().length() > 0) {
                        member.setId(tfMembershipId.getText());
                        member.setName(tfName.getText());
                        member.setFaculty(tfFaculty.getText());
                        member.setPhoneNumber(tfPhoneNumber.getText());
                        member.setEmailAddress(tfEmailAddress.getText());
                    }

                    entityManager.getTransaction().begin();
                    entityManager.persist(member);
                    entityManager.getTransaction().commit();

                    createdText.setText("Member created!");
                    MainMenu mainMenu = new MainMenu();
                    JOptionPane.showMessageDialog(mainMenu, "Success! ALS Membership created.");
                } catch (PersistenceException ex) {
                    createdText.setText("Error!");
                    MainMenu mainMenu = new MainMenu();
                    JOptionPane.showMessageDialog(mainMenu, "Error! Member already exist; Missing or Incomplete fields.");
                }


               entityManagerFactory.close();
            }
        });

        JPanel panel = new JPanel();
        JLabel label = new JLabel("next screen");
        panel.add(label);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(labelFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                MainMenu mainMenu = new MainMenu();
                mainMenu.initialize();
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 40, 40));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(createdText);
        buttonsPanel.add(createMemberButton);
        buttonsPanel.add(backButton);

        setLayout(new BorderLayout());
        setBackground(new Color(250, 249, 246));
        setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        add(title, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
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
        MemberCreate createMember = new MemberCreate();
        createMember.initialize();
    }

}
