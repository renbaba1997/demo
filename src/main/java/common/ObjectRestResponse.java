package common;

import lombok.Data;

@Data
public class ObjectRestResponse<T> extends BaseResponse{

    T data;

    public ObjectRestResponse(T data) {
        super();
        this.data = data;
    }

    public ObjectRestResponse(String code, String message) { super(code, message);}

    public ObjectRestResponse() { super(); }
}
