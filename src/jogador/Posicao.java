package jogador;
public enum Posicao {
    //posições possíveis
    goleiro,
    zagueiro,
    meioCampo,
    atacante;

    //métodos úteis

    public boolean isLinha(){
        return (this != goleiro);
    }
}
