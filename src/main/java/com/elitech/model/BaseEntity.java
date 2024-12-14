package com.elitech.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private LocalDateTime createdAt,updatedAt;
@PrePersist
void init()
{
createdAt=updatedAt=LocalDateTime.now();	
}
@PreUpdate
void update()
{
updatedAt=LocalDateTime.now();	
}

}
