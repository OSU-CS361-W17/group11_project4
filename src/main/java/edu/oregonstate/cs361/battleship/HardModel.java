package edu.oregonstate.cs361.battleship;

import java.util.Random;

public class HardModel extends BattleshipModel{
    public boolean wasHit;

    //changed or added methods or variables for hard mode are put here
    public HardModel() {
        super();

        wasHit = false;
    }

    public void shootAtPlayer() {
        int max = 10;
        int min = 1;
        int row = 0;
        int col = 0;
        Random random = new Random();
        Coordinate coor;

        if(!wasHit) {
            do {
                row = random.nextInt(max - min + 1) + min;
                col = random.nextInt(max - min + 1) + min;
            }while(!isLegal(row, col));
        }
        else{
            Coordinate last = playerHits.get(playerHits.size() - 1);

            do {
                int choice = random.nextInt(4) + 1;

                switch (choice) {
                    case 1:
                        row = last.getDown() - 1;
                        col = last.getAcross();
                        break;
                    case 2:
                        row = last.getDown();
                        col = last.getAcross() + 1;
                        break;
                    case 3:
                        row = last.getDown() + 1;
                        col = last.getAcross();
                        break;
                    case 4:
                        row = last.getDown();
                        col = last.getAcross() - 1;
                        break;
                    default:
                        System.out.println("This should never happen.");
                        break;
                }
            }while(!isLegal(row, col));
        }

        coor = new Coordinate(row, col);
        playerShot(coor);
    }

    public boolean isLegal(int r, int c){
        if(r < 1 || r > 10){
            return false;
        }
        if(c < 1 || c > 10){
            return false;
        }

        Coordinate coor = new Coordinate(r, c);
        if(playerHits.contains(coor) || playerMisses.contains(coor)){
            return false;
        }

        return true;
    }

    void playerShot(Coordinate coor) {
        if(playerMisses.contains(coor)){
            System.out.println("Dupe");
        }

        if(aircraftCarrier.covers(coor)){
            playerHits.add(coor);
            wasHit = true;
        }else if (battleship.covers(coor)){
            playerHits.add(coor);
            wasHit = true;
        }else if (submarine.covers(coor)){
            playerHits.add(coor);
            wasHit = true;
        }else if(clipper.covers(coor)) {
            playerHits.add(coor);
            wasHit = true;
        }else if(dinghy.covers(coor)){
            playerHits.add(coor);
            wasHit = true;
        }
        else {
            playerMisses.add(coor);
            wasHit = false;
        }
    }
}