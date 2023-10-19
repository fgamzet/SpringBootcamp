package yte.intern.spring.core.InjectionTypes;

import org.springframework.stereotype.Component;

@Component
public class FieldInjectionBean {
    public void print(){
        System.out.println("Field injection bean");
    }

}
