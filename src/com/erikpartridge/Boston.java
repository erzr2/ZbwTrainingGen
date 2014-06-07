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
    
    private static ArrayList<Aircraft> perfect;
    
    //Makes an aircraft
    //Difficulty between 0-10, 5 = average 1 error per flight plan, 10 = 2, etc.
    public static void makePlane(double difficulty, Airport airport, File perfect){
        if(perfect == null){
            loadPerfect(airport);
        }
        double chance = difficulty / 20;
        
    }
    // Creates a perfect airplane from a perfect airplane examples file
    private static void loadPerfect(Airport airport){
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
        in.close();
    }
    
    //Uses the preferred routes file to generate a perfect aircraft
    //TODO
    private Aircraft makePerfect(){
        return null;
    }
    
    private String changeRoute(String init){
        double type = rand.nextDouble();
        if(init.trim().charAt(6) == ' '){
            if(type < .5){
                String temp = init.substring(6);
                ArrayList<String> opts = Loader.alts.get(init.substring(0,6));
                String chosen = opts.get(rand.nextInt(opts.size()));
                return chosen + temp;
            }
            else if(type < .65 && init.length() > 6){
                return init.substring(6);
            }
            else if(type < .7){
                return "DIRECT";
            }
            else if(type < .8){
                if(init.charAt(init.length() - 1) > 47 && init.charAt(init.length() - 1) < 58){
                    return init.substring(0, init.length() - 7);
                }
            } else{
                return init.replaceAll(" ", " DCT ");
            }
        } else{
            if(type < .5){
                return "PWM4 DIRECT" + init;
            }
            else if(type < .65 && init.length() > 6){
                return init.substring(6);
            }
            else if(type < .7){
                return "DIRECT";
            }
            else if(type < .8){
                if(init.charAt(init.length() - 1) > 47 && init.charAt(init.length() - 1) < 58){
                    return init.substring(0, init.length() - 7);
                }
            } else{
                return init.replaceAll(" ", " DCT ");
            }
        }
        return init;
    }
}
