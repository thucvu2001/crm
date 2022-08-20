package cybersoft.javabe18.crm.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobModel {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public JobModel(int id, String name, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
