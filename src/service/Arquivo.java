package service;

import model.Usuarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Arquivo {
    public void gravarNoArquivo(String nome, String senha){
        FileWriter file = null;
        try {
            file = new FileWriter("users.txt", true);
            file.write(nome + "\n" + senha + "\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void lerArquivo(List<Usuarios> listaDeUsuarios){
        try (BufferedReader leitor = new BufferedReader(new FileReader("users.txt"))){
            String tmpNome;
            String tmpSenha;
            while ((tmpNome = leitor.readLine()) != null && (tmpSenha = leitor.readLine()) != null){
                listaDeUsuarios.add(new Usuarios(tmpNome, tmpSenha));
            }
        } catch (Exception e) {
            System.out.println("Falha ao ler o arquivo");
            throw new RuntimeException(e);
        }
    }

    public void atualizarArquivo(List<Usuarios> listaDeUsuarios){
        try(FileWriter sobrescrever = new FileWriter("users.txt", false)){
            for (Usuarios u : listaDeUsuarios){
                sobrescrever.write(u.getNome() + "\n" + u.getSenha() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
