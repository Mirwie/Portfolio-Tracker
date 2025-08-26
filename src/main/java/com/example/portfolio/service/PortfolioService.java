package com.example.portfolio.service;


import com.example.portfolio.domain.Stock;
import com.example.portfolio.dto.StockRequest;
import com.example.portfolio.dto.StockResponse;
import com.example.portfolio.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PortfolioService {
    private final StockRepository repo;


    public StockResponse add(StockRequest req) {
        Stock s = Stock.builder()
                .ticker(req.ticker().trim())
                .name(req.name().trim())
                .quantity(req.quantity())
                .buyPrice(req.buyPrice())
                .buyDate(req.buyDate())
                .build();
        s = repo.save(s);
        return toDto(s);
    }


    @Transactional(readOnly = true)
    public List<StockResponse> list() {
        return repo.findAll().stream().map(this::toDto).toList();
    }


    public StockResponse update(Long id, StockRequest req) {
        Stock s = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Stock not found: " + id));
        s.setTicker(req.ticker().trim());
        s.setName(req.name().trim());
        s.setQuantity(req.quantity());
        s.setBuyPrice(req.buyPrice());
        s.setBuyDate(req.buyDate());
        return toDto(s);
    }


    public void delete(Long id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("Stock not found: " + id);
        repo.deleteById(id);
    }


    private StockResponse toDto(Stock s) {
        return new StockResponse(s.getId(), s.getTicker(), s.getName(), s.getQuantity(), s.getBuyPrice(), s.getBuyDate());
    }
}