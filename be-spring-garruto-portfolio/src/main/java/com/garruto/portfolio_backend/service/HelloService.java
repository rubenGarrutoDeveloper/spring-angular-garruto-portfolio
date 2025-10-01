package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.Hello;
import com.garruto.portfolio_backend.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HelloService {

    private final HelloRepository helloRepository;

    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public List<Hello> findAll() {
        return helloRepository.findAll();
    }
}
