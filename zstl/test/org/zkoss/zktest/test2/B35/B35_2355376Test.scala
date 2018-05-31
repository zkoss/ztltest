/* B35_2355376Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 13, 2012 11:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2355376.zul,B,E,Window,Button")
class B35_2355376Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <zk>
        After this page display, if there is not Javascript error, that is correct.(IE only)
        <window title="IE Bug" border="normal" width="500px">
          <window id="win" closable="true" minimizable="true" maximizable="true" border="normal" width="300px" onClose="self.visible=false; event.stopPropagation();">
            <caption image="/test2/img/inet.png" label="Hi there!"/>
            Auto-position (applicable if not embedded)
            <separator/>
            <button label="left,center" onClick="win.position = &quot;left,center&quot;;"/>
            <button label="right,bottom" onClick="win.position = &quot;right,bottom&quot;;"/>
            <button label="center" onClick="win.position = &quot;center&quot;;"/>
          </window>
          <button label="Overlap" focus="true" onClick="win.doOverlapped();"/>
          <button label="Highligh" onClick="win.doHighlighted();"/>
          <button label="Modal" onClick="win.doModal();"/>
          <button label="Popup" onClick="win.doPopup();"/>
          <button label="Embed" onClick="win.doEmbedded();"/>
          <button label="Toggle Visible" onClick="win.visible = !win.visible"/>
          <html><![CDATA[
	<select>
		<option>Option 1</option>
		<option>Option 2</option>
		<option>Option 3</option>
	</select>
	]]></html>
          <separator bar="true"/>
          <window id="w2" border="normal" title="Overlapped" width="200px" mode="overlapped">
            This is a overlapped window
            <groupbox mold="3d" height="100px">
              <caption label="3d groupbox"/>
              Content of the groupbox
            </groupbox>
            <window id="w21" border="normal" title="Overlapped in Overlapped" width="200px" mode="overlapped">
              <![CDATA[${ w21.title }]]>
              <window id="w211" border="normal" title="Popup in Overlapped in Overlapped" width="200px" visible="false">
                <![CDATA[${ w211.title }]]>
                <window id="w2111" border="normal" title="Overlapped in Popup" width="200px" mode="overlapped">
                  <![CDATA[${ w2111.title }]]>
                </window>
              </window>
              <button label="Popup" onClick="w211.doPopup()"/>
            </window>
            <button label="Visible 1st of 2nd" onClick="w21.visible = !w21.visible"/>
          </window>
          <button label="Visible 2nd" onClick="w2.visible = !w2.visible"/>
        </window>
      </zk>
    """
    runZTL(zscript, () => {

      // Verify there is no javascript error
      verifyFalse(jq(".z-error").exists());

    })
  }
}