import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {
    private JTextArea inputField;
    private JComboBox<String> sortingOptions;
    private JButton sortButton, clearHistoryButton;
    private JTextField resultField;
    private JTextArea historyArea;
    private ArrayList<String> history;

    public View() {
        setTitle("Aplikasi Sorting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        JLabel title = new JLabel("Aplikasi Sorting", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        topPanel.setBackground(new Color(70, 130, 180)); 
        topPanel.add(title, BorderLayout.NORTH);

        inputField = new JTextArea(3, 40);
        inputField.setLineWrap(true);
        inputField.setWrapStyleWord(true);
        inputField.setBackground(new Color(255, 250, 240)); 
        inputField.setForeground(Color.BLACK);
        JScrollPane inputScroll = new JScrollPane(inputField);
        inputScroll.setBorder(BorderFactory.createTitledBorder("Masukkan elemen array (pisah dengan koma):"));
        inputScroll.setBackground(new Color(240, 240, 240)); 
        topPanel.add(inputScroll, BorderLayout.CENTER);

        sortingOptions = new JComboBox<>(new String[]{"Bubble Sort", "Selection Sort", "Insertion Sort"});
        sortingOptions.setBackground(new Color(220, 220, 220)); 
        JPanel sortingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sortingPanel.add(new JLabel("Pilih metode sorting:"));
        sortingPanel.add(sortingOptions);
        topPanel.add(sortingPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        sortButton = new JButton("Sort");
        sortButton.setBackground(new Color(34, 139, 34)); 
        sortButton.setForeground(Color.WHITE);
        sortButton.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(sortButton);
        centerPanel.add(buttonPanel, BorderLayout.NORTH);

        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setBorder(BorderFactory.createTitledBorder("Hasil Sorting"));
        resultField.setPreferredSize(new Dimension(50, 30));
        resultField.setMaximumSize(new Dimension(50, 30));
        resultField.setBackground(new Color(255, 255, 255)); 
        resultField.setForeground(Color.BLACK);
        centerPanel.add(resultField, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        historyArea = new JTextArea();
        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);
        historyArea.setEditable(false);
        historyArea.setBackground(new Color(240, 240, 240)); 
        historyArea.setForeground(Color.BLACK);
        JScrollPane historyScroll = new JScrollPane(historyArea);
        historyScroll.setBorder(BorderFactory.createTitledBorder("Histori Sorting"));
        historyScroll.setPreferredSize(new Dimension(600, 200));
        bottomPanel.add(historyScroll, BorderLayout.CENTER);

        clearHistoryButton = new JButton("Hapus Histori");
        clearHistoryButton.setBackground(new Color(255, 69, 0)); 
        clearHistoryButton.setForeground(Color.WHITE);
        clearHistoryButton.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(clearHistoryButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        history = new ArrayList<>();
        pack();
        setMinimumSize(new Dimension(800, 600));
    }

    public String getInput() {
        return inputField.getText();
    }

    public String getSelectedSorting() {
        return (String) sortingOptions.getSelectedItem();
    }

    public void setResult(String result) {
        resultField.setText(result);
    }

    public void addHistory(String entry) {
        history.add(entry);
        updateHistoryDisplay();
    }

    public void clearHistory() {
        history.clear();
        updateHistoryDisplay();
    }

    private void updateHistoryDisplay() {
        StringBuilder historyText = new StringBuilder();
        for (String entry : history) {
            historyText.append(entry).append("\n");
        }
        historyArea.setText(historyText.toString());
    }

    public void addSortListener(ActionListener listener) {
        sortButton.addActionListener(listener);
    }

    public void addClearHistoryListener(ActionListener listener) {
        clearHistoryButton.addActionListener(listener);
    }
}
