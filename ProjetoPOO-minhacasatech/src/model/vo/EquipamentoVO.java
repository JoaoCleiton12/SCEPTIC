package model.vo;

public class EquipamentoVO {
	private Long Id;
	private String nome;
	private double peso;
	private String numeroDeSerie;
	private double preco;
	private int quantidade;
	private FuncionarioVO responsavel;
	private LocalVO local;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome==null) {
			
		}
		else {
			if(nome.equals("")) {
				
			}
			else {
				this.nome = nome;
			}
		}
		
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if(peso>0) {
			this.peso = peso;
		}
		else {
			
		}
	}
	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}
	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		if(preco>0 && preco!=0) {
			this.preco = preco;
		}
		else {
			
		}
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if(quantidade>0 || quantidade==0) {
			this.quantidade = quantidade;
		}
		else {
			
		}
	}
	public FuncionarioVO getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(FuncionarioVO responsavel) {
		if(responsavel==null) {
			System.out.println("Nulo");
		}
		else {
				this.responsavel = responsavel;
		}
	}
	public String getNomeResponsavel() {
		return responsavel.getNome();
	}
	public String getNomeLocal() {
		return local.getNome();
	}
	public LocalVO getLocal() {
		return local;
	}
	public void setLocal(LocalVO local) {
		if(local==null) {
			System.out.println("Nulo");
		}
		else {
				this.local = local;
		}
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	@Override
	public String toString() {
				return getNome();
	}
	
	
}
