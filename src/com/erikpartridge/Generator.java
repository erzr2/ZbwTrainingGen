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
        while(a.hasParking() && count < 45){
            Aircraft acf = Boston.makePlane(difficulty, a);
            if(acf != null){
                System.out.println("here");
                out.write(acf.getCallsign() + ":" + acf.getType() + ":" + acf.getEngine() + ":" + 
                        acf.getRules() + ":" + acf.getDep() + ":" + acf.getArr() + ":" + acf.getCruise() + ":"
                        + acf.getRoute() + ":" + acf.getRemarks() + ":" + byteToString(acf.getSquawk()) + ":"
                        + "S:" + acf.getAltitude() + ":"+ acf.getAltitude() + ":" + acf.getSpeed() + ":" +
                        acf.getHeading() + "\n");
            }
        }
        out.close();
    }
    
    public String byteToString(Byte[] in){
        String res = "";
        for(Byte b: in){
            res += b.toString();
        }
        return res;
    }
}
