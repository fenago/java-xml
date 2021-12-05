/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.stax;

import java.io.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;


public class StAXTest {
   
       
    private static void printUsage() {
        System.out.println("No filename passed in as argument - Using order.xml");
    }
    
    public static void main(String[] args) throws Exception {
        
        int count = 0 ;
        String filename = "order.xml";
        
        if (args.length > 0) {
            filename = args[0];
            printUsage();
        }
        
        
        XMLInputFactory xmlif = null ;
        try{
            xmlif = XMLInputFactory.newInstance();
            xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,Boolean.TRUE);
            xmlif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,Boolean.FALSE);
            //set the IS_COALESCING property to true , if application desires to
            //get whole text data as one event.            
            xmlif.setProperty(XMLInputFactory.IS_COALESCING , Boolean.FALSE);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        try{
			//pass the file name.. 
			XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
			//when XMLStreamReader is created, it is positioned at START_DOCUMENT event.
			int eventType = xmlr.getEventType();
			//printEventType(eventType);
			printStartDocument(xmlr);
			//check if there are more events in the input stream
			while(xmlr.hasNext()){
				eventType = xmlr.next();                   
				//printEventType(eventType);
				
				//these functions prints the information about the particular event by calling relevant function
				printStartElement(xmlr);                    
				printEndElement(xmlr);                    
				printText(xmlr);                    
				printPIData(xmlr);
				printComment(xmlr);
				
				if (getContinue() == false) break;
			}
        }catch(XMLStreamException ex){
            System.out.println(ex.getMessage());
            if(ex.getNestedException() != null)ex.getNestedException().printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    /**
     * Returns the String representation of the given integer constant.
     *
     * @param eventType Type of event.
     * @return String representation of the event
     */    
    public final static String getEventTypeString(int eventType) {
        switch (eventType){
            case XMLEvent.START_ELEMENT:
                return "START_ELEMENT";
            case XMLEvent.END_ELEMENT:
                return "END_ELEMENT";
            case XMLEvent.PROCESSING_INSTRUCTION:
                return "PROCESSING_INSTRUCTION";
            case XMLEvent.CHARACTERS:
                return "CHARACTERS";
            case XMLEvent.COMMENT:
                return "COMMENT";
            case XMLEvent.START_DOCUMENT:
                return "START_DOCUMENT";
            case XMLEvent.END_DOCUMENT:
                return "END_DOCUMENT";
            case XMLEvent.ENTITY_REFERENCE:
                return "ENTITY_REFERENCE";
            case XMLEvent.ATTRIBUTE:
                return "ATTRIBUTE";
            case XMLEvent.DTD:
                return "DTD";
            case XMLEvent.CDATA:
                return "CDATA";
            case XMLEvent.SPACE:
                return "SPACE";
        }
        return "UNKNOWN_EVENT_TYPE , " + eventType;
    }
    
    private static void printEventType(int eventType) {    
        System.out.println("EVENT TYPE("+eventType+") = " + getEventTypeString(eventType));
    }
    
    private static void printStartDocument(XMLStreamReader xmlr){

        if(xmlr.START_DOCUMENT == xmlr.getEventType()){
			printLeader();
			printEventType(xmlr.getEventType());
			printTrailer();
        }
    }
    
    private static void printComment(XMLStreamReader xmlr){
        if(xmlr.getEventType() == xmlr.COMMENT){
			printLeader();
			printEventType(xmlr.getEventType());
			printTrailer();
        }
    }
            
    private static void printText(XMLStreamReader xmlr){
    if(xmlr.hasText() && xmlr.getEventType() != xmlr.COMMENT){
			printLeader();
            printEventType(xmlr.getEventType());
			System.out.println("\t Character content: " + xmlr.getText());
			printTrailer();
        }
    }
    
    private static void printPIData(XMLStreamReader xmlr){
        if (xmlr.getEventType() == XMLEvent.PROCESSING_INSTRUCTION){
			printEventType(xmlr.getEventType());
            System.out.print("\t PI target/data: " + xmlr.getPITarget() + " " + xmlr.getPIData() + "?>") ;
        }
    }
    
    private static void printStartElement(XMLStreamReader xmlr){
        if(xmlr.isStartElement()){
			printLeader();
			printEventType(xmlr.getEventType());
            System.out.println("\t Element name: " + xmlr.getName().toString());
			printTrailer();
			// printAttributes(xmlr);
        }
    }
    
    private static void printEndElement(XMLStreamReader xmlr){
        if(xmlr.isEndElement()){
			printLeader();
			printEventType(xmlr.getEventType());
            System.out.println("\t Element name: " + xmlr.getName().toString());
			printTrailer();
        }
    }
    
    private static void printAttributes(XMLStreamReader xmlr){
        int count = xmlr.getAttributeCount() ;
        if(count > 0){
			System.out.print("\t Attributes: ");
			System.out.print("\t\t ");
            for(int i = 0 ; i < count ; i++) {
                System.out.print(xmlr.getAttributeName(i).toString());
                System.out.print("=");
                System.out.print("\"");
                System.out.print(xmlr.getAttributeValue(i));
                System.out.print("\"");
            }            
        }
        
        count = xmlr.getNamespaceCount();
        if(count > 0){
			System.out.print("\t Namespaces: ");
			System.out.print("\t\t ");
            for(int i = 0 ; i < count ; i++) {
                System.out.print(" ");
                System.out.print("xmlns");
                if(xmlr.getNamespacePrefix(i) != null ){
                    System.out.print(":" + xmlr.getNamespacePrefix(i));
                }                
                System.out.print("=");
                System.out.print("\"");
                System.out.print(xmlr.getNamespaceURI(i));
                System.out.print("\"");
            }            
        }
    }
	
	private static void printLeader() {
		System.out.println("");
	}
	
	private static void printTrailer() {
		System.out.println("");
	}
	
	public static boolean getContinue() {
		System.out.print("Enter Y if you want to continue the parse : ");
		boolean continueParse = false;
		try {
			BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
			String line = bi.readLine();
			if (line.compareToIgnoreCase("Y") == 0) {
				continueParse = true;
			}
		}
		catch (Exception e) {
		}
		return continueParse;
	}
}

