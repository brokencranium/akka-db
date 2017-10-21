package com.brokencranium.akka;

/**
 * Created by vicky on 10/21/17.
 */
public class ItemMessage {
    private final Integer itemNumber;
    private final String description;
    private final Integer thawTimeMinutes;
    private final Integer shelfLife;

    public ItemMessage(Integer itemNumber, String description, Integer thawTimeMinutes, Integer shelfLife) {
        this.itemNumber = itemNumber;
        this.description = description;
        this.thawTimeMinutes = thawTimeMinutes;
        this.shelfLife = shelfLife;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public Integer getThawTimeMinutes() {
        return thawTimeMinutes;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }
}
