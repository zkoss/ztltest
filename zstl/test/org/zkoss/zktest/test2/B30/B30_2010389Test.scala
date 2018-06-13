/* B30_2010389Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2010389Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?> 
			<window width="500px">
			<html><![CDATA[
			<p>
			1. You shoud see "OrderName - 3" as selected item in combobox.<br/>
			2. Press button "load new selected value".<br/>
			3. It is a bug if you see an alert window complains <br/>
			"Index: -1, Size: 30"<br/>
			4. It is OK if selected item is "OrderName - 6" and no such alert window.<br/>
			</p>  
			]]></html>
			<zscript><![CDATA[
			import java.util.*;
			
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
			    for(int j= 0; j < count; ++j) {
			      Order o = new Order();
			      o.setOrderName("OrderName - " + j );
			      o.setOrderNumber("OrderNumber - " + j);
			      orders.add(o);
			    }   
			    selected = orders.get(3);
			  ]]></zscript>
			
			<combobox model="@{orders}" selectedItem="@{selected}" value="@{selected.orderName}">
			       <comboitem self="@{each=order}" label="@{order.orderName}" value="@{order.orderNumber}"/>
			   </combobox>
			  <grid>
			    <auxhead>
			      <auxheader align="center" colspan="2">Order Information</auxheader>
			    </auxhead>
			    <columns>
			      <column align="center" width="200px" label="Item"/>
			      <column align="center" width="200px" label="Value"/>
			  </columns>  
			    <rows>
			      <row>OrderNumber: <label id="numLbl" value="@{selected.orderNumber}"/></row>
			      <row>OrderName: <label id="nameLbl" value="@{selected.orderName}"/></row>
			    </rows>
			  </grid>
			
			  <separator width="3px"/>
			
			  <button id="loadNewVal" label="load new selected value">
			    <attribute name="onClick">
			      selected = orders.get(6);
			
			      AnnotateDataBinder binder = page.getAttribute("binder");
			      binder.loadAll();
			    </attribute>
			  </button>
			
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val numLbl = ztl$engine.$f("numLbl")
    val nameLbl = ztl$engine.$f("nameLbl")
    val loadNewVal = ztl$engine.$f("loadNewVal")
    runZTL(zscript, () => {
      sleep(1000);
      //for DataBinding
      var comboboxInp = jq(jq(".z-combobox").toWidget().$n("real"))
      verifyEquals("OrderName - 3", comboboxInp.`val`())
      click(loadNewVal)
      waitResponse()
      verifyEquals("OrderName - 6", comboboxInp.`val`())
      verifyEquals("OrderNumber - 6", jq(numLbl).text())
      verifyEquals("OrderName - 6", jq(nameLbl).text())
    })
  }
}



