package curihous.ifit.api.event.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 메트릭 이벤트 리스너
 * - 프로메테우스에서 메트릭 데이터 수집 (5초마다?)
 * - WebSocket을 통한 실시간 대시보드 데이터 전송
 */
@Component
public class MetricsEventListener {

    // TODO: PrometheusService, WebSocketService 의존성 주입

    @Async
    @EventListener
    public void onMetricsUpdated() {

    }
}
