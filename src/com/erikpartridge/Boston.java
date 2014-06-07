/*
*This code is provided as-is without any warranty
* This code and its compiled program are released under the Apache 2.0 license
*
**/
package com.erikpartridge;

import java.util.ArrayList;
import java.io.File;


public class Boston {

    private final Random rand = new Random();
    
    private ArrayList<Airplane> perfect;
    
    //Makes an aircraft, false if failed (ie. no parking spaces)
    //Difficulty between 0-10, 5 = average 1 error per flight plan, 10 = 2, etc.
    public static boolean makePlane(double difficulty, Airport airport, File perfect){
        
    }
    // Creates a perfect airplane from a perfect airplane examples file
    public Airplane loadPerfect(File f){
        
    }
    
    //Uses the preferred routes file to generate a perfect aircraft
    Airplane makePerfect(File f){
        
    }
}
