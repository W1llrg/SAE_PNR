@echo off

javac -cp ../class -d ../class ../src/modele/traitement/*.java
javac -cp ../class -d ../class ../src/modele/ScenarioTraitement.java

java modele/ScenarioTraitement