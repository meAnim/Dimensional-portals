package alphaUni;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.Scanner;

public class Terran {
	StringBuilder postInfo = new StringBuilder();
	
	
	public StringBuilder postFromTerran() {
		
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
				
				Scanner scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()) {
					postInfo.append(scanner.nextLine());
				}
				
				scanner.close();
				conect.disconnect();
				
			}else {
				
				throw new RuntimeException("This didnt work. The response code received is "+ responseCode+ " and responseMessage is "+ responseMessage);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return postInfo;
	}
	
	
	StringBuilder getInfo = new StringBuilder();
	
	public StringBuilder getFromTerran() {
		
		try {
			URL url = new URL("");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			connection.connect();
			
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return getInfo;
	}
	

}
