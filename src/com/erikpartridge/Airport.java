/** (c) Erik Malmstrom-Partridge 2014
This code is provided as-is without any warranty
This source code or its compiled program may not be redistributed in any way
**/
package com.erikpartridge;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Airport {

    private HashMap<String, ArrayList<Point2D.Double>> parking;
    
    
    public Airport(File f){
        try {
            loadParking(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Airport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadParking(File f) throws FileNotFoundException{
        Scanner in = new Scanner(f);
        parking.put("A", new ArrayList<>());
        parking.put("G", new ArrayList<>());
        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] split = line.split(":");
            Point2D.Double pt = new Point2D.Double(Double.parseDouble(split[1]), Double.parseDouble(split[2]));
            parking.get(split[0]).add(pt);
        }
    }
    
   
}
