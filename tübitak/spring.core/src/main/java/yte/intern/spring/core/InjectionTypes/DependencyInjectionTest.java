package yte.intern.spring.core.InjectionTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionTest {

    /* %99 durumlarda constructor injection
    kalan nadir %1 için setter injection
    Field injection kullanmayın*/
    @Autowired
    public FieldInjectionBean fieldInjectionBean;
    public SetterInjectionBean setterInjectionBean;
    public ConstructorInjectionBean constructorInjectionBean;

    @Autowired
    public DependencyInjectionTest(ConstructorInjectionBean constructorInjectionBean) {
        this.constructorInjectionBean = constructorInjectionBean;
    }

    @Autowired
    public void setSetterInjectionBean(SetterInjectionBean setterInjectionBean) {
        this.setterInjectionBean = setterInjectionBean;
    }

    public void print(){
        fieldInjectionBean.print();
        setterInjectionBean.print();
        constructorInjectionBean.print();
    }
}
