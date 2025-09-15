package curihous.ifit.api.event.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 메트릭 이벤트 발행자
 * - 프로메테우스 메트릭 수집 완료시 이벤트 발행
 * - 실시간 대시보드 업데이트 트리거
 */
@Component
public class MetricsPublisher {

    // TODO: ApplicationEventPublisher 의존성 주입


    public void publishMetricsUpdated() {
        // TODO: MetricsUpdatedEvent 발행
        // TODO: 메트릭 데이터와 함께 이벤트 생성
    }
}
