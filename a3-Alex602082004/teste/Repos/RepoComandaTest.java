package Repos;

import Domain.Comanda;
import Domain.Tort;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RepoComandaTest {
    @Test
    void testGetDate() throws IOException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<Tort> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        Comanda c = new Comanda(list, calendar.getTime());
        comanda.add(c);
        Vector<Date> date = new Vector<>();
        date.add(calendar.getTime());
        assertEquals(date, comanda.getDate());

    }


    @Test
    void testsize() throws IOException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<Tort> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        Comanda c = new Comanda(list, calendar.getTime());
        comanda.add(c);
        int size = comanda.size();
        assertEquals(size, 1);


    }
}