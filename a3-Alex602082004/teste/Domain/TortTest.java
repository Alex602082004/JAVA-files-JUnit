package Domain;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TortTest {
    @Test
    public void Tort() throws IOException {
        Tort t = new Tort();
        assertEquals(t.getCakeType(), "");
        int id = t.getId();
        assertEquals(t.getId(), id);
    }

    @Test
    void getCakeType() throws IOException {
        Tort tort = new Tort("vanilie");
        assertEquals(tort.getCakeType(), "vanilie");
    }

    @Test
    void setCakeName() throws IOException {
        Tort t = new Tort("vanilie");
        assertEquals(t.getCakeType(), "vanilie");
        t.setCakeType("cioco");
        assertEquals(t.getCakeType(), "cioco");
    }

    @Test
    void testToString() throws IOException {
        Tort t = new Tort("vanilie");
        String s = t.toString();
        String ID = String.valueOf(t);
        assertEquals(s, ID);
    }

}