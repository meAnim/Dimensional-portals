package alphaUni;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Terran {
	
	public static void main(String [] args) {
		
		try {
			URL url = new URL("");
			HttpURLConnection conect = (HttpURLConnection) url.openConnection();
			conect.setRequestMethod("Post");
			conect.setRequestProperty("Content-Type", "application/json");
			String input = "{\"name\":\"Emmanuel\" , \"job\":\"software\"}";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
