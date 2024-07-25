package entity;

public class Onibus {
	
	// variaveis
	private Passageiro[] vagas;
	private int totalVagas = 46;
	
	//corpo
	public Onibus(int totalVagas) {
		
		this.totalVagas = totalVagas;
		this.vagas = new Passageiro[totalVagas];
	}
		
	public boolean adicionaPassageiro(Passageiro passageiro, int vaga) {
		if (vaga >= 0 && vaga < totalVagas && vagas[vaga] == null) {
			vagas[vaga] = passageiro;
			return true;
			
		}
		return false;
	}
	
	
	// gets e sets

	
}
