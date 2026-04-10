package fr.ensai.elevator;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrazyElevator extends Elevator {

    private static final Logger logger = LogManager.getLogger(CrazyElevator.class);
    private Random random;

    public CrazyElevator(int id, int startFloor, int capacity) {
        super(id, startFloor, capacity);
        this.random = new Random();
    }

    /**
     * Lorsqu'il se déplace, le crazy elevator peut (avec 1 chance sur 3) :
     * rester sur place, sauter la prochaine destination ou se comporter normalement
     */
    @Override
    public void move() {
        if (this.destinationQueue.isEmpty()) {
            return;
        }

        int action = random.nextInt(3);

        if (action == 0) {
            // le CrazyElevator Ne bouge pas
            logger.warn("The CrazyElevator (number {}) decides to stay at Floor{}!", this.getId(), this.currentFloor);
            
        } else if (action == 1) {
            // il saute la prochaine destination
            if (this.destinationQueue.size() >= 2) {
                int skippedFloor = this.destinationQueue.removeFirst(); 
                this.currentFloor = this.destinationQueue.removeFirst(); 
                logger.warn(" The CrazyElevator (number {}) ignores Floor number {} and goes straight to the Floor number {}!", 
                            this.getId(), skippedFloor, this.currentFloor);
            } else {
                // S'il n'y avait qu'une seule destination, il l'efface et reste sur place
                int skippedFloor = this.destinationQueue.removeFirst();
                logger.warn("The CrazyElevator (number {}) erases its only destination ({}) and doesnt move.", 
                            this.getId(), skippedFloor);
            }
            
        } else if (action == 2) {
            // il agit normalement
            logger.warn("The CrazyElevator (number {}) acts normally!", this.getId());
            super.move();
        }
    }

    /**
     * Le crazy elevator peut (avec une chance de 1/2):
     * - Laisser les passagers descendre
     * - NE PAS les laisser descendre
     */
    @Override
    public int unloadPassengers(Floor floor) {
        
        // 50% de chance (0 ou 1)
        if (random.nextInt(2) == 0) {
            logger.warn("The CrazyElevator (number {}) doesnt let its passengers go off to the Floor number {}!", 
                        this.getId(), floor.getNumber());
            // Il ne décharge personne, donc on renvoie 0
            return 0;
        } else {
            // Sinon, il se comporte normalement
            logger.warn("The CrazyElevator (number {}) lets its passengers go off like it's supposed to..", this.getId());
            return super.unloadPassengers(floor);
        }
    }


    /**
     * Si le crazy elevator est plein, il envoie tout le monde dans une autre dimension
     */
    @Override
    public void loadPassengers(Floor floor) {
        
        super.loadPassengers(floor); 

        if (this.isFull()) {
            logger.warn("The CrazyElevator (number {}) is full ! The {} passengers are sent into another dimension!", 
                        this.getId(), this.passengers.size());
            
            this.passengers.clear(); 
            
        }
    }
}