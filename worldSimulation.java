import Model.*;
import Controller.simulationController;
import View.simulationView;

public class worldSimulation {
    public static void main(String[] args) {
        int f=1;
        simulationModel model = new simulationModel();
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
