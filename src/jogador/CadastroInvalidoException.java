package jogador;

import racha.RachaException;

public class CadastroInvalidoException extends RachaException {
    private final String campo;

    public CadastroInvalidoException(String campo, String mensagem){
        super(mensagem);
        this.campo = campo;
    }

    public String getCampo(){
        return campo;
    }
    
}
