package jogador.estatisticas;

import racha.RachaException;

public class NotaInvalidaException extends RachaException {
    public NotaInvalidaException(double nota) {
        super("Nota inválida");
    }
}
