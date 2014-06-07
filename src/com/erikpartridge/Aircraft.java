/** (c) Erik Malmstrom-Partridge 2014
This code is provided as-is without any warranty
This source code and its compiled program are released under the Apache 2.0 license
* 
**/
package com.erikpartridge;



public class Aircraft {

    private String callsign;
    
    private String type;
    
    private String engine;
    
    private char rules;
    
    private char[] dep;
    
    private char[] arr;
    
    private int cruise;
    
    private String route;
    
    private String remarks;
    
    private byte[] squawk;
    
    private char sMode;
    
    private double lat;
    
    private double lon;
    
    private int altitude;
    
    private int speed;
    
    private int heading;

    
    public Aircraft(){
        
    }

    public Aircraft(String callsign, String type, String engine, char rules, char[] dep, char[] arr, int cruise, String route, String remarks, byte[] squawk, char sMode, double lat, double lon, int altitude, int speed, int heading) {
        this.callsign = callsign;
        this.type = type;
        this.engine = engine;
        this.rules = rules;
        this.dep = dep;
        this.arr = arr;
        this.cruise = cruise;
        this.route = route;
        this.remarks = remarks;
        this.squawk = squawk;
        this.sMode = sMode;
        this.lat = lat;
        this.lon = lon;
        this.altitude = altitude;
        this.speed = speed;
        this.heading = heading;
    }
    
    /**
     * @return the callsign
     */
    public String getCallsign() {
        return callsign;
    }

    /**
     * @param callsign the callsign to set
     */
    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return engine class
     */
    public String getEngine() {
        return engine;
    }

    /**
     * @param engine the engine type
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

    /**
     * @return the flight rules
     */
    public char getRules() {
        return rules;
    }

    /**
     * @param rules the flight rules
     */
    public void setRules(char rules) {
        this.rules = rules;
    }

    /**
     * @return the departure field
     */
    public char[] getDep() {
        return dep;
    }

    /**
     * @param dep the departure field
     */
    public void setDep(char[] dep) {
        this.dep = dep;
    }

    /**
     * @return the arrival field
     */
    public char[] getArr() {
        return arr;
    }

    /**
     * @param arr the arrival field
     */
    public void setArr(char[] arr) {
        this.arr = arr;
    }

    /**
     * @return the cruise alitude
     */
    public int getCruise() {
        return cruise;
    }

    /**
     * @param cruise the cruise altitude
     */
    public void setCruise(int cruise) {
        this.cruise = cruise;
    }

    /**
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * @param route the route
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the squawk code
     */
    public byte[] getSquawk() {
        return squawk;
    }

    /**
     * @param squawk the squawk code
     */
    public void setSquawk(byte[] squawk) {
        this.squawk = squawk;
    }

    /**
     * @return the squawk mode
     */
    public char getsMode() {
        return sMode;
    }

    /**
     * @param sMode the squawk mode
     */
    public void setsMode(char sMode) {
        this.sMode = sMode;
    }

    /**
     * @return the latitude of the aircraft
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the latitude of the aircraft
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the longitude of the aircraft
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the longitude of the aircraft
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * @return the altitude of the aircraft
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * @param altitude set the altitude of the aircraft
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    /**
     * @return the speed of the aircraft
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed of the aircraft
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the current heading of the aircraft
     */
    public int getHeading() {
        return heading;
    }

    /**
     * @param heading the heading to set
     */
    public void setHeading(int heading) {
        this.heading = heading;
    }
    
}
