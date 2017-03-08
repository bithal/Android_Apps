package com.example.locationservice;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class RetriveLocation implements Runnable{

	String loc;
	public Thread thread;
	public String data;
	
	public RetriveLocation(String loc) {

		this.loc = loc;
		thread = new Thread(this, "New Thread");
		thread.start();
	}
	@Override
	public void run() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/xml?latlng="+loc+"&Sensor=true");
			
			Document document = builder.parse(url.openStream());
			
			NodeList nodeList = document.getElementsByTagName("result");
			
			Node node = nodeList.item(0);
			
			Element element = (Element) node;
			
			data = element.getElementsByTagName("formatted_address").item(0).getTextContent();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
