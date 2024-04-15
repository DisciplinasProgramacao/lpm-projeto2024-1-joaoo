/**
 * A classe Mesa representa as mesas do sistema de restaurante.
 */
public class Mesa {

    private static int contador = 1;

    private int id;
    private int capacidade;
    private boolean ocupada;
    private Requisicao requisicao;


    public int getCapacidade() {
        return capacidade;
    }

    public int getId() {
        return id;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }
    public boolean estaOcupada() {
        return ocupada;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade == 4 || capacidade == 6 ||capacidade == 8 ){
        this.capacidade = capacidade;
        }
    }
  
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setID(int id) {
        this.id = id;
    }

    /**
     * Método para realizar a ação de desocupar a mesa, tornando o @param setOcupada false.
     */
    public boolean desocupar(){
        this.requisicao = null;
        this.setOcupada(false); 
        return !estaOcupada();
    }

    /**
     * Método para realizar a ação de ocupar a mesa, tornando o @param setOcupada true.
     */
    public boolean ocupar(Requisicao requisicao){
        this.requisicao = requisicao;
        this.setOcupada(true); 
        return estaOcupada();
    }

    /**
     * Construtor para inicializar um objeto Mesa com capacidade, disponibilidade e ID.
     * 
     * @param capacidade A capacidade da mesa.
     */
    public Mesa(int capacidade){
        setCapacidade(capacidade);
        setOcupada(false);
        setID(contador++);
    }
}
