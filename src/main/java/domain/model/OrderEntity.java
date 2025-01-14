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
    public Integer count;

    public OrderEntity(Integer transactionId, String type, LocalDate date, Map<Integer, Integer> location, Integer count) {
        this.transactionId = transactionId;
        this.type = type;
        this.date = date;
        this.location = location;
        this.count = count;
    }
}
