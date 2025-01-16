package domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderEntity {
    private Integer transactionId;
    private String type;
    private LocalDate date;
    private Map<Integer, Integer> location;
    private Integer count;

    public OrderEntity(Integer transactionId, String type, LocalDate date, Map<Integer, Integer> location, Integer count) {
        this.transactionId = transactionId;
        this.type = type;
        this.date = date;
        this.location = location;
        this.count = count;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public Map<Integer, Integer> getLocation() {
        return location;
    }

    public Integer getCount() {
        return count;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocation(Map<Integer, Integer> location) {
        this.location = location;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
