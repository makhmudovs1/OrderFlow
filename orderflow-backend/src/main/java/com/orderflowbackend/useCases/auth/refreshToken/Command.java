package com.orderflowbackend.useCases.auth.refreshToken;

import lombok.Builder;
import lombok.Data;

// чтобы тот хэндлер обработал запрос, он должен получить данные.
// нам нужен контракт и это будет некое dto, которое мы назвали Command
@Data
@Builder
public class Command {
    private String refreshToken;
}
