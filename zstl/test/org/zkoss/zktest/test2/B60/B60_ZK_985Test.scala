/* B60_ZK_985Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 11:22:35 CST 2012 , Created by benbai
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
 * A test class for bug ZK-985
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-985.zul,A,E,Grid,onChanging")
class B60_ZK_985Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
			<html>
			<ul>
				<li>Enter something in the textbox below and wait. You shall see nothing happen.
				(The bug is that the content you entered is cleared wrongly.)</li>
			</ul>
			</html>
			<zscript>
			import org.zkoss.zktest.test2.select.models.*;
			ListModel model = ListModelArrays.getModel(ListModelArrays.DEFAULT);
			</zscript>
    		<button id="btn" label="test" onClick='lb.setValue(tbx.getValue())' />
    		<label id="lb" />
			<grid id="grid" model="${model}">
			    <columns>
			        <column label="Category"/>
			    </columns>
			    <auxhead>
			    	<auxheader>
			    		<textbox id="tbx" onChanging="grid.setModel(ListModelArrays.getModel(ListModelArrays.DEFAULT))"/>
			    	</auxheader>
			    </auxhead>
			</grid>
			</zk>

    }

    runZTL(zscript,
        () => {
        var btn: Widget = engine.$f("btn");
        var lb: Widget = engine.$f("lb");
        var tbx: Widget = engine.$f("tbx");

        sendKeys(tbx, "asdf"); sleep(2000);
        click(btn); waitResponse();
        verifyTrue("Textbox not cleared",
            lb.$n().get("innerHTML").contains("asdf"));
    }
   );
  }
}