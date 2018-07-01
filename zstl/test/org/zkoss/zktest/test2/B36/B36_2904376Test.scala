/* B36_2904376Test.scala

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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2904376
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2904376.zul,A,E,Window,Sizable")
class B36_2904376Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2904376.zul

	Purpose:
		
	Description:
		
	History:
		Fri Nov 27 16:33:02     2009, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<zk>
<window id="win1" border="normal" mode="overlapped" left="180px" top="20px" title="parent window" width="850px"  height="650" closable="true" sizable="true">
	<button label="Click Me and then resize the child window, it should be correctly resized.">
		<attribute name="onClick"><![CDATA[
			Window win = new Window();
    		win.setId("win2");
			win.setWidth("200px");
			win.setHeight("200px");
			win.setTitle("child window");
			win.setBorder("normal");
			win.doOverlapped();
			win.setSizable(true);
			win.setLeft("20px");
			win.setTop("20px");
			win1.appendChild(win);
		]]></attribute>
	</button>
	<div height="600px">
	</div>
		<attribute name="onClose"><![CDATA[
			event.stopPropagation();
		]]></attribute>
</window>
</zk>

      """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click button
        var bt = jq("@button");
        click(bt);
        waitResponse();



        //Get Window
        var win2 = jq("$win2");
        var w = win2.outerWidth();
        var h = win2.outerHeight();
        var dim = w / 2 + "," + h;
        var dim2 = w / 2 + "," + (h * 2);
        var dim3 = w + "," + (h / 2);
        var dim4 = (w * 2) + "," + (h / 2);

        //Vertical resize
        mouseDownAt(win2.toWidget(), dim);
        mouseMoveAt(win2.toWidget(), dim2);
        mouseUpAt(win2.toWidget(), dim2);
        waitResponse();

        var h1 = win2.height();
        verifyTrue(h1 != h);

        waitResponse();

        //Horizontal resize
        mouseDownAt(win2.toWidget(), dim3);
        mouseMoveAt(win2.toWidget(), dim4);
        mouseUpAt(win2.toWidget(), dim4);
        waitResponse();

        var w1 = win2.width();

        verifyTrue(w1 != w);


      });
  }

}