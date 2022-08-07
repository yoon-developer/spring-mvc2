package hello.itemservice.domain.item;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000 이상 이여야 합니다")
@NoArgsConstructor
/**
 * Controller4 에서 사용
 */
public class Item {
  private Long id;

  private String itemName;

  private Integer price;

  private Integer quantity;

  public Item(String itemName, Integer price, Integer quantity) {
    this.itemName = itemName;
    this.price = price;
    this.quantity = quantity;
  }
}

///**
// * Controller1, Controller2, Controller3 에서 사용
// */
//public class Item {
//
//  @NotNull(groups = UpdateCheck.class) //수정 요구사항 추가
//  private Long id;
//
//  @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
//  private String itemName;
//
//  @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//  @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
//  private Integer price;
//
//  @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//  @Max(value = 9999, groups = {SaveCheck.class})
//  private Integer quantity;
//
//  public Item(String itemName, Integer price, Integer quantity) {
//    this.itemName = itemName;
//    this.price = price;
//    this.quantity = quantity;
//  }
//}
