package Repos;

import Domain.Comanda;
import Exceptions.RepoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class RepoJsonComanda extends RepoComanda {

    private String filePath;  // Calea fișierului JSON

    // Constructor fără argumente pentru deserializare
    public RepoJsonComanda() {
        super();  // Apelă constructorul clasei părinte
    }

    // Constructor cu calea fișierului
    public RepoJsonComanda(String filePath) {
        super();
        this.filePath = filePath; 
    }

    // Adaugă o comandă și salvează lista în fișierul JSON
    @Override
    public void add(Comanda c) throws JAXBException, IOException {
        super.add(c);
        saveToJson();  // Salvează lista după adăugarea unei comenzi
    }

    // Elimină o comandă și salvează lista în fișierul JSON
    @Override
    public void remove(int i) throws RepoException, JAXBException, IOException {
        super.remove(i);
        saveToJson();  // Salvează lista după ștergerea unei comenzi
    }

    // Salvare lista de comenzi în JSON
    public void saveToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Adaugă formatarea JSON
        objectMapper.writeValue(new File(filePath), this.comenzi);  // Serializare în fișier JSON
        System.out.println("Lista de comenzi salvată în JSON: " + filePath);
    }

    // Încărcare lista de comenzi din JSON
    public void loadFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Comanda> comenzi = objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Comanda.class));
        this.comenzi = (Vector<Comanda>) comenzi;  // Setează lista de comenzi încărcată din fișier
        System.out.println("Lista de comenzi încărcată din JSON.");
    }

    // Getter pentru filePath
    public String getFilePath() {
        return filePath;
    }

    // Setter pentru filePath
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
