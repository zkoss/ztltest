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
  @Test
  def testClick() = {
    runZTL(
      () => {
        //remove all whitespace using regex
        var contentOne = jq(".z-html:eq(0)").html().replaceAll("\\s", "");
        var contentTwo = jq(".z-html:eq(1)").html().replaceAll("\\s", "");
        verifyEquals("content of the two blocks should be equal", contentOne, contentTwo);
      });
  }
}