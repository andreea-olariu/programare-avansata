package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class SharedMemory {
    private List<Token> tokens = new CopyOnWriteArrayList<>();

    public SharedMemory() {
        for(int i = 0; i < 100; i++) {
            tokens.add(new Token(i));
        }
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            int index = random.nextInt(0, tokens.size());
            extracted.add(tokens.get(index));
        }
        return extracted;
    }
}