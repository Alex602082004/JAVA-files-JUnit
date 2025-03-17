package Domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.Scanner;

@XmlRootElement  // Adnotăm clasa pentru a o face compatibilă cu JAXB
public abstract class ID implements Serializable {
    private static final long serialVersionUID = 1L;

    File file = new File("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\id");
    protected int id;
    static int k = 100;

    public ID() throws FileNotFoundException {
        try (Scanner sc = new Scanner(file)) {
            if (sc.hasNextInt())
                k = sc.nextInt();
        }
        k++;
        id = k;
        try (FileWriter fw = new FileWriter("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\id", false)) {
            fw.write(String.valueOf(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @XmlElement  // Adnotăm câmpul id pentru a fi inclus în serializare
    public int getId() {
        return id;
    }
}
