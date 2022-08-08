package dev.be.handler.resolver;

import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import dev.be.handler.dto.DemoDTO;

public class DemoResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(DemoDTO.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory)
            throws Exception {

        String userKey = webRequest.getHeader("userKey");
        String clientOsVer = webRequest.getHeader("clientOsVer");
        String clientAppVer = webRequest.getHeader("clientAppVer");

        MDC.put("userKey", userKey);
        MDC.put("clientOsVer", clientOsVer);

        // userKey -> DemoDTO 바꿔서 Controller에게 넘겨준다.
        // 컨트롤러에서 DemoDTO 형식의 input 값을 받고 싶다.
        // 그런데 클라는 mid와 name 값을 모름
        // 클라는 userKey만 보낼뿐
        // 그러니까 controller에 가기전에 resolver 단계에서
        // 스프링 프레임워크의 기능을 활용하여
        // userKey를 사용하여 DemoDTO를 만든다.
        // 그리고 그렇게 만든 DemoDTO를 Controller에게 넘긴다.
        // 그러면 우리가 원한 목적을 달성할 수 있다.
        return DemoDTO.builder()
                      .name(findByUserKeyFromDB(userKey) + findByUserKeyFromDB(userKey))
                      .mid(DemoDTO.getBindValue(userKey))
                      .build();
    }

    private String findByUserKeyFromDB(String key) {
        // d
        // d
        String aa = "aa";
        // d
        // d
        String bb = "bb";
        // d
        return "dev";
    }
}
