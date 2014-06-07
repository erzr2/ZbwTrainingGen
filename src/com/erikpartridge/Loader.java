/**
This code is provided as-is without any warranty
This source code & its compiled program are released under the Apache 2.0 license
**/
package com.erikpartridge;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Loader {
    
    public static File config;
    
    public static HashMap<String, URL> resources = new HashMap<>();
    
    public static void load(){
        configure();
    }
    
    public static void configure(){
        Scanner in = null;
        try {
            in = new Scanner(config);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(in.hasNextLine()){
            String temp = in.nextLine();
            
            String[] dat = temp.split(";");
                        
            URL url = null;
            try {
                url = new URL(dat[1]);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
            }
            resources.put(dat[0], url);
        }
    }
}
