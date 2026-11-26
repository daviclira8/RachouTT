package racha;
public enum StatusRacha {
    ABERTO,
    TIMES_SORTEADOS,
    FASE_DE_GRUPOS,
    ELIMINATORIAS,
    FINALIZADO;
    // Metodo que permite que um jogador confirme presenca.
    public boolean permiteConfirmacao(){
        return this == ABERTO;
    }
}
