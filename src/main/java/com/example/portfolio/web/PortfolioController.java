package com.example.portfolio.web;


import com.example.portfolio.dto.StockRequest;
import com.example.portfolio.dto.StockResponse;
import com.example.portfolio.service.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class PortfolioController {
    private final PortfolioService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockResponse add(@Valid @RequestBody StockRequest req) {
        return service.add(req);
    }


    @GetMapping
    public List<StockResponse> list() {
        return service.list();
    }


    @PutMapping("/{id}")
    public StockResponse update(@PathVariable Long id, @Valid @RequestBody StockRequest req) {
        return service.update(id, req);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}