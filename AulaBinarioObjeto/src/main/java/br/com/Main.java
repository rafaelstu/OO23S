package br.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Pessoa pessoa1 = new Pessoa("pessoa1", 1, "1");
        Pessoa pessoa2 = new Pessoa("pessoa2", 2, "2");
        Pessoa pessoa3 = new Pessoa("pessoa3", 3, "3");
        Pessoa pessoa4 = new Pessoa("pessoa4", 4, "4");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);


//        System.out.println(pessoas.toString());

        String arqPessoas = "ListaDePessoas.bin";
        try (
                FileOutputStream fos = new FileOutputStream(arqPessoas);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(pessoas);
        } catch (IOException e) {
            throw new RuntimeException("erro ao gravar objtos" + e.getMessage());
        }

        File filePes = new File(arqPessoas);
        if (filePes.exists()) {
            try (FileInputStream fis = new FileInputStream(arqPessoas);
                 BufferedInputStream bis = new BufferedInputStream(fis);
                 ObjectInputStream ois = new ObjectInputStream(bis)) {

                List<Pessoa> listaDePessoasDoArquivo = new ArrayList<>();
                listaDePessoasDoArquivo = (List<Pessoa>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("Lista de pessoas do arquivo");
            System.out.println(pessoas.toString());

        } else {
            System.out.println("arquivo " + arqPessoas + " nao encontraod");
        }
    }
}
