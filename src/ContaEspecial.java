public class ContaEspecial extends  ContaCorrente{
    private String nomeGerente;

    public ContaEspecial(int nroConta, String nomeCliente, String CPF, String nomeGerente) {
        super(nroConta, nomeCliente, CPF);
        this.nomeGerente = nomeGerente;
    }

    public ContaEspecial(int nroConta, String nomeCLiente, String CPF, double limite, String nomeGerente){
        super(nroConta, nomeCLiente, CPF, limite);
        this.nomeGerente = nomeGerente;
    }

    public String getNomeGerente(){
        return this.nomeGerente;
    }

    public void setNomeGerente(String nomeGerente){
        this.nomeGerente = nomeGerente;
    }

    public String toString(){
        return super.toString() + "\nGerente: " + this.nomeGerente;
    }
}
