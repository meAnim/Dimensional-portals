package alphaUni;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Universe {
	
	public static void main(String [] args) {
		
		Terran terran = new Terran();
		
		System.out.println(terran.postFromTerran());
		
	}

}
