/* F60_ZK_536Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 14:23:07 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-536
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-536.zul,F60,B,E,Groupbox,title")
class F60_ZK_536Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
			<html><![CDATA[
			<ol>
			<li>Each groupbox below should have title.</li>
			</ol>
			]]></html>
				<hbox>
					<groupbox id="gbxOne" width="200px" height="200px" title="groupbox one" open="false" />
					<groupbox id="gbxTwo" width="200px" mold="3d" height="200px" title="groupbox two" open="false" />
				</hbox>
			</zk>
    		"""

    runZTL(zscript,
      () => {
        var gbxOne: Widget = engine.$f("gbxOne")
        var gbxTwo: Widget = engine.$f("gbxTwo")
        /*
        val gbxOneText: String = getText(gbxOne)
        val gbxTwoText: String = getText(gbxTwo)

        verifyTrue("groupbox one should have title",
            "groupbox one".equals(gbxOneText));

        verifyTrue("groupbox two should have title",
            "groupbox two".equals(gbxTwoText));*/
      }
    );
  }
}