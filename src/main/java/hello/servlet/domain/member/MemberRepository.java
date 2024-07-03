package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L;
  // MemberRepository 클래스에서 store와 sequence를 static으로 선언한 것은
  // 이 두 필드를 MemberRepository의 모든 인스턴스가 아닌, 클래스 자체와 연결하기 위함입니다.
  // 이렇게 함으로써, MemberRepository의 어떤 인스턴스에서도 같은 store와 sequence에 접근하고 수정할 수 있게 됩니다.
  // 이는 MemberRepository가 싱글톤 패턴으로 구현되었음을 암시합니다.
  // 싱글톤 패턴은 특정 클래스의 인스턴스가 하나만 생성되어야 할 때 사용하는 디자인 패턴입니다.

  private static final MemberRepository instance = new MemberRepository();

  public static MemberRepository getInstance() {
    return instance;
  }
  private MemberRepository() {} // 외부에서 생성자를 호출할 수 없도록 private으로 선언 (싱글톤으로 쓸때)

  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  public Member findById(Long id) {
    return store.get(id);
  }

  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  public void clearStore() {
    store.clear();
  }
}
