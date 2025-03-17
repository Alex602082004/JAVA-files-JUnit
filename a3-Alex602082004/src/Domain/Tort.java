package Domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

@XmlRootElement
public class Tort extends ID {
    private String CakeType;

    // Constructorul implicit pentru JAXB
    public Tort() throws IOException {
        super();
        this.CakeType = "";
    }

    public Tort(String CakeType) throws IOException {
        super();
        this.CakeType = CakeType;
    }

    // Aplicați @XmlElement doar pe getter, nu și pe setter
    @XmlElement
    public String getCakeType() {
        return CakeType;
    }

    // Eliminați @XmlElement de pe setter
    public void setCakeType(String CakeType) {
        this.CakeType = CakeType;
    }

    @Override
    public String toString() {
        return "\nTort{" +
                "id=" + id +
                ", CakeType='" + CakeType + '\'' +
                '}';
    }
}
