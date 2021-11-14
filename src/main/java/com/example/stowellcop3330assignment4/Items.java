package com.example.stowellcop3330assignment4;

import java.time.LocalDate;

public class Items {
    int id;
    String Description;
    LocalDate Duedate;
    String Status;

    public Items(int id, String Description, LocalDate DueDate, String Status)
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
