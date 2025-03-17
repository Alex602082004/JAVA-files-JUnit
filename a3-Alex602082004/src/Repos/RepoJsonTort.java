package Repos;

import Domain.Tort;
import Exceptions.RepoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class RepoJsonTort extends RepoTort {

    private String filePath;  // Calea fișierului JSON

    // Constructor fără argumente pentru deserializare
    public RepoJsonTort() throws IOException {
        super();  // Apelă constructorul clasei părinte
    }

    // Constructor cu calea fișierului
    public RepoJsonTort(String filePath) throws IOException {
        super();
        this.filePath = filePath;
    }

    // Adaugă un tort și salvează lista în fișierul JSON
    @Override
    public void add(Tort t) throws JAXBException, IOException {
        super.add(t);
        saveToJson();  // Salvează lista după adăugarea unui tort
    }

    // Elimină un tort și salvează lista în fișierul JSON
    @Override
    public void remove(int i) throws RepoException, JAXBException, IOException {
        super.remove(i);
        saveToJson();  // Salvează lista după ștergerea unui tort
    }

    // Salvare lista de torturi în JSON
    public void saveToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Adaugă formatarea JSON
        objectMapper.writeValue(new File(filePath), this.torturi);  // Serializare în fișier JSON
        System.out.println("Lista de torturi salvată în JSON: " + filePath);
    }

    // Încărcare lista de torturi din JSON
    public void loadFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Tort> torturi = objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Tort.class));
        this.torturi = (Vector<Tort>) torturi;  // Setează lista de torturi încărcată din fișier
        System.out.println("Lista de torturi încărcată din JSON.");
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
