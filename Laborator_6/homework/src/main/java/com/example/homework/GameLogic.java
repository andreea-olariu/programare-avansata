package com.example.homework;

import java.io.Serializable;
import java.util.List;

public class GameLogic implements Serializable {

    public static String showWinner(List<GameLine> blue, List<GameLine> red) {
        for(int i = 0; i < blue.size() - 2; i++) {
            for(int j = i + 1; j < blue.size() - 1; j++) {
                for(int k = j + 1; k < blue.size(); k++) {
                    if(blue.get(i).commonDot(blue.get(j)) && blue.get(j).commonDot(blue.get(k)) && blue.get(i).commonDot(blue.get(k))) {
                        return "Blue";
                    }
                }
            }
        }

        for(int i = 0; i < red.size() - 2; i++) {
            for(int j = i + 1; j < red.size() - 1; j++) {
                for(int k = j + 1; k < red.size(); k++) {
                    if(red.get(i).commonDot(red.get(j)) && red.get(j).commonDot(red.get(k)) && red.get(i).commonDot(red.get(k))) {
                        return "Red";
                    }
                }
            }
        }
        return "Remiza";
    }

}
