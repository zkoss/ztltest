/* F30_1764967Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F30_1764967Test extends ZTL4ScalaTestCase {
  @Test
  def testEvent() = {
    var zscript =
      """
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?> 
<window width="500px" xmlns:n="http://www.zkoss.org/2005/zk/native">
   <zscript>
public class Order {
	private String _orderName;
	private String _orderNumber;
	
	public void setOrderName(String o) {
		_orderName = o;
	}
	
	public String getOrderName() {
		return _orderName;
	}
	
	public void setOrderNumber(String n) {
		_orderNumber = n;
	}
	
	public String getOrderNumber() {
		return _orderNumber;
	}
}   
    int count = 30;
    List orders = new LinkedList();
    for(int j= 0; j &lt; count; ++j) {
      Order o = new Order();
      o.setOrderName("OrderName - " + j );
      o.setOrderNumber("OrderNumber - " + j);
      orders.add(o);
    }   
    selected = null;
  </zscript>
  <n:h2>[1764967] Combobox to support List binding</n:h2>
	<n:ol>
		<n:li>Combobox should has multiple entries.</n:li>
		<n:li>Select an entry from combobox, and databinding Load-on-Save mechanism should triggered. grid below will be updated to selected value</n:li>
		<n:li>Try to type a non-exist string, gird will be updated to empty</n:li>    
	</n:ol>

  <combobox model="@{orders}" selectedItem="@{selected}">
       <comboitem self="@{each=order}" label="@{order.orderName}" value="@{order.orderNumber}"/>
   </combobox>
  <grid>
	<auxhead><auxheader align="center" colspan="2">Order Information</auxheader></auxhead>
  	<columns>
  		<column align="center" width="200px" label="Item"/>
  		<column align="center" width="200px" label="Value"/>
	</columns>	
  	<rows>
  		<row>OrderNumber: <label value="@{selected.orderNumber}"/></row>
  		<row>OrderName: <label id="name" value="@{selected.orderName}"/></row>
  	</rows>
  </grid>
</window>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val name = ztl$engine.$f("name")
    runZTL(zscript, () => {
      var comboInput = jq(".z-combobox").toWidget().$n("real")
      click(jq(".z-combobox").toWidget().$n("btn"))
      waitResponse()
      click(jq(".z-comboitem").get(4))
      waitResponse()
      verifyEquals(comboInput.attr("value"), name.attr("value"))
      sendKeys(comboInput, "xxx")
      blur(comboInput)
      waitResponse()
      verifyEquals("", name.attr("value"))
    })
  }
}



