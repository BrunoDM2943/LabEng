/**
 * 
 */
package edu.fatec;

/**
 * Classe: Jogo <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criação: 21/04/2015 <br>
 */
public class Jogo {
	
	private String nome;
	
	private Dificuldade dificuldade;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dificuldade
	 */
	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	/**
	 * @param dificuldade the dificuldade to set
	 */
	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {	
		return nome.equalsIgnoreCase(Jogo.class.cast(obj).getNome());
	}

}
