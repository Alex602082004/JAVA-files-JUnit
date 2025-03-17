import Domain.Comanda;
import Domain.Tort;
import Exceptions.RepoException;
import Repos.*;
import Services.ServiceComanda;
import Services.ServiceTort;
import UI.Settings;
import UI.UInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException, RepoException, JAXBException {
        Settings settings = Settings.getInstance();

        RepoComanda c = null;
        RepoTort r = null;

        if ("memory".equals(settings.getRepoType())) {
            r = new RepoTort();
            c = new RepoComanda();
        }
        if ("txt".equals(settings.getRepoType())) {
            r = new RepoTxtTort("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\torttxt.txt");
            c = new RepoTxtComanda("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\comandatxt.txt");
        }
        if ("bin".equals(settings.getRepoType())) {
            r = new RepoBinTort("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\tortbin.bin");
            c = new RepoBinComanda("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\comandabin.bin");
        }
        if ("xml".equals(settings.getRepoType())) {
            r = new RepoXmlTort("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\tortxml.xml");
            c = new RepoXmlComanda("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\comandaxml.xml");
        }

        if ("json".equals(settings.getRepoType())) {
            r = new RepoJsonTort("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\tortjson.json");
            c = new RepoJsonComanda("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\src\\Files\\comandajson.json");
        }
        if (c == null && r == null) {
            throw new RepoException("Repo-uri nule");
        }

        Calendar calendar = Calendar.getInstance();
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("caramel");
        Tort t3 = new Tort("bezea");
        Tort t4 = new Tort("cioco");
        Tort t5 = new Tort("mousse");
        List<Tort> torturi1 = Arrays.asList(t1, t2, t3, t4, t5);
        List<Tort> torturi2 = Arrays.asList(t1, t2, t3);


        calendar.set(2024, Calendar.MARCH, 1);
        Comanda c1 = new Comanda(torturi1, calendar.getTime());
        calendar.set(2024, Calendar.MAY, 3);
        Comanda c2 = new Comanda(torturi2, calendar.getTime());
        calendar.set(2024, Calendar.MARCH, 3);
        Comanda c3 = new Comanda(torturi1, calendar.getTime());


        c.add(c1);
        c.add(c2);
        c.add(c3);

        r.add(t1);
        r.add(t2);
        r.add(t3);
        r.add(t4);
        r.add(t5);

        ServiceTort st = new ServiceTort(r);
        ServiceComanda sc = new ServiceComanda(c, r);
        UInterface ui = new UInterface(sc, st);
        ui.run();

    }
}
