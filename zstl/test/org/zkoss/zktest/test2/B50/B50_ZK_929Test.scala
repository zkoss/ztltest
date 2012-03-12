/* B50_ZK_929Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 12:39:43 CST 2012 , Created by benbai
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
 * A test class for bug ZK-929
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-929.zul,B,M,Common,StringFns")
class B50_ZK_929Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" ?>
			<zk>
				<label value='${c:replace("ZK-123-ZK-456-ZK", "ZK", "Hello ZK!")}'/>
				
				<separator />
				(It should be [<label value='Hello ZK!-123-Hello ZK!-456-Hello ZK!'/>] )
			</zk>

    """


   runZTL(zscript, () => {
   			verifyTrue("It should be [Hello ZK!-123-Hello ZK!-456-Hello ZK!]",
   			    jq(".z-label:contains(Hello ZK!-123-Hello ZK!-456-Hello ZK!)").length() == 2);
		})
  }
}