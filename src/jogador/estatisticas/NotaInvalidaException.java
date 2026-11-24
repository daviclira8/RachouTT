package jogador.estatisticas;
import racha.RachaException;

public class NotaInvalidaException extends RachaException{
    private double notaInformada;

    public NotaInvalidaException(double notaInformada, String mensagem){
        super(mensagem);
        this.notaInformada = notaInformada;
    }    

    public double getNotaInformada(){
        return this.notaInformada;
    }
}
