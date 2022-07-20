import java.util.Scanner;
public class Main {

    static GerenciarConta gerenciar = new GerenciarConta();
    static ContaPoupanca p1;

    static Scanner entrada = new Scanner(System.in);

    static int nroConta = 0;


    public static void cadastrar(){
        Scanner entrada = new Scanner(System.in);
        String nomeCliente;
        String CPF;
        String nomeGerente;
        int tipoConta;
        double limite = 0;
        char lim;
        int rendimento;
        System.out.println("Digite o nome:");
        nomeCliente = entrada.nextLine();
        System.out.println("Digite o CPF:");
        CPF = entrada.nextLine();
        System.out.println("Digite o nome do Gerente responsável:");
        nomeGerente = entrada.nextLine();
        System.out.println("Deseja ter limite?(Apenas para conta correte ou conta especial e o máximo de 500) s/n");
        lim = entrada.next().charAt(0);
        if(lim == 's'){
            System.out.println("DIgite o limite:");
            limite = entrada.nextDouble();
            if(limite >500){
                System.out.println("Limite excedido");
            }
        }
        System.out.println("Qual o tipo de conta?");
        System.out.println("1 - Conta corrente \n2 - Conta poupança \n3 - Conta especial");
        tipoConta = entrada.nextInt();
        switch (tipoConta) {
            case 1:
                nroConta++;
                gerenciar.adicionarConta(new ContaCorrente(nroConta, nomeCliente, CPF, limite));
                nomeCliente = null;
                CPF = null;
                tipoConta = 0;
                break;
            case 2:
                nroConta++;
                p1 = new ContaPoupanca(nroConta, nomeGerente, CPF);
                gerenciar.adicionarConta(p1);
                nomeCliente = null;
                CPF = null;
                tipoConta = 0;
                break;
            case 3:
                nroConta++;
                gerenciar.adicionarConta(new ContaEspecial(nroConta, nomeCliente, CPF, limite, nomeGerente));
                nomeCliente = null;
                CPF = null;
                tipoConta = 0;
                break;
            default:
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char continua;
        double valor;
        int	nroContaEscolhida;
        int nroContaEscolhido2;
        int escolha;
        int rendimento;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar conta \n2 - Sacar \n3 - Depositar \n4 - Transferir \n5 - Buscar contas especiais \n6 - Buscar contas usando limite \n7 - Buscar conta \n8 - Listar contas \n9 - Remover conta \n10 - Calcular rendimento(Conta Poupança)");
            escolha = entrada.nextInt();
            switch (escolha) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    System.out.println("Digite o número da conta:");
                    nroContaEscolhida = entrada.nextInt();
                    System.out.println("Digite o valor:");
                    valor = entrada.nextDouble();
                    System.out.println(gerenciar.sacar(nroContaEscolhida, valor));
                    nroContaEscolhida = 0;
                    valor = 0;
                    escolha = 0;
                    break;
                case 3:
                    System.out.println("Digite o número da conta:");
                    nroContaEscolhida = entrada.nextInt();
                    System.out.println("Digite o valor:");
                    valor = entrada.nextDouble();
                    System.out.println(gerenciar.depositar(nroContaEscolhida, valor));
                    nroContaEscolhida = 0;
                    valor = 0;
                    escolha = 0;
                    break;
                case 4:
                    System.out.println("Digite o número da conta fonte:");
                    nroContaEscolhida = entrada.nextInt();
                    System.out.println("Digite o valor:");
                    valor = entrada.nextDouble();
                    System.out.println("Digite o número da conta destino:");
                    nroContaEscolhido2 = entrada.nextInt();
                    System.out.println(gerenciar.transferirValor(nroContaEscolhida, nroContaEscolhido2, valor));
                    nroContaEscolhida = 0;
                    nroContaEscolhido2 = 0;
                    valor = 0;
                    escolha = 0;
                    break;
                case 5:
                    System.out.println(gerenciar.buscarContasEspeciais());
                    escolha = 0;
                    break;
                case 6:
                    System.out.println(gerenciar.buscarClientesUsandoLimite());
                    escolha = 0;
                    break;
                case 7:
                    System.out.println("Digite o número da conta");
                    nroContaEscolhida = entrada.nextInt();
                    System.out.println(gerenciar.buscarConta(nroContaEscolhida));
                    nroContaEscolhida = 0;
                    escolha = 0;
                    break;
                case 8:
                    System.out.println(gerenciar.listarContas());
                    escolha = 0;
                    break;
                case 9:
                    System.out.println("Digite o número da conta");
                    nroContaEscolhida = entrada.nextInt();
                    System.out.println(gerenciar.removerConta(nroContaEscolhida));
                    escolha = 0;
                    nroContaEscolhida = 0;
                    break;
                case 10:
                    System.out.println("Digite o rendimento:");
                    rendimento = entrada.nextInt();
                    p1.calcularRendimento(rendimento);
                    nroContaEscolhida = 0;
                    rendimento = 0;
                    escolha = 0;
                default:
            }
            System.out.println("Deseja continuar? s/n");
            continua = entrada.next().charAt(0);
        } while(continua != 'n');
    }
}