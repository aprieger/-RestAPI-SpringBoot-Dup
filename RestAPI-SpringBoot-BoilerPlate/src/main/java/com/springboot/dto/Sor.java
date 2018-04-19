package com.aftt.dto;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sors")
public class Sor {

    @Id
    public String id;
    
    public String sorName;
    public List<MetaPlatform> platforms;
    
	public Sor() {}
	public Sor(String id, String sorName, List<MetaPlatform> platforms) {
		this.id = id;
		this.sorName = sorName;
		this.platforms = platforms;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlatformName() {
		return sorName;
	}
	public void setPlatformName(String sorName) {
		this.sorName = sorName;
	}
	public List<MetaPlatform> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<MetaPlatform> platforms) {
		this.platforms = platforms;
	}
	@Override
	public String toString() {
		return "id=" + id + ", sorName=" + sorName + ", platforms=" + platforms;
	}
}