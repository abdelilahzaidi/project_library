package be.bruxellesformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String namefile;

    public FileReader(String namefile) {
        this.namefile = namefile;
    }

    public String read(){
        String tmp = "";
        File file = new File(namefile);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                tmp += reader.nextLine() + "\n";
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("impossible de trouve le fichier");
        }
        return tmp;
    }

}
