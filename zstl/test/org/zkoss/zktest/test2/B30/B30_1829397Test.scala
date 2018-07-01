/* B30_1829397Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Oct 11, 2011 3:55:21 PM , Created by jumperchen
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author jumperchen
  *
  */
@Tags(tags = "B30-1829397.zul,B,E,Window,Button")
class B30_1829397Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <window title="Test of on-shot timer" xmlns:html="http://www.w3.org/1999/xhtml">
        <vbox id="v">
          You shall see only one label below:
          <timer delay="1000" repeats="false">
            <attribute name="onTimer">
              v.appendChild(new Label("You shall see this label only once!!! running:"+self.running));
            </attribute>
          </timer>
        </vbox>
      </window>
    """
    runZTL(zscript, () => {
      verifyTrue(jq("$v").isVisible());
      verifyContains(jq(".z-label").eq(0).text(), "You shall see only one label below:")
      sleep(1100);
      verifyContains(jq(".z-label").eq(1).text(), "You shall see this label only once!!!")
    })
  }
}