package com.ghoststore.app.models;

import java.io.Serializable;
import java.util.List;

public class AppModel implements Serializable {
    private String name, developer, version, size, rating, icon, banner, download, description, category;
    private List<String> screenshots;

    public AppModel() {}

    public String getName() { return name; }
    public String getDeveloper() { return developer; }
    public String getVersion() { return version; }
    public String getSize() { return size; }
    public String getRating() { return rating; }
    public String getIcon() { return icon; }
    public String getBanner() { return banner; }
    public String getDownload() { return download; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public List<String> getScreenshots() { return screenshots; }

    public void setName(String name) { this.name = name; }
    public void setDeveloper(String developer) { this.developer = developer; }
    public void setVersion(String version) { this.version = version; }
    public void setSize(String size) { this.size = size; }
    public void setRating(String rating) { this.rating = rating; }
    public void setIcon(String icon) { this.icon = icon; }
    public void setBanner(String banner) { this.banner = banner; }
    public void setDownload(String download) { this.download = download; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setScreenshots(List<String> screenshots) { this.screenshots = screenshots; }
}
