public abstract class Conta {
    protected int nroConta;
    protected String nomeCliente;
    protected String CPF;
    protected double saldo;

    public Conta (int nroConta, String nomeCliente, String CPF){
        this.nroConta = nroConta;
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
    }

    public int getNroConta(){
        return this.nroConta;
    }
    public String getNomeCliente(){
        return this.nomeCliente;
    }

    public String getCPF(){
        return this.CPF;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    private void setNroConta(int nroConta){
        this.nroConta = nroConta;
    }

    private void setSaldo(double saldo){
        this.saldo = saldo;
    }

    private void setCPF(String CPF){
        this.CPF = CPF;
    }

    public boolean sacar(double valorSacado){
        if(valorSacado <= saldo){
            saldo -= valorSacado;
            if(saldo >= 0){
                return true;
            }
            saldo += valorSacado;
            return true;
        }
        return false;
    }


    public boolean depositar(double valorDepositado){
        if(valorDepositado>0){
            saldo += valorDepositado;
            return true;
        }
        return false;
    }


    public String toString(){
        return "\nNome: " + nomeCliente+
                "\nCPF: " + CPF +
                "\nNúmero da Conta: " + nroConta +
                "\nSaldo: " + saldo;
    }



}
