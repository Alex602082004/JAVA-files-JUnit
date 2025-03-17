package Repos;

import Domain.Tort;
import Exceptions.RepoException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

@XmlRootElement
public class RepoXmlTort extends RepoTort {
    @XmlElement
    private String filePath;  // Variabila pentru calea fișierului XML

    // Constructor implicit (fără argumente) pentru a permite deserializarea
    public RepoXmlTort() throws IOException {
        super();
    }

    // Constructor cu calea fișierului
    public RepoXmlTort(String filePath) throws IOException {
        super();
        this.filePath = filePath;
    }

    // Adaugă un tort și salvează lista în fișierul XML
    @Override
    public void add(Tort t) throws JAXBException, IOException {
        super.add(t);
        saveToXml();  // Salvează lista după adăugarea unui tort
    }

    // Elimină un tort și salvează lista în fișierul XML
    @Override
    public void remove(int i) throws RepoException, JAXBException, IOException {
        super.remove(i);
        saveToXml();  // Salvează lista după ștergerea unui tort
    }

    // Salvare lista de comenzi în XML
    public void saveToXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RepoXmlTort.class); // Folosim RepoXmlComanda
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this, new File(filePath)); // Serializarea instanței curente
        System.out.println("Lista de torturi salvată în XML: " + filePath);
    }

    // Încărcare lista de comenzi din XML
    public void loadFromXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RepoXmlTort.class); // Folosim RepoXmlComanda
        Unmarshaller unmarshaller = context.createUnmarshaller();
        RepoXmlTort repo = (RepoXmlTort) unmarshaller.unmarshal(new File(filePath));
        this.torturi = repo.torturi; // presupun că 'comenzi' este lista din clasa părinte
        System.out.println("Lista de torturi încărcată din XML.");
    }
}
