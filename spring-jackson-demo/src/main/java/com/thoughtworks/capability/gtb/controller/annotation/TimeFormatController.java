package com.thoughtworks.capability.gtb.controller.annotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 场景六：JSON中的时间是特定格式，在序列化时指定时间格式
 * 使用@JsonFormat
 *
 * @author itutry
 * @create 2020-05-20_17:09
 */
@RestController
public class TimeFormatController {

  @GetMapping("/events/{id}")
  public EventVo getEvent(@PathVariable("id") String id) {
    return new EventVo(id, "pay", LocalDateTime.now());
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class EventVo {

    private String id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
  }
}
