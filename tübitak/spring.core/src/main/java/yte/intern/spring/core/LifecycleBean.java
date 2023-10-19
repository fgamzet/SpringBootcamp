package yte.intern.spring.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean {
    @PostConstruct
    public void init(){
         System.out.println("init içindeyim");
    }
    public LifecycleBean(){
        System.out.println("Consturctor içindeyim");
    }
    public @PreDestroy
    void destroy(){
        System.out.println("destroy içindeyim");
    }
    public void print(){
        System.out.println("Print içindeyim");
    }
}
