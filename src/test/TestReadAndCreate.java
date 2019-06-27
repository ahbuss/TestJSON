package test;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahbuss
 */
public class TestReadAndCreate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String jsonString = "{\n"
                + "\"DatabaseFile\":\"input/WIOMWork.SQLite\",\n"
                + "\"Sim_ID\":\"385004bb-24e3-49ab-bbde-633720acb016\",\n"
                + "\"Data_Dictionary_ID\":\"efadfdda-5193-11e9-af3e-e30da88c27d4\",\n"
                + "\"verbose\":\"true\",\n"
                + "\"console\":\"output.txt\",\n"
                + "\"verbose_level\":\"1\"}";

        Gson gson = new Gson();
        Scenario scenario = gson.fromJson(jsonString, Scenario.class);

        Scenario scenario2 = null;
        File file = new File("input/DRPSIM_repair.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            scenario2 = gson.fromJson(fileReader, Scenario.class);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestReadAndCreate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(TestReadAndCreate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.out.println("Success!");
    }

    private static class Scenario {

        private String DatabaseFile;
        private String Sim_ID;
        private String Data_Dictionary_ID;
        private boolean verbose;
        private String console;
        private int verbose_level;

        /**
         * @return the DatabaseFile
         */
        public String getDatabaseFile() {
            return DatabaseFile;
        }

        /**
         * @param DatabaseFile the DatabaseFile to set
         */
        public void setDatabaseFile(String DatabaseFile) {
            this.DatabaseFile = DatabaseFile;
        }

        /**
         * @return the Sim_ID
         */
        public String getSim_ID() {
            return Sim_ID;
        }

        /**
         * @param Sim_ID the Sim_ID to set
         */
        public void setSim_ID(String Sim_ID) {
            this.Sim_ID = Sim_ID;
        }

        /**
         * @return the Data_Dictionary_ID
         */
        public String getData_Dictionary_ID() {
            return Data_Dictionary_ID;
        }

        /**
         * @param Data_Dictionary_ID the Data_Dictionary_ID to set
         */
        public void setData_Dictionary_ID(String Data_Dictionary_ID) {
            this.Data_Dictionary_ID = Data_Dictionary_ID;
        }

        /**
         * @return the verbose
         */
        public boolean isVerbose() {
            return verbose;
        }

        /**
         * @param verbose the verbose to set
         */
        public void setVerbose(boolean verbose) {
            this.verbose = verbose;
        }

        /**
         * @return the console
         */
        public String getConsole() {
            return console;
        }

        /**
         * @param console the console to set
         */
        public void setConsole(String console) {
            this.console = console;
        }

        /**
         * @return the verbose_level
         */
        public int getVerbose_level() {
            return verbose_level;
        }

        /**
         * @param verbose_level the verbose_level to set
         */
        public void setVerbose_level(int verbose_level) {
            this.verbose_level = verbose_level;
        }

    }

}
