/**
This code is provided as-is without any warranty
This source code and its compiled program are released under the Apache 2.0 license.
**/
package com.erikpartridge;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.vecmath.Point2d;



public class Airport {

    /* "A" is the key for airline parking spots
     * "G" is the key for General aviation parking spots
     * "C" is the key for cargo parking spots
     * Stores all of those, and if parking is desired, accesses correct ArrayList and gets the coordinates
    */
    private HashMap<String, ArrayList<Point2D.Double>> parking;
    //Name of the airport
    private final String name;
    
    private final Random rand = new Random();
    
    public Airport(File f){
        this.name = "";
        try {
            loadParking(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Airport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* Should be called only in the constructor -- in a method for better error handling
     * Creates the arraylists and puts them with their keys
     * iterates through the parking place file and gets the coordinates
     *
    */
    private void loadParking(File f) throws FileNotFoundException{
        Scanner in = new Scanner(f);
        //Initializing parking
        parking.put("A", new ArrayList<>());
        parking.put("G", new ArrayList<>());
        parking.put("C", new ArrayList<>());
        
        //Going through parking place file
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(!line.substring(0,2).equals("//")){          
                String[] split = line.split(":");
                Point2D.Double pt = new Point2D.Double(Double.parseDouble(split[1]), Double.parseDouble(split[2]));
                parking.get(split[0]).add(pt);
            }
        }
    }
    
    /* Gets a random parking place for an aircraft given its type */
    public Point2D.Double getParkingPlace(String type){
        ArrayList<Point2D.Double> opt = parking.get(type);
        //If there's a bad character log it
        if(opt == null){
            Logger.getLogger(Airport.class.getName()).log(new LogRecord(Level.WARNING, "Invalid type parameter at Airport.getParkingPlace"));
            return null;
        }
        //If we're out of parking log it
        else if(opt.size() < 1){
            Logger.getLogger(Airport.class.getName()).log(new LogRecord(Level.WARNING, "No more parking places of this type available, type:: " + type));
            return null;
        }
        return opt.remove(rand.nextInt(opt.size()));
    }
    
    
   
}
