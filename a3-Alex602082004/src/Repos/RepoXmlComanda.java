package Repos;

import Domain.Comanda;
import Exceptions.RepoException;
import Repos.RepoComanda;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.List;

@XmlRootElement
public class RepoXmlComanda extends RepoComanda {
    @XmlElement
    private String filePath;

    // Constructor fără argumente cerut de JAXB
    public RepoXmlComanda() {}

    // Constructor cu argumente
    public RepoXmlComanda(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void add(Comanda comanda) throws JAXBException, IOException {
        super.add(comanda);
        saveToXml();
    }

    @Override
    public void remove(int i) throws RepoException, JAXBException, IOException {
        super.remove(i);
        saveToXml();
    }

    // Salvare lista de comenzi în XML
    public void saveToXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RepoXmlComanda.class); // Folosim RepoXmlComanda
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this, new File(filePath)); // Serializarea instanței curente
        System.out.println("Lista de comenzi salvată în XML: " + filePath);
    }

    // Încărcare lista de comenzi din XML
    public void loadFromXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RepoXmlComanda.class); // Folosim RepoXmlComanda
        Unmarshaller unmarshaller = context.createUnmarshaller();
        RepoXmlComanda repo = (RepoXmlComanda) unmarshaller.unmarshal(new File(filePath));
        this.comenzi = repo.comenzi; // presupun că 'comenzi' este lista din clasa părinte
        System.out.println("Lista de comenzi încărcată din XML.");
    }
}
