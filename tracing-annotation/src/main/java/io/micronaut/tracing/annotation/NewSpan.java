/*
 * Copyright 2017-2022 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.tracing.annotation;

import io.micronaut.aop.Around;
import io.micronaut.aop.InterceptorBinding;
import io.micronaut.context.annotation.Type;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>Indicates that a new Open Tracing span should be started.</p>
 *
 * <p>Annotation inspired by Spring Sleuth but using Open Tracing and Micronaut AOP.</p>
 *
 * @author graemerocher
 * @since 1.0
 */
@Retention(RUNTIME)
@Inherited
@Target({METHOD, ANNOTATION_TYPE})
@Around
@Type(InterceptorBinding.class)
@InterceptorBinding
public @interface NewSpan {

    /**
     * The name of the span which will be created.
     * Default is the annotated method's name separated by hyphens.
     *
     * @return the key to use for the tag
     */
    String value() default "";
}
