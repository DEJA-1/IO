package domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderEntity {
    public Integer transactionId;
    public String type;
    public LocalDate date;
    public Map<Integer, Integer> location;
    public List<Map<Integer, Integer>> locationList;

    public OrderEntity(Integer transactionId, String type, LocalDate date, Map<Integer, Integer> location) {
        this.transactionId = transactionId;
        this.type = type;
        this.date = date;
        this.location = location;
    }
}
