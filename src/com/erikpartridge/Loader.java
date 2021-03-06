/**
This code is provided as-is without any warranty
This source code & its compiled program are released under the Apache 2.0 license
**/
package com.erikpartridge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Loader {
    
    public static File config;
    
    public static HashMap<String, URL> resources = new HashMap<>();
    
    public static HashMap<String, List<String>> alts = new HashMap<>();
            
    public static void load(){
        configure();
        try {
            loadAlternatives();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Airport a = new Airport(resources.get("kpwm_parking.txt").openStream(), "kpwm");
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        in.close();
    }
    
    public static void loadAlternatives() throws URISyntaxException{
        URL url = resources.get("kpwm_alternatives.txt");
        InputStream input = null;
        try {
            input = url.openStream();
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner s = null;
        s = new Scanner(input);
        int count = 0;
        while(s.hasNextLine()){
            String line = s.nextLine();
            if(count > 0){
                String[] data = line.split(":");
                alts.put(data[0], new ArrayList<>(Arrays.asList(data)));
            }
            count++;
        }
        s.close();
    }
}
