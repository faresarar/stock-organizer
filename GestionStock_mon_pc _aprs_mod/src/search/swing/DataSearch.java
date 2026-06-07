package search.swing;

import model.Produit;

public class DataSearch {

    public Produit getText() {
        return text;
    }

    public void setText(Produit text) {
        this.text = text;
    }

    public boolean isStory() {
        return story;
    }

    public void setStory(boolean story) {
        this.story = story;
    }

    public DataSearch(Produit text, boolean story) {
        this.text = text;
        this.story = story;
    }

    public DataSearch() {
    }

    private Produit text;
    private boolean story;
}
