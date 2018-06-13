/* B36_2721977Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2721977Test extends ZTL4ScalaTestCase {
  @Test
  def testconstraint() = {
    var zscript =
      """
			<zk>
			1.Press the button "save" twice or thrice, you should always see the two error box.
			<window title="My First Window" border="normal" width="200px">
			    <vlayout>
			    <textbox id="txb1"/>
			    <textbox id="txb2"/>
			    </vlayout>
			    <button id="btn" label="save" onClick="save()"/>
			    <zscript>
			        public void save() {
			            ArrayList al = new ArrayList();
						try{
				            if(txb1.getValue() == null || txb1.getValue().length() == 0) {
				                 al.add(new WrongValueException(txb1, "fill textbox 1"));
				                 txb1.focus();
				            }
				            if(txb2.getValue() == null || txb1.getValue().length() == 0)
				                 al.add(new WrongValueException(txb2, "fill textbox 2"));
			        	}catch(Exception e) {
			        		if(al.isEmpty())
			            		throw e;
			        	}
			            if(al.size() > 0)
			                throw new WrongValuesException(al.toArray(new WrongValueException[1]));
					}
			    </zscript>
			</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val txb1 = ztl$engine.$f("txb1")
    val txb2 = ztl$engine.$f("txb2")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      /** set speed depended on test case setting */
      setSpeed("200")
      click(btn)
      waitResponse()
      verifyEquals(2, jq(".z-errorbox").length())
      click(btn)
      waitResponse()
      verifyEquals(2, jq(".z-errorbox").length())
      click(btn)
      waitResponse()
      verifyEquals(2, jq(".z-errorbox").length())

      /** reset */
      setSpeed("200")
    })
  }
}



