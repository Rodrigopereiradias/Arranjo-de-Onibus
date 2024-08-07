package entity;

public class Onibus {
	
	// variaveis
	private Passageiro[] vagas;
	private int totalVagas = 46;
	
	// Construtor
	public Onibus(int totalVagas) {
		
		this.totalVagas = totalVagas;
		this.vagas = new Passageiro[totalVagas];
	}
	// Métodos	
	public boolean adicionaPassageiro(Passageiro passageiro, int vaga) {
		if (vaga >= 0 && vaga < totalVagas && vagas[vaga] == null) {
			vagas[vaga] = passageiro;
			return true;
			
		}
		return false;
	}
	
	public void mostraVagas() {
        for (int i = 0; i < totalVagas; i++) {
            if (vagas[i] != null) {
                System.out.println("Vaga " + i + ": " + vagas[i].getNome());
            } else {
                System.out.println("Vaga " + i + ": Vazia");
            }
        }
    }
	
	 public void mostrarInformacoesPassageiros() {
	        for (int i = 0; i < totalVagas; i++) {
	            if (vagas[i] != null) {
	                Passageiro p = vagas[i];
	                System.out.println("Vaga " + (i + 1) + ": Nome: " + p.getNome() + ", CPF: " + p.getCpf() + ", Idade: " + p.getIdade() + ", Sexo: " + (p.isSexo() ? "Masculino" : "Feminino"));
	            }
	        }
	    }
	
	// gets e sets
	public Passageiro[] getVagas() {
		return vagas;
	}

	public void setVagas(Passageiro[] vagas) {
		this.vagas = vagas;
	}

	public int getTotalVagas() {
		return totalVagas;
	}

	public void setTotalVagas(int totalVagas) {
		this.totalVagas = totalVagas;
	}
	
	
	

	
	
}
