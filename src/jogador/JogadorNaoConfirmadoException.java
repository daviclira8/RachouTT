package jogador;
public class JogadorNaoConfirmadoException extends RachaException {
    private long jogadorId;

    public JogadorNaoConfirmadoException(long jogadorId, String mensagem){
        super(mensagem);
        this.jogadorId = jogadorId;
    }

    public long getJogadorLd(){
        return this.jogadorId;
    }
}
