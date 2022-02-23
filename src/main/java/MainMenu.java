import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    private final Font mainFont = new Font("Arial", Font.BOLD, 18);

    public void initialize() {

        JLabel title = new JLabel("(ALS)");
        title.setFont(mainFont);

        JButton btnMembership = new JButton("Membership");
        btnMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberSelect memberSelect = new MemberSelect();
                memberSelect.initialize();
                setContentPane(memberSelect);
                validate();
            }
        });
        JLabel lbMembership = new JLabel("Membership");
        lbMembership.setFont(mainFont);


        JButton btnBooks = new JButton("Books");
        btnBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CreateMember createMember = new CreateMember();
//                createMember.initialize();
//                setContentPane(createMember);
//                validate();
            }
        });
        JLabel lbBooks = new JLabel("Books");
        lbBooks.setFont(mainFont);

        JButton btnLoans = new JButton("Loans");
        btnLoans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CreateMember createMember = new CreateMember();
//                createMember.initialize();
//                setContentPane(createMember);
//                validate();
            }
        });
        JLabel lbLoans = new JLabel("Loans");
        lbLoans.setFont(mainFont);

        JButton btnReservations = new JButton("Reservations");
        btnReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CreateMember createMember = new CreateMember();
//                createMember.initialize();
//                setContentPane(createMember);
//                validate();
            }
        });
        JLabel lbReservations = new JLabel("Reservations");
        lbReservations.setFont(mainFont);

        JButton btnFines = new JButton("Fines");
        btnFines.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CreateMember createMember = new CreateMember();
//                createMember.initialize();
//                setContentPane(createMember);
//                validate();
            }
        });
        JLabel lbFines = new JLabel("Fines");
        lbFines.setFont(mainFont);

        JButton btnReports = new JButton("Reports");
        btnReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CreateMember createMember = new CreateMember();
//                createMember.initialize();
//                setContentPane(createMember);
//                validate();
            }
        });
        JLabel lbReports = new JLabel("Reports");
        lbReports.setFont(mainFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3, 40, 40));
        buttonPanel.add(btnMembership);
        buttonPanel.add(btnBooks);
        buttonPanel.add(btnLoans);
        buttonPanel.add(lbMembership);
        buttonPanel.add(lbBooks);
        buttonPanel.add(lbLoans);
        buttonPanel.add(btnReservations);
        buttonPanel.add(btnFines);
        buttonPanel.add(btnReports);
        buttonPanel.add(lbReservations);
        buttonPanel.add(lbFines);
        buttonPanel.add(lbReports);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(250, 249, 246));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);


        add(mainPanel);

        setTitle("ALS");
        setSize(1250,750);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.initialize();
    }

}