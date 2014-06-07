/*
*This code is provided as-is without any warranty
* This code and its compiled program are released under the Apache 2.0 license
*
**/
package com.erikpartridge;

import java.util.ArrayList;
import java.io.File;
import java.util.Random;


public class Boston {

    private final Random rand = new Random();
    
    private ArrayList<Aircraft> perfect;
    
    //Makes an aircraft
    //Difficulty between 0-10, 5 = average 1 error per flight plan, 10 = 2, etc.
    public static void makePlane(double difficulty, Airport airport, File perfect){
        
        
    }
    // Creates a perfect airplane from a perfect airplane examples file
    public Aircraft loadPerfect(File f){
        
        return null;
    }
    
    //Uses the preferred routes file to generate a perfect aircraft
    public Aircraft makePerfect(File f){
        return null;
    }
}
