/* B36_3000305Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3000305
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-3000305.zul,A,E,Databind,Constraint")
class B36_3000305Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<window>
	<zscript><![CDATA[
	String str = null;
	]]>
	</zscript>
	<html><![CDATA[
	<ol>
	  <li>Type X</li>
	  <li>Press TAB and shift-TAB to change focus</li>
	  <li>Delete X and then click "Set new String" button.</li>
	  <li>Expected result: no error message at all.</li>
	</ol>
	]]></html>
	<vbox>
		<button id="btn" label="Set new String" onClick='str = "X"; binder.loadAll();' />
		<textbox id="txt" value="@{str}" constraint="no empty" />
	</vbox>
</window>

      """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click maximize button
        var txt = jq("$txt");
        focus(txt);
        waitResponse();

        //Type X
        sendKeys(txt, "X");

        waitResponse();

        //Press Tab and Shift-TAB
        sendKeys(txt, Keys.SHIFT + "" + Keys.TAB);

        waitResponse();

        //Delete X
        focus(txt);
        waitResponse();
        sendKeys(txt, Keys.BACK_SPACE);
        waitResponse();

        //Click button
        var btn = jq("$btn");
        click(btn);
        waitResponse();

        //Check error visible 
        var err = jq(".zk-errbox");
        verifyFalse(err.isVisible());

      });
  }

}