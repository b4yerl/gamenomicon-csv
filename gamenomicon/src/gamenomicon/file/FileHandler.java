package gamenomicon.file;

import gamenomicon.model.Game;
import gamenomicon.model.GameBook;

import java.io.*;
import java.util.Optional;

/**
 * Classe feita para lidar com leitura e escrita dos arquivos CSV
 *
 * @author bayerl
 */
public class FileHandler {
    /**
     * Este método gera o objeto gamenomicon, seja lendo um CSV existente ou não.
     *
     * @return Retorna o objeto gamenomicon a ser utilizado no restante da aplicação.
     */
    public static GameBook load() {
        if(!new File("../gamenomicon.csv").isFile()) return new GameBook();

        GameBook gamenomicon = new GameBook();
        try {
            BufferedReader br = new BufferedReader(new FileReader("../gamenomicon.csv"));
            Optional<String> line = Optional.ofNullable(br.readLine());
            while(line.isPresent()) {
                String[] currentValues = line.get().split(",");
                Game newGame = new Game(currentValues[0], currentValues[1],
                                Integer.parseInt(currentValues[2]), Integer.parseInt(currentValues[3]));
                gamenomicon.addGame(newGame);
                line = Optional.ofNullable(br.readLine());
            }
            br.close();
        } catch(IOException e) {
            System.out.println("An unexpected error occurred.");
        }

        return gamenomicon;
    }

    /**
     * Persiste o objeto gamenomicon atual em um arquivo .csv
     *
     * @return Retorna um boolean explicitando o resultado da operação.
     */
    public static boolean save(GameBook gamenomicon) {
        try {
            File csvGamenomicon = new File("../gamenomicon.csv");
            PrintWriter writer = new PrintWriter(csvGamenomicon);
            gamenomicon.getFullList().stream().map(n -> String.join(",", n)).forEach(writer::println);
            writer.close();
            return true;

        } catch (IOException e) {
            System.out.println("An unexpected error occurred while saving the gamenomicon file.");
            return false;
        }
    }
}
