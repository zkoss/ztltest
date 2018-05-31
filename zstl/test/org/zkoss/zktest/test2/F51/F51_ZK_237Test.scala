/* F51_ZK_237Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 16 09:51:52 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug ZK-237
  *
  * @author benbai
  *
  */
@Tags(tags = "F51-ZK-237.zul,F60,A,E,import,class")
class F51_ZK_237Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<?import org.zkoss.zktest.test2.*?>
			<?import org.zkoss.zul.*?>
			<?import org.zkoss.zktest.test2.F327Init?>
			<?import org.zkoss.zktest.test2.*?>
			<?import java.lang.*?>
			
			<?init class="F327Init"?>
			<?variable-resolver class="F327Resolver"?>
			<?function-mapper class="F327Mapper"?>
			<?xel-method prefix="c" name="forName"
				class="Class"
				signature="Class forName(String)"?>
			
			<window border="normal" apply="F327Composer" use="Window">
				If you saw this page, it runs correctly.
				<separator/>
				<button id="hi" label="hi"/>
				${resolver}
				<separator/>
				${c:forName('java.util.List')}
			</window>

    """

    runZTL(zscript,
      () => {
        verifyTrue("Page should displayed correctly",
          jq(".z-label:contains(If you saw this page, it runs correctly.)").exists());
      }
    );
  }
}