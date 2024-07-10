package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  //  @RequestMapping("/springmvc/v2/members/new-form") 원래 이거였는데, 위에 @RequestMapping("/springmvc/v2/members")가 있어서 생략 가능하다.
  @RequestMapping("/new-form")
  public ModelAndView newForm() {
    return new ModelAndView("new-form");
  }

  @RequestMapping("/save")
  public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

    ModelAndView mv = new ModelAndView("save-result");
    mv.addObject("member", member);
    return mv;
  }

  @RequestMapping
  public ModelAndView members() {
    List<Member> members = memberRepository.findAll();
    ModelAndView mv = new ModelAndView("members");
    mv.addObject("members", members);
    return mv;
  }


}
