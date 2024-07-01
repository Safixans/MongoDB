package springAdvanced.startingLesson.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Service
public class CacheService {

    private final ConcurrentHashMap<Object, Map<Object, Object>> cache = new ConcurrentHashMap<>();

    public void put(Map<Object, Object> model) {
        cache.putIfAbsent(model.get("userID"), model);
    }

    public Map<Object, Object> get(Object key) {
        return cache.get(key);
    }

}