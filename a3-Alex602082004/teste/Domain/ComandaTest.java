package Domain;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComandaTest {

    @Test
    void getCakes() throws IOException {
        List<Tort> t = new ArrayList<>();
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        Tort t3 = new Tort("vanilie");
        t.add(t1);
        t.add(t2);
        t.add(t3);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MARCH, 9);
        Comanda c = new Comanda(t, calendar.getTime());
        assertEquals(t, c.getCakes());
    }

    @Test
    void addTort() throws IOException {
        List<Tort> t = new ArrayList<>();
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        Tort t3 = new Tort("vanilie");
        t.add(t1);
        t.add(t2);
        t.add(t3);
        Comanda c = new Comanda();
        c.addTort(t1);
        c.addTort(t2);
        c.addTort(t3);
        assertEquals(t.getFirst(), c.getCakes().getFirst());
        assertEquals(t.getLast(), c.getCakes().getLast());
        assertEquals(t.get(1), c.getCakes().get(1));


    }

    @Test
    void setCakes() throws IOException {
        List<Tort> t = new ArrayList<>();
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        Tort t3 = new Tort("vanilie");
        t.add(t1);
        t.add(t2);
        t.add(t3);
        Comanda c = new Comanda();
        c.setCakes(t);
        assertEquals(t, c.getCakes());
    }

    @Test
    void getData() throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MARCH, 9);
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        Tort t3 = new Tort("vanilie");
        List<Tort> t = new ArrayList<>();
        t.add(t1);
        t.add(t2);
        t.add(t3);
        Comanda c = new Comanda(t, calendar.getTime());
        assertEquals(c.getData(), calendar.getTime());


    }

    @Test
    void setData() throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MARCH, 9);
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        Tort t3 = new Tort("vanilie");
        List<Tort> t = new ArrayList<>();
        t.add(t1);
        t.add(t2);
        t.add(t3);
        Comanda c = new Comanda(t, calendar.getTime());
        calendar.set(2024, Calendar.MARCH, 8);
        c.setData(calendar.getTime());
        assertEquals(c.getData(), calendar.getTime());

    }

    @Test
    void testToString() throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MARCH, 9);
        Tort t1 = new Tort("vanilie");
        Tort t2 = new Tort("cioco");
        Tort t3 = new Tort("vanilie");
        List<Tort> t = new ArrayList<>();
        t.add(t1);
        t.add(t2);
        t.add(t3);
        Comanda c = new Comanda(t, calendar.getTime());
        String sir = c.toString();
        assertEquals(sir, c.toString());

    }
}