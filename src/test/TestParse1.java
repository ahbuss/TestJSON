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
public class TestParse1 {

    private static final Logger LOGGER = Logger.getLogger(TestParse1.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inputFileName = args.length > 0 ? args[0] : "input/name1.json";
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
            List<Map<String, String>> data = gson.fromJson(bufferedReader, type);
            for (Map<String, String> map: data) {
                System.out.println(map);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestParse1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestParse1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static class MapTypeToken extends TypeToken<List<Map<String, Object>>> {
    }

}
