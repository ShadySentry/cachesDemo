package com.shadysentry.ehCache2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@CacheConfig(cacheNames = "employeeCache")
public class EmployeeService {
    static Map<Long, Employee> db = new HashMap<>();

    static {
        db.put(1L, new Employee(1L, "Alex", "Gussin"));
        db.put(2L, new Employee(2L, "Brian", "Schultz"));

        for (int i = 3; i <= 1000; i++) {
            db.put((long) i,
                    new Employee((long) i, "Generated_first_name_" + i, "Generated_last_name_" + i));
        }
    }

    @CacheEvict(allEntries = true)
    public void clearCache(){
        log.info("cache cleared");
    }

    @Cacheable(cacheNames = "employeeCache", key = "#id")
    public Employee getEmployeeById(Long id) {

        log.info("Getting employee from DB");
        return db.get(id);
    }
}