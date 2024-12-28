package main;

import model.Usuarios;
import service.Arquivo;
import service.Estruturador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalMenu {
    private Scanner scanner = new Scanner(System.in);
    List<Usuarios> listaDeUsuarios = new ArrayList<>();
    Arquivo arquivo = new Arquivo();
    Estruturador estruturador = new Estruturador();

    public PrincipalMenu() {
        arquivo.lerArquivo(listaDeUsuarios);
    }

    public void exibirMenu(){
        estruturador.quickSort(listaDeUsuarios, 0, listaDeUsuarios.size() - 1);
        System.out.println("B e m  V i n d o");
        System.out.println("1 - Inserir");
        System.out.println("2 - Editar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Listar");
        System.out.print("Opção: ");
        var op = scanner.nextInt();
        scanner.nextLine();

        switch (op){
            case 1:
                inserir();
                break;

            case 2:
                editar();
                break;

            case 3:
                excluir();
                break;

            case 4:
                listar();
                break;

            default:
                System.out.println("Saindo...");
                break;
        }
    }

    public void inserir(){
        System.out.print("Digite seu nome de usuário: ");
        var nome = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        var senha = scanner.nextLine();

        //Verificar se o usuario ja existe

        listaDeUsuarios.add(new Usuarios(nome, senha));
        arquivo.gravarNoArquivo(nome, senha);
        System.out.println("Usuário adicionado com sucesso!");
        exibirMenu();
    }

    public void editar(){
        System.out.print("Digite um nome a ser alterado: ");
        var nome = scanner.nextLine();
        var p = estruturador.Bbin(listaDeUsuarios, nome, 0, listaDeUsuarios.size());
        if (p > -1){
            System.out.print("Digite novo nome: ");
            var novoNome = scanner.nextLine();
            listaDeUsuarios.get(p).setNome(novoNome);
            arquivo.atualizarArquivo(listaDeUsuarios);
            System.out.println("Usuário alterado com sucesso!");
        }else System.out.println("Usuário não encontrado");
        exibirMenu();
    }

    public void excluir(){
        System.out.print("Digite o nome de usuário a ser excluído: ");
        var nomeExcluir = scanner.nextLine();
        var p = estruturador.Bbin(listaDeUsuarios, nomeExcluir, 0, listaDeUsuarios.size());
        if (p > -1){
            listaDeUsuarios.remove(p);
            arquivo.atualizarArquivo(listaDeUsuarios);
            System.out.println("Usuário excluído com sucesso!");
        }else System.out.println("Usuário não encontrado");
        exibirMenu();
    }

    public void listar(){
        listaDeUsuarios.forEach(l -> {
            System.out.println("Nome: " + l.getNome() + "\t\t Senha: " + l.getSenha());
        });
        exibirMenu();
    }
}
