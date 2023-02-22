package common;

import lombok.Data;

import java.util.List;

@Data
public class TableResultResponse<T> extends BaseResponse {

    PaginationResult<T> data;

    public TableResultResponse(PaginationResult<T> data) {
        super();
        this.data = data;
    }

    public TableResultResponse(int total, List<T> rows) {
        this.data = new PaginationResult<T>(total, rows);
    }

    public TableResultResponse() {
        super();
        this.data = new PaginationResult<T>();
    }
}
