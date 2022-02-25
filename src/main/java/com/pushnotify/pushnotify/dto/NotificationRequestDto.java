package com.pushnotify.pushnotify.dto;

import java.util.List;

//@Data
public class NotificationRequestDto {
    private String domain;
    private String text;
    private String vmsCameraId;
    private String updatedAt;
    private String level;
    private String duration;
    private String type;
    private String detected;
    private String id;
    private String createdAt;
    private List<String> user;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVmsCameraId() {
        return vmsCameraId;
    }

    public void setVmsCameraId(String vmsCameraId) {
        this.vmsCameraId = vmsCameraId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetected() {
        return detected;
    }

    public void setDetected(String detected) {
        this.detected = detected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getUser() {
        return user;
    }

    public void setUser(List<String> user) {
        this.user = user;
    }


}
