package com.test.samir.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.samir.custom.CustomResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private String responseCode;
    private String responseMessage;

    @JsonIgnore
    public void setResponse(CustomResponse response){
        this.setResponseCode(response.getCode());
        this.setResponseMessage(response.getMessage());
    }
}
