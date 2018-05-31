/* B50_3317170Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 10:13:59 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import java.lang._

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Element, Tags, Widget}

/**
  * A test class for bug 3317170
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3317170.zul,B,E,Datebox,Calendar,FF3")
class B50_3317170Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				<html><![CDATA[
					<ol>
						<li>the div element of calendar should inside the datebox root i element</li>
					</ol>
				]]></html>
					<datebox id="db">
						<custom-attributes org.zkoss.zul.client.rod="true" />
					</datebox>
			</zk>

    """
    runZTL(zscript,
      () => {
        var db: Widget = engine.$f("db");

        def isUnderParent(child: Element, parent: Element): Boolean = {
          if (child.get("id").equals(parent.get("id")))
            return true;
          else if (child.parentNode().exists())
            return isUnderParent(child.parentNode(), parent);
          else
            return false;
        }

        verifyNotEquals("the div element of calendar should inside the datebox root i element",
          isUnderParent(db.$n("pp"), db.$n()));
      }
    );

  }
}