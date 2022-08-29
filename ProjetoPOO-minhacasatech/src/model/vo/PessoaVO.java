package model.vo;
public abstract class PessoaVO {
	private Long Id;
	private String nome;
	private String endereco;
	private String telefone;
	
	public PessoaVO(String nome, String endereco, String telefone){
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
	}
	public PessoaVO() {
  }
  public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone==null) {
		}
		else {
			if(telefone.equals("")) {		
			}
			else {
			this.telefone = telefone;
			}
		}
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco==null) {
		}
		else {
			if(endereco.equals("")) {
				
			}
			else {
				this.endereco = endereco;
			}
		}
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
}
