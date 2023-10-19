package yte.intern.spring.core.InjectionTypes;

import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionBean {
    public void print(){
        System.out.println("Constructor injection bean");
    }
}
