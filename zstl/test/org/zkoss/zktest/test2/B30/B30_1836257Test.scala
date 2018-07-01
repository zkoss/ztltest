/* B30_1836257Test.scala

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
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 1836257
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1836257.zul,B,E,Listbox")
class B30_1836257Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<window title="listbox demo" border="normal">
                [ 1836257 ] Click the Button. The stripe color should be correct.
                <listbox width="250px">
                    <listhead sizable="true">
                        <listheader label="name" sort="auto"/>
                        <listheader label="gender" sort="auto"/>
                    </listhead>
                    <listitem>
                        <listcell label="Mary"/>
                        <listcell label="FEMALE"/>
                    </listitem>
                    <listitem id="row1">
                        <listcell label="John"/>
                        <listcell label="MALE"/>
                    </listitem>
                    <listitem>
                        <listcell label="Jane"/>
                        <listcell label="FEMALE"/>
                    </listitem>
                    <listitem >
                        <listcell label="Henry"/>
                        <listcell label="MALE"/>
                    </listitem>
                </listbox>
                <button label="change" onClick='row1.visible = !row1.visible'/>
            </window>
   """
    runZTL(zscript,
      () => {

        waitResponse();
        //Verify row stripe before hide row
        verifyFalse(jq("@listitem:eq(0)").hasClass("z-listbox-odd"));
        verifyTrue(jq("@listitem:eq(1)").hasClass("z-listbox-odd"));
        verifyFalse(jq("@listitem:eq(2)").hasClass("z-listbox-odd"));
        verifyTrue(jq("@listitem:eq(3)").hasClass("z-listbox-odd"));

        click(jq("@button"));
        waitResponse();
        //row1 must be invisible
        verifyTrue(!jq("$row1").isVisible());

        verifyFalse(jq("@listitem:eq(0)").hasClass("z-listbox-odd"));
        verifyTrue(jq("@listitem:eq(1)").hasClass("z-listbox-odd"));
        verifyFalse(jq("@listitem:eq(3)").hasClass("z-listbox-odd"));

        //Verify row after row uhide
        click(jq("@button"));
        waitResponse();

        //row1 must be visible
        verifyTrue(jq("$row1").isVisible());

        verifyFalse(jq("@listitem:eq(0)").hasClass("z-listbox-odd"));
        verifyTrue(jq("@listitem:eq(1)").hasClass("z-listbox-odd"));
        verifyFalse(jq("@listitem:eq(2)").hasClass("z-listbox-odd"));
        verifyTrue(jq("@listitem:eq(3)").hasClass("z-listbox-odd"));

      }
    );
  }
}
