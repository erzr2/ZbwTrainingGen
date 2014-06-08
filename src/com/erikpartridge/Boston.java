/*
*This code is provided as-is without any warranty
* This code and its compiled program are released under the Apache 2.0 license
*
**/
package com.erikpartridge;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Boston {

    private final static Random rand = new Random();
    
    private static ArrayList<Aircraft> perfect = new ArrayList<>();
    
    //Makes an aircraft
    //Difficulty between 0-10, 5 = average 1 error per flight plan, 10 = 2, etc.
    public static Aircraft makePlane(double difficulty, Airport airport){
        loadPerfect(airport);
        Aircraft acf = perfect.get(rand.nextInt(perfect.size()));
        double chance = difficulty / 20;
        double score = rand.nextDouble();
        if(score < chance * 1.5){
            acf.setRoute(changeRoute(acf.getRoute()));
        } else if(score < chance * 2){
            acf.setRules(changeRules(acf.getRules()));
        } else if(score < chance * 2.5){
            acf.setCruise(acf.getCruise() + 500);
        } else if(score < chance * 3){
            acf.setCruise(acf.getCruise() + 1000);
        } else if(score < chance * 4){
            acf.setType(acf.getType().substring(0,4));
        }
        acf.setRemarks("/V/");
        acf.setsMode('S');
        String park = acf.getParking();
        
        Point2D.Double parking = airport.getParkingPlace(park);
        if(parking != null){
            acf.setLat(parking.x);
            acf.setLon(parking.y);
            int num = rand.nextInt(10000);
            acf.setCallsign(acf.getCallsign().substring(0,3) + num);
        return acf;
        } else{
            return null;
        }
    }
    // Creates a perfect airplane from a perfect airplane examples file
    private static void loadPerfect(Airport airport){
        URL url = Loader.resources.get(airport.getIcao().toLowerCase() + "_perfect_flights.txt");
        InputStream ex = null;
        try {
            ex = url.openStream();
        } catch (IOException ex1) {
            Logger.getLogger(Boston.class.getName()).log(Level.SEVERE, null, ex1);
        }   
        
        Scanner in = null;
        in = new Scanner(ex);
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(!line.contains("\\")){
                String[] data = line.split(":");
                System.out.println(data);
                //Make a new plane from each line
                Aircraft a;
                a = new Aircraft(data[0],data[1],data[2],data[3].charAt(0),
                        data[4], data[5],Integer.parseInt(data[6]),
                        data[7],"/v/", new Byte[4], 'S',0.0,0.0,74,0,360, data[8].trim());
                perfect.add(a);
            }
        }
        in.close();
            Logger.getLogger(Boston.class.getName()).log(Level.SEVERE, null, "");
    }  
    //Uses the preferred routes file to generate a perfect aircraft
    //TODO
    private Aircraft makePerfect(){
        return null;
    }
    
    private static char changeRules(char init){
        if(init == 'I'){
            return 'V';
        } else{
            return 'I';
        }
    }
    
    private static String changeRoute(String init){
        double type = rand.nextDouble();
        if(init.trim().charAt(6) == ' '){
            if(type < .5){
                String temp = init.substring(6);
                List<String> opts = Loader.alts.get(init.substring(0,6));
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
