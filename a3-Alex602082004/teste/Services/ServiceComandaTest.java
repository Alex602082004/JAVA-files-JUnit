package Services;

import Domain.Comanda;
import Domain.Tort;
import Exceptions.RepoException;
import Repos.RepoComanda;
import Repos.RepoTort;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.spi.CalendarNameProvider;

import static org.junit.jupiter.api.Assertions.*;

class ServiceComandaTest {

    @Test
    void serviceCitireComanda() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<Tort> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);

        serviceComanda.ServiceCitireComanda(list, calendar.getTime());
        assertEquals(serviceComanda.getRepoComanda(), comanda);

    }

    @Test
    void getRepoComanda() throws IOException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<Tort> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);

        serviceComanda.ServiceCitireComanda(list, calendar.getTime());
        assertEquals(serviceComanda.getRepoComanda(), comanda);

    }

    @Test
    void serviceAddComanda() throws IOException, RepoException, JAXBException {
        List<String> list = new ArrayList<>();
        list.add("vanilie");
        list.add("cioco");
        List<Tort> list1 = new ArrayList<>();
        list1.add(new Tort("vanilie"));
        list1.add(new Tort("cioco"));
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(new Tort("vanilie"));
        repoTort.add(new Tort("cioco"));
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);
        serviceComanda.ServiceAddComanda(2, list, 10, 9);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.OCTOBER, 9);
        Comanda comanda1 = new Comanda(list1, calendar.getTime());
        assertEquals(serviceComanda.getRepoComanda().getComandait(0).getCakes().getFirst().getCakeType(), comanda1.getCakes().getFirst().getCakeType());
        assertEquals(serviceComanda.getRepoComanda().getComandait(0).getCakes().getLast().getCakeType(), comanda1.getCakes().getLast().getCakeType());

    }

    @Test
    void serviceRemoveComanda() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<String> list = new ArrayList<>();
        list.add("vanilie");
        list.add("cioco");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);
        serviceComanda.ServiceAddComanda(2, list, 10, 10);
        int id = serviceComanda.getRepoComanda().getComandait(0).getId();
        serviceComanda.ServiceRemoveComanda(id);
        assertNull(serviceComanda.getRepoComanda().getComandait(0));

    }

    @Test
    void serviceGetRepoComanda() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<String> list = new ArrayList<>();
        list.add("vanilie");
        list.add("cioco");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);
        serviceComanda.ServiceAddComanda(2, list, 10, 10);
        RepoComanda comanda1 = serviceComanda.getRepoComanda();
        assertNotNull(comanda1);
        assertEquals(serviceComanda.getRepoComanda(), comanda1);
    }

    @Test
    void serviceUpdateComandaTorturi() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        Tort t3 = new Tort("bezea");
        Tort t4 = new Tort("banane");
        List<String> list = new ArrayList<>();
        List<Tort> list2 = new ArrayList<>();
        list2.add(t3);
        list2.add(t4);
        list.add("vanilie");
        list.add("cioco");
        List<String> list1 = new ArrayList<>();
        list1.add("bezea");
        list1.add("banane");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        repoTort.add(t3);
        repoTort.add(t4);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);
        serviceComanda.ServiceAddComanda(2, list, 10, 10);
        serviceComanda.ServiceUpdateComandaTorturi(serviceComanda.getRepoComanda().getComandait(0).getId(), 2, list1);
        Comanda comanda1 = new Comanda(list2, calendar.getTime());
        assertNotNull(comanda1);
        assertEquals(serviceComanda.getRepoComanda().getComandait(0).getCakes().getFirst().getCakeType(), comanda1.getCakes().getFirst().getCakeType());
        assertEquals(serviceComanda.getRepoComanda().getComandait(0).getCakes().getLast().getCakeType(), comanda1.getCakes().getLast().getCakeType());

    }

    @Test
    void serviceUpdateComandaData() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<String> list = new ArrayList<>();
        list.add("vanilie");
        list.add("cioco");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);
        serviceComanda.ServiceAddComanda(2, list, 10, 10);
        serviceComanda.ServiceUpdateComandaData(serviceComanda.getRepoComanda().getComandait(0).getId(), 10, 11);
        calendar.set(2024, Calendar.NOVEMBER, 11);
        assertEquals(serviceComanda.getRepoComanda().getComandait(0).getData(), calendar.getTime());

    }

    @Test
    void testToString() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<String> list = new ArrayList<>();
        list.add("vanilie");
        list.add("cioco");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);
        serviceComanda.ServiceAddComanda(2, list, 10, 10);
        String string= serviceComanda.toString();
        assertEquals(string, serviceComanda.toString());

    }

    @Test
    void serviceGetComanda() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        List<String> list = new ArrayList<>();
        List<Tort> list2 = new ArrayList<>();
        list2.add(t1);
        list2.add(t2);
        list.add("vanilie");
        list.add("cioco");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        RepoComanda comanda = new RepoComanda();
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceComanda serviceComanda = new ServiceComanda(comanda, repoTort);
        serviceComanda.ServiceAddComanda(2, list, 10, 10);
        Comanda comanda1=new Comanda(list2, calendar.getTime());
        assertNotNull(comanda1);
        assertEquals(serviceComanda.ServiceGetComanda(serviceComanda.getRepoComanda().getComandait(0).getId()).getCakes().getFirst().getCakeType(), comanda1.getCakes().getFirst().getCakeType());
    }
}