package learning.io.operations.ui;

import com.formdev.flatlaf.util.SystemFileChooser;
import learning.io.operations.service.NotepadStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;


public class Notepad {

    private JFrame frame;
    private JTextArea textArea;
    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton exitButton;
    private File currentFile;
    private final Font font = new Font("Roboto Flex", Font.PLAIN, 14);
    private final NotepadStream fileStream; // Placeholder for future file operations


    public Notepad(NotepadStream fileStream) {
        this.fileStream = fileStream;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Simple Notepad");
        textArea = new JTextArea();
        textArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(textArea);

        newButton = new JButton("Nuevo");
        newButton.setFont(font);
        openButton = new JButton("Abrir");
        openButton.setFont(font);
        saveButton = new JButton("Guardar");
        saveButton.setFont(font);
        exitButton = new JButton("Salir");
        exitButton.setFont(font);

        newButton.addActionListener(e -> createNew());
        openButton.addActionListener(e -> openFile());
        saveButton.addActionListener(e -> saveFile());
        exitButton.addActionListener(e -> frame.dispose());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(newButton);
        topPanel.add(openButton);
        topPanel.add(saveButton);
        topPanel.add(exitButton);

        frame.setFont(font);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createNew() {
        textArea.setText("");
        currentFile = null;
    }

    private void openFile() {
        SystemFileChooser chooser = new SystemFileChooser();
        int result = chooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            String content = fileStream.read(currentFile.getAbsolutePath());
            textArea.setText(content != null ? content : "");
        }
    }

    private void saveFile() {
        SystemFileChooser chooser = new SystemFileChooser();
        if (currentFile != null) {
            chooser.setSelectedFile(currentFile);
        }
        int result = chooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            this.fileStream.write(currentFile.getAbsolutePath(), textArea.getText());
            JOptionPane.showMessageDialog(frame, "Archivo guardado correctamente.");
        }
    }
}
