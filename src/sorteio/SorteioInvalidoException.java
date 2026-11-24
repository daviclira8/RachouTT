package sorteio;
import racha.RachaException;

public class SorteioInvalidoException extends RachaException{
    private int minimoNecessario;

    public SorteioInvalidoException(int minimoNecessario, String mensagem){
        super(mensagem);
        this.minimoNecessario = minimoNecessario;
    }

    public int getMinimoNecessario(){
        return this.minimoNecessario;
    }
}
