package model.vo;

public class NotaFiscalVO {
	private String dataEmissao;
	private String destino;
	private String horarioEnvio;
	private String nomeProduto;
	private String codProduto;
	private double valorProduto;
	private double valorTotal;
	private int quantidadeProduto;
	private double pesoProduto;
	private double pesoTotal;
	private ClienteVO nomeCliente;
	private ClienteVO CPF;
	
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		if(dataEmissao==null) {
			
		}
		else {
			if(dataEmissao.equals("")) {
				
			}
			else {
				this.dataEmissao = dataEmissao;
			}
		}
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		if(destino==null) {
			
		}
		else {
			if(destino.equals("")) {
				
			}
			else {
				this.destino = destino;
			}
		}
	}
	public String getHorarioEnvio() {
		return horarioEnvio;
	}
	public void setHorarioEnvio(String horarioEnvio) {
		if(horarioEnvio==null) {
			
		}
		else {
			if(horarioEnvio.equals("")) {
				
			}
			else {
				this.horarioEnvio = horarioEnvio;
			}
		}
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		if(nomeProduto==null) {
			
		}
		else {
			if(nomeProduto.equals("")) {
				
			}
			else {
				this.nomeProduto = nomeProduto;
			}
		}
	}
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		if(codProduto==null) {
			
		}
		else {
			if(codProduto.equals("")) {
				
			}
			else {
				this.codProduto = codProduto;
			}
		}
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		if(valorProduto>0 && valorProduto!=0)
		{
			this.valorProduto = valorProduto;
		}
		else {
			
		}
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		if(valorTotal>0 && valorTotal!=0)
		{
			this.valorTotal = valorTotal;
		}
		else {
			
		}
	}
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		if(quantidadeProduto>0 || quantidadeProduto==0) {
			this.quantidadeProduto = quantidadeProduto;
		}
		else {
			
		}
	}
	public double getPesoProduto() {
		return pesoProduto;
	}
	public void setPesoProduto(double pesoProduto) {
		if(pesoProduto > 0) {
			this.pesoProduto = pesoProduto;
		}
		else {
			
		}
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		if(pesoTotal>0) {
			this.pesoTotal = pesoTotal;
		}
		else {
			
		}
	}
	
	public ClienteVO getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(ClienteVO nomeCliente) {
		if(nomeCliente==null)
		{
			
		}
		else {
			if(nomeCliente.getNome().equals("")) {
				
			}
			else {
				this.nomeCliente = nomeCliente;
			}
		}
	}
	public ClienteVO getCPF() {
		return CPF;
	}
	public void setCPF(ClienteVO CPF) {
		if(CPF.getCPF().equals("")) {
			
		}
		else {
			this.CPF = CPF;
			}
		}
	
}
