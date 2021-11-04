package io.minecraftapps.carmods;

import java.io.Serializable;

public class Mod implements Serializable {

    //private ModType type;

    private String title;
    private String description;

    private String speed;
    private String size;

    private int[] screenIds;

    private int modFileId;
    private String fileExtension;

    public Mod(
            //ModType modType,
            String title,
            String speed,
            String size,
            int[] screenIds,
            int modFileId,
            String fileExtension
    ) {
        //this.type = modType;
        this.title = title;
        this.speed = speed;
        this.size = size;
        this.screenIds = screenIds;
        this.modFileId = modFileId;
        this.fileExtension = fileExtension;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    /*public ModType getType() {
        return type;
    }*/

    public Integer getScreen(int num) {
        //Drawable drawable = FirebaseController.getDrawable()
        return (num < screenIds.length) ? screenIds[num] : null;
    }

    /*public void setType(ModType type) {
        this.type = type;
    }*/

    public int[] getScreenIds() {
        return screenIds;
    }

    public void setScreenIds(int[] screenIds) {
        this.screenIds = screenIds;
    }

    public int getModFileId() {
        return modFileId;
    }

    public void setModFileId(int modFileId) {
        this.modFileId = modFileId;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
