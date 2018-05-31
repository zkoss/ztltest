/* B50_2880236Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2880236Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>
<zk xmlns="http://www.zkoss.org/2005/zul">
<html><![CDATA[
<ol>
<li>Enter "A" and "123" and press "Add" button.</li> 
<li>You shall see "A" and "123" added as the last row on the grid.</li>
<li>Enter "B" and "-123" and press "Add" button.</li> 
<li>You shall see "B" and "-123" added as the last row on the grid.</li>
<li>Enter "C" and "1.255" and press "Add" button.</li> 
<li>You shall see "C" and "1.26" added as the last row on the grid.</li>
<li>Enter "D" and "1.285" and press "Add" button.</li> 
<li>You shall see "D" and "1.28" added as the last row on the grid.</li>
<li>Enter "E" and "12345678901234567890" and press "Add" button.</li> 
<li>You shall see "E" and "12,345,678,901,234,567,890" added as the last row on the grid.</li>
<li>Done</li>
</ol>
]]>
</html>
<zscript><![CDATA[
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Person {

	public BigDecimal balance;
	
	public String name;
	
	public Person(BigDecimal balance, String name) {
		this.balance = balance;
		this.name = name;
	}

}

List peopleList = new ArrayList();

peopleList.add(new Person(new BigDecimal("1.99"), "foo1"));
peopleList.add(new Person(new BigDecimal("2.99"), "foo2"));
peopleList.add(new Person(new BigDecimal("3.99"), "foo3"));

ListModel people = new BindingListModelList(peopleList, true);
]]></zscript>
<window border="none">
<groupbox>
<grid id="peopleGrid" model="@{people}">
	<columns>
		<column label="Name" />
		<column label="Balance" />
		<column />
	</columns>
	<rows>
		<row self="@{each='person'}" value="@{person}">
			<textbox value="@{person.name}"/>
			<decimalbox value="@{person.balance}" format="##,###.##" hflex="1"/>
			<button label="Remove">
				<attribute name="onClick"><![CDATA[
				people.remove(self.parent.value);
				]]></attribute>
			</button>
		</row>
	</rows>
	<foot>
		<footer>
			<textbox id="newName" />
		</footer>
		<footer>
			<decimalbox id="newBalance" format="##,###.##" hflex="1"/>
		</footer>
		<footer>
			<button id="add" label="Add">
				<attribute name="onClick"><![CDATA[
				people.add(new Person(newBalance.value, newName.value));
				newName.rawValue = null;
				newBalance.rawValue = null;
				]]></attribute>
			</button>
		</footer>
	</foot>
</grid>
</groupbox>
</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val peopleGrid = ztl$engine.$f("peopleGrid")
    val newName = ztl$engine.$f("newName")
    val newBalance = ztl$engine.$f("newBalance")
    val add = ztl$engine.$f("add")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      // A, 123
      sendKeys(jq(newName), "A")
      sendKeys(jq(newBalance), "123")
      focus(jq(add))
      click(jq(add))
      waitResponse()
      var lastRecName = jq(".z-textbox:eq(" + (jq(".z-textbox").length() - 2) + ")")
      verifyTrue("The name of last row is not match. Name: " + lastRecName.`val`(), lastRecName.`val`().equals("A"))
      var lastRecBalance = jq(".z-decimalbox:eq(" + (jq(".z-decimalbox").length() - 2) + ")")
      verifyTrue("The balance of last row is not match. Balance: " + lastRecBalance.`val`(), lastRecBalance.`val`().equals("123"))
      // B, -123
      sendKeys(jq(newName), "B")
      sendKeys(jq(newBalance), "-123")
      focus(jq(add))
      click(jq(add))
      waitResponse()
      lastRecName = jq(".z-textbox:eq(" + (jq(".z-textbox").length() - 2) + ")")
      verifyTrue("The name of last row is not match. Name: " + lastRecName.`val`(), lastRecName.`val`().equals("B"))
      lastRecBalance = jq(".z-decimalbox:eq(" + (jq(".z-decimalbox").length() - 2) + ")")
      verifyTrue("The balance of last row is not match. Balance: " + lastRecBalance.`val`(), lastRecBalance.`val`().equals("-123"))
      // C, 1.255
      sendKeys(jq(newName), "C")
      sendKeys(jq(newBalance), "1.255")
      focus(jq(add))
      click(jq(add))
      waitResponse()
      lastRecName = jq(".z-textbox:eq(" + (jq(".z-textbox").length() - 2) + ")")
      verifyTrue("The name of last row is not match. Name: " + lastRecName.`val`(), lastRecName.`val`().equals("C"))
      lastRecBalance = jq(".z-decimalbox:eq(" + (jq(".z-decimalbox").length() - 2) + ")")
      verifyTrue("The balance of last row is not match. Balance: " + lastRecBalance.`val`(), lastRecBalance.`val`().equals("1.26"))
      // D, 1.285
      sendKeys(jq(newName), "D")
      sendKeys(jq(newBalance), "1.285")
      focus(jq(add))
      click(jq(add))
      waitResponse()
      lastRecName = jq(".z-textbox:eq(" + (jq(".z-textbox").length() - 2) + ")")
      verifyTrue("The name of last row is not match. Name: " + lastRecName.`val`(), lastRecName.`val`().equals("D"))
      lastRecBalance = jq(".z-decimalbox:eq(" + (jq(".z-decimalbox").length() - 2) + ")")
      verifyTrue("The balance of last row is not match. Balance: " + lastRecBalance.`val`(), lastRecBalance.`val`().equals("1.28"))
      // E, 12345678901234567890
      sendKeys(jq(newName), "E")
      sendKeys(jq(newBalance), "12345678901234567890")
      focus(jq(add))
      click(jq(add))
      waitResponse()
      lastRecName = jq(".z-textbox:eq(" + (jq(".z-textbox").length() - 2) + ")")
      verifyTrue("The name of last row is not match. Name: " + lastRecName.`val`(), lastRecName.`val`().equals("E"))
      lastRecBalance = jq(".z-decimalbox:eq(" + (jq(".z-decimalbox").length() - 2) + ")")
      verifyTrue("The balance of last row is not match. Balance: " + lastRecBalance.`val`(),
        lastRecBalance.`val`().equals("12,345,678,901,234,567,890"))
    })
  }
}



