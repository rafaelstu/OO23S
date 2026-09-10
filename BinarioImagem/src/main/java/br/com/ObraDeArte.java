package br.com;

import java.io.Serializable;
import java.util.Arrays;

public class ObraDeArte implements Serializable {
    private String titulo;
    private String artista;
    private byte[] fotoDaObra;

    public ObraDeArte(String titulo, String artista, byte[] fotoDaObra) {
        this.titulo = titulo;
        this.artista = artista;
        this.fotoDaObra = fotoDaObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public byte[] getFotoDaObra() {
        return fotoDaObra;
    }

    @Override
    public String toString() {
        int tamanhoImagem = (fotoDaObra != null) ? fotoDaObra.length : 0;

        return titulo + " | " + artista + " | tamanho imagem: " + tamanhoImagem + " bytes";
    }
}
