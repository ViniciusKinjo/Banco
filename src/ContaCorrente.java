public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(int nroConta, String nomeCliente, String CPF){
        super(nroConta, nomeCliente, CPF);
    }

    public ContaCorrente(int nroConta, String nomeCliente, String CPF, double limite){
        super(nroConta, nomeCliente, CPF);
        this.limite = limite;
    }

    public boolean usandoLimite(){
        return saldo < 0;
    }

    public boolean sacar(double valorSacado) {
        if(valorSacado<=saldo){
            saldo -= valorSacado;
            return true;
        } else if(valorSacado > saldo){
            saldo -= valorSacado;
            if(saldo < -limite){
                saldo += valorSacado;
                return false;
            }
            return true;
        }
        return false;
    }

    public String toString(){
        return super.toString() + "\nLimite: " + limite;
    }


}
