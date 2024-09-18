import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    private String nome;
    private int idade;
    private String curso;

    public Aluno(String nome, int idade, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Curso: " + curso;
    }
}

public class SistemaCadastroAlunos {
    private static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Editar Aluno");
            System.out.println("4. Remover Aluno");
            System.out.println("5. Sair");
            opcao = sc.nextInt();
            sc.nextLine();  // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarAluno(sc);
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    editarAluno(sc);
                    break;
                case 4:
                    removerAluno(sc);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        sc.close();
    }

    private static void adicionarAluno(Scanner sc) {
        System.out.println("Digite o nome do aluno:");
        String nome = sc.nextLine();
        System.out.println("Digite a idade do aluno:");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o curso do aluno:");
        String curso = sc.nextLine();
        alunos.add(new Aluno(nome, idade, curso));
        System.out.println("Aluno adicionado com sucesso.");
    }

    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    private static void editarAluno(Scanner sc) {
        System.out.println("Digite o nome do aluno a ser editado:");
        String nome = sc.nextLine();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                System.out.println("Digite o novo nome:");
                aluno.setNome(sc.nextLine());
                System.out.println("Digite a nova idade:");
                aluno.setIdade(sc.nextInt());
                sc.nextLine();
                System.out.println("Digite o novo curso:");
                aluno.setCurso(sc.nextLine());
                System.out.println("Aluno atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void removerAluno(Scanner sc) {
        System.out.println("Digite o nome do aluno a ser removido:");
        String nome = sc.nextLine();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                alunos.remove(aluno);
                System.out.println("Aluno removido com sucesso.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }
}
