package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author ahbuss
 */
public class TestParse2 {

    private static final Logger LOGGER = Logger.getLogger(TestParse2.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inputFileName = System.getProperty("drpsim_config", "input/Sim.json");
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            LOGGER.log(Level.SEVERE, "{0} not found!", inputFile.getAbsolutePath());
            return;
        }
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Gson gson = new Gson();
            TypeToken typeToken = new MapTypeToken();
            Type type = typeToken.getType();
            Map<String, Object> data = gson.fromJson(bufferedReader, type);
            bufferedReader.close();
            for (String key: data.keySet()) {
                System.out.printf("%s = %s%n", key, data.get(key));
            }
            List<String> niins = (List)data.get("niin");
            if (niins.size() == 1 && niins.get(0).equalsIgnoreCase("ALL")) {
                System.out.println("Process ALL NIINS");
            } else {
                System.out.printf("Process these NIINS: %s%n", niins);
            }
//            System.out.println(value.getClass());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestParse2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestParse2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static class MapTypeToken extends TypeToken<Map<String, Object>> {
    }

}
