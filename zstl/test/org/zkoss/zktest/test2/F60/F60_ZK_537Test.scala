/* F60_ZK_537Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 14:47:05 CST 2012 , Created by benbai
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
 * A test class for bug ZK-537
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-537.zul,F60,B,E,Hlayout")
class F60_ZK_537Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
			<zk>
			<div>The buttons should aligned correctly.</div>
				<checkbox id="cbOne" label="hlayout one" checked="true" />
				<checkbox id="cbTwo" label="hlayout two" checked="true" />
				<checkbox id="cbThree" label="hlayout three" checked="true" />
				<radiogroup>
					<attribute name="onCheck">
						String s = self.getSelectedItem().getLabel();
						
						if (cbOne.isChecked()) {
							hlOne.setValign(s);
							lbOne.setLabel("align "+s);
						}
						if (cbTwo.isChecked()) {
							hlTwo.setValign(s);
							lbTwo.setLabel("align "+s);
						}
						if (cbThree.isChecked()) {
							hlThree.setValign(s);
							lbThree.setLabel("align "+s);
						}
					</attribute>
					<radio label="top" id="rTop" />
					<radio label="middle" id="rMiddle" />
					<radio label="bottom" id="rBottom" />
				</radiogroup>
			    <hlayout id="hlOne" height="100px">
			    	<button id="lbOne" label="align top" />
			    	<window id="win1" width="100px" height="100px" title="test window" border="normal" />
			    </hlayout>
			    <hlayout id="hlTwo" valign="middle" height="100px">
			    	<button id="lbTwo" label="align middle" />
			    	<window id="win2" width="100px" height="100px" title="test window" border="normal" />
			    </hlayout>
			    <hlayout id="hlThree" valign="bottom" height="100px">
			    	<button id="lbThree" label="align bottom" />
			    	<window id="win3" width="100px" height="100px" title="test window" border="normal" />
			    </hlayout>
			</zk>

    """

    runZTL(zscript,
        () => {
        var rTop: Widget = engine.$f("rTop");
        var rMiddle: Widget = engine.$f("rMiddle");
        var rBottom: Widget = engine.$f("rBottom");
        var lbOne: Widget = engine.$f("lbOne");
        var lbTwo: Widget = engine.$f("lbTwo");
        var lbThree: Widget = engine.$f("lbThree");
        var win1: Widget = engine.$f("win1");
        var win2: Widget = engine.$f("win2");
        var win3: Widget = engine.$f("win3");

        def clickAndCheck (wgt: Widget, align: String) {
          click(wgt.$n("real"));
          waitResponse();

          checkAlign(lbOne, win1, align);
          checkAlign(lbTwo, win2, align);
          checkAlign(lbThree, win3, align);
        }
        def checkAlign (w1: Widget, w2: Widget, align: String) {
          var $w1: JQuery = jq(w1);
          var $w2: JQuery = jq(w2);
          if ("top".equals(align))
            verifyTrue("Should align top",
                ($w1.offsetTop() - $w2.offsetTop()) < 2);
          else if ("middle".equals(align))
            verifyTrue("Should align middle",
                (($w1.offsetTop()+$w1.outerHeight()/2) - ($w2.offsetTop()+$w2.outerHeight()/2)) < 2);
          else if ("bottom".equals(align))
            verifyTrue("Should align bottom",
                (($w1.offsetTop()+$w1.outerHeight()) - ($w2.offsetTop()+$w2.outerHeight())) < 2);
        }
        checkAlign(lbOne, win1, "top");
        checkAlign(lbTwo, win2, "middle");
        checkAlign(lbThree, win3, "bottom");

        clickAndCheck(rTop, "top");
        clickAndCheck(rMiddle, "middle");
        clickAndCheck(rBottom, "bottom");
    }
   );
  }
}