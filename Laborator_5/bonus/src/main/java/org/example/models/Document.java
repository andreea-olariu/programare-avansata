package org.example.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String path;
    private int id;
    private String name;
    private Map<String, String> tags;

    public Document() {
        this.tags = new HashMap<>();
    }
    public Document(String path, int id, String name) {
        this.path = path;
        this.id = id;
        this.name = name;
        this.tags = new HashMap<>();
    }

    public Document(String path, int id, String name, Map<String, String> tags) {
        this.path = path;
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public void addTag(String key, String value) {
        this.tags.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Documentul cu numele " + name);
        if(this.tags.size() != 0) {
            result.append(" are informatiile ");
        }
        for(var key : this.tags.keySet()) {
            result.append(key + ": " + this.tags.get(key) + ", ");
        }
        result.append("\n");
        return result.toString();
    }
}
