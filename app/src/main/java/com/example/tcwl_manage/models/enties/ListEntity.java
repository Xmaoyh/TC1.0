package com.example.tcwl_manage.models.enties;

/**
 * Created by MAOYH on 2016/3/4.
 */
public class ListEntity {
    //Í·Ïñ 
    public int icon;
    public String title;
    public String content;

    public ListEntity(int icon, String content, String title) {
        this.icon = icon;
        this.content = content;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
