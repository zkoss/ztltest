/* F60_ZK_720Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 28 17:40:15 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

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
 * A test class for bug ZK-720
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-720.zul,")
class F60_ZK_720Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk xmlns:h="xhtml">
				<h:pre>
					1.Click all the (left/Right) toolbarbutton and see if the toggle effect working.
					  press toolbarbutton and release , 
					  then a tootlebarbutton is persistent checked.
					  
					  (Also need to check if there's any issue with images.')
					  
					2. Click the "test event" , there should show up "Checked:true"
					
					3. Click the "test event" again, there should show up "Checked:false"
					 
				</h:pre>
				<window title="Toolbar window" border="normal" width="400px">
					<label id="lb" value="message: " />
					<toolbar>
						<toolbarbutton id="tbn1" label="Left" mode="toggle" image="/img/network.gif" />
						<space />
						<toolbarbutton id="tbn2" label="Right"  mode="toggle" image="/img/network.gif" dir="reverse" />
						<separator />
						<toolbarbutton id="tbn3" label="checked Left" mode="toggle" checked="true" image="/img/network.gif" />
						<space />
						<toolbarbutton id="tbn4" label="checked Right" mode="toggle" checked="true" image="/img/network.gif" dir="reverse" />
						
						<separator />
						<toolbarbutton id="tbn5" label="Left" mode="toggle" />
						<space />
						<toolbarbutton id="tbn6" label="Right"  mode="toggle" />
						<separator />
						<toolbarbutton id="tbn7" label="checked Left" mode="toggle" checked="true" />
						<space />
						<toolbarbutton id="tbn8" label="checked Right" mode="toggle" checked="true" dir="reverse" />
					</toolbar>
					<toolbar>
						<toolbarbutton id="tbn9" label="Test event" mode="toggle" onCheck='lbl.setValue("Checked:"+event.isChecked())' />
						<label id="lbl" /> 
						<space />
					</toolbar>
				</window>
			</zk>

    }

    runZTL(zscript,
        () => {

          var lbl: Widget = engine.$f("lbl");

        def checkAct (tbn: Widget) {
          var toggled: Boolean = jq(tbn.$n()).hasClass("z-toolbarbutton-checked");
          click(tbn);
          mouseOut(tbn); waitResponse();
          verifyTrue("Should"+(if (toggled) " not" else "")+" be toggled",
                jq(tbn.$n()).hasClass("z-toolbarbutton-checked") != toggled);
        }
        engine.$f("tbn1");
        for (i <- 1 to 8) {
          checkAct(engine.$f("tbn"+i));
          checkAct(engine.$f("tbn"+i));
        }
        click(engine.$f("tbn9"));
        mouseOut(engine.$f("tbn9")); waitResponse();
        verifyTrue("should be toggled",
            lbl.$n().get("innerHTML").contains("true"));
        click(engine.$f("tbn9"));
        mouseOut(engine.$f("tbn9")); waitResponse();
        verifyTrue("should not be toggled",
            lbl.$n().get("innerHTML").contains("false"));
    }
   );
  }
}