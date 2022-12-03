package Model;

public class simulationModel {
    private Rats hamster;
    private Humans people;
    private Weapons weapon;
    private Sharks shark;
    private Tsunami tsunami;
    private Earthquake earthquake;
    private int year;
    private boolean tsunamiHappened,earthquakeHappened,tsunamiCausedEarthquake;

    public simulationModel(){
        year=0;
        World.humidity=50;
        World.temperature=5;
        Ground.soilFertility=55;
        Ground.waterAmount=25;
        people = new Humans();
        shark = new Sharks();
        hamster = new Rats();
        weapon = new Weapons();
        tsunami = new Tsunami();
        earthquake = new Earthquake();
        people.setAttributes(0, 100, 60, -20, 500, 20,10);
        shark.setAttributes(30, 100, 40, -30, 20, 80, 10);
        hamster.setAttributes(40, 70, 31, 20, 20, 5, 1);
        tsunami.setDestructionLevel(50); tsunami.setDuration(5);
        earthquake.setDestructionLevel(50); earthquake.setDuration(5);
    }

    public void startSimulation(){
        tsunamiHappened=false; earthquakeHappened=false; tsunamiCausedEarthquake=false;
        hamster.drown(); hamster.environmentAffects(); hamster.reproduce(); hamster.wars(); hamster.destroyCrops(); 
        people.affectEnvironment(); people.drown(); people.makeSoilFertile(); people.becomeSmarter();
        weapon.produceWeapons(people.getAmount());
        if (Ground.soilFertility>0)
            people.reproduce();
            else
            people.reproduce(100); 
        int weaponsLost=people.wars(weapon.getWeaponAmount(),weapon.getDestructionLevel());  people.produceFood(); weapon.reduceWeapons(weaponsLost);
        shark.drown(); shark.environmentAffects(); shark.reproduce(); shark.wars(); 
        year+=1;
        people.environmentAffects();
        if (people.getIntelligence()>=1000)
            weapon.setDestructionLevel( (float) ((people.getIntelligence()*people.getAmount()*0.0001)/(people.getIntelligence()/1000)));
        else weapon.setDestructionLevel( (float) (people.getIntelligence()*people.getAmount()*0.0001));
        if (tsunami.probabilityOfCalamity()==1){
            tsunami.modifyWaterAmount();
            tsunamiHappened=true;           //tsunami
        } else { if (earthquake.probabilityOfCalamity()==1) {
                earthquake.modifySoilandTemp();
                earthquakeHappened=true;   //earthquake
                if (tsunami.probabilityOfCalamity(8)==1){
                    tsunami.modifyWaterAmount();
                    tsunamiCausedEarthquake=true;  //tsunami caused by earthquake
                }
            }
        }
    }

    public float getHumidity(){
        return World.humidity;
    }

    public float getTemperature(){
        return World.temperature;
    }

    public float getSoilFertility(){
        return Ground.soilFertility;
    }

    public float getWaterAmount(){
        return Ground.waterAmount;
    }

    public int getPeopleAmount(){
        return people.getAmount();
    }

    public float getPeopleIntelligence(){
        return people.getIntelligence();
    }

    public int getPeopleEvilness(){
        return people.getEvilness();
    }

    public float getFoodProduced(){
        return people.getFoodProduced();
    }

    public int getWeaponAmount(){
        return weapon.getWeaponAmount();
    }

    public float getWeaponDestruction(){
        return weapon.getDestructionLevel();
    }

    public int getSharkAmount(){
        return shark.getAmount();
    }

    public int getRatAmount(){
        return hamster.getAmount();
    }

    public int getYear(){
        return year;
    }

    public boolean tsunamiHapp(){
        return tsunamiHappened;
    }

    public boolean EarthquakeHapp(){
        return earthquakeHappened;
    }

    public boolean tsunamiCause(){
        return tsunamiCausedEarthquake;
    }
}
