import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaRH {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        boolean sair = false;

        while (!sair) {
            System.out.println("--------Sistema de RH--------");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Calcular folha de pagamento");
            System.out.println("0 - Sair");

            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario(input, funcionarios);
                    break;
                case 2:
                    listarFuncionarios(funcionarios);
                    break;
                case 3:
                    calcularFolhaDePagamento(funcionarios);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        input.close();
    }

    private static void cadastrarFuncionario(Scanner input, List<Funcionario> funcionarios) {
        System.out.println("Informe o nome do funcionário:");
        String nome = input.next();
        System.out.println("Informe o salário do funcionário:");
        double salario = input.nextDouble();
        System.out.println("Informe a data de admissão (dd/mm/aaaa):");
        String dataAdmissao = input.next();
        System.out.println("Informe a função do funcionário:");
        String funcao = input.next();
        System.out.println("Informe o setor do funcionário:");
        String setor = input.next();

        Funcionario funcionario = new Funcionario(nome, salario, dataAdmissao, funcao, setor);
        funcionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("--------Lista de funcionários--------");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
            System.out.println("Função : " + funcionario.getFuncao());
            System.out.println("Setor : " + funcionario.getSetor());


            System.out.println("------------------------------");
        }
    }

    private static void calcularFolhaDePagamento(List<Funcionario> funcionarios) {
        double totalSalarios = 0;

        for (Funcionario funcionario : funcionarios) {
            totalSalarios += funcionario.getSalario();
        }

        System.out.println("Total de salários: " + totalSalarios);
    }
}

class Funcionario {
    private String nome;
    private double salario;
    private String dataAdmissao;
    private String funcao;
    private String setor;

    public Funcionario(String nome, double salario, String dataAdmissao, String funcao, String setor) {
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.funcao = funcao;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }
    
    public String getFuncao() {
    	return funcao;
    }
    
    public String getSetor() {
    	return setor;
    }
}