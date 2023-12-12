package principal;

import java.util.Date;

public class Voos {
	private int IDVoo;
    private String numeroVoo;
    private String aeroportoOrigem;
    private String aeroportoDestino;
    private Date dataHoraPartida;
    private Date dataHoraChegada;
    private String companhiaAerea;
    private double preco;
	private Date novaData;
    
	public int getIDVoo() {
		return IDVoo;
	}
	public void setIDVoo(int iDVoo) {
		IDVoo = iDVoo;
	}
	public String getNumeroVoo() {
		return numeroVoo;
	}
	public void setNumeroVoo(String numeroVoo) {
		this.numeroVoo = numeroVoo;
	}
	public String getAeroportoOrigem() {
		return aeroportoOrigem;
	}
	public void setAeroportoOrigem(String aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}
	public String getAeroportoDestino() {
		return aeroportoDestino;
	}
	public void setAeroportoDestino(String aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}
	public Date getDataHoraPartida() {
		return dataHoraPartida;
	}
	public void setDataHoraPartida(Date dataHoraPartida) {
		this.dataHoraPartida = dataHoraPartida;
	}
	public Date getDataHoraChegada() {
		return dataHoraChegada;
	}
	public void setDataHoraChegada(Date dataHoraChegada) {
		this.dataHoraChegada = dataHoraChegada;
	}
	public String getCompanhiaAerea() {
		return companhiaAerea;
	}
	public void setCompanhiaAerea(String companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Date getData() {
		return novaData;
		
	}
	public void setData(Date novaData) {
		this.novaData = novaData;
		
	}
    
}
