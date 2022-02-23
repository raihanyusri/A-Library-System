import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberSelect extends JPanel {

    private final Font mainFont = new Font("Arial", Font.BOLD, 18);

    public void initialize() {

        JLabel title = new JLabel("Select one of the Options below:");
        title.setFont(mainFont);

        JLabel membershipTitle = new JLabel("Membership");
        membershipTitle.setFont(mainFont);

        JButton btnCreation = new JButton("Creation");
        btnCreation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberCreate createMember = new MemberCreate();

                removeAll();
                add(createMember);
                createMember.initialize();
                invalidate();
                repaint();
            }
        });
        JLabel lbCreation = new JLabel("Membership creation");
        lbCreation.setFont(mainFont);

        JButton btnDeletion = new JButton("Deletion");
        btnDeletion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberDelete deleteMember = new MemberDelete();

                removeAll();
                add(deleteMember);
                deleteMember.initialize();
                invalidate();
                repaint();
            }
        });
        JLabel lbDeletion = new JLabel("Membership deletion");
        lbDeletion.setFont(mainFont);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberUpdate updateMember  = new MemberUpdate();

                removeAll();
                add(updateMember);
                updateMember.initialize();
                invalidate();
                repaint();
            }
        });
        JLabel lbUpdate = new JLabel("Membership update");
        lbUpdate.setFont(mainFont);
        JButton btnBack = new JButton("Back To Main Menu");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                MainMenu mainMenu = new MainMenu();
                mainMenu.initialize();
                revalidate();
                repaint();
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(lbCreation);
        buttonsPanel.add(btnCreation);
        buttonsPanel.add(lbDeletion);
        buttonsPanel.add(btnDeletion);
        buttonsPanel.add(lbUpdate);
        buttonsPanel.add(btnUpdate);

        setLayout(new BorderLayout());
        setBackground(new Color(250, 249, 246));
        setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        add(title, BorderLayout.NORTH);
        add(membershipTitle, BorderLayout.WEST);
        add(buttonsPanel, BorderLayout.CENTER);
        add(btnBack, BorderLayout.SOUTH);

//        add(mainPanel);
//
//        setTitle("ALS");
//        setSize(1250,750);
//        setMinimumSize(new Dimension(300,400));
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setVisible(true);
    }

    public static void main(String[] args) {
        MemberSelect memberSelect = new MemberSelect();
        memberSelect.initialize();
    }

}
