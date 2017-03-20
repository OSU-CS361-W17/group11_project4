package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Garrett on 3/19/2017.
 */
class HardModelTest {
    @Test
    void shootAtPlayer(){
        HardModel model = new HardModel();
        model.placeShip("Aircraftcarrier","1","5","horizontal");
        model.placeShip("Battleship","2","4","horizontal");
        model.placeShip("Clipper","3","3","horizontal");
        model.placeShip("Dinghy","4","2","horizontal");
        model.placeShip("Submarine","5","1","horizontal");

        assertEquals(true, model.isLegal(10, 10));

        model.playerShot(new Coordinate(9,9));
        assertEquals(true, model.playerHits.isEmpty());

        model.playerShot(new Coordinate(1,5));
        assertEquals(1, model.playerHits.get(0).getAcross());
        assertEquals(5, model.playerHits.get(0).getDown());

        model.playerShot(new Coordinate(2,4));
        assertEquals(2, model.playerHits.get(1).getAcross());
        assertEquals(4, model.playerHits.get(1).getDown());

        model.playerShot(new Coordinate(3,3));
        assertEquals(3, model.playerHits.get(2).getAcross());
        assertEquals(3, model.playerHits.get(2).getDown());

        model.playerShot(new Coordinate(4,2));
        assertEquals(4, model.playerHits.get(3).getAcross());
        assertEquals(2, model.playerHits.get(3).getDown());

        model.playerShot(new Coordinate(5,1));
        assertEquals(5, model.playerHits.get(4).getAcross());
        assertEquals(1, model.playerHits.get(4).getDown());

    }
}