/* B50_ZK_647Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Dec 07 12:59:50 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

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
 * A test class for bug ZK-647
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-647.zul,B,E,Style")
class B50_ZK_647Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div height="10px" />
				<div height="20px">Check whether all the style of the 'Test' below are correct,</div>
				<div height="20px">color:#0000CC; font-family:"courier new","times new roman",""; font-size:30px;</div>
				<label id="lb" value='Test'
					style='color:#0000CC; font-family:"courier new","times new roman",""; font-size:30px;'/>
			</zk>

    }


   runZTL(zscript, () => {
    		var lb: Widget = engine.$f("lb");
    		verifyTrue("the style of font-size should be applied",
    		    jq(lb.$n()).height() >= 30);
		})
  }
}