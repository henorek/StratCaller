package com.example.jarek.stratcaller.data;

import java.io.Serializable;

public class TacticsEntity implements Serializable{

    private int id;
    private String name;
    private String description;
    private String category;
    private String minimap;
    private String level;
    private String side;
    private int difficulty;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMinimap() {
        return minimap;
    }

    public void setMinimap(String minimap) {
        this.minimap = minimap;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TacticsEntity that = (TacticsEntity) o;

        if (difficulty != that.difficulty) return false;
        if (id != that.id) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (minimap != null ? !minimap.equals(that.minimap) : that.minimap != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(side != null ? !side.equals(that.side) : that.side != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (minimap != null ? minimap.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (side != null ? side.hashCode() : 0);
        result = 31 * result + difficulty;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
