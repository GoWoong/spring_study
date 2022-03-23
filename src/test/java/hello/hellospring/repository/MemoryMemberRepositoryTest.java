package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


//테스트 주도개발의 시작 TDD 테스트 용 툴을 만들고 그 뒤에 코드를 개발한다.

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    } //중요 콜백 처럼 하나의 매소드가 끝나고 @AfterEach가 있는 이 매소드를 실행 한다.
    //이 매소드는 공용 데이터를 지우는 용도 이다.
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");//방향키 안쓰고 다음줄로 가기 = shift + enter

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
        //두가지 방법이 있다. 밑의 Assertions는 static으로 만들수 있다.
    }
    @Test
    public void findByName(){
        Member member1 = new Member(); //shift + F6 = rename
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member(); //shift + F6 = rename
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
