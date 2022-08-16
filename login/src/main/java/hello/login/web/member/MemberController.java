package hello.login.web.member;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

  private final MemberRepository memberRepository;

  @GetMapping("/add")
  public String addFrom(@ModelAttribute("member") Member member) {
    return "members/addmemberForm";
  }

  @PostMapping("/add")
  public String save(@Valid @ModelAttribute("member") Member member, BindingResult result) {
    if (result.hasErrors()) {
      return "members/addmemberForm";
    }

    memberRepository.save(member);
    return "redirect:/";
  }
}
