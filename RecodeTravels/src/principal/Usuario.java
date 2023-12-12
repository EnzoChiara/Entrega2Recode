package principal;

public class Usuario {

	private int IDUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String informacoesContato;
    
    
	public Usuario(int iDUsuario, String nome, String sobrenome, String email, String senha,
			String informacoesContato) {
		super();
		IDUsuario = iDUsuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.informacoesContato = informacoesContato;
	}
	public Usuario(){
		
	}
	
	public int getIDUsuario() {
		return IDUsuario;
	}
	public void setIDUsuario(int iDUsuario) {
		IDUsuario = iDUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getInformacoesContato() {
		return informacoesContato;
	}
	public void setInformacoesContato(String informacoesContato) {
		this.informacoesContato = informacoesContato;
	}
    
    
}
