package com.jdglazer.binwrite.dataaccess.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class XMLBuilder {
	
	public static String buildElement( String tagName, Map<String,String> attributes ) {
		
		String xml = "<"+tagName;
		
		if( attributes != null ) {
			
			for( String name : attributes.keySet() ) {
				
				if ( name != null ) {
					
					String value = attributes.get(name);
					
					xml += " "+name+"=\""+value+"\"";
				}
			}
		}
		
		xml += "/>";
		
		return xml;
	}
	
	public static String buildElement( String tagName, Map<String,String> attributes, String encasedContent ) {
		
		if ( encasedContent == null ) {
			
			System.out.println("DEBUG: Null encased content for tag: "+tagName+". Return self-closing tag.");
			
			return buildElement( tagName, attributes );
		}
		
		String xml = "<"+tagName;
		
		if ( attributes != null ) {	
		
			for( String name : attributes.keySet() ) {
				
				if ( name != null ) {
					
					String value = attributes.get(name);
					
					xml += " "+name+"=\""+value+"\"";
				}
			}
		} 
		else { 
			System.out.println("DEBUG: null attributes list for tag: "+ tagName);
		}
		
		xml += ">";
	    
		xml += encasedContent;
		
		xml += "</"+tagName+">";
		
		return xml;
	}
	
	public static String formatXML( int indentSpacing, String xml ) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xml)));
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(out));
		System.out.println(out.toString());
		return null;
	}
}
