package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Caitlin on 3/19/2017.
 */
class EasyModelTest {
    @Test
    void shootAtPlayer() {
        BattleshipModel model = new EasyModel();
        model.placeShip("Aircraftcarrier","1","5","horizontal");
        model.placeShip("Battleship","2","4","horizontal");
        model.placeShip("Cruiser","3","3","horizontal");
        model.placeShip("Destroyer","4","2","horizontal");
        model.placeShip("Submarine","5","1","horizontal");


        assertEquals(true, model.playerHits.isEmpty());
        assertEquals(true, model.playerMisses.isEmpty());

        model.shootAtPlayer();
        assertEquals(1, model.playerMisses.get(0).getAcross());
        assertEquals(1, model.playerMisses.get(0).getDown());

        model.shootAtPlayer();
        assertEquals(2, model.playerMisses.get(1).getAcross());
        assertEquals(1, model.playerMisses.get(1).getDown());

        model.shootAtPlayer();
        assertEquals(3, model.playerMisses.get(2).getAcross());
        assertEquals(1, model.playerMisses.get(2).getDown());

        model.shootAtPlayer();
        assertEquals(4, model.playerMisses.get(3).getAcross());
        assertEquals(1, model.playerMisses.get(3).getDown());

        model.shootAtPlayer();
        assertEquals(5, model.playerHits.get(0).getAcross());
        assertEquals(1, model.playerHits.get(0).getDown());


    }

}