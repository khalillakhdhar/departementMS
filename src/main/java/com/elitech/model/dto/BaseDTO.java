package com.elitech.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {
private long id;
private LocalDateTime createdAt,updatedAt;
}
