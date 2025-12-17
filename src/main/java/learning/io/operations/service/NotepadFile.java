package learning.io.operations.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Deprecated Esta clase esta obsoleta. Usar NotepadBuffer en su lugar.
 */
@Deprecated
public class NotepadFile implements NotepadStream {

    @Override
    public String read(String filePath) {
        File file = new File(filePath);// crea un objeto File con la ruta del archivo
        if (!file.exists()) return null; // si no existe el archivo, retorna null
        StringBuilder stringBuilder = new StringBuilder();

        // lee el contenido del archivo carácter por carácter
        try (FileReader reader = new FileReader(file)) {
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString(); // retorna el contenido del archivo como una cadena
    }

    @Override
    public void write(String filePath, String content) {
        File file = new File(filePath); // crea un objeto File con la ruta del archivo

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content); // escribe el contenido en el archivo
            writer.flush(); // asegura que todos los datos se escriban en el archivo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
