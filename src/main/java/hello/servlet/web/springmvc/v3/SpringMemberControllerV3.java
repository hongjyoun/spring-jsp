package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  //  @RequestMapping(value ="/new-form", method = RequestMethod.GET)
  @GetMapping("/new-form") // 위의 @RequestMapping(value ="/new-form", method = RequestMethod.GET)와 같은 의미. method가 추가되고 더 간단해진 어노테이션이라고 볼 수 있다.
  public String newForm() {
    return "new-form";
  }

  //  @RequestMapping(value ="/save", method = RequestMethod.POST)
  @PostMapping("/save") // 위의 @RequestMapping(value ="/save", method = RequestMethod.POST)와 같은 의미. method가 추가되고 더 간단해진 어노테이션이라고 볼 수 있다.
  public String save(
    @RequestParam("username") String username,
    @RequestParam("age") int age,
    Model model
  ){
    Member member = new Member(username, age);
    memberRepository.save(member);

    model.addAttribute("member", member);
    return "save-result";
  }

  //  @RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public String members(Model model) {
    List<Member> members = memberRepository.findAll();

    model.addAttribute("members", members);
    return "members";
  }
}
