package com.codedifferently.lesson7.aaronsantiago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe {

  private String ownerName;
  private int capacity;
  private List<String> clothes;
  private String purchaseDate;
  private String type;
  private final int id;
  private Map<Integer, String> additionalInfo = new HashMap<>();

  public Wardrobe(String ownerName, int capacity, String purchaseDate, String type, int id) {
    this.ownerName = ownerName;
    this.capacity = capacity;
    this.purchaseDate = purchaseDate;
    this.type = type;
    this.id = id;
    this.clothes = new ArrayList<>();
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public List<String> getClothes() {
    return clothes;
  }

  public String getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(String purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void addAdditionalInfo(int key, String value) {
    additionalInfo.put(key, value);
  }

  public String getAdditionalInfo(int key) {
    return additionalInfo.get(key);
  }

  public void removeAdditionalInfo(int key) {
    additionalInfo.remove(key);
  }

  public void addClothes(String item) throws Exception {
    if (clothes.size() < capacity) {
      clothes.add(item);
    } else {
      throw new Exception("Wardrobe is full! Cannot add more clothes.");
    }
  }

  public void removeClothes(String item) throws Exception {
    if (clothes.contains(item)) {
      clothes.remove(item);
    } else {
      throw new Exception("Item not found in the wardrobe.");
    }
  }

  public void checkClothes() {
    for (int i = 0; i < clothes.size(); i++) {
      String item = clothes.get(i);
      System.out.println(item);
    }
  }

  @Override
  public String toString() {
    return "Owner: "
        + ownerName
        + "\n"
        + "Capacity: "
        + capacity
        + "\n"
        + "Current Clothes: "
        + clothes
        + "\n"
        + "Purchase Date: "
        + purchaseDate
        + "\n"
        + "Type: "
        + type
        + "\n"
        + "ID: "
        + id;
  }
}
