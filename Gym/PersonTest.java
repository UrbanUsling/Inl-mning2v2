package Gym;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    String nr = "8801011111ewgwe";
    String n = " Philip ";
    String d = "2012-01-01";
    LocalDate d1 = LocalDate.parse(d);

    Person p = new Person(nr, n, d);


    @Test
    void skapaPerson() {

        assertEquals(p.getNamn(), n.trim());
        assertEquals(p.getPersonNr(), nr.substring(0,10));
        assertEquals(p.getDatum(), d1);
        assertNotEquals(p.getNamn(), n);
        assertNotEquals(p.getPersonNr(), nr);
        assertNotEquals(p.getDatum(), LocalDate.of(2022, 01, 01));

    }

    @Test
    void getNamn() {
        assertEquals(p.getNamn(),"Philip");
        assertNotEquals(p.getNamn(), n);
    }

    @Test
    void getPersonNr() {
        assertEquals(p.getPersonNr(), "8801011111");
        assertNotEquals(p.getPersonNr(), nr);
    }

    @Test
    void getDatum() {
        assertEquals(p.getDatum(), d1);
        assertNotEquals(p.getDatum(), LocalDate.of(2012, 12, 22));
    }

    @Test
    void getGymLista() {
        Person.addGymLista(p);
        assertEquals(Person.getGymLista().get(0).getNamn(), p.getNamn());
        assertEquals(Person.getGymLista().get(0).getPersonNr(), p.getPersonNr());
        assertEquals(Person.getGymLista().get(0).getDatum(), p.getDatum());
    }
}