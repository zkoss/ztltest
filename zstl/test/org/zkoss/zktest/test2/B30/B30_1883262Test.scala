/* B30_1883262Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1883262Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
<n:p>1.Please focus in and out the input element, you should not see any error dialog.</n:p>
<n:p>2.The textbox shall disappear.</n:p>

	<window id="win">	 
	<zscript><![CDATA[
Constraint ctt = new Constraint() {
	public void validate(Component comp, Object value) throws WrongValueException { 
		try {
			throw new WrongValueException( comp, "Error" );
		}finally{
			Events.postEvent(new Event("onChange", comp, null));
		}
	} 
} 
	]]></zscript>
	<button id="blur" label="blur"/>
	<textbox id="txtbox" constraint="${ctt}" onChange="self.clearErrorMessage();win.detach();"/>
	</window>
</zk>

		"""
    val ztl$engine = engine()
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      var txtbox = jq("$txtbox")
      focus(txtbox.toWidget.$n())
      var error = jq(".z-errorbox")
      verifyFalse(error.exists()); //error box should not exist
      blur(txtbox)
      waitResponse()
      verifyFalse(jq(".z-textbox").exists()) //txtbox should disappear
    })
  }
}



