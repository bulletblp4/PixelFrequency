package com.tumblr.client;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import java.util.List;

import javax.imageio.ImageIO;


public class TumblrClient {
		
	
	
	public BufferedImage getAvatarData(String blogName) throws IllegalArgumentException {
		String urlStirng = "https://api.tumblr.com/v2/blog/"+blogName+".tumblr.com/avatar/512";
		
		URL url = null;
		try {
			url = new URL(urlStirng);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		
		int status = 0;
		try {
			status = con.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> result = null;
		BufferedImage image = null;
		if(status == 200){
			
			try {
				image = ImageIO.read(con.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else{
			throw new IllegalArgumentException();
		}
		
		return image;
	}
	
	
	
}
