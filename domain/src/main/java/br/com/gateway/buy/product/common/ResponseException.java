package br.com.gateway.buy.product.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseException<T> {

    private Integer status;
    private String error;
    private String message;
    private String path;
}

