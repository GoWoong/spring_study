package hello.hellospring.controller;


import hello.hellospring.dto.MemaberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping(value = "/default")
    public String putMethod() { return "Hello World";}

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object>postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemaberDTO memberDTO){
        return memberDTO.toString();
    }

    @PutMapping(value = "/member2")
    public MemaberDTO postMemberDto2(@RequestBody MemaberDTO memberDTO){
        return memberDTO;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemaberDTO> postMemberDto3(@RequestBody MemaberDTO memaberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memaberDTO);
    }
}
