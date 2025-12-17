package learning.io.operations.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Implementación de NotepadStream que utiliza buffers para leer y escribir archivos.
 * Esta clase es más eficiente que leer y escribir carácter por carácter
 * y es la recomendada para operaciones de E/S en archivos de texto.
 *
 * @see NotepadStream
 */
public class NotepadBuffer implements NotepadStream {
    @Override
    public String read(String filePath) {
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            return "";
        }

        StringBuilder content = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.lines().forEach(line -> content.append(line).append("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content.toString();
    }

    @Override
    public void write(String filePath, String content) {
        File file = new File(filePath);

        try (FileWriter fileWriter = new FileWriter(file)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
