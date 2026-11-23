package jogador.estatisticas;

import racha.RachaException;

public class NotaInvalidaException extends RachaException {
    double notaInformada;
    public NotaInvalidaException(double notaInformada) {
        super("Nota inválida");
        this.notaInformada = notaInformada;
    }
}
