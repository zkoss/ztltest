/* F60_ZK_666Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 15:59:12 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-666
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-666.zul,F60,B,E,annotation,namespace")
class F60_ZK_666Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<div>
				<html><![CDATA[
				<ul>
				<li>The first two lines shall be the same: value is "abc", and annotation
				is "@annot()".</li>
				<li>The last two lines shall be the same: value is "@annot()", and
				has no annotation.</li>
				</ul>
				]]></html>
			
				<zscript><![CDATA[
				void show(Component c) {
					c.parent.insertBefore(
						new Label(": " + c.getAnnotations("value", "annot")), c.nextSibling);
				}
				]]></zscript>
			
				<textbox value="abc" a:value="@annot()" xmlns:a="annotation"/>
				<separator onCreate="show(self.previousSibling)"/>
				<textbox value="@annot()">
					<attribute name="value">abc</attribute>
				</textbox>
				<separator onCreate="show(self.previousSibling)"/>
			
				<textbox z:value="@annot()" xmlns:z="zul"/>
				<separator onCreate="show(self.previousSibling)"/>
				<textbox>
					<attribute name="value">@annot()</attribute>
				</textbox>
				<separator onCreate="show(self.previousSibling)"/>
			</div>

    """
    runZTL(zscript,
      () => {
        verifyContains("The first two lines shall be the same: value is \"abc\", and annotation is \"@annot()\".",
          jq(".z-textbox").get(0).get("value"), "abc")
        verifyContains(jq(".z-label").get(0).get("innerHTML"), "@annot()")
        verifyContains(jq(".z-label").get(1).get("innerHTML"), "@annot()")
        verifyContains("The last two lines shall be the same: value is \"@annot()\", and has no annotation",
          jq(".z-textbox").get(2).get("value"), "@annot()")
        verifyContains("The last two lines shall be the same: value is \"@annot()\", and has no annotation", jq(".z-textbox").get(3).get("value"), "@annot()")
        verifyNotContains("The last two lines shall be the same: value is \"@annot()\", and has no annotation", jq(".z-label").get(2).get("innerHTML"), "@annot()")
        verifyNotContains("The last two lines shall be the same: value is \"@annot()\", and has no annotation", jq(".z-label").get(3).get("innerHTML"), "@annot()")
      }
    );
  }
}