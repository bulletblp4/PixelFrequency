package com.tumblr.process;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tublr.util.SortMap;
import com.tumblr.client.TumblrClient;

public class PixelCounter {
	
	private String blogName;
	private int count;
	public PixelCounter(String blogName, int count){
		this.blogName = blogName;
		this.count = count;
	}
	
	/**
	 * call the client to get the image
	 * returns the top N images.
	 * @return
	 * @throws TumblerPixelReaderException
	 */
	public List<Entry<String, Integer>> retreiveAvatarData() throws IllegalArgumentException {
		TumblrClient client = new TumblrClient();
		BufferedImage image = client.getAvatarData(blogName);
		SortMap sortMap = new SortMap();
		List<Entry<String, Integer>> descSorted = sortMap.entriesSortedDescByValues(populateMapWithPixelCount(image));
		return descSorted.subList(0, count);
	}
	
	/**
	 * Given a buffered image returns a Map of all the pixel hex value with their count.
	 * @param image
	 * @return Map<String,Long>
	 */
	private Map<String,Integer> populateMapWithPixelCount(BufferedImage image){

		Map<String,Integer> result = new HashMap<>();
		for(int i = 0 ; i < image.getHeight()-1 ; i++){
			for(int j = 0 ; j < image.getWidth()-1 ; j++){
				Color col = new Color(image.getRGB(i, j));
	            String hex = String.format("%02x%02x%02x", col.getRed(),col.getGreen(),col.getBlue());
	            
	            if(result.containsKey(hex)){
	            	int val = result.get(hex);
	            	result.put(hex,val+1);
	            }else{
	            	result.put(hex,1);
	            }
				
			}
		}
		return result;
		
	}
	
	
	
	
	
}
