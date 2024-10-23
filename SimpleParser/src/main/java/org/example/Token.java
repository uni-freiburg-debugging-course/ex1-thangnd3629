package org.example;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Token {
    private String value;
    private TokenType tokenType;
}


