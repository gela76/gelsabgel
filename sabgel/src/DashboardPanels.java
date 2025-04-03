
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// Dashboard Panel
class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Summary panels
        JPanel summaryPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        // Available Cars panel
        JPanel availableCarsPanel = createSummaryBox("Available Cars", "15");
        summaryPanel.add(availableCarsPanel);

        // Active Bookings panel
        JPanel activeBookingsPanel = createSummaryBox("Active Bookings", "8");
        summaryPanel.add(activeBookingsPanel);

        // Maintenance Alert panel
        JPanel maintenanceAlertPanel = createSummaryBox("Maintenance Alerts", "3");
        summaryPanel.add(maintenanceAlertPanel);

        add(summaryPanel, BorderLayout.NORTH);

        // Recent activities table
        String[] columnNames = {"Date", "Activity", "Details"};
        Object[][] data = {
                {"2025-04-02", "New Booking", "Toyota Camry booked by John Doe"},
                {"2025-04-01", "Car Return", "Honda Civic returned by Jane Smith"},
                {"2025-03-31", "Maintenance", "Ford Focus scheduled for oil change"},
                {"2025-03-30", "New Car Added", "Tesla Model 3 added to fleet"}
        };

        JTable activityTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(activityTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Recent Activities"));

        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createSummaryBox(String title, String count) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel countLabel = new JLabel(count);
        countLabel.setFont(new Font("Arial", Font.BOLD, 24));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(countLabel, BorderLayout.CENTER);

        return panel;
    }
}

// Car Registration Panel
class CarRegistrationPanel extends JPanel {
    private JTextField carIdField, makeField, modelField, yearField, licenseField, dailyRateField;
    private JComboBox<String> statusComboBox;
    private JTable carTable;
    private DefaultListModel<String> carListModel;

    public CarRegistrationPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Register New Car"));

        formPanel.add(new JLabel("Car ID:"));
        carIdField = new JTextField();
        formPanel.add(carIdField);

        formPanel.add(new JLabel("Make:"));
        makeField = new JTextField();
        formPanel.add(makeField);

        formPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        formPanel.add(modelField);

        formPanel.add(new JLabel("Year:"));
        yearField = new JTextField();
        formPanel.add(yearField);

        formPanel.add(new JLabel("License Plate:"));
        licenseField = new JTextField();
        formPanel.add(licenseField);

        formPanel.add(new JLabel("Daily Rate:"));
        dailyRateField = new JTextField();
        formPanel.add(dailyRateField);

        formPanel.add(new JLabel("Status:"));
        statusComboBox = new JComboBox<>(new String[]{"Available", "Booked", "Maintenance"});
        formPanel.add(statusComboBox);

        JButton registerButton = new JButton("Register Car");
        registerButton.addActionListener(e -> {
            // Validation logic would go here
            JOptionPane.showMessageDialog(this, "Car registered successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);

            // In a real application, you would add this to a database
            // and update the table model
            clearFields();
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearFields());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);

        formPanel.add(new JLabel(""));
        formPanel.add(buttonPanel);

        // Table for displaying cars
        String[] columnNames = {"ID", "Make", "Model", "Year", "License", "Daily Rate", "Status"};
        Object[][] data = {
                {"CAR001", "Toyota", "Camry", "2023", "ABC123", "$50.00", "Available"},
                {"CAR002", "Honda", "Civic", "2022", "XYZ789", "$45.00", "Booked"},
                {"CAR003", "Ford", "Focus", "2021", "DEF456", "$40.00", "Maintenance"},
                {"CAR004", "Tesla", "Model 3", "2024", "GHI789", "$75.00", "Available"}
        };

        carTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(carTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Available Cars"));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(formPanel, BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scrollPane);
        splitPane.setDividerLocation(350);

        add(splitPane, BorderLayout.CENTER);
    }

    private void clearFields() {
        carIdField.setText("");
        makeField.setText("");
        modelField.setText("");
        yearField.setText("");
        licenseField.setText("");
        dailyRateField.setText("");
        statusComboBox.setSelectedIndex(0);
    }
}