package Gym;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class KollaKund {
    String namn;
    private Person pr;
    private boolean medlem = false;
    private boolean aktivMedlem = false;
    private long antalDagar;

    public KollaKund(String namn){
      this.namn=namn;


    }
    public KollaKund() throws IOException {
        namnInmatning();
        namnMatch(namn);
        if (medlem)
            tidsBeräkning();
        else{
            JOptionPane.showMessageDialog(null, "Denna person har aldrig varit medlem",
                    "Ej medlem", JOptionPane.PLAIN_MESSAGE);
        }

        if (aktivMedlem)
            sparaKundinfo(pr.getNamn());

    }

    public void namnInmatning() {
        namn = (JOptionPane.showInputDialog(null,
                "Vilken medlem söker du? Ange namn eller 10siffrigt personnummer",
                "Medlemssökning", JOptionPane.QUESTION_MESSAGE));
    }

    public void namnMatch(String namn){
        if(namn==null)
            System.exit(0);
        namn = namn.toLowerCase();
        for (Person p : Person.getGymLista()) {
            if (p.getNamn().toLowerCase().equals(namn) || p.getPersonNr().equals(namn)) {
                LocalDate t = p.getDatum();
                antalDagar = ChronoUnit.DAYS.between(t, LocalDate.now());
                pr = p;
                medlem = true;
            }
        }

    }
    public void tidsBeräkning() {
        if (antalDagar < 365) {
            aktivMedlem = true;
            JOptionPane.showMessageDialog(null, pr.getNamn() +
                            " är välkommen att gymma! "+ (365 - antalDagar)+" dagar kvar på medlemsskapet",
                    "Aktiv medlem", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, pr.getNamn()+ " måste betala avgiften då ett år passerats",
                    "Gammal medlem", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void sparaKundinfo(String namn) throws IOException {
        try (
            FileWriter writer = new FileWriter("src\\textfil\\" + namn + " "+ pr.getPersonNr() + ".txt", true);

        ) {
                writer.write(namn + " "+ pr.getPersonNr()+" tränade " + LocalDate.now());
                writer.write("\n");


            }

        }
        public long getAntalDagar(){
        return antalDagar;
        }

    public boolean isAktivMedlem() {
        return aktivMedlem;
    }

    public boolean isMedlem() {
        return medlem;
    }

    public Person getPr() {
        return pr;
    }

    public String getNamn() {
        return namn;
    }
}
