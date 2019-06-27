package test;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author ahbuss
 */
public class TestArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        
        Scenario[] scenarios = gson.fromJson(new FileReader("input/DRPSIM_repair_1.json"), Scenario[].class);
        System.out.println("Success?");
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
