package sparta.com.sappun.domain.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.com.sappun.domain.TimeStamp;
import sparta.com.sappun.domain.sample.dto.request.SampleUpdateReq;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_sample")
public class Sample extends TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String field1;

    private String field2;

    @Builder
    private Sample(String field1, String field2) { // 빌더로 id값을 직접 넣어주는 경우가 없으므로 제거
        this.id = id;
        this.field1 = field1;
        this.field2 = field2;
    }

    public void update(SampleUpdateReq sampleUpdateReq) {
        this.field1 = sampleUpdateReq.getField1();
        this.field2 = sampleUpdateReq.getField2();
    }
}
