
import javax.swing.*;
import java.awt.*;

// Bookings Panel
class BookingsPanel extends JPanel {
    private JTextField bookingIdField, customerNameField, customerPhoneField, startDateField, endDateField;
    private JComboBox<String> carComboBox;
    private JTable bookingsTable;

    public BookingsPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("New Booking"));

        formPanel.add(new JLabel("Booking ID:"));
        bookingIdField = new JTextField();
        formPanel.add(bookingIdField);

        formPanel.add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        formPanel.add(customerNameField);

        formPanel.add(new JLabel("Customer Phone:"));
        customerPhoneField = new JTextField();
        formPanel.add(customerPhoneField);

        formPanel.add(new JLabel("Select Car:"));
        carComboBox = new JComboBox<>(new String[]{
                "CAR001 - Toyota Camry (2023)",
                "CAR004 - Tesla Model 3 (2024)"
        });
        formPanel.add(carComboBox);

        formPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField("YYYY-MM-DD");
        formPanel.add(startDateField);

        formPanel.add(new JLabel("End Date:"));
        endDateField = new JTextField("YYYY-MM-DD");
        formPanel.add(endDateField);

        JButton bookButton = new JButton("Create Booking");
        bookButton.addActionListener(e -> {
            // Validation logic would go here
            JOptionPane.showMessageDialog(this, "Booking created successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);

            // In a real application, you would add this to a database
            // and update the table model
            clearFields();
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearFields());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(bookButton);
        buttonPanel.add(clearButton);

        formPanel.add(new JLabel(""));
        formPanel.add(buttonPanel);

        // Table for displaying bookings
        String[] columnNames = {"ID", "Customer", "Car", "Start Date", "End Date", "Total Cost", "Status"};
        Object[][] data = {
                {"B001", "John Doe", "Toyota Camry", "2025-04-05", "2025-04-10", "$250.00", "Upcoming"},
                {"B002", "Jane Smith", "Honda Civic", "2025-03-20", "2025-03-25", "$225.00", "Completed"},
                {"B003", "Bob Johnson", "Tesla Model 3", "2025-04-15", "2025-04-20", "$375.00", "Upcoming"}
        };

        bookingsTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Booking Records"));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(formPanel, BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scrollPane);
        splitPane.setDividerLocation(350);

        add(splitPane, BorderLayout.CENTER);
    }

    private void clearFields() {
        bookingIdField.setText("");
        customerNameField.setText("");
        customerPhoneField.setText("");
        carComboBox.setSelectedIndex(0);
        startDateField.setText("YYYY-MM-DD");
        endDateField.setText("YYYY-MM-DD");
    }
}

// Maintenance Panel
class MaintenancePanel extends JPanel {
    private JComboBox<String> carComboBox;
    private JTextField maintenanceIdField, dateField;
    private JTextArea descriptionArea;
    private JTable maintenanceTable;

    public MaintenancePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("New Maintenance Record"));

        formPanel.add(new JLabel("Maintenance ID:"));
        maintenanceIdField = new JTextField();
        formPanel.add(maintenanceIdField);

        formPanel.add(new JLabel("Select Car:"));
        carComboBox = new JComboBox<>(new String[]{
                "CAR001 - Toyota Camry (2023)",
                "CAR002 - Honda Civic (2022)",
                "CAR003 - Ford Focus (2021)",
                "CAR004 - Tesla Model 3 (2024)"
        });
        formPanel.add(carComboBox);

        formPanel.add(new JLabel("Date:"));
        dateField = new JTextField("YYYY-MM-DD");
        formPanel.add(dateField);

        formPanel.add(new JLabel("Description:"));
        descriptionArea = new JTextArea();
        JScrollPane descScrollPane = new JScrollPane(descriptionArea);
        formPanel.add(descScrollPane);

        JButton addButton = new JButton("Add Record");
        addButton.addActionListener(e -> {
            // Validation logic would go here
            JOptionPane.showMessageDialog(this, "Maintenance record added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);

            // In a real application, you would add this to a database
            // and update the table model
            clearFields();
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearFields());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        formPanel.add(buttonPanel);

        // Table for displaying maintenance records
        String[] columnNames = {"ID", "Car", "Date", "Description", "Cost", "Status"};
        Object[][] data = {
                {"M001", "Toyota Camry", "2025-03-15", "Oil Change", "$50.00", "Completed"},
                {"M002", "Honda Civic", "2025-03-20", "Brake Inspection", "$75.00", "Completed"},
                {"M003", "Ford Focus", "2025-04-05", "Engine Tune-up", "$150.00", "Scheduled"}
        };

        maintenanceTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(maintenanceTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Maintenance Records"));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(formPanel, BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, tableScrollPane);
        splitPane.setDividerLocation(350);

        add(splitPane, BorderLayout.CENTER);
    }

    private void clearFields() {
        maintenanceIdField.setText("");
        carComboBox.setSelectedIndex(0);
        dateField.setText("YYYY-MM-DD");
        descriptionArea.setText("");
    }
}