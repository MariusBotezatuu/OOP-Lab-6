import Model.*;
import Controller.simulationController;
import View.simulationView;

public class worldSimulation {
    public static void main(String[] args) {
        int f=1,year=0;
        World.humidity=50;
        World.temperature=5;
        Ground.soilFertility=55;
        Ground.waterAmount=25;
        Humans people = new Humans();
        Sharks shark = new Sharks();
        Rats hamster = new Rats();
        Weapons weapon = new Weapons();
        Tsunami tsunami = new Tsunami();
        Earthquake earthquake = new Earthquake();
        people.setAttributes(0, 100, 60, -20, 500, 20,10);
        shark.setAttributes(30, 100, 40, -30, 20, 80, 10);
        hamster.setAttributes(40, 70, 31, 20, 20, 5, 1);
        tsunami.setDestructionLevel(50); tsunami.setDuration(5);
        earthquake.setDestructionLevel(50); earthquake.setDuration(5);
        simulationModel model = new simulationModel(hamster,people,weapon,shark,tsunami,earthquake,year);
        simulationView view = new simulationView();
        simulationController controller = new simulationController(model,view);

        while(f==1){
            controller.updateView();
            wait(1500);
        }
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
