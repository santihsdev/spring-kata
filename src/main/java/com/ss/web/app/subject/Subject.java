package com.ss.web.app.model;

public class Subject {
  private Long code;
  private String title;
  private String description;

  public Subject(Long code, String title, String description) {
    this.code = code;
    this.title = title;
    this.description = description;
  }

  public Long getCode() {
    return code;
  }

  public void setCode(Long code) {
    this.code = code;
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
}
