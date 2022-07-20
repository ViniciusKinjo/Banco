public class ContaPoupanca extends Conta{

    public ContaPoupanca(int nroConta, String nomeCLiente, String CPF){
        super(nroConta, nomeCLiente, CPF);
    }

    public void calcularRendimento(double porcentagemRendimento){
        saldo = saldo + (saldo * porcentagemRendimento / 100);
    }

}
