
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarRentalSystem {
    public static void main(String[] args) {
        // Set look and feel to match IntelliJ style
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}

// Login Frame
class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Car Rental System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Logo and title
        JLabel titleLabel = new JLabel("Car Rental Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Login form
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            // Simple validation
            if (usernameField.getText().equals("admin") &&
                    String.valueOf(passwordField.getPassword()).equals("admin")) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid credentials. Please try again.",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        formPanel.add(new JLabel(""));
        formPanel.add(loginButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}

// Main Application Frame
class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public MainFrame() {
        setTitle("Car Rental Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Add tabs for different sections
        tabbedPane.addTab("Dashboard", new DashboardPanel());
        tabbedPane.addTab("Car Registration", new CarRegistrationPanel());
        tabbedPane.addTab("Bookings", new BookingsPanel());
        tabbedPane.addTab("Maintenance Records", new MaintenancePanel());

        add(tabbedPane);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("Export Data"));
        fileMenu.add(new JMenuItem("Import Data"));
        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(new JMenuItem("User Manual"));
        helpMenu.add(new JMenuItem("About"));

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }
}