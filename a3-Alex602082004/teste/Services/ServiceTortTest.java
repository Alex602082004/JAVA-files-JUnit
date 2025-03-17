package Services;

import Domain.Tort;
import Exceptions.RepoException;
import Repos.RepoTort;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTortTest {

    @Test
    void getRepoTort() throws IOException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceTort serviceTort = new ServiceTort(repoTort);
        assertEquals(serviceTort.getRepoTort(), repoTort);
    }

    @Test
    void serviceAddTort() throws IOException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        RepoTort repoTort = new RepoTort();
        ServiceTort serviceTort = new ServiceTort(repoTort);
        serviceTort.ServiceAddTort(t1);
        serviceTort.ServiceAddTort(t2);
        assertEquals(serviceTort.getRepoTort(), repoTort);
    }

    @Test
    void serviceDeleteTort() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceTort serviceTort = new ServiceTort(repoTort);
        serviceTort.ServiceAddTort(t1);
        serviceTort.ServiceAddTort(t2);
        serviceTort.ServiceDeleteTort(serviceTort.getRepoTort().getTortit(0).getId());
        assertEquals(serviceTort.getRepoTort().getTorturi().getFirst(), t2);
    }

    @Test
    void serviceCitireTort() throws IOException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        RepoTort repoTort = new RepoTort();
        ServiceTort serviceTort = new ServiceTort(repoTort);
        serviceTort.ServiceCitireTort("vanilie");
        assertEquals(serviceTort.getRepoTort().getTorturi().getFirst().getCakeType(), t1.getCakeType());
    }

    @Test
    void serviceGetTort() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceTort serviceTort = new ServiceTort(repoTort);
        assertEquals(serviceTort.ServiceGetTort(serviceTort.getRepoTort().getTortit(0).getId()), repoTort.getTortit(0));
    }

    @Test
    void serviceUpdateTort() throws IOException, RepoException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceTort serviceTort = new ServiceTort(repoTort);
        serviceTort.ServiceAddTort(t1);
        serviceTort.ServiceUpdateTort(serviceTort.getRepoTort().getTortit(0).getId(), "cioco");
        assertEquals(serviceTort.getRepoTort().getTorturi().getFirst().getCakeType(), t2.getCakeType());
    }

    @Test
    void testToString() throws IOException, JAXBException {
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        RepoTort repoTort = new RepoTort();
        repoTort.add(t1);
        repoTort.add(t2);
        ServiceTort serviceTort = new ServiceTort(repoTort);
        String result = serviceTort.toString();
        assertEquals(result, serviceTort.toString());

    }
}