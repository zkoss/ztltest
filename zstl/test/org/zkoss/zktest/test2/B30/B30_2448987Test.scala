/* B30_2448987Test.java

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


class B30_2448987Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<?page id="testZul" title=" New ZUL Title" cacheable="false" 
				language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
			<window>
			<html><![CDATA[  
			<ol>
			<li>You shall see the listbox in the order of item4,item0,item1,item2,item3,item5,item6,item7,item8,item9</li>
			<li>Otherwise, it is a bug</li>
			<li>Done</li>
			</ol>
			]]>
			
			</html>
			<zscript><![CDATA[
			    ListModelList model = new ListModelList(new ArrayList(10), true);
			    for (int j = 0; j < 10; ++j) {
			    	model.add("item"+j);
			    }
			    List subList = model.subList(0, 5);
			    Collections.rotate(subList, +1);
			]]></zscript>
				<listbox model="${model}"/>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val testZul = ztl$engine.$f("testZul")
    runZTL(zscript, () => {
      verifyEquals("item4", jq(".z-listitem:eq(0)").text())
      verifyEquals("item0", jq(".z-listitem:eq(1)").text())
      verifyEquals("item1", jq(".z-listitem:eq(2)").text())
      verifyEquals("item2", jq(".z-listitem:eq(3)").text())
      verifyEquals("item3", jq(".z-listitem:eq(4)").text());
      verifyEquals("item5", jq(".z-listitem:eq(5)").text())
      verifyEquals("item6", jq(".z-listitem:eq(6)").text())
      verifyEquals("item7", jq(".z-listitem:eq(7)").text())
      verifyEquals("item8", jq(".z-listitem:eq(8)").text());
      verifyEquals("item9", jq(".z-listitem:eq(9)").text())
      verifyEquals(10, jq(".z-listitem").length())
    })
  }
}



