package curihous.ifit.api.event;

import org.springframework.context.ApplicationEvent;

/**
 * 대시보드 메트릭 업데이트 이벤트
 * - 프로메테우스에서 새로운 메트릭 데이터를 가져왔을 때 발행
 * - 실시간 대시보드 업데이트를 위한 WebSocket 전송 트리거
 * - 임계값 초과시 알림 발송 트리거(여유시)
 */
public class MetricsUpdatedEvent extends ApplicationEvent {

    // TODO: 메트릭 데이터, 조직 ID 등 필요한 필드 추가

    public MetricsUpdatedEvent(Object source) {
        super(source);
    }

}
