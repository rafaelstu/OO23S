package br.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String caminhoImagemEntrada = "piguim.jpg";
        String caminhoArquivoBinario = "obra.bin";
        String caminhoImagemRecuperada = "piguim_r.jpg";

        try {
            Path pathEntrada = Path.of(caminhoImagemEntrada);
            if (!Files.exists(pathEntrada)) {
                System.err.println("imagem '" + caminhoImagemEntrada + "' nao encontrado.");
                return;
            }

            byte[] bytesImagem = Files.readAllBytes(pathEntrada);
            System.out.println("Imagem lida com sucesso! Tamanho: " + bytesImagem.length + " bytes.");

            ObraDeArte piguim = new ObraDeArte("piguim", "pingu", bytesImagem);

            GerenciadorGaleria.salvarObra(piguim, caminhoArquivoBinario);


            ObraDeArte obraRecuperada = GerenciadorGaleria.carregarObra(caminhoArquivoBinario);

            if (obraRecuperada != null) {
                System.out.println("\nObra recuperada:");
                System.out.println(obraRecuperada);

                byte[] bytesRecuperados = obraRecuperada.getFotoDaObra();
                Files.write(Path.of(caminhoImagemRecuperada), bytesRecuperados);

                System.out.println("Nova imagem gerada com sucesso: " + caminhoImagemRecuperada);
            }

        } catch (IOException e) {
            System.err.println("Erro durante o processamento dos arquivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}