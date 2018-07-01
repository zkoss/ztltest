/* B30_2165067Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 1, 2011 05:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-2165067.zul,B,E,Window,Button")
class B30_2165067Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <zk>
        <html><![CDATA[
		<ol>
			<li>Before doing anything, you should see 3 "test" labels.</li>
			<li>Click on "Remove" Button. The "test" labels should disappear, leaving only Button 2. If not, it is a bug.</li>
		</ol>
	]]></html>
        <div id="d">
          <label value="test"/>
          <label value="test"/>
          <label value="test"/>
          <button label="Button 2"/>
        </div>
        <button label="Remove">
          <attribute name="onClick"><![CDATA[
			ListIterator it = d.getChildren().listIterator(3);
			for (int n = 3; --n >= 0;) {
				it.previous();
				it.remove();
			}
		]]></attribute>
        </button>
      </zk>
    """
    runZTL(zscript, () => {
      // Verify the existence of the labels
      verifyTrue("The tree labels should does not exists", jq(".z-label:contains(test)").length() == 3);

      // Click on the button
      click(jq("@button").get(1));
      waitResponse();

      // Verify the inexistence of the labels
      verifyFalse("The tree labels should does not exists", jq(".z-label:contains(test)").length() == 3);

      // Verify the existence of the "Button 2"
      verifyTrue("The button 'Button 2' should does exists", jq("@button:contains(Button 2)").exists());
    })
  }
}