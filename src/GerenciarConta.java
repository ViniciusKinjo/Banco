import java.util.ArrayList;
public class GerenciarConta {
    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta c){
        contas.add(c);
    }

    public boolean removerConta(int nroConta){
        for(Conta c : contas){
            if(c.getNroConta() ==(nroConta)){
                contas.remove(c);
                return true;
            }
        }
        return false;
    }

    public String buscarContasEspeciais(){
        String retornar = "";
        for(Conta c : contas){
            if(c instanceof ContaEspecial){
                retornar += c.toString() + "\n";
            }
        }
        return retornar;
    }

    public String buscarClientesUsandoLimite(){
        String retornar = "";
        for(Conta c : contas){
            if(c instanceof ContaCorrente){
                if(((ContaCorrente) c).usandoLimite()) {
                    retornar += c.toString() + "\n";
                }
            }
        }
        return retornar;
    }

    public Conta buscarConta(int nroConta){
        for(Conta c : contas){
            if(c.getNroConta() == nroConta){
                return c;
            }
        }
        return null;
    }

    public boolean transferirValor(int nroContaFonte, int nroContaDestino, double valor){
        for(Conta c : contas){
            if(c.getNroConta() == nroContaFonte){
                if(c.sacar(valor) == true){
                    for(Conta x : contas){
                        if(x.getNroConta() == nroContaDestino){
                            if(x.depositar(valor) == true){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean sacar(int nroConta, double valorSacado){
        for(Conta c : contas){
            if(c.getNroConta() == nroConta){
                if(c.sacar(valorSacado) == true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean depositar(int nroConta, double valorDepositado){
        for(Conta c : contas){
            if(nroConta == c.getNroConta()){
                if(c instanceof ContaPoupanca){
                    if(c.depositar(valorDepositado) == true){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public String listarContas() {
        for(int i = 0; i < contas.size(); i++){
            return contas.toString();
        }
        return null;
    }
}
