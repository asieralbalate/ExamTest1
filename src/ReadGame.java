import java.io.*;
import java.util.*;

public class ReadGame {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of the file with the players: ");
        String filename = keyboard.nextLine();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filename));
            String line;
            Map<String, List<Card>> map = new HashMap<>();
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String name = items[0];
                List<Card> list = new ArrayList<>();
                for (int i = 1; i < items.length; i += 2) {
                    int number = Integer.parseInt(items[i]);
                    int suit = Integer.parseInt(items[i + 1]);
                    Card card = new Card(number, suit);
                    list.add(card);
                }
                map.put(name, list);

            }
            List<KeyAndList<String, Card>> list = Util.transform(map);
            Collections.sort(list);
            writeToFile(list);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Error reading file");
            System.exit(1);
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static void writeToFile(List<KeyAndList<String, Card>> list) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.dat")));
            for (KeyAndList<String, Card> kl : list) {
                out.writeObject(kl);
            }
        } catch (IOException ex) {
            System.out.println("Error writing file");
            System.exit(1);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
