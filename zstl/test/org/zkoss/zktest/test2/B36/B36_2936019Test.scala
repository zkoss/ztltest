/* B36_2936019Test.scala

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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2936019
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2936019.zul,A,E,Listbox,Listgroup,Listgroupfoot")
class B36_2936019Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<zk>
<html><![CDATA[
<ol>
<li>Press the "add Group+Groupfoot" button</li>
<li>If you see a Group and a Groupfoot item shown in the listbox, then it is OK; otherwise, it is a bug</li>
</ol>
]]>
</html>
<listbox id="lbx" mold="paging">
	<listhead>
		<listheader label="header"></listheader>
	</listhead>
</listbox>
<zscript>
	lbx.getPaginal().setAutohide(false);
</zscript>
<button label="add Group+Groupfoot">
	<attribute name="onClick">
	<![CDATA[
	Listgroup lg = new Listgroup("Group");
	lbx.insertBefore(lg, lbx.getPaginal());
	Listgroupfoot lgf = new Listgroupfoot("Groupfoot");
	lbx.insertBefore(lgf, lbx.getPaginal());
	]]>
	</attribute>
</button>
</zk>

      """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click button
        var btn = jq("@button");
        click(btn);
        waitResponse();

        //Verify group
        var group = jq(".z-listgroup");
        verifyTrue(group.isVisible());

        //Check  groupfooter 
        var foot = jq(".z-listgroupfoot");
        verifyTrue(foot.isVisible());

      });
  }

}