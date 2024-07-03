package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloData {

  private String username;
  private int age;

  // lombok을 사용하면 아래와 같이 getter, setter를 자동으로 생성할 수 있다.
  //  public String getUsername() {
  //    return username;
  //  }
  //
  //  public void setUsername(String username) {
  //    this.username = username;
  //  }
  //
  //  public int getAge() {
  //    return age;
  //  }
  //
  //  public void setAge(int age) {
  //    this.age = age;
  //  }

}
