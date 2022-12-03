package View;

public class simulationView {
    public void printSimulationDetails(float humidity, float temperature, float soilFertility,float waterAmount,int people,float intelligence,int evilness,float food,int wepAmount,float wepDes,int shark, int rat,int year,boolean tsunamiHappened, boolean earthquakeHappened, boolean tsunamiCausedEarthquake){
        System.out.print("\033[H\033[2J");
        System.out.println("Year:"+year);
        if (tsunamiHappened)
            System.out.println("A tsunami took place!"); 
        if (earthquakeHappened)
            System.out.println("An earthquake took place!");
        if (tsunamiCausedEarthquake)
            System.out.println("The earthquake caused a tsunami!");
        System.out.println("World humidity="+humidity+"%");
        System.out.println("World temperature="+temperature+"C");
        System.out.println("Soil fertility="+soilFertility+"%");
        System.out.println("Water amount="+waterAmount+"%");
        System.out.println("Total people:"+people);
        System.out.println("People intelligence:"+intelligence);
        System.out.println("People evilness:"+evilness);
        System.out.println("Food produced:"+food+"T");
        System.out.println("Weapons produced:"+wepAmount);
        System.out.println("Weapons destruction level:"+wepDes);
        System.out.println("Total sharks:"+shark);
        System.out.println("Total rats:"+rat);
    }
}
