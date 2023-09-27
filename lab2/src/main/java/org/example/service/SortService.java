package org.example.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("sortService")
public class SortService {
    public List<String> doSort(List<String> stringList) {
        return stringList.stream().sorted().collect(Collectors.toList());
    }
}
