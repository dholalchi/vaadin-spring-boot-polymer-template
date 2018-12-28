package de.holalchi.javapolymertemplate.ui.model;

public class PanelMetaData {
    private final String link;
    private final String icon;
    private final String title;

    public PanelMetaData(String link, String icon, String title) {
        this.link = link;
        this.icon = icon;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

}
