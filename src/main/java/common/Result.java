package common;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result<T> implements Serializable {

    /**
     * 响应码
     */
    private String Code;

    /**
     * 承载数据
     */
    private T data;

    /**
     * 返回消息
     */
    private String msg;

    private Result(String code, T data, String msg) {
        this.Code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> Result<T> success(String code,T data,String msg) {
        return new Result<>(code, data, data == null ? "消息为空" : msg);
    }

    public static<T> Result<T> success(T data, String msg) {
        return success("200", data, msg);
    }
}
