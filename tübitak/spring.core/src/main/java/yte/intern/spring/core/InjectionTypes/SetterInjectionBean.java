package yte.intern.spring.core.InjectionTypes;

import org.springframework.stereotype.Component;

@Component
public class SetterInjectionBean {
    public void print(){
        System.out.println("Setter injection bean");
    }
}
