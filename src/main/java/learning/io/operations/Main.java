package learning.io.operations;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import learning.io.operations.service.NotepadBuffer;
import learning.io.operations.service.NotepadStream;
import learning.io.operations.ui.Notepad;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        NotepadStream fileStream = new NotepadBuffer();
        SwingUtilities.invokeLater(() -> new Notepad(fileStream));
    }
}