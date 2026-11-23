package jogador;

import jogador.estatisticas.EstatisticaJogador;
import jogador.estatisticas.NotaInvalidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Jogador implements Pagavel, Avaliavel {

    private final long id;
    private final String nome;
    private final List<Double> historicoNotas;
    private final EstatisticaJogador estatisticas;
    private Posicao posicao;

    public Jogador(long id, String nome, Posicao posicao) throws CadastroInvalidoException{
        if(nome == null || nome.trim().isEmpty()){
            throw new CadastroInvalidoException("Nome");
        }
        if (posicao == null){
            throw new CadastroInvalidoException("Posição");
        }
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.historicoNotas = new ArrayList<>();
        this.estatisticas = new EstatisticaJogador();
    }

    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public EstatisticaJogador getEstatisticas() {
        return estatisticas;
    }

    protected void validarNota(double nota) throws NotaInvalidaException{
        if(nota < 0.0 || nota > 10.0){
            throw new NotaInvalidaException(nota);
        }
    }

    public double getNotaGeral(){
        double soma = 0.0;
        for(double nota : historicoNotas){
            soma+= nota;
        }
        return (soma/historicoNotas.size());
    }
    //adicionar notas, atualizar estatisticas, resetar notas

    @Override
    public void addNota(double nota){
        validarNota(nota);
        this.historicoNotas.add(nota);
    }

    @Override
    public boolean isIsento(){
        return !this.posicao.isLinha();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return id == jogador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Jogador{\n" +
                "id=" + id +
                "\nnome=" + nome +
                "\nestatisticas=" + estatisticas +
                "\nposicao=" + posicao +
                "\n}";
    }
}
