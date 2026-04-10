package fr.ensai.elevator;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

        // --------------------------------------------------------------------
        // Create Floors, Elevators and Hotel
        // --------------------------------------------------------------------

        final int elevatorCapacity = Config.getInt("hotel.elevator.capacity");
        final int nbSteps = Config.getInt("steps.count");
        final int msBetweenSteps = Config.getInt("steps.delay");
        final int nbFloors = Config.getInt("floors.count");
        final int nbElevators = Config.getInt("elevators.count");

        List<Floor> floors = new ArrayList<>();
        for (int floor = 0 ; floor <= nbFloors; floor++){
        floors.add(new Floor(floor));
        }

        List<Elevator> elevators = new ArrayList<>();
        for (int elevator = 1; elevator <= nbElevators; elevator++){
            elevators.add(new Elevator(elevator, 0, elevatorCapacity));
        }
        elevators.add(new CrazyElevator(nbElevators+1, 0, elevatorCapacity));



        Hotel hotel = new Hotel(floors, elevators);

        // --------------------------------------------------------------------
        // Run simulation
        // --------------------------------------------------------------------

        for (int step = 1; step <= nbSteps; step++) {
            logger.info("\nStep: {}\n--------", step);

            hotel.update();
            hotel.spawnPerson();
            hotel.display(step);
            Thread.sleep(msBetweenSteps);
        }
    }

}