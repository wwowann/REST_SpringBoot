package com.example.demo.service;

import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public abstract class ArgumentResolver implements HandlerMethodArgumentResolver {

    private final WebArgumentResolver adaptee;

    protected ArgumentResolver(WebArgumentResolver adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Actually resolve the value and check the resolved value is not
     * {@link WebArgumentResolver#UNRESOLVED} absorbing _any_ exceptions.
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        try {
            NativeWebRequest webRequest = getWebRequest();
            Object result = this.adaptee.resolveArgument(parameter, webRequest);
            if (result == WebArgumentResolver.UNRESOLVED) {
                return false;
            } else {
                return ClassUtils.isAssignableValue(parameter.getParameterType(), result);
            }
        } catch (Exception ex) {
            // ignore (see class-level doc)
           return false;
        }
    }

    /**
     * Delegate to the {@link WebArgumentResolver} instance.
     *
     * @throws IllegalStateException if the resolved value is not assignable
     *                               to the method parameter.
     */
    @Override
    @Nullable
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {

        Class<?> paramType = parameter.getParameterType();
        Object result = this.adaptee.resolveArgument(parameter, webRequest);
        if (result == WebArgumentResolver.UNRESOLVED || !ClassUtils.isAssignableValue(paramType, result)) {
            throw new IllegalStateException(
                    "Standard argument type [" + paramType.getName() + "] in method " + parameter.getMethod() +
                            "resolved to incompatible value of type [" + (result != null ? result.getClass() : null) +
                            "]. Consider declaring the argument type in a less specific fashion.");
        }
        return result;
    }


    /**
     * Required for access to NativeWebRequest in {@link #supportsParameter}.
     */
    protected abstract NativeWebRequest getWebRequest();

}