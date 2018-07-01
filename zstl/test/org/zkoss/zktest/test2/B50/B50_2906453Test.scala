/* B50_2906453Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import java.text.DecimalFormat
import java.util.{ArrayList, HashMap, List, Map}

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{ClientWidget, Widget}

import scala.collection.JavaConversions._

class B50_2906453Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html><![CDATA[
<ol>
<li>For each input box, enter number and then tab away, the number in the input box and the one show after the input box shall be the same.</li>
<li>Enter 0</li>
<li>Enter 00.00</li>
<li>Enter .12</li>
<li>Enter 0.12</li>
<li>Enter 1.2</li>
<li>Enter 1.30</li>
<li>Enter 1.400</li>
<li>Enter 1.5000</li>
<li>Enter 12</li>
<li>Enter 12. (note the decimal point at the end)</li>
<li>Enter 100</li>
<li>Enter 123456789</li>
<li>done</li>
</ol>
]]></html>
<vbox>
<hbox>doublebox (#.00#): <doublebox id="db1" format="#.00#" width="140px" onChange='format("l2")'/><label id="l2"/></hbox>
<hbox>doublebox (#.00): <doublebox id="db2" format="#.00" width="140px" onChange='format("l1")'/><label id="l1"/></hbox>
<hbox>decimalbox(#.0#): <decimalbox id="db3" format="#.0#" width="140px" onChange='format("l3")'/><label id="l3"/></hbox>
<hbox>decimalbox(#.##): <decimalbox id="db4" format="#.##" width="140px" onChange='format("l4")'/><label id="l4"/></hbox>
<hbox>doublebox (#0.00#): <doublebox id="db5" format="#0.00#" width="140px" onChange='format("l5")'/><label id="l5"/></hbox>
<hbox>doublebox (#00.00): <doublebox id="db6" format="#00.00" width="140px" onChange='format("l6")'/><label id="l6"/></hbox>
<hbox>doublebox (#,#00.00): <doublebox id="db7" format="#,#00.00" width="140px" onChange='format("l7")'/><label id="l7"/></hbox>
</vbox> 
<zscript><![CDATA[
import java.text.DecimalFormat;
import org.zkoss.zul.Label;
void format(String xid) {
	Object rawval = self.getRawValue();
	Label lbl = self.getFellow(xid);
	if (rawval != null) {
		DecimalFormat fmt = new DecimalFormat(self.getFormat());
		lbl.setValue(fmt.format(rawval));
	} else {
		lbl.setValue("");
	}
}
]]></zscript>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db1 = ztl$engine.$f("db1")
    val l2 = ztl$engine.$f("l2")
    val db2 = ztl$engine.$f("db2")
    val l1 = ztl$engine.$f("l1")
    val db3 = ztl$engine.$f("db3")
    val l3 = ztl$engine.$f("l3")
    val db4 = ztl$engine.$f("db4")
    val l4 = ztl$engine.$f("l4")
    val db5 = ztl$engine.$f("db5")
    val l5 = ztl$engine.$f("l5")
    val db6 = ztl$engine.$f("db6")
    val l6 = ztl$engine.$f("l6")
    val db7 = ztl$engine.$f("db7")
    val l7 = ztl$engine.$f("l7")
    runZTL(zscript, () => {
      // This case's target is: Testing the format does match Java's rule or not.
      var testValues: List[String] = new ArrayList()
      testValues.add("0")
      testValues.add("00.00")
      testValues.add(".12")
      testValues.add("0.12")
      testValues.add("1.2")
      testValues.add("1.30")
      testValues.add("1.400")
      testValues.add("1.5000")
      testValues.add("12")
      testValues.add("12.")
      testValues.add("100")
      testValues.add("123456789")
      var verifyValueMap: Map[String, ClientWidget] = new HashMap()
      verifyValueMap.put("#.00#", jq("$db2"))
      verifyValueMap.put("#.00", jq("$db1"))
      verifyValueMap.put("#.0#", jq("$db3"))
      verifyValueMap.put("#.##", jq("$db4"))
      verifyValueMap.put("#0.00#", jq("$db5"))
      verifyValueMap.put("#00.00", jq("$db6"))
      verifyValueMap.put("#,#00.00", jq("$db7"))
      for (testValue <- testValues) {
        for (key <- verifyValueMap.keySet()) {
          var wgt = verifyValueMap.get(key)
          sendKeys(wgt, testValue)
          waitResponse()
          blur(wgt)
        }
        for (key: String <- verifyValueMap.keySet()) {
          var clientWidget = verifyValueMap.get(key)
          var formatter = new DecimalFormat(key)
          var msgBuffer: StringBuffer = new StringBuffer("Format does not match. Format: ")
          msgBuffer.append(key)
          msgBuffer.append(", value: ")
          msgBuffer.append(jq(clientWidget).`val`())
          var $wgt = jq(clientWidget)
          verifyEquals(msgBuffer.toString(), formatter.format(testValue), $wgt.`val`())
          $wgt.toElement().set("value", "")
        }
      }
    })
  }
}



