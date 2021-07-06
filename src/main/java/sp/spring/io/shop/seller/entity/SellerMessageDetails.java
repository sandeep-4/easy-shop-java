package sp.spring.io.shop.seller.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SellerMessageDetails {

	  private int msgSeqNum;

	    private int status;

	    private String msgBody;

	    private String msgSubject;

	    private String senderName;

	    private String timestamp;

	    private boolean starred;
}
