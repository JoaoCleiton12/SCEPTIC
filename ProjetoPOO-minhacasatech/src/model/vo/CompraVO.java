package model.vo;

public class CompraVO {
  private EquipamentoVO equipamento;
  private Long id;
  private ClienteVO cliente;
  private String dataCompra;
  private Long quantidade;
  private Double preco;
  private String descricao;
  
  public EquipamentoVO getEquipamento() {
    return equipamento;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public Double getPreco() {
    return preco;
  }
  public void setPreco(Double preco) {
    if(preco==null) {
			System.out.println("Nulo");
		}
		else {
				this.preco = preco;
		}
  }
  public Long getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Long quantidade) {
    if(quantidade==null) {
			System.out.println("Nulo");
		}
		else {
				this.quantidade = quantidade;
		}
  }
  public String getDataCompra() {
    return dataCompra;
  }
  public void setDataCompra(String dataCompra) {
    if(dataCompra==null) {
			System.out.println("Nulo");
		}
		else {
				this.dataCompra = dataCompra;
		}
  }
  public ClienteVO getCliente() {
    return cliente;
  }
  public void setCliente(ClienteVO cliente) {
    if(cliente==null) {
			System.out.println("Nulo");
		}
		else {
				this.cliente = cliente;
		}
  }
  public void setEquipamento(EquipamentoVO equipamento) {
    if(equipamento==null) {
			System.out.println("Nulo");
		}
		else {
				this.equipamento = equipamento;
		}
  }
  // @Override
  // public String toString(){
  //   return cliente.getCPF();

  // }
  public String getEquipamentoNome() {
    return equipamento.getNome();
  }
  public String getEquipamentoSerie() {
    return equipamento.getNumeroDeSerie();
  }
  public double getEquipamentoPeso() {
    return equipamento.getPeso();
  }
  public double getEquipamentopreco() {
    return equipamento.getPreco();
  }
}
