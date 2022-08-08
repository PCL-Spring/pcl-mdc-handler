package dev.be.handler.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoDTO {

    private String name;
    private String mid; // member id

    private static Map<String, String> map = Map.of(
            "aaa", "111",
            "bbb", "222"
    );

    public static String getBindValue(String key) {
        return map.getOrDefault(key, "333");
    }
}
