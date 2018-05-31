/* B35_2088479Test.scala

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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags


/**
  * A test class for bug 2088479
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2088479.zul,A,E,Tabbox,IE,BI")
class B35_2088479Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2088479.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Sep  3 11:19:01 TST 2008, Created by Flyworld
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>	
<vbox>
<label> 1.Click on the accordion tabbox, it shouldn't be
dissected.</label>
</vbox>
<tabbox width="400px" orient="vertical">
<tabs width="60px">
<tab label="Tab 1"/>
<tab label="Tab 2" selected="true"/>
</tabs>
<tabpanels>
<tabpanel height="100px" style="background:yellow">This is panel
1</tabpanel>
<tabpanel height="100px" style="background:blue;overflow:auto">This is
panel 2
<div height="200px">---</div>The second panel
</tabpanel>
</tabpanels>
</tabbox>
<tabbox width="400px" mold="accordion">
<tabs>
<tab id="tab1" label="Tab 1"/>
<tab id="tab2" label="Tab 2" selected="true"/>
</tabs>
<tabpanels>
<tabpanel id="p1" height="100px" style="background:yellow">This is panel
1</tabpanel>
<tabpanel id="p2" height="100px" style="background:blue;overflow:auto">This is
panel 2
<div height="200px">---</div>The second panel
</tabpanel>
</tabpanels>
</tabbox>
</zk>

      """

    runZTL(zscript,
      () => {

        waitResponse();
        var tab1 = jq("$tab1");
        var tab2 = jq("$tab2");

        click(tab1);
        waitResponse(true);

        //Panels 1 visible, 2 invisible
        verifyTrue(jq("$p1").find(".z-tabpanel-content").isVisible());
        verifyFalse(jq("$p2").find(".z-tabpanel-content").isVisible());

        click(tab2);
        waitResponse(true);

        //Panels 2 visible, 1 invisible
        verifyTrue(jq("$p2").find(".z-tabpanel-content").isVisible());
        verifyFalse(jq("$p1").find(".z-tabpanel-content").isVisible());

      });
  }
}
