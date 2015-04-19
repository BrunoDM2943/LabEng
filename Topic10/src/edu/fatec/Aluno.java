package edu.fatec;
/**
 * 
 * Classe: Aluno <br>
 * 
 * @author Bruno <br>
 * 
 *         Propósito: Entidade representando um Aluno <br>
 *         Data de criação: 11/04/2015 <br>
 */
public class Aluno {

	private long id;

	private String ra;

	private String nome;

	private int idade;

	private String sexo;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the ra
	 */
	public String getRa() {
		return ra;
	}

	/**
	 * @param ra
	 *            the ra to set
	 */
	public void setRa(String ra) {
		this.ra = ra;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * @param idade
	 *            the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", ra=" + ra + ", nome=" + nome + ", idade="
				+ idade + ", sexo=" + sexo + "]";
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (int) id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Aluno e = (Aluno) obj;
		return e.getId() == id;
	}
	
}
