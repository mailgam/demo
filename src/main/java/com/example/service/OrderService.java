package com.example.service;

import com.example.bean.Order;
import com.example.dto.OrderDto;
import com.example.mapper.OrderMapper;
import com.example.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository repository, OrderMapper orderMapper) {
        this.repository = repository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public OrderDto save(OrderDto orderDto) {
        Order entity = orderMapper.toEntity(orderDto);
        return orderMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public OrderDto findById(Integer id) {
        return orderMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<OrderDto> findByCondition(Pageable pageable) {
        Page<Order> entityPage = repository.findAll(pageable);
        List<Order> entities = entityPage.getContent();
        return new PageImpl<>(orderMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public OrderDto update(OrderDto orderDto, Integer id) {
        OrderDto data = findById(id);
        Order entity = new Order();
        BeanUtils.copyProperties(data, entity);
        entity = orderMapper.toEntity(orderDto);
        return save(orderMapper.toDto(entity));
    }
}
