/* B35_2125673Test.scala

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
import org.zkoss.ztl.annotation.Tags


/**
  * A test class for bug 2125673
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2125673.zul,B,E,Groupbox")
class B35_2125673Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2125673.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Sep 24 16:38:32     2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
	Please click the "fruits" title, and then the groupbox should not be closed.
		<groupbox id="gb" width="300px" closable="false">
			<caption image="/test2/img/inet.png" label="fruits"/>
			<radiogroup onCheck="fruit.value = self.selectedItem.label">
				<radio label="Apple"/>
				<radio label="Orange"/>
				<radio label="Grape"/>
			</radiogroup>
		</groupbox>
</zk>


    """;

    runZTL(zscript,
      () => {

        waitResponse();

        var title = jq("@caption");
        var group = jq("@groupbox").toWidget().$n("cave");

        //1 - click title
        click(title);
        waitResponse();

        //2 - Verify groupbox not closed
        verifyTrue(jq(group).exists());
        verifyTrue(jq(group).isVisible());


      }
    );
  }
}
