package com.inspur.gs.commonutils.demo.event.delay;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author tjz
 * @date 2022/7/20
 * @description
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ApplicationDelayedEvent extends ApplicationEvent implements Delayed {

    private static final long serialVersionUID = 1L;

    private final Clock delaySeconds;

    public ApplicationDelayedEvent(Object source, long delaySeconds) {
        super(source);
        this.delaySeconds = Clock.offset(Clock.systemDefaultZone(), Duration.ofSeconds(delaySeconds));
    }

    @Override
    public int compareTo(Delayed o) {
        long delta = getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
        return (int) delta;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long millis = delaySeconds.millis();
        long currentTimeMillis = System.currentTimeMillis();
        long sourceDuration = millis - currentTimeMillis;
        return unit.convert(sourceDuration, unit);
    }
}
