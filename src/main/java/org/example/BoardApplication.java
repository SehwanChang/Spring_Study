package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication // 내가 있는 패키지, 하위만 스캔 
public class BoardApplication {
    public static void main(String[] args) { // 프로그램 실행시 가장먼저 호출
        // 내부적으로 Tomcat 서버 실행, 컨트롤러 스캔, 설정 초기화
        SpringApplication.run(BoardApplication.class, args);
    }
}
