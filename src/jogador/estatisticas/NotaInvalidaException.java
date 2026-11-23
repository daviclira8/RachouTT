package jogador.estatisticas;

import racha.RachaException;

public class NotaInvalidaException extends RachaException {
    public NotaInvalidaException() {
        super("Nota inválida");
    }
}
