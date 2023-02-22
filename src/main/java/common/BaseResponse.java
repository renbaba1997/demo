package common;

import lombok.Data;

@Data
public class BaseResponse {

    private String code = "200";

    private String message;

    public BaseResponse(String code, String message){
        this.code = code;
        this.message = message;
    }

    public BaseResponse() {super();}

    public void setResponse(String code, String message){
        this.code = code;
        this.message = message;
    }
}
