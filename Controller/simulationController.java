package Controller;

import Model.simulationModel;
import View.simulationView;

public class simulationController {
    private simulationModel model;
    private simulationView view;

    public simulationController(simulationModel model,simulationView view){
        this.model=model;
        this.view=view;
    }

    public void updateView(){
        model.startSimulation();
        view.printSimulationDetails(model.getHumidity(), model.getTemperature(), model.getTemperature(), model.getWaterAmount(), model.getPeopleAmount(), model.getPeopleIntelligence(), model.getPeopleEvilness(), model.getFoodProduced(), model.getWeaponAmount(), model.getWeaponDestruction(), model.getSharkAmount(), model.getRatAmount(),model.getYear(),model.tsunamiHapp(),model.EarthquakeHapp(),model.tsunamiCause());
    }
}
