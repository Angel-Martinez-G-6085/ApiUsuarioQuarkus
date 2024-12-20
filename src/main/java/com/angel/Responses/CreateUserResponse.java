package com.angel.Responses;

public class CreateUserResponse extends GlogalResponse {

    private Long userId;

    public CreateUserResponse(String status, String message, Long userId) {
        super( status,message);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
