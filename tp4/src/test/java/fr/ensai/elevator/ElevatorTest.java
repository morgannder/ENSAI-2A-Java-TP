package fr.ensai.elevator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

class ElevatorTest {

    /**
     * La méthode est compliquée à tester car on n'a pas de fonctionnalité permettant de 
     * générer des ascenseurs avec des gens à l'intérieur.
     * On va donc créer cette méthode afin de créer des ascenseurs déjà remplis pour pouvoir tester la méthode isFull.
     */

    @Test
    void isFull_isNotFull() {

        // GIVEN
        int capacity = 5;
        Elevator elevator = new Elevator(1, 0, capacity); 
        
        // WHEN 
        elevator.addPassengersToElevator(3); 

        // THEN
        assertFalse(elevator.isFull());
    }
    
    @Test
    void isFull_isReallyFull() {

        // GIVEN
        int capacity = 5;
        Elevator elevator = new Elevator(1, 0, capacity); 
        
        // WHEN 
        elevator.addPassengersToElevator(5); 

        // THEN
        assertTrue(elevator.isFull());
    }

    @Test
    void Elevator_addDestination() {
                
        // GIVEN
        Elevator elevator = new Elevator(1, 0, 5);
        assertEquals(0, elevator.getDestinationQueueSize()); 

        // WHEN 
        elevator.addDestination(3);
        elevator.addDestination(5);

        // THEN
        assertTrue(elevator.containDestination(3));
        assertTrue(elevator.containDestination(5));
    }
}