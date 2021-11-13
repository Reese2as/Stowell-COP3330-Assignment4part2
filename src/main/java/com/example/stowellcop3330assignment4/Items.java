package com.example.stowellcop3330assignment4;

import java.time.LocalDate;

public class Items {
    int id;
    String Description;
    LocalDate Duedate;
    Boolean Status;

    public Items(int id, String Description, LocalDate DueDate, Boolean Status)
    {
        this.id = id;
        this.Description = Description;
        this.Duedate = DueDate;
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public LocalDate getDueDate() {
        return Duedate;
    }

    public void setDuedate(LocalDate DueDate) {
        this.Duedate = DueDate;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }
}
