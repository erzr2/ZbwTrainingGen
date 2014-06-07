/*
*This code is provided as-is without any warranty
* This code and its compiled program are released under the Apache 2.0 license
*
**/
package com.erikpartridge;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Boston {

    private final Random rand = new Random();
    
    private ArrayList<Aircraft> perfect;
    
    //Makes an aircraft
    //Difficulty between 0-10, 5 = average 1 error per flight plan, 10 = 2, etc.
    public static void makePlane(double difficulty, Airport airport, File perfect){
        
        
    }
    // Creates a perfect airplane from a perfect airplane examples file
    private void loadPerfect(Airport airport){
        URL url = Loader.resources.get(airport.getIcao());
        File ex = null;
        
        try {
            ex = new File(url.toURI());
        } catch (URISyntaxException ex1) {
            Logger.getLogger(Boston.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        Scanner in = null;
        
        try{
            in = new Scanner(ex);
        } catch (FileNotFoundException ex1) {
            Logger.getLogger(Boston.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(!line.contains("\\")){
                String[] data = line.split(":");
                //Make a new plane from each line
                Aircraft a;
                a = new Aircraft(data[0],data[1],data[2],data[3].charAt(0),
                        data[4].toCharArray(), data[5].toCharArray(),Integer.parseInt(data[6]),
                        data[7],"/v/", new Byte[4], 'S',0.0,0.0,0,0,360, data[8].trim());
                perfect.add(a);
            }
        }
    }
    
    //Uses the preferred routes file to generate a perfect aircraft
    private Aircraft makePerfect(){
        return null;
    }
}
