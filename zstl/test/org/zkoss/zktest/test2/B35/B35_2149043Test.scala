/* B35_2149043Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 7, 2012 12:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2149043.zul,B,E,Window,Button")
class B35_2149043Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <window height="600px">
        <fisheyebar id="fish" style="position: absolute; top: 50px; left:100px;margin:20px;" attachEdge="top">
          <fisheye id="f1" image="/test2/img/icon_browser.png" label="Web Browser" onClick="alert(self.label)"/>
          <fisheye image="/test2/img/icon_calendar.png" label="Calendar" onClick="alert(self.label)"/>
          <fisheye image="/test2/img/icon_email.png" label="Email" onClick="alert(self.label)"/>
          <fisheye image="/test2/img/icon_texteditor.png" label="Text Editor" onClick="alert(self.label)"/>
          <fisheye image="/test2/img/icon_update.png" label="Software Update" onClick="alert(self.label)"/>
          <fisheye image="/test2/img/icon_users.png" label="Users" onClick="alert(self.label)"/>
        </fisheyebar>
        Click "Change image" button, and then it should work well. If it is out of expected, it is bug.
        <separator/>
        <button label="Change image" onClick='f1.setImage("/test2/img/icon_email.png")'/>
      </window>
    """
    runZTL(zscript, () => {

      // Record the image after the click on the button
      val height = jq("$f1").outerHeight()
      val width = jq("$f1").outerWidth()
      // Click on Change image button
      click(jq("@button"));
      waitResponse();
      val img = engine.$f("f1").attr("image");

      // Verify that the image is changed
      verifyContains("The image should be /test2/img/icon_email.png", img, "/test2/img/icon_email.png")

      mouseOver(jq(".z-fisheye:eq(4) img"));
      waitResponse();
      verifyTrue(height < jq("$f1").outerHeight());
      verifyTrue(width < jq("$f1").outerWidth());
    })
  }
}