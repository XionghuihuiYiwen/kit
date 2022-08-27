package cn.xionghuihui.infrastructure.spring.common.condition;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotationPredicates;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 集合元素匹配
 *
 * @author huihui.xiong
 * @since 2022-08-24 16:49:07
 */
public class OnListPropertyConditional extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        List<AnnotationAttributes> annotationAttributes = metadata.getAnnotations()
                .stream(KitConditionalOnListProperty.class.getName())
                .filter(MergedAnnotationPredicates.unique(MergedAnnotation::getMetaTypes))
                .map(MergedAnnotation::asAnnotationAttributes).collect(Collectors.toList());
        List<ConditionOutcome> matchList = new ArrayList<>();
        for (AnnotationAttributes annotationAttribute : annotationAttributes) {
            String value = annotationAttribute.getString("value");
            String containsValue = annotationAttribute.getString("containsValue");
            String[] propertyValues = context.getEnvironment().getProperty(value, String[].class);
            if (propertyValues == null || propertyValues.length == 0 || !StringUtils.hasText(containsValue)) {
                return ConditionOutcome.noMatch("match error");
            }
            for (String propertyValue : propertyValues) {
                if (Objects.equals(propertyValue, containsValue)) {
                    matchList.add(ConditionOutcome.match());
                }
            }
        }
        return matchList.isEmpty() ? ConditionOutcome.noMatch("match error") : ConditionOutcome.match();
    }
}
