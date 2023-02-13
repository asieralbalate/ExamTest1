import java.io.*;
import java.util.*;

public class MainReadFile {
    public static void main(String[] args) throws IOException {
        List<KeyAndList<String, Card>> list = readFromFile("object.dat");
        for (KeyAndList<String, Card> kl : list) {
            System.out.println(kl);
        }
    }

    public static List<KeyAndList<String, Card>> readFromFile(String filename) throws IOException {
        ObjectInputStream input = null;
        List<KeyAndList<String, Card>> list = new ArrayList<>();
        try {
            input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));

            while (true) {
                KeyAndList<String, Card> kl = (KeyAndList<String, Card>) input.readObject();
                list.add(kl);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (EOFException ex) {

        } finally {
            if (input != null) {
                input.close();
            }
        }
        return list;
    }
}
