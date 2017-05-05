/* B60_ZK_761_1Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 10:41:47 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

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
  * A test class for bug ZK-761-1
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-761-1.zul,A,E,ListModelList,Grid")
class B60_ZK_761_1Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<window>
			Please click the reset button, and then you should not see any exception dialog.
			 <zscript>
			 org.zkoss.zul.ListModelList model = new org.zkoss.zul.ListModelList();
			 model.add("A");
			 model.add("B");
			 model.add("C");
			 model.add("D");
			    </zscript>
			 <grid id="grid" width="300px" model="${model}">
			  <template name="model">
			   <row>
			    <label value="${each}" />
			   </row>
			  </template>
			 </grid>
			 <button id="btnOne" label="reset" onClick="grid.setModel(model)"/>
			 </window>

    """

    runZTL(zscript,
      () => {
        var btnOne: Widget = engine.$f("btnOne");
        click(btnOne);
        waitResponse();
        verifyTrue("The grid should rendered (not exception page)",
          jq(".z-row:contains(D)").exists());
        verifyFalse("Should no exception alert window",
          jq(".z-window-modal").exists());
      }
    );
  }
}