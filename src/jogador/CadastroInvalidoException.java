package jogador;
public class CadastroInvalidoException  extends Exception{
    private String campoErro;

    public CadastroInvalidoException(String campoErro){
        this.campoErro = campoErro;
        super("Campo inválido no cadastro: " + campoErro);
    }

    public String getCampoErro() {
        return campoErro;
    }
}
//Acho melhor essa ser uma exceção checkada, apesar da uml dizer outra coisa.