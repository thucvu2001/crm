package cybersoft.javabe18.crm.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskModel {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private int userId;
    private int jobId;
    private int statusId;

    public TaskModel(int id, String name, LocalDate startDate, LocalDate endDate, int userId, int jobId, int statusId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
        this.jobId = jobId;
        this.statusId = statusId;
    }
}
