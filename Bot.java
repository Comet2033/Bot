import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bot {
    static void textCmd(Map<String, String[]> m, String cmd){
        String[] tbr = m.get("tbr");
        for (int i = 0; i < tbr.length; i++){
            cmd = cmd.replace(tbr[i], "");
        }
        Map<Integer, String[]> command = new HashMap<>();
        command.put(0, new String[]{"какой час", "сколько времени", "какое время", "время"});
        command.put(1, new String[]{"анекдот", "шутку", "шутка", "прикол"});
        command.put(2, new String[]{"выход", "выйти", "exit", "quit", "выключись", "стоп", "stop"});
        for(int i =0; i < command.size(); i++){
            String[] arr = command.get(i);
            for (int j = 0; j < arr.length; j++){
                if (cmd.equals(arr[j])){
                    findCommand(i);
                }
            }
        }
    }

    static void findCommand(int i){
        switch (i){
            case 0:
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                System.out.println(format.format(date));
                break;
            case 1:
                System.out.println("Я не умею шутить");
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
}
