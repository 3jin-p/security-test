package com.example.api.service;

import com.example.common.entity.Dummy;
import com.example.common.repo.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepo testRepo;

    public Dummy testGet(Long id) {
        return testRepo.getOne(id);
    }
    public Dummy testPost(Dummy dummy) {
        return testRepo.save(dummy);
    }
    public void testDelete(Long id) {
        testRepo.deleteById(id);
    }
}
