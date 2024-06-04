package org.example.restexam.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {
    // 서비스 거쳐서 DB가는 과정 생략하고 연습하려고 아래처럼함
    private final Map<Long, String> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String content) {
        long id = counter.incrementAndGet();
        // 원래는 서비스에 넘기겠지만..
        memos.put(id, content);
        return ResponseEntity.ok(id);
    };

    @GetMapping("/{id}")
    public ResponseEntity<String> getMemo(@PathVariable("id")Long id) {
        String memo = memos.get(id);
        if( memo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable("id") Long id, @RequestBody String content) {
        if(!memos.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        memos.put(id,content);
        return ResponseEntity.ok("메모수정 성공!!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") Long id) {
        String removeMemo = memos.remove(id);
        if(removeMemo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("삭제 성공");
    }
}
