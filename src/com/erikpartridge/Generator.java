/** (c) Erik Malmstrom-Partridge 2014
This code is provided as-is without any warranty
This source code or its compiled program may not be redistributed in any way
**/
package com.erikpartridge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Generator {

    
    public void writeFile(String path, Airport a, double difficulty){
        File f = new File(path);
        PrintWriter out = null;
        try {
            out = new PrintWriter(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        while(a.hasParking() && count < 100){
            Aircraft acf = Boston.makePlane(difficulty, a);
            if(acf != null){
                out.write(acf.getCallsign() + ":" + acf.getType() + ":" + acf.getEngine() + ":" + 
                        acf.getRules() + ":" + acf.getDep() + ":" + acf.getArr() + ":" + acf.getCruise() + ":"
                        + acf.getRoute() + ":" + acf.getRemarks() + ":" + acf.getSquawk() + ":"
                        + "S:" + acf.getLat() + ":" + acf.getLon() + ":"+ acf.getAltitude() + ":"+ acf.getAltitude() + ":" + acf.getSpeed() + ":" +
                        acf.getHeading() + "\n");
            }
        }
        out.close();
    }
    
}
