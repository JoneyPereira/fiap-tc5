package com.fiap.tc5apicarts.client;

import com.fiap.tc5apicarts.dto.ProductDTO;
import com.fiap.tc5apicarts.dto.StockDTO;
import com.fiap.tc5apicarts.dto.StockOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(
        name = "api-product",
        url = "http://localhost:8081"
)
public interface ProductFeignClient {

    @GetMapping("/stock/{uuid}")
    StockDTO findByUuid(@PathVariable UUID uuid);

    @PostMapping(value = "/stock/output")
    void outPutStock(@RequestBody StockOutputDTO dto);
}
