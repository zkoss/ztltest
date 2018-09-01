/* B30_1906748Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1906748Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>This bug is only caused by running Tomcat with Java6, so if the test case runs on Tomcat with Java6 without any error that is correct.</n:p>
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
			    selected = orders.get(0);
			  </zscript>
			
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
			  		<row>OrderNumber: <label id="oNumberLbl" value="@{selected.orderNumber}"/></row>
			  		<row>OrderName: <label id="oNameLbl"  value="@{selected.orderName}"/></row>
			  	</rows>
			  </grid>
			</window>
			</zk>
		"""
    val ztl$engine = engine()
    val oNumberLbl = ztl$engine.$f("oNumberLbl")
    val oNameLbl = ztl$engine.$f("oNameLbl")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-comboitem:eq(5)"))
      waitResponse()
      verifyEquals("OrderNumber - 5", jq(oNumberLbl).text())
      verifyEquals("OrderName - 5", jq(oNameLbl).text())
    })
  }
}



