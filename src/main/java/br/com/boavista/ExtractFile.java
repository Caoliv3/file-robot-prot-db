package br.com.boavista;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;



public class ExtractFile {

	public void decompressGzip(String string, String string2) {

		try (GZIPInputStream in = new GZIPInputStream(new FileInputStream(string))) {
			try (FileOutputStream out = new FileOutputStream(string2)) {
				byte[] buffer = new byte[1024];
				int len;
				while ((len = in.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void decompressTar(String tarFile, String dest) {
//
//		TarArchiveInputStream tarIn = new TarArchiveInputStream(
//				new GzipCompressorInputStream(new BufferedInputStream(new FileInputStream(tarFile))));
//
//		TarArchiveEntry tarEntry = tarIn.getNextTarEntry();
//		// tarIn is a TarArchiveInputStream
//		while (tarEntry != null) {
//			// create a file with the same name as the tarEntry
//			File destPath = new File(dest, tarEntry.getName());
//			System.out.println("working: " + destPath.getCanonicalPath());
//			if (tarEntry.isDirectory()) {
//				destPath.mkdirs();
//			} else {
//				destPath.createNewFile();
//				byte[] btoRead = new byte[2048];
//				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(destPath));
//				int len;
//				while ((len = tarIn.read(btoRead)) != -1) {
//					bout.write(btoRead, 0, len);
//				}
//
//				bout.close();
//				btoRead = null;
//
//			}
//			tarEntry = tarIn.getNextTarEntry();
//		}
//		tarIn.close();
//
//	}

}
