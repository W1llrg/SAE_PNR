package controller;

import java.sql.Date;
import java.sql.Time;

public class Observation {
    
    
   private int id;
   private Date date;
   private Time heure;
   private Double coordX;
   private Double coordY;
   

   public Observation(int id, Date date, Time heure, Double coordX, Double coordY) {
       this.id = id;
       this.date = date;
       this.heure = heure;
       this.coordX = coordX;
       this.coordY = coordY;
   }
}
