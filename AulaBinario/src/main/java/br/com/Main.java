package br.com;

import java.io.*;
import java.util.Scanner;

public class Main {
    static void main() {
        //nome do arq (nome, idade)
        String nomeArq = "pessoas.bin";


        try (Scanner scanner = new Scanner(System.in);
             FileOutputStream fos = new FileOutputStream(nomeArq, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos)) {
            String nome;
            int idade;

            do {
                System.out.println("informe um nome ou S/s para sair: ");
                nome = scanner.nextLine();

                if (!nome.equalsIgnoreCase("s")) {
                    dos.writeUTF(nome);

                    System.out.println("informe a idade: ");
                    idade = scanner.nextInt();
                    dos.writeInt(idade);

                    scanner.nextLine();
                }

            } while (!nome.equalsIgnoreCase("s"));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gravar no arquivo: " + e.getMessage());
        }

        File file = new File(nomeArq);
        if (file.exists()) {
            System.out.println("lendo dados do arquivovivo:");

            try (
                    FileInputStream fis = new FileInputStream(nomeArq);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    DataInputStream dis = new DataInputStream(bis)
            ) {
                StringBuilder sb = new StringBuilder();

                while (true) {
                    try {
                        sb.append(dis.readUTF())
                                .append(" ")
                                .append(dis.readInt())
                                .append("\n");
                    } catch (EOFException e) {
                        break;
                    }
                }

                System.out.println(sb.toString());
            } catch (IOException e) {throw new RuntimeException("Erro ao ler arquivo: " + e.getMessage());

            }
        } else {
            System.out.println("Arquivo " + nomeArq + " não encontrado");
        }
    }
}
