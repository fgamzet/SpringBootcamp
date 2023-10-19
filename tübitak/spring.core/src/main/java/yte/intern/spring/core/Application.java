package yte.intern.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import yte.intern.spring.core.InjectionTypes.DependencyInjectionTest;
import yte.intern.spring.core.creatingBean2way.ComponentTest;
import yte.intern.spring.core.creatingBean2way.InjectionTest;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);

		ComponentTest componentTest = context.getBean(ComponentTest.class); //componentTest in bir instanceını oluşturduk
		//componentTest.print();
		DependencyInjectionTest dependencyInjectionTest = context.getBean(DependencyInjectionTest.class);
		//dependencyInjectionTest.print();
		LifecycleBean lifecycleBean = context.getBean(LifecycleBean.class);
		//lifecycleBean.print();
		InjectionTest injectionTest=context.getBean(InjectionTest.class);
		//injectionTest.print();
	}
//Dependency injection is a pattern through which to implement IoC, where the control being inverted is the setting of object's dependencies.
}
