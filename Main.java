import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String name = "";
        String age = "";

        Scanner in = new Scanner(System.in);
        Map<String, String[]> orgs = new HashMap<>();
        orgs.put("align", new String[]{"джарвис", "дж"});
        orgs.put("tbr", new String[]{"скажи", "расскажи", "покажи", "произнеси", "сколько", "сейчас"});

        ArrayList<String> arrSet = new ArrayList<>();

        File file = new File("data.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String[] hz = new String[2];
            for (int i = 0; i < 2; i++){
                line = reader.readLine();
                String[] rep = {"Name: ", "Age: "};
                for (int j = 0; j< rep.length; j++){
                    line = line.replace(rep[j], "");
                }
                hz[i] = line;
            }
            name = hz[0];
            age = hz[1];
        }else{
            FileWriter fw = new FileWriter(file);
            System.out.print("Ваше имя: ");
            name = in.nextLine();
            System.out.print("Ваш возраст: ");
            age = String.valueOf(in.nextInt());
            fw.write("Name: " +name + "\n");
            fw.write("Age: " + age + "\n");
            fw.close();
        }

        while (true) {
            System.out.print("Введите команду: ");
            String cmd = in.nextLine();
            cmd = cmd.toLowerCase();
            String[] z = {",", "!", ".", "?", ";"};
            for (int i = 0; i < z.length; i++){
                cmd = cmd.replace(z[i], "");
            }

            for (int i = 0; i < orgs.get("tbr").length; i++){
                String[] arr = orgs.get("tbr");
                cmd = cmd.replace(arr[i], "");
            }

            String[] align = orgs.get("align");
            for (int i = 0; i < align.length ; i++){
                if (cmd.startsWith(align[i]) || cmd.startsWith("")){
                    cmd = cmd.replace(align[i]  + " ", "");
                    Bot.textCmd(orgs, cmd);
                    break;
                }
            }
        }
    }
}