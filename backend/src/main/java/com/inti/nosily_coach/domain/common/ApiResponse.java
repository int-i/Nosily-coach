package com.inti.nosily_coach.domain.common;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    public static final ApiResponse<String> OK = success("OK");
    
    private String resultCode;
    
    private String message;
    
    private T data;
    
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("", "", data);
    }
    
    public static <T> ApiResponse<T> error(Exception exception) {
        return new ApiResponse<>(exception.getMessage(), exception.getMessage(), null); // 손봐야함
    }
}
