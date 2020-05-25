package br.com.boavista;

import java.io.IOException;
import java.util.HashMap;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {

		String sourceRobo = args[0];
		String destination = args[1];
//		String sourceCartorios = args[2];
//		String erroMeet = args[3];
		String linha = "";
		int cont = 0;
		int contErr = 0;

		DaoCartoiros dao = new DaoCartoiros();
//		ReadFile leitorArqCartorios = new ReadFile(sourceCartorios);
//		HashMap<String, ModelCatorioBvs> cartoriosBvs = new HashMap<String, ModelCatorioBvs>();
//
//
//		linha = leitorArqCartorios.lerLinha();
//		ModelCatorioBvs model = new ModelCatorioBvs(linha);
//		do {
//
//			cartoriosBvs.put(model.getCodigoBusca, model);
//			linha = leitorArqCartorios.lerLinha();
//			if (linha != null) {
//				model = new ModelCatorioBvs(linha);
//			}
//		} while (linha != null);

		ReadFile leitorArqRobo = new ReadFile(sourceRobo);
		WriteFile grava = new WriteFile(destination);

//		WriteFile gravaErro = new WriteFile(erroMeet);

//		ExtractFile extract = new ExtractFile();
//		extract.decompressGzip(source, destination);
//      		

		linha = leitorArqRobo.lerLinha();
		do {

			ModelProtestoAS400 protesto = new ModelProtestoAS400(linha);
//			if (cartoriosBvs.containsKey(protesto.getCodigoBusca)) {
//				model = cartoriosBvs.get(protesto.getCodigoBusca);
//				protesto.setCodigoCartorio(model.codCartoiroBvs);
//				cont++;
//			} else {
//				if (!protesto.getTelefone.equals("")) {
//					String s = protesto.getCodigoBusca;
//					String z = protesto.getTelefone;
//					gravaErro.WriteLine(protesto.getCodigoBusca + "|" + protesto.getTelefone +  "\n");
//					contErr ++;
//				}
//			}
			if (!protesto.getGetddd().equals("")) {
				protesto.setcodCartorioBvs(dao.selecionaCartorio(protesto.getGetddd(), protesto.getGetNumTel()));
			}
			grava.WriteLine(protesto + "\n");
			linha = leitorArqRobo.lerLinha();

		} while (linha != null);

		grava.close();
//		gravaErro.close();
		leitorArqRobo.close();
		System.out.println("Termino de processamento " + cont + " " + contErr );
	}
}
