package alphaUni;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.Scanner;

public class Terran {
	
	
	
	public StringBuilder postFromTerran() {
		StringBuilder postInfo = new StringBuilder();
		
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
				
				throw new RuntimeException("An error occured The code received is "+ responseCode+ " and responseMessage is "+ responseMessage);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return postInfo;
	}
	
	
	
	public StringBuilder getFromTerran() {
		StringBuilder getInfo = new StringBuilder();
		HttpURLConnection connection = null;
		Scanner scanner  = null;
		
		int responseCode = 0;
		String responseMessage ="intial";
		
		try {
			URL url = new URL("");
			
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			connection.connect();
			
			responseCode = connection.getResponseCode();
			responseMessage = connection.getResponseMessage();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()) {
					
					getInfo.append(scanner.nextLine());
				}
				
			}else {
				System.out.println("ResponseCode: " + responseCode);
				System.out.println("ResponseMessage: " + responseMessage);
			}
			
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			
		} finally{
			scanner.close();
			connection.disconnect();
		}
		
		return getInfo;
	}
	

}
