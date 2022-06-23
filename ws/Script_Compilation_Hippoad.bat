@echo off

javac -cp ../class -d ../class ../src/modele/donnee/*.java
javac -cp ../class -d ../class ../src/modele/traitement/*.java

javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml ../src/controller/Loader.java
java --module-path %PATH_TO_FX% --add-modules javafx.controls ../src/controller/Loader
