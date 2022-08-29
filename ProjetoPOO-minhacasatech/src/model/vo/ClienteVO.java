package model.vo;

public class ClienteVO extends PessoaVO{

	private String CPF;
	private Long Id;
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		if(cPF.equals(""))
		{
			System.out.println("Erro");
		}
		else {
			this.CPF = cPF;
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
