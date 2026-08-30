package br.com;

import java.io.*;

public class Main {
    static void main() {
        String a1 = "arq1.txt";
        String a2 = "arq2.txt";

        File f1 = new File(a1);
        File f2 = new File(a2);

        StringBuilder sb = new StringBuilder();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f1))) {
            for (int i = 0; i <= 10; i++) {
                writer.write("5 * " + i + " = " + 5 * i + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (f1.exists()) {
            System.out.println(f1.getAbsolutePath());

            try (BufferedReader reader = new BufferedReader(new FileReader(f1))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    sb.append(line).append("\n");
                }
            } catch (IOException e) {
                System.out.println("erro ao ler o arquivo");
            }
        } else {
            System.out.println("NAO EXISTE O ARQUIVO");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f2))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(f2))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("erro ao ler o arquivo");
        }
    }
}
