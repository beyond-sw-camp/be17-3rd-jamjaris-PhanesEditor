package org.example.coding_convention.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.example.coding_convention.common.model.BaseResponseStatus.SUCCESS;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T results;

    public static <T> BaseResponse<T> success(T results) {
        return new BaseResponse<>(SUCCESS.isSuccess(), SUCCESS.getMessage(), results);
    }

    public static <T> BaseResponse<T> error(BaseResponseStatus status) {
        return new BaseResponse<>(status.isSuccess(), status.getMessage(), null);
    }

    public static <T> BaseResponse<T> error(BaseResponseStatus status, T results) {
        return new BaseResponse<>(status.isSuccess(), status.getMessage(), results);
    }
}

