package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;

/**
 * Created by Caitlin on 3/19/2017.
 */
public class EasyModel extends BattleshipModel {
    //changed or added methods or variables for easy mode are put here
    private int nextShotAcross;
    private int nextShotDown;

    public void  shootAtPlayer() {
        // hard coded firing starts at (1,1) and moves across the row, then to the next column
        Coordinate coor = new Coordinate(nextShotAcross,nextShotDown);
        playerShot(coor);
        nextShotAcross = nextShotAcross + 1;
        if (nextShotAcross > 10){
            nextShotAcross = nextShotAcross % 10;
            nextShotDown = (nextShotDown %10) + 1;
        }
    }

    public EasyModel() {
        playerHits = new ArrayList<>();
        playerMisses= new ArrayList<>();
        computerHits = new ArrayList<>();
        computerMisses= new ArrayList<>();
        nextShotAcross = 1;
        nextShotDown = 1;
    }
}

