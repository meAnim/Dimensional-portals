package alphaUni;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Terran {
	
	public static void main(String [] args) {
		
		try {
			URL url = new URL("https://regres.in/api/users");
			HttpURLConnection conect = (HttpURLConnection) url.openConnection();
			
			conect.setRequestMethod("POST"); // protocol
			
			conect.setRequestProperty("Content-Type", "application/json"); // headers
			
			String input = "{\"name\":\"Emmanuel\" , \"job\":\"software\"}"; // json body
			
			conect.connect();
			
			int responseCode = conect.getResponseCode();
			
			String responseMessage = conect.getResponseMessage();
			
			if(responseCode == HttpURLConnection.HTTP_CREATED) {
				StringBuilder information = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()) {
					information.append(scanner.nextLine());
				}
				System.out.println(information);
				scanner.close();
				conect.disconnect();
				
			}else {
				
				throw new RuntimeException("This didnt work. The response code received is "+ responseCode+ " and responseMessage is "+ responseMessage);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
