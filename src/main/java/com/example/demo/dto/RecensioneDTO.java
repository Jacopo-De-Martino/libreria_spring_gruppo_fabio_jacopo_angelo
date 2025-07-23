package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecensioneDTO {
    private Long id;
    private String testo;
    private Long libroId;
}