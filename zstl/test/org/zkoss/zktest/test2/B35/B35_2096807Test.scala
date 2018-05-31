/* B35_2096807Test.scala

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
  * A test class for bug 2096807
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2096807.zul,A,E,Borderlayout,Paging")
class B35_2096807Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2096807.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Sep  8 15:21:55 TST 2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<window>
Please click the changing paging, and then you should see the button of  the paging.
<zscript>
List items = new org.zkoss.zktest.test2.BigList(100); //a big list ofInteger
</zscript>
<borderlayout height="300px"><center flex="true">
<listbox mold="paging">
<listitem forEach="&#36;{items}">
<listcell label="&#36;{each}-1"/>
<listcell label="&#36;{each}-2"/>
<listcell label="&#36;{each}-3"/>
<listcell label="&#36;{each}-4"/>
</listitem>
</listbox>
</center></borderlayout>
</window>


    """

    runZTL(zscript,
      () => {

        waitResponse();
        var nextd = jq("[name=" + jq("@paging").attr("id") + "-next][disabled=disabled]")
        var next = jq("[name=" + jq("@paging").attr("id") + "-next]")

        //Previous disabled in first page
        var firstd = jq("[name=" + jq("@paging").attr("id") + "-first][disabled=disabled]")
        var first = jq("[name=" + jq("@paging").attr("id") + "-first]")

        var lastd = jq("[name=" + jq("@paging").attr("id") + "-last][disabled=disabled]")
        var last = jq("[name=" + jq("@paging").attr("id") + "-last]")

        var prevd = jq("[name=" + jq("@paging").attr("id") + "-prev][disabled=disabled]")
        var prev = jq("[name=" + jq("@paging").attr("id") + "-prev]")

        //Verify disabled and enabled pagging buttons
        var nd = nextd.exists();
        var n = next.exists();
        verifyFalse(nd);
        verifyTrue(n);

        var ld = lastd.exists();
        var l = last.exists();
        verifyFalse(ld);
        verifyTrue(l);

        //first & prev are disabled
        var fd = firstd.exists();
        verifyTrue(fd);

        var pd = prevd.exists();
        verifyTrue(pd);

        //click next button
        click(next);
        waitResponse();

        //Verify all pagging enabled
        verifyFalse(nextd.exists());
        verifyTrue(next.exists());

        verifyFalse(lastd.exists());
        verifyTrue(last.exists());

        verifyFalse(firstd.exists());
        verifyTrue(first.exists());

        verifyFalse(prevd.exists());
        verifyTrue(prev.exists());

        click(last);
        waitResponse();

        //Verify last & next disabled
        verifyTrue(nextd.exists());
        verifyTrue(lastd.exists());

        verifyFalse(firstd.exists());
        verifyTrue(first.exists());

        verifyFalse(prevd.exists());
        verifyTrue(prev.exists());

      }
    );
  }
}
