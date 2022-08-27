package cn.xionghuihui.infrastructure.spring.common.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnListPropertyConditional.class)
public @interface KitConditionalOnListProperty {

	/**
	 * 属性的Key
	 */
	String value() default "";

	/**
	 * 拥有具体的值
	 */
	String containsValue() default "";

}
