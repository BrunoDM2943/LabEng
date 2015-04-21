/**
 * 
 */
package edu.fatec;

/**
 * Classe: Dificuldade <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criação: 21/04/2015 <br>
 */
public enum Dificuldade {
	
	FACIL("Facil"),
	MEDIO("Medio"),
	DIFICIL("Dificil");
	
	String dificuldade;

	/**
	 * @param dificuldade
	 */
	private Dificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	
		
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return dificuldade;
	}

	/**
	 * @return the dificuldade
	 */
	public String getDificuldade() {
		return dificuldade;
	}

	/**
	 * @param dificuldade the dificuldade to set
	 */
	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
}
