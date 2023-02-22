package common;

import lombok.Data;

import java.util.List;

@Data
public class PaginationResult<T> {

    List<T> data;

    int total;

    public PaginationResult() { super(); }

    public PaginationResult(int total, List<T> data) {
        super();
        this.total = total;
        this.data = data;
    }
}
