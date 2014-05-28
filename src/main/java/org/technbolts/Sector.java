package org.technbolts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sector {

    private List<Document> documents = new ArrayList<Document>();
    private boolean won;
    private final Block[][] blocks;

    public Sector() {
        this(0, 0);
    }

    public Sector(int width, int height) {
        blocks = new Block[width][height];
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                blocks[x][y] = new Block();
            }
        }
    }

    public void declareDocument(Document document) {
        documents.add(document);
    }

    public void hackDocument() {
        Optional<Document> first = documents.stream().filter(doc -> !doc.isHacked()).findFirst();
        if (first.isPresent()) {
            first.get().setHacked(true);
        } else {
            throw new ProgramExecutionError("No more document to hack");
        }
    }

    public boolean isWon() {
        return documents.stream().allMatch(doc -> doc.isHacked());
    }

    public Block getBlock(int x, int y) {
        return blocks[x][y];
    }

    public Block getBlock(Location location) {
        return getBlock(location.getX(), location.getY());
    }

    public boolean isValidLocation(Location location) {
        boolean xInBounds = location.getX() >= 0 && location.getX() < blocks.length;
        boolean yInBounds = location.getY() >= 0 && location.getY() < blocks[0].length; // FIXME: assumes square sector; or heuristic that assumes the first column is the longest one
        return xInBounds && yInBounds && getBlock(location) != null;
    }
}
