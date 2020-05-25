package br.com.boavista;

import lombok.Data;

@Data
public class ModelCatorioBvs {
	
	
	
	private String ufedBvs = "";	
	private String municipioBvs = "";
	private String cartorioBvs = "";
	private String enderecoBvs = "";	
	private String numddBvs = "";
	private String telefoneBvs = "";
	public  String codCartoiroBvs = "";
	public  String getCodigoBusca;

	public ModelCatorioBvs(String reg) {
		
		String[] linha = reg.split(";");
		
		
		ufedBvs = linha[0];
		numddBvs = linha[1];
		telefoneBvs = linha[2];
		cartorioBvs = linha[4];
		codCartoiroBvs = linha[5];
		enderecoBvs = linha[6];		
		municipioBvs = linha[7];
		
		getCodigoBusca = numddBvs + telefoneBvs;
	}

}
