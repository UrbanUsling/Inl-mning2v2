package Gym;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class KollaKundTest {
    String nr = "8801011111wgwe";
    String n = " Philip ";
    String d = "2022-01-01";
    LocalDate d1 = LocalDate.parse(d);

    Person p = new Person(nr, n, d);
    KollaKund k = new KollaKund(p.getNamn());
    KollaKund l = new KollaKund(p.getPersonNr());

    public KollaKundTest() {
        Person.addGymLista(p);
        k.namnMatch(k.getNamn());
        l.namnMatch(l.getNamn());
        k.tidsBeräkning();
        l.tidsBeräkning();

    }



        @Test
        void sparaKundinfo () throws IOException {
            k.sparaKundinfo(k.getPr().getNamn());
            l.sparaKundinfo(l.getPr().getNamn());
            
        }

        @Test
        void getAntalDagar () {
            assertEquals(k.getAntalDagar(), ChronoUnit.DAYS.between(p.getDatum(), LocalDate.now()));
            assertEquals(l.getAntalDagar(), ChronoUnit.DAYS.between(k.getPr().getDatum(), LocalDate.now()));
        }

        @Test
        void isAktivMedlem () {
            assertTrue(k.isAktivMedlem());
            assertTrue(l.isAktivMedlem());

        }

        @Test
        void isMedlem () {
            assertTrue(k.isMedlem());
            assertTrue(l.isMedlem());
        }

        @Test
        void getPr () {
            assertEquals(k.getPr().getNamn(), p.getNamn());
            assertEquals(l.getPr().getPersonNr(), p.getPersonNr());
            assertEquals(l.getPr().getDatum(), p.getDatum());
        }
    }
