package hello.itemservice.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

  MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

  @Test
  void messageCodesResolverObject() {

    String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

    System.out.println("messageCodes = " + Arrays.toString(messageCodes));

    assertThat(messageCodes).containsExactly("required.item", "required");

  }

  @Test
  void messageCodesResolverField() {
    String[] messageCodes = codesResolver
        .resolveMessageCodes("required", "item", "itemName", String.class);

    System.out.println("messageCodes = " + Arrays.toString(messageCodes));

    assertThat(messageCodes).containsExactly(
        "required.item.itemName",
        "required.itemName",
        "required.java.lang.String",
        "required"
    );
  }
}
