package com.drive.fast.api.handler.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse (
        LocalDateTime localDateTime,
        int status,
        String message,
        Map<String, String> errors
){
}
