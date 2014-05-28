package org.technbolts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sector {

    List<Document> documents = new ArrayList<Document>();
    private boolean won;


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
}
