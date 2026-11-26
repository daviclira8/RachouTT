package racha;
import jogador.Jogador;
import jogador.Time;
import fases.FaseDeGrupos;
import fases.FaseEliminatoria;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class Racha {
    private Long id;
    private LocalDate data;
    private String local;
    private BigDecimal custoTotal;
    private int qtdTimes;
    private StatusRacha status;
    private Set<Jogador> confirmados;
    private List<Time> times;
    private FaseDeGrupos faseDeGrupos;
    private FaseEliminatoria faseEliminatoria;

    public Racha(Long id, LocalDate data, String local, BigDecimal custoTotal, int qtdTimes){
        
        validarDados(id, data, local, custoTotal, qtdTimes);
        
        this.id = id;
        this.data = data;
        this.local = local;
        this.custoTotal = custoTotal;
        this.qtdTimes = qtdTimes;
        this.status = StatusRacha.ABERTO;
        this.confirmados = new HashSet<>();
        this.times = new ArrayList<>();
        this.faseDeGrupos = null;
        this.faseEliminatoria = null;

    }

    private void validarDados(Long id, LocalDate data, String local, BigDecimal custoTotal, int qtdTimes){
        if(qtdTimes < 2){
            throw new RachaException("Quantidade de times inválida."); 
        }    
        if(local == null || local.isBlank()){
            throw new RachaException("Local inválido.");
        }
        if(id == null || id < 1){
            throw new RachaException("ID do racha inválido");
        }
        if(data == null){
            throw new RachaException("A data do racha deve ser informada.");
        }
        if(custoTotal == null || custoTotal.compareTo(BigDecimal.ZERO) < 0){
            throw new RachaException("O custo total do racha é inválido");
        }

    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public BigDecimal getCustoTotal() {
        return custoTotal;
    }

    public int getQtdTimes() {
        return qtdTimes;
    }

    public StatusRacha getStatus() {
        return status;
    }

    public Set<Jogador> getConfirmados(){
        return Set.copyOf(confirmados);
    }
    
    public List<Time> getTimes(){
        return List.copyOf(times);
    }

    public void confirmarPresenca(Jogador j){
        if(j == null){
            throw new RachaException("Jogador nulo");
        }
        if(!status.permiteConfirmacao()){
            throw new RachaException("O racha não permite configurações.");
        }
        boolean adicionado = confirmados.add(j);
        if(!adicionado){
            throw new RachaException("O jogador já está confirmado");
        }

    }

}   