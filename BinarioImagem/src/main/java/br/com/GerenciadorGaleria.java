package br.com;

import java.io.*;

public class GerenciadorGaleria {

    public static void salvarObra(ObraDeArte obra, String caminho) {
        try (FileOutputStream fos = new FileOutputStream(caminho);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obra);
            System.out.println("Obra salva com sucesso em: " + caminho);

        } catch (IOException e) {
            System.err.println("Erro ao salvar a obra: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ObraDeArte carregarObra(String caminho) {
        try (FileInputStream fis = new FileInputStream(caminho);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (ObraDeArte) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar a obra: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}