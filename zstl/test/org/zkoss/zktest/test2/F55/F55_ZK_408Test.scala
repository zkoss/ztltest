/* F55_ZK_408Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 16 10:24:58 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F55

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-408
 * @author benbai
 *
 */
@Tags(tags = "F55-ZK-408.zul,F60,A,E,textAs")
class F55_ZK_408Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				The content of the following block shall be the same.
				<html><![CDATA[
				<ol style="border: 1px solid blue;">
					<li>Apple</li>
					<li>Orange</li>
				</ol>
				]]></html>
				<zscript>
				String[] fruits = new String[] {"Apple", "Orange"};
				</zscript>
				<html>
				<ol style="border: 1px solid blue;">
					<li forEach="${fruits}">${each}</li>
				</ol>
				</html>
			</zk>

    """

   runZTL(zscript,
        () => {
          var contentOne: String = jq("span:contains(Apple)").get(0).get("innerHTML");
          var contentTwo: String = jq("span:contains(Apple)").get(1).get("innerHTML");
          contentOne = contentOne.replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "").trim();
          contentTwo = contentTwo.replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "").trim();
          verifyTrue("Content of the two block should the same",
              contentOne.equals(contentTwo));
    }
   );
  }
}