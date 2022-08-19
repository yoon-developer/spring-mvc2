package hello.login.web.session;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {

  public static final String SESSION_COOKIE_NAME = "mySessionId";

  private Map<String, Object> sesstionStore = new ConcurrentHashMap<>();

  /**
   * 세션 생성
   */
  // 세션에는 최소한의 데이터만 보관
  public void createSession(Object value, HttpServletResponse response) {

    String sesstionId = UUID.randomUUID().toString();

    sesstionStore.put(sesstionId, value);

    //쿠키 생성
    Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sesstionId);
    response.addCookie(cookie);
  }

  /**
   * 세션 조회
   */
  public Object getSession(HttpServletRequest request) {

    Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);

    if (sessionCookie == null) {
      return null;
    }

    return sesstionStore.get(sessionCookie.getValue());
  }

  /**
   * 세션 만료
   */
   public void expire(HttpServletRequest request) {
     Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);

     if (sessionCookie != null) {
       sesstionStore.remove(sessionCookie.getValue());
     }
   }

  private Cookie findCookie(HttpServletRequest request, String cookieName) {
    return Arrays.stream(request.getCookies())
        .filter(cookie -> cookie.getName().equals(cookieName)).findAny().orElse(null);
  }

}
