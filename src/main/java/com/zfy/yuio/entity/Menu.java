package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:菜单实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:09
*/
public class Menu {
    @JsonProperty("id")
    private String menuId;
    @JsonProperty("name")
    private String menuName;
    @JsonProperty("mark")
    private String menuMark;
    @JsonProperty("url")
    private String menuUrl;
    @JsonProperty("icon")
    private String menuIcon;
    @JsonProperty("description")
    private String menuDescription;
    @JsonProperty("status")
    private int menuStatus;
    @JsonProperty("create_time")
    private LocalDateTime menuCreateTime;
    @JsonProperty("pid")
    private String menuPid;
    @JsonProperty("level")
    private int menuLevel;
    @JsonProperty("type")
    private int menuType;

    private List<Menu> children;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuMark() {
        return menuMark;
    }

    public void setMenuMark(String menuMark) {
        this.menuMark = menuMark;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public LocalDateTime getMenuCreateTime() {
        return menuCreateTime;
    }

    public void setMenuCreateTime(LocalDateTime menuCreateTime) {
        this.menuCreateTime = menuCreateTime;
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid;
    }

    public int getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(int menuStatus) {
        this.menuStatus = menuStatus;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
