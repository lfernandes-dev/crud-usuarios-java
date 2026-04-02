import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        String menu = """
                =======================================
                Bem vindo ao menu de cadastro do usuario
                ========================================
                1 - Cadastrar usuários
                2 - Ver Lista de usuários
                3 - Buscar usuários
                4 - Remover usuários
                5 - Editar usuários
                6 - Sair
                """;
        boolean continuar = true;
        while (continuar){
            System.out.println(menu);
            System.out.println("Digite uma opção do menu");
            int escolha = leitura.nextInt();
            leitura.nextLine();
            if (escolha == 1){
                System.out.println("Digite o nome do usuário que deseja adicionar: ");
                String usuario = leitura.nextLine();
                if (lista.contains(usuario)){
                    System.out.println("Usuário ja existente");
                }else {
                    lista.add(usuario);
                    System.out.println("Usuário " + usuario + " adicionado com sucesso pressione ENTER para continuar...");
                    leitura.nextLine();
                }
            }
            else if (escolha == 2){
                if (lista.isEmpty()){
                    System.out.println("A lista está vazia...");
                    System.out.println("Pressione ENTER para continuar");
                    leitura.nextLine();
                    continue;
                } else {
                    System.out.println(lista);
                   System.out.println("Pressione ENTER para voltar ao menu...");
                   leitura.nextLine();
                }


            } else if (escolha == 3){
                System.out.println("Digite o nome do usuário que você deseja buscar: ");
                String busca = leitura.nextLine();
                boolean encontrou = false;

                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).equalsIgnoreCase(busca)) {
                        System.out.println("Usuário encontrado: " + busca);
                        System.out.println("Pressione ENTER para continuar...");
                        leitura.nextLine();
                        encontrou = true;
                    }
                }
                if (!encontrou) {
                    System.out.println("Usuário inexistente");
                    System.out.println("Pressione ENTER para continuar...");
                    leitura.nextLine();
                }
            }
            else if (escolha == 4){
                if (lista.isEmpty()){
                    System.out.println("A lista está vazia");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    leitura.nextLine();
                    continue;
                }
                System.out.println("Digite o nome que deseja remover: ");
                String nomeDigitado = leitura.nextLine();
                boolean encontrarParaRemover = false;

                for (int i = 0; i < lista.size(); i++) {
                    if (nomeDigitado.equalsIgnoreCase(lista.get(i))){
                        System.out.println("Usuário encontrado!");
                        System.out.println("Deseja excluir permantentemente " + lista.get(i)+ " S/N");
                        String resposta = leitura.nextLine();


                        if (resposta.equalsIgnoreCase("S")){
                            lista.remove(i);
                            System.out.println("Usuário removido com sucesso!");
                            System.out.println("Pressione ENTER para continuar...");
                            leitura.nextLine();
                        } else {
                            System.out.println("Remoção Cancelada");
                            System.out.println("Pressione ENTER para continuar...");
                            leitura.nextLine();
                        }
                        encontrarParaRemover = true;
                        break;
                    }
                }
                if (!encontrarParaRemover){
                    System.out.println("Usuário não encontrado");
                    System.out.println("Voltando ao menu...");
                }
            }
            else if (escolha == 5){
                if (lista.isEmpty()){
                    System.out.println("A lista está vazia");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    leitura.nextLine();
                    continue;
                }

                System.out.println("Digite o nome que deseja editar: ");
                String editarNome = leitura.nextLine();
                boolean encontrarParaEditar = false;

                for (int i = 0; i < lista.size(); i++) {
                    if(editarNome.equalsIgnoreCase(lista.get(i))){
                        System.out.println("Usuário "+ lista.get(i)+ " encontrado digite o novo nome que deseja por: ");
                        String novoUsuario = leitura.nextLine();

                        System.out.println("Usuário"+ lista.get(i) + " Trocado por "+ novoUsuario);
                        lista.set(i, novoUsuario);
                        encontrarParaEditar = true;
                        break;
                    }
                }
                if (!encontrarParaEditar){
                    System.out.println("Usuário não encontrado...");
                    System.out.println("Voltando ao menu...");
                }
            }
            else if (escolha == 6){
                System.out.println("Saindo do sistema obrigado...");
                continuar = false;
            }

        }
    }
}
