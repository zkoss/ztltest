/* B35_2086093Test.scala

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
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 2086093
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2086093.zul,B,E,Button,Listbox")
class B35_2086093Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<!--
Z30-listbox-0008.zul

{{IS_NOTE
Purpose:

Description:

History:
Thu Oct 27 21:18:02 2005, Created by tomyeh
}}IS_NOTE

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
no metter click on checkbox, button or textbox. it should not show "selected" message below.
<listbox onSelect='inf.appendChild(new Label("selected"))'>
	<listhead>
		<listheader label="Population"/>
		<listheader label="%"/>
	</listhead>
	<listitem value="A">
		<listcell><textbox id="t1" value="A. Graduate"/></listcell>
		<listcell label="20%"/>
	</listitem>
	<listitem value="B">
		<listcell><checkbox id="ch1" label="B. College"/></listcell>
		<listcell><button id="b1" label="23%"/></listcell>
	</listitem>
	<listitem value="C">
		<listcell label="C. High School"/>
		<listcell><textbox id="t2" cols="8" value="40%"/></listcell>
	</listitem>
</listbox>
      
<vlayout id="inf"/>
</zk>


    """

    runZTL(zscript,
      () => {

        //click text1
        click(jq("$t1"));
        waitResponse();

        verifyFalse(jq("@label[value=\"selected\"]").isVisible());

        //click text2
        click(jq("$t2"));
        waitResponse();

        verifyFalse(jq("@label[value=\"selected\"]").isVisible());

        //click check
        val ck1 = engine.$f("ch1");
        click(ck1.$n("real"));

        waitResponse();

        verifyFalse(jq("@label[value=\"selected\"]").isVisible());

        //click button
        click(jq("$b1"));
        waitResponse();

        verifyFalse(jq("@label[value=\"selected\"]").isVisible());

      }
    );
  }
}
