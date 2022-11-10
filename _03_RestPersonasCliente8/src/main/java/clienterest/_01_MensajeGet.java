package clienterest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class _01_MensajeGet {

	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner(System.in);
			System.out.println("Bienvenido a nuestra primera app de conexión al servlet");
			System.out.println("-------------------------------------------------------");
			System.out.println("Quiere acceder al texto o al html?");
			
			String recurso = sc.nextLine();
			
			
			URL url = new URL("http://localhost:8080/_03_RestPersonas-0.0.1-SNAPSHOT/rest/mensaje/" + recurso);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			conn.connect();
			
			if (conn.getResponseCode() != 200) {
				System.out.println("Mensaje del servidor: " + conn.getResponseCode());
			}else {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				String output = null;
				System.out.println("Salida del servidor ....");
				
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
			}			

			conn.disconnect();
			sc.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}