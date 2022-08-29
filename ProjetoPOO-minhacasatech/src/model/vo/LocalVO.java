package model.vo;

public class LocalVO {
	private Long id;
	private String nome;
	private String compartimento;
	
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
	public String getCompartimento() {
		return compartimento;
	}
	public void setCompartimento(String compartimento) {
		if(compartimento==null) {
			
		}
		else {
			if(compartimento.equals("")) {
				
			}
			else {
				this.compartimento = compartimento;
			}
		}	
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return getNome();

	}
}
