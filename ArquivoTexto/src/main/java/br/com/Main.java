package br.com;

import java.io.*;

public class Main {
    static void main() {
        String nomeArq = "arquivo_texto.txt";

        File file = new File(nomeArq);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("DESISTA DOS SEUS SONHOS E MORRA");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (file.exists()) {
            System.out.printf(file.getAbsolutePath());

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                int character;
                while ((character = reader.read()) != -1) {
                    System.out.println((char) character);
                }
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("erro ao ler o arquivo");
            }
        } else {
            System.out.println("NAO EXISTE O ARQUIVO SR FAROFA");
        }
    }
}
