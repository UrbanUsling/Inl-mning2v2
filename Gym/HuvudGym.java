package Gym;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HuvudGym {
    public HuvudGym() {
        try (var scan = new Scanner(new File("src\\textfil\\customers.txt"));
        ) {
            while (scan.hasNext()) {
                String nr = scan.next();
                String namn = scan.nextLine();
                String datum = scan.nextLine();
                Person.addGymLista(new Person(nr, namn, datum));
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,  "Filen kunde inte hittas",
                    "Error file not found", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        HuvudGym hej = new HuvudGym();
        KollaKund heja = new KollaKund();
    }
}